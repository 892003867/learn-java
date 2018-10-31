--myisam与innodb都是mysql的两种存储模式，通常innodb方式
--默认charset为utf-8
create table jdbc_03(
id int primary key auto_increment,
username varchar(100) default null,
password varchar(100) default null
)ENGINE=innodb DEFAULT CHARSET=utf8;


--插入数据
insert into jdbc_03 (username,password) values ('a','1')
,('b','2');

--查询
select * from jdbc_03;

--数据表的登录查询
select * from jdbc_03 where username='a' and password='1';