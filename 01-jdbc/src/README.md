#### Utils  
1. JDBCUtils.java  
*properties配置文件，并封装JDBC实现工具
----
#### JDBC01
1. 进行简单步骤连接  
----
#### JDBC02  
1. 使用ResultSet实现类进行结果集处理，此类方法获取竖行一列的数据，传参可传递列名，精确获取    
>ResultSet类方法：`next(); getString(); getInt();`
----
#### JDBC03  
1. 防止sql注入  
*通过Connection实现类的方法prepareStatement得到PreparedStatement实现类。使用？占位符，站位sql语句     
>PreparedStatement实现类方法：`prepareStatement()`  
>案例：JDBC03-prepareStatementDemo.java   

----
#### JDBC04  
1. 数据表数据存储对象，读取数据库的数据，存储到bean类中，并将bean类存储到List集合当中  
----
#### JDBC05  
1. properties配置文件
```java
public public static void start(android.content.Context context) {
    android.content.Intent starter = new Intent(context, .class);
    starter.putExtra();
    context.startActivity(starter);
}
```