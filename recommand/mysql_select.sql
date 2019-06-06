truncate score;

INSERT INTO score(user_id,house_id,score)
SELECT user_id,house_id,5
from phone;

INSERT INTO score(user_id,house_id,score)
SELECT user_id,house_id,3
from collect where (user_id,house_id) NOT in
(SELECT user_id,house_id
from score
);

INSERT INTO score(user_id,house_id,score)
SELECT user_id,house_id,2
from `log` where (user_id,house_id) NOT in
(SELECT user_id,house_id
from score
);