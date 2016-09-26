package servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Administrator on 2016/9/26.
 */
@WebFilter(urlPatterns = "/*")
public class Filter implements javax.servlet.Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        resp.setContentType("text/json;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");

        String requestURI = ((HttpServletRequest)req).getRequestURI();
        String[] split = requestURI.split("/");
        if(split.length>1){
            String s = split[split.length - 1];
            System.out.println(s);
            req.setAttribute("urlId",s);
        }else{
            req.setAttribute("urlId","");
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
