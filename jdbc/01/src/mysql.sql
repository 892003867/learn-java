USE jdbc;
#添加表
CREATE TABLE jdbc_01(
  sid INT PRIMARY KEY AUTO_INCREMENT,
  sname VARCHAR(1000),
  sprice DOUBLE,
  sdesc VARCHAR(5000)
);

#添加数据
INSERT INTO jdbc_01(sname,sprice,sdesc) VALUES ('家电',2000,'优惠促销'),
                                            ('家具',8000,'家具价格上调，原材料涨价'),
                                            ('玩具',300,'赚家长钱'),
                                            ('生鲜',500.99,'生鲜商品'),
                                            ('服装',24000,'换季销售'),
                                            ('洗涤',50,'洗发水促销');
#查询所有数据
SELECT * FROM jdbc_01_sort;
#删除表并清除自增长
truncate table jdbc_01_sort