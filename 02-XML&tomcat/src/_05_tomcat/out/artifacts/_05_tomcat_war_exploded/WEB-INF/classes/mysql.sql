 USE tomcat;
CREATE TABLE 05_tomcat(
tid INT PRIMARY KEY AUTO_INCREMENT,
tusername VARCHAR(100) NOT NULL,
tpassword VARCHAR(100) NOT NULL
)ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO 05_tomcat(tusername,tpassword) VALUES('tom','123'),('lucy','456');
SELECT * FROM 05_tomcat;