import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://192.168.56.1:8888/jdbc?useUnicode=true&characterEncoding=utf8";
        String username = "root";
        String password = "123456";
        Connection con = DriverManager.getConnection(url, username, password);
        Statement state = con.createStatement();
        String sql = "SELECT * FROM jdbc_01";
        // 返回的ResultSet的实现类对象，依然是在驱动包里实现的
        ResultSet result = state.executeQuery(sql);
        // 处理结果集
        while (result.next()) {
            int vInt = result.getInt("sid");
            String vString = result.getString("sname");
            System.out.println(vInt); // 得到每竖列的数据 int类型
            System.out.println(vString); // 得到每竖列的数据 String类型
        }
        result.close();
        state.close();
        con.close();

    }
}
