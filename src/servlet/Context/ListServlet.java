package servlet.Context;

import com.google.gson.Gson;
import po.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 文件列表
 * Created by Administrator on 2016/9/26.
 */
@WebServlet(urlPatterns = "/api/context/get")
public class ListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("in");
        Gson gson = new Gson();
//        Context context = new Context("name","password");
//        String s = gson.toJson(context);
        PrintWriter writer = response.getWriter();
//        writer.write(s);

    }
}
