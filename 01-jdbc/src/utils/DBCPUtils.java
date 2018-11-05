package utils;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;

import java.lang.reflect.Method;

public class DBCPUtils {
    private DBCPUtils() {
    }

    public static void main(String[] args) {

    }

    private static BasicDataSource bds;
    private static BasicDataSource dbs;
    private static QueryRunner qr;
    private static Class c;

    static {
        bds = new BasicDataSource();
        bds.setDriverClassName("com.mysql.jdbc.Driver");
        bds.setUsername("root");
        bds.setPassword("123456");
        bds.setUrl("jdbc:mysql://192.168.56.1:8888/jdbc?useUnicode=true&characterEncoding=utf8");
        // 连接池进行配置
        bds.setInitialSize(50); // 连接池初始化连接数
        bds.setMaxTotal(40); // 最大连接数量
        bds.setMaxIdle(30); // 最大空闲数
        bds.setMinIdle(1); // 最小空闲数
    }

    static {
        c = DBCPUtils.class;
    }

    public static BasicDataSource getClassReflect() {
        Method m = null;
        try {
            m = c.getMethod("getDataSource");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            dbs = (BasicDataSource) m.invoke(c.newInstance());
        } catch (Exception e) {
            throw new RuntimeException("执行method异常");
        }
        return dbs;
    }

    public static QueryRunner getqr() {
        Method m = null;
        try {
            m = c.getMethod("getQueryRunner");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            qr = (QueryRunner) m.invoke(c.newInstance());
        } catch (Exception e) {
            throw new RuntimeException("执行method异常");
        }
        return qr;
    }

    public BasicDataSource getDataSource() {
        return bds;
    }

    public QueryRunner getQueryRunner() {
        return new QueryRunner(bds);

    }
}
