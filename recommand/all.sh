#!/bin/bash
sh mysql2hdfs.sh
/home/icss/application/hadoop2/bin/hadoop jar Recommand.jar
/home/icss/application/hive2.2/bin/hive -f table_operation.sql
sh hdfs2mysql.sh