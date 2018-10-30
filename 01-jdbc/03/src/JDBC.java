import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

// sql注入攻击演示
public class JDBC {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://192.168.56.1:8888/jdbc?useUnicode=true&characterEncoding=utf8";
        String username = "root";
        String password = "123456";
        Connection con = DriverManager.getConnection(url, username, password);
        Statement state = con.createStatement();
        // or 1=1 是注入攻击的sql
        // 这将导致查询依旧可执行，这就很sql攻击注入
        String sql = "SELECT * FROM jdbc_03 where username='dad' and password='1312' or 1=1";
        ResultSet v = state.executeQuery(sql);
        System.out.println(v);
        state.close();
        con.close();
    }
}