package servlet.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 文件列表
 * Created by Administrator on 2016/9/26.
 */
@WebServlet(urlPatterns = "/api/context/del/*")
public class DelServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object urlId = request.getAttribute("urlId");
        System.out.println(urlId);
    }
}
