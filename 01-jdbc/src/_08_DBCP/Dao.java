package _08_DBCP;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.DBCPUtils;

import java.sql.SQLException;

// 操作数据库中的表
// 两个方法，分别实现了用户注册与登录
public class Dao {
    private static QueryRunner qr = DBCPUtils.getqr();

    // 登录验证
    public Boolean login(String username, String password) {
        Object[] list = null;
        String sql = "select * from dbcp_08 where dusername=? and dpassword=?";
        String[] arr = {username, password};
        try {
            list = qr.query(sql, arr, new ArrayHandler());
        } catch (SQLException e) {
            throw new RuntimeException("数据库查询数失败");
        }
        // 数组进行判断
        if (list.length == 0) {
            // 说明没有结果集
            return false;
        } else {
            // 如果不等于0，说明有结果集
            return true;
        }
    }

    // 注册验证
    public Boolean register(String username, String password) {
        Integer v = null;
        // 拼写sql语句，检查用户名是否被占用
        String sql = "select * from dbcp_08 where dusername=?";
        // 调用qr对象，查询结果集
        try {
            v = qr.query(sql, username, new ScalarHandler<Integer>());
        } catch (SQLException e) {
            throw new RuntimeException("数据库查询数失败");
        }
        // 如果用户存在，返回false，用户不存在结果是null，那么返true
        if (v != null)
            return false;
        // 说明v等于null，那么用户不存在，就可以进行注册
        // 进行sql语句插入
        String insert = "insert into dbcp_08(dusername,dpassword) values (?,?)";
        String[] params = {username, password};
        try {
            int result = qr.update(insert, params);
        } catch (SQLException e) {
            throw new RuntimeException("写入数据失败");
        }
        return true;
    }
}