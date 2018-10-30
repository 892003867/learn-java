package _04_JDBC;

import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/*
    JDBC读取数据表，每行封装到对象中
    每个类对象，存储到List集合当中
 */
public class jdbc04 {
    public static void main(String[] args) throws Exception {
        // 使用自己封装的jdbc工具类
        Connection con = JDBCUtils.getConnection();
        String sql = "select * from jdbc_01";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        // 创建结合
        List<bean04> list = new ArrayList<bean04>();
        while (rs.next()) {
            // 获取到的每个列数据封装到bean类中
            bean04 jdbc = new bean04(rs.getInt("sid"), rs.getString("sname"), rs.getDouble("sprice"), rs.getString("sdesc"));
            // 存储到集合当中
            list.add(jdbc);
        }
        // 遍历list集合
        for (bean04 jd : list) {
            System.out.print(jd.getSid() + "/" + jd.getSname() + "/" + jd.getSprice() + "/" + jd.getSdesc());
            System.out.println();
            /*
                1/家电/2000.0/优惠促销
                2/家具/8000.0/家具价格上调，原材料涨价
                3/玩具/300.0/赚家长钱
                4/生鲜/500.99/生鲜商品
                5/服装/24000.0/换季销售
                6/洗涤/50.0/洗发水促销
             */
        }
    }
}