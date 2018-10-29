import java.sql.*;
public class prepareStatementDemo {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://192.168.56.1:8888/jdbc?useUnicode=true&characterEncoding=utf8";
        String username = "root";
        String password = "123456";
        Connection con = DriverManager.getConnection(url, username, password);
        /*
         使用Statement子接口PreparedStatement子接口预编译sql，防止注入攻击
         使用Connection实现类的prepareStatement方法得到PrepareStatement实现类
         */
        String sql = "select * from jdbc_03 where username=? and password=?";
        // ? 占位符
        PreparedStatement state = con.prepareStatement(sql);
        state.setString(1, "a");
        state.setInt(2, 1);
        ResultSet r = state.executeQuery();
        System.out.println(r);
        con.close();
    }
}