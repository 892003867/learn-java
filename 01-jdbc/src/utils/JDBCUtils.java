package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;

public class JDBCUtils {
    private JDBCUtils() {
    }

    private static Connection con;
    private static FileInputStream fis;

    static {
        try {
            fis = new FileInputStream("database.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException("properties文件找不到");
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://192.168.56.1:8888/jdbc?useUnicode=true&characterEncoding=utf8";
            String username = "root";
            String password = "123456";
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            throw new RuntimeException("e" + "数据库连接失败");
        }
    }

    // 静态方法
    public static Connection getConnection() {
        return con;
    }

    // 关闭方法
    public static void close(Connection con, Statement state, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
            }
        }
        if (state != null) {
            try {
                state.close();
            } catch (SQLException ex) {
            }
        }
    }

    public static void close(Connection con, Statement state) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
            }
        }
        if (state != null) {
            try {
                state.close();
            } catch (SQLException ex) {
            }
        }
    }
}
