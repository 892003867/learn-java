import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

// sql防止注入攻击
public class JDBC {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://192.168.56.1:8888/jdbc?useUnicode=true&characterEncoding=utf8";
        String username = "root";
        String password = "123456";
        Connection con = DriverManager.getConnection(url, username, password);
        Statement state = con.createStatement();
        String sql = "SELECT * FROM jdbc_01_sort";
        ResultSet result = state.executeQuery(sql);
        while (result.next()) {
            int vInt = result.getInt("sid");
            String vString = result.getString("sname");
        }
        result.close();
        state.close();
        con.close();
    }
}
