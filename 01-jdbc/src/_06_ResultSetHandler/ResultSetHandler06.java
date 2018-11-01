package _06_ResultSetHandler;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
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

    @Test // BeanHandler
    public void beanHandler() throws Exception {
        // BeanHandler,将一行数据封装成java Bean类对象
        String sql = "select * from jdbc_01";
        jdbc01bean jdbcbean = qr.query(con, sql, new BeanHandler<jdbc01bean>(jdbc01bean.class));
        System.out.println(jdbcbean.getSdesc());
    }

    @Test // BeanListHandler
    public void beanListHandler() throws Exception {
        // BeanListHandler类，将每行数据封装bean类，并存储到List集合中
        String sql = "select * from jdbc_01";
        List<jdbc01bean> list = qr.query(con, sql, new BeanListHandler<jdbc01bean>(jdbc01bean.class));
        Iterator<jdbc01bean> it = list.iterator();
        while (it.hasNext()) {
            jdbc01bean jdbc = it.next();
            System.out.print(jdbc.getSdesc() + "\t");
        }
    }

    @Test // ColumnListHandler
    public void columnListHandler() throws Exception {
        // ColumnListHandler类，将指定竖列封装到List集合中
        String sql = "select * from jdbc_01";
        // 传递sname指定获取sname的那一列数据
        List<Object> list = qr.query(con, sql, new ColumnListHandler<Object>("sname"));
        Iterator<Object> it = list.iterator();
        while (it.hasNext()) {
            Object o = it.next();
            System.out.print(o + "\t");
        }
    }
}