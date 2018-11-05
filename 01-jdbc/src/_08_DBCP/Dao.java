package _08_DBCP;

import org.apache.commons.dbutils.QueryRunner;
import utils.DBCPUtils;

// 操作数据库中的表
// 两个方法，分别实现了用户注册与登录
public class Dao {
    private static QueryRunner qr = DBCPUtils.getqr();

    public Boolean login(String username, String password) {

        return false;
    }
}
