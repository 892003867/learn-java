package _01;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class quick implements Servlet {
    // 初始化的方法
    //
    public void init(ServletConfig servletConfig) throws ServletException {
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
