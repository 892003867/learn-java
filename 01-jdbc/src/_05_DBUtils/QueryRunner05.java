package _05_DBUtils;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.jupiter.api.Test;
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

    @Test // insert into
    public void insert() throws Exception {
        // 插入
        String sql = "insert into jdbc_01(sname,sprice,sdesc) values (?,?,?)";
        Object[] params = {"成人", 1000, "稀有货品"};
        int v = qr.update(con, sql, params);
        DbUtils.closeQuietly(con);
    }

    @Test
    public void modify() throws Exception {
        // 修改
        String sql = "update jdbc_01 set sname=?,sprice=?,sdesc=? where sid=?";
        Object[] params = {"修改", 2000, "测试修改数据", 1};
        int v = qr.update(con, sql, params);
        DbUtils.closeQuietly(con);
    }

    @Test // delete
    public void delete() throws Exception {
        // 删除
        String sql = "delete from jdbc_01 where sid=?";
        Object[] params = {7};
        int v = qr.update(con, sql, params);
        DbUtils.closeQuietly(con);
    }
}
