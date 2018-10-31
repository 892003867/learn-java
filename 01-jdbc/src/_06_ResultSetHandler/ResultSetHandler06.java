package _06_ResultSetHandler;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.junit.jupiter.api.Test;
import utils.JDBCUtils;

import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

public class ResultSetHandler06 {
    private static Connection con;
    private static QueryRunner qr;

    static {
        con = JDBCUtils.getConnection();
        qr = new QueryRunner();
    }

    @Test // ArrayHandler
    public void arrayHandler() throws Exception {
        // arrayHandler,只查询第一行的数据
        String sql = "select * from jdbc_01";
        Object[] v = qr.query(con, sql, new ArrayHandler());
        for (Object o : v) {
            System.out.print(o + "\t");
        }
        DbUtils.closeQuietly(con);
    }

    @Test // ArrayListHandler
    public void arrayListHandler() throws Exception {
        // ArrayListHandler,每一行封装到对象数组中
        String sql = "select * from jdbc_01";
        List<Object[]> v = qr.query(con, sql, new ArrayListHandler());
        Iterator i = v.iterator();
        while (i.hasNext()) {
            Object[] result = (Object[]) i.next();
            for (Object o : result) {
                System.out.print(o + "\t");
            }
            System.out.println();
        }
        DbUtils.closeQuietly(con);
    }
}