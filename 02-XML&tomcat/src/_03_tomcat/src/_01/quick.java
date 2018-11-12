package _01;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class quick implements Servlet {
    // 初始化的方法
    //
    public void init(ServletConfig servletConfig) throws ServletException {
        // 1.获得servlet的<servlet-name>abc</servlet-name>
        String name = servletConfig.getServletName();
        System.out.println(name); // quick
        // 2.获得初始化的参数
        String url = servletConfig.getInitParameter("url");
        System.out.println(url); // dbdc:mysql://
        ServletContext context = servletConfig.getServletContext();
        System.out.println(context); // 获得Context对象

        
        System.out.println("init running");
    }

    //
    public ServletConfig getServletConfig() {
        return null;
    }

    //
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        System.out.println("server running");
        res.getWriter().write("quick");
    }

    //
    public String getServletInfo() {
        return null;
    }

    // 销毁的方法
    public void destroy() {
        System.out.println("destroy running");
    }
}
