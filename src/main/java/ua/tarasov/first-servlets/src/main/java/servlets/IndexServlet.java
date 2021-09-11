package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String client = req.getParameter("client");
        if (client == null) {
            client = "anonymous user";
        }
        String indexServlet = "/visitor-count?client=" + client;
//        resp.sendRedirect(req.getContextPath() + indexServlet);
        getServletContext().getRequestDispatcher(indexServlet).forward(req, resp);
    }
}

