package _07_DBCP;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.util.List;
import java.util.Map;

public class basicDataSource {
    public static void main(String[] args) throws Exception {
        // 创建DataSource的实现类，BasicDataSource类
        BasicDataSource bds = new BasicDataSource();
        // 反射创建Driver驱动
        bds.setDriverClassName("com.mysql.jdbc.Driver");
        bds.setUsername("root");
        bds.setPassword("123456");
        bds.setUrl("jdbc:mysql://192.168.56.1:8888/jdbc?useUnicode=true&characterEncoding=utf8");
        // 连接池进行配置
        bds.setInitialSize(50); // 连接池初始化连接数
        bds.setMaxTotal(40); // 最大连接数量
        bds.setMaxIdle(30); // 最大空闲数
        bds.setMinIdle(1); // 最小空闲数

        // 使用QueryRunner
        QueryRunner qr = new QueryRunner(bds);
        String sql = "select * from jdbc_01";
        List<Map<String, Object>> rs = qr.query(sql, new MapListHandler());
        System.out.println(rs);

    }
}
