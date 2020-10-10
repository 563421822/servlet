package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class PermissionsFilter implements Filter {
    public PermissionsFilter() {
        System.out.println("PermissionFilter构造方法");
    }

    public void destroy() {
        System.out.println("PermissionFilter.destroy");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("PermissionFilter请求执行");
        chain.doFilter(req, resp);
        System.out.println("PermissionFilter响应执行");
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("PermissionFilter.init");

    }

}
