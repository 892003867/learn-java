package utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private JDBCUtils() {
    }

    private static Connection con;
    private static InputStream fis;
    private static Properties pro;

    static {
        fis = ClassLoader.getSystemResourceAsStream("utils/database.properties");
        pro = new Properties();
        try {
            pro.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("读取properties流错误");
        }
        try {
            Class.forName(pro.getProperty("driverClass"));
            String url = pro.getProperty("url");
            String username = pro.getProperty("username");
            String password = pro.getProperty("password");
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
