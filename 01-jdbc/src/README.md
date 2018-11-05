#### 导航  
1. _01_JDBC：[简单连接](#user-content-_01_jdbc)  
2. _02_JDBC：[结果集处理](#user-content-_02_jdbc)  
3. _03_JDBC：[防止sql注入](#user-content-_03_jdbc)  
4. _04_JDBC：[数据表数据存储对象](#user-content-_04_jdbc)  
5. _05_DBUtils：[DBUtils工具类](#user-content-_05_dbutils)  
6. _06_ResultSetHandler：[ResultSetHandler结果集处理](#user-content-_06_resultsethandler)  
7. _07_DBCP：[DBCP连接池](#user-content-_07_dbcp)  
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
2. DBCPUtils.java  
*内部实现反射技术，返回BasicDataSource实现类  
```java
Class c = DBCPUtils.class;
        Method m = null;
        try {
            m = c.getMethod("getDataSource");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            dbs = (BasicDataSource) m.invoke(c.newInstance());
        } catch (Exception e) {
            throw new RuntimeException("执行method异常");
        }
        return dbs;
```
----
#### _01_JDBC  
1. 进行简单步骤连接[跳转导航](#user-content-导航)
----
#### _02_JDBC  
1. 使用ResultSet实现类进行结果集处理，此类方法获取竖行一列的数据，传参可传递列名，精确获取    
>ResultSet实现类方法：`next(); getString(); getInt();`[跳转导航](#user-content-导航)
----
#### _03_JDBC  
1. 防止sql注入  
*通过Connection实现类的方法prepareStatement得到PreparedStatement实现类。使用？占位符，站位sql语句     
>PreparedStatement实现类方法：`prepareStatement()`[跳转导航](#user-content-导航)
----
#### _04_JDBC  
1. 数据表数据存储对象，读取数据库的数据，存储到bean类中，并将bean类存储到List集合当中 
----
#### _05_DBUtils  
1. 对JDBC的封装工具类  
>核心类：`DbUtils类、QueryRunner类、ResultSetHandler类`  
2. QueryRunner类  
*通过`update()`方法进行增删改操作[跳转导航](#user-content-导航)  
----
#### _06_ResultSetHandler  
1. JavaBean：对数据库表的一种类的表现，要求getter与setter，空参构造器与构造器赋值，bean用于封装数据  
2. ResultSetHandler接口：结果集处理工具,依据实现类进行对结果处理，通过QueryRunner类的`query()`方法，得到ResultSetHandler接口  
>ResultSetHandler接口常用实现类：`ArrayHandler类、ArrayListHandler类、BeanHandler类、BeanListHandler类、ColumnListHandler类、ScalarHandler类、MapHandler类、MapListHandler类`  
3. ArrayHandler类  
*只查询数据库第一行的数据  
4. ArrayListHandler类  
*每一行的数据封装到List<Object[]>中,通过嵌套循环遍历  
5. BeanHandler类  
*将结果集的第一行封装成bean类  
```java
 String sql = "select * from jdbc_01";
        jdbc01bean jdbcbean = qr.query(con, sql, new BeanHandler<jdbc01bean>(jdbc01bean.class));
```  
6. BeanListHandler类  
*将数据库得到的结果集封装成bean类并存储到List集合中  
7. ColumnListHandler类  
*结果集，指定列的数据，存储到List集合  
```java
  List<Object> list = qr.query(con, sql, new ColumnListHandler<Object>("sname"));
```  
7. ScalarHandler类  
*只针对一条结果集处理类  
8. MapHandler类  
*第一行数据，以键值对存储到Map集合中，键是数据库的列名，值时数据库的数据  
8. ScalarListHandler类  
*将数据库查询到的结果集存储到List<Map<k,v>>集合当中[跳转导航](#user-content-导航)  
----
#### _07_DBCP  
1. javax.sql包中的DataSource接口，常见连接池DBCP、c3p0，使用dbcp包与pool包  
>常用实现类：`BasicDataSource类`  
2. BasicDataSource类通过`getConnection()`获得连接，但在此之前需要通过`set`一系列方法进行配置连接。  
3. 配置连接池  
>配置连接池常用方法：`setInitialSize()、setMaxTotal()、setMinIdle()`  
4. 使用`QueryRunner类`配合`BasicDataSource类`进行连接并查询数据库[跳转导航](#user-content-导航)  
#### _07_DBCP  
1.登录注册的实现，