#### 01
1. 进行简单步骤连接  
#### 02  
1. 结果集处理  
2. 使用ResultSet实现类进行结果集处理
3. 结果集处理方法  
*`next(); getString(); getInt();`  
*此类方法获取竖行一列的数据，传参可传递列名，精确获取
#### 03  
1. 防止sql注入  
*`prepareStatement()`  
*通过Connection实现类的方法prepareStatement得到PreparedStatement实现类。使用？占位符，站位sql语句    
*案例：03-prepareStatementDemo.java  
2. 简单封装JDBC工具类  
*案例：03-utils.JDBCUtils.java  
#### 04  
1. 数据表数据存储对象  
*读取数据库的数据，存储到bean类中，并将bean类存储到List集合当中
#### 05  
1. properties配置文件