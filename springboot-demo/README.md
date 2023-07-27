1.创建springboot项目：https://blog.csdn.net/wshjk/article/details/123879847

2.整合mybatis：https://blog.csdn.net/yuran06/article/details/122012790

3.数据库结构：
mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| performance_schema |
| sys                |
| test               |
+--------------------+
5 rows in set (0.00 sec)

mysql> show tables;
+----------------+
| Tables_in_test |
+----------------+
| duwujun        |
| runoob_tbl     |
+----------------+
2 rows in set (0.00 sec)

mysql> desc duwujun;
+-------+-------------+------+-----+---------+-------+
| Field | Type        | Null | Key | Default | Extra |
+-------+-------------+------+-----+---------+-------+
| id    | int         | NO   |     | NULL    |       |
| name  | varchar(50) | NO   |     | NULL    |       |
| age   | varchar(40) | YES  |     | NULL    |       |
+-------+-------------+------+-----+---------+-------+
3 rows in set (0.02 sec)

4.启动mysql和redis服务

5.整合redis:https://www.w3cschool.cn/springboot/springboot-fwsi24l6.html