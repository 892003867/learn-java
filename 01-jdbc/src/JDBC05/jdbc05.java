package JDBC05;

import utils.JDBCUtils;

import java.sql.Connection;

public class jdbc05 {
    public static void main(String[] args) {
        Connection c =JDBCUtils.getConnection();
        System.out.println(c);
    }
}
