package _05_DBUtils;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import utils.JDBCUtils;

import java.sql.Connection;

// QueryRunner类进行数据库的操作
public class QueryRunner05 {
    private static Connection con;
    private static QueryRunner qr;

    static {
        con = JDBCUtils.getConnection();
        qr = new QueryRunner();
    }

    public static void main(String[] args) throws Exception {
        insert(); // insert into
        modify(); // update jdbc_01
    }

    public static void insert() throws Exception {
        // 插入操作
        String sql = "insert into jdbc_01(sname,sprice,sdesc) values (?,?,?)";
        Object[] params = {"成人", 1000, "稀有货品"};
        int v = qr.update(con, sql, params);
        DbUtils.closeQuietly(con);
    }

    public static void modify() throws Exception {
        // 修改数据
        String sql = "update jdbc_01 set sname=?,sprice=?,sdesc=? where sid=1";
        Object[] params = {"修改", 2000, "测试修改数据"};
        int v = qr.update(con, sql, params);
        DbUtils.closeQuietly(con);
    }
}
