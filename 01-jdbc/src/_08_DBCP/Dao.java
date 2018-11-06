package _08_DBCP;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import utils.DBCPUtils;

import java.sql.SQLException;

// 操作数据库中的表
// 两个方法，分别实现了用户注册与登录
public class Dao {
    private static QueryRunner qr = DBCPUtils.getqr();

    public Boolean login(String username, String password) {
        Object[] list = null;
        String sql = "select * from dbcp_08 where dusername=? and dpassword=?";
        Object[] arr = {username, password};
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
}