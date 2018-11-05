 USE jdbc;
CREATE TABLE dbcp_08(
did INT PRIMARY KEY AUTO_INCREMENT,
dusername VARCHAR(100) NOT NULL,
dpassword VARCHAR(100) NOT NULL
)ENGINE=INNODB DEFAULT CHARSET=utf8;

-- 写入表中数据
insert into dbcp_08(dusername,dpassword) values
('a','1'),('b','2');

SELECT * FROM dbcp_08;