import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbc_01 {
    public static void main(String[] args) throws Exception {
        // 1.不推荐的做法
        // DriverManager.registerDriver(new Driver());

        // 2.通过反射方式进行注册
        Class.forName("com.mysql.jdbc.Driver");

        // url连接完整
        String url = "jdbc:mysql://192.168.56.1:8888/jdbc?useUnicode=true&characterEncoding=utf8";
        String username = "root";
        String password = "123456";
        Connection c = DriverManager.getConnection(url, username, password);
        /*
            com.mysql.jdbc.JDBC4Connection@2b05039f
            com.mysql.jdbc.JDBC4Connection：实现类
            @2b05039f：内存地址
        */

        // 3.获取执行sql操作对象
        Statement s = c.createStatement();
        System.out.println(s);

        // 4.执行sql语句，获取结果
        String insert = "insert into jdbc_01_sort(sname,sprice,sdesc) values('工具',7000,'装潢用品') ";
        int i = s.executeUpdate(insert);
        System.out.println(i);
    }
}