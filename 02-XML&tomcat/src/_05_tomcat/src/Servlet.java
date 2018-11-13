import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/*
    先找service方法，没有就找HttpServlet类里的service方法，存在就执行，内部有调用了service的重载方法，重载方法里通过getMethod()方法判断是post还是get请求，再进行doGet或者doPost方法调用，最终调用子类重写方法
 */
public class Servlet extends HttpServlet {
    private static BasicDataSource bds = new BasicDataSource();
    static {
        bds.setDriverClassName("com.mysql.jdbc.Driver");
        bds.setUsername("root");
        bds.setPassword("123456");
        bds.setUrl("jdbc:mysql://192.168.56.1:8888/tomcat?useUnicode=true&characterEncoding=utf8");

        bds.setInitialSize(50);
        bds.setMaxTotal(40);
        bds.setMaxIdle(30);
        bds.setMinIdle(1);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        QueryRunner con = new QueryRunner(bds);
        String sql = "select * from 05_tomcat where tusername=? and tpassword=?";
        String[] s = {username,password};
        try {
            Integer result = con.query(sql,new ScalarHandler<Integer>(),s);
            System.out.println(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("执行post方法，调用doGet并将req与res传递过去");
        doGet(req, resp);
    }
}
