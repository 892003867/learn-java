####导航  
1. _01_JDBC：[简单连接](#user-content-_01_jdbc)  
2. _02_JDBC：[结果集处理](#user-content-_02_jdbc)  
3. _03_JDBC：[防止sql注入](#user-content-_03_jdbc)  
4. _04_JDBC：[数据表数据存储对象](#user-content-_04_jdbc)  
5. _05_JDBC：[JDBC简单连接](#user-content-_05_jdbc)  
----
#### Utils  
1. JDBCUtils.java  
*properties配置文件，并封装JDBC实现工具,读取properties文件可以通过FileInputStream字节流读取，但读取文件的方式需要采用类的加载器读取
```java
 InputStream fis = ClassLoader.getSystemResourceAsStream("utils/database.properties");
  Properties pro = new Properties();
        try {
            pro.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("读取properties流错误");
        }
```
----
#### _01_JDBC  
1. 进行简单步骤连接
----
#### _02_JDBC  
1. 使用ResultSet实现类进行结果集处理，此类方法获取竖行一列的数据，传参可传递列名，精确获取    
>ResultSet实现类方法：`next(); getString(); getInt();`[跳转导航](#user-content-导航)
----
#### _03_JDBC  
1. 防止sql注入  
*通过Connection实现类的方法prepareStatement得到PreparedStatement实现类。使用？占位符，站位sql语句     
>PreparedStatement实现类方法：`prepareStatement()`  
----
#### _04_JDBC  
1. 数据表数据存储对象，读取数据库的数据，存储到bean类中，并将bean类存储到List集合当中 
----
#### _05_DBUtils  
1. properties配置文件