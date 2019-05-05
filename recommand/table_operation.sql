drop table if exists recommand.results;
create table if not exists recommand.results(
user_id int COMMENT '用户id',
house_score string COMMENT 'houseid_score')
COMMENT '推荐结果文件的直接映射表'
row format delimited
fields terminated by '\t';

load data inpath '/user/icss/hivetmp/results.txt' into table recommand.results;

drop table if exists recommand.result_split;
create table if not exists recommand.result_split(
user_id int COMMENT '用户id',
house_score string COMMENT 'houseid_score')
COMMENT '推荐结果文件的间接映射表'
row format delimited
fields terminated by ',';


insert into table recommand.result_split
select user_id,house_score_split as house_score from recommand.results lateral view explode(split(house_score,',')) tmp as house_score_split;


drop table if exists recommand.result_all;
create table if not exists recommand.result_all(
user_id int COMMENT 'userId',
house_id int COMMENT 'houseId',
score double COMMENT 'score')
COMMENT 'all recommand results'
row format delimited
fields terminated by ',';

insert into table recommand.result_all
select user_id,split(house_score,'_')[0] as house_id,split(house_score,'_')[1] as score from recommand.result_split;

drop table if exists recommand.result_mysql;
create table if not exists recommand.result_mysql(
user_id int COMMENT 'userId',
house_id int COMMENT 'houseId',
score double COMMENT 'score')
COMMENT 'recommand results for mysql'
row format delimited
fields terminated by ',';

insert into table recommand.result_mysql
select user_id,house_id,score from (select user_id,house_id,score,row_number() over(partition by user_id order by score desc) as num from result_all) t where num<=20;