package servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class VisitorsCountServlet extends HttpServlet {

    private final Map<String, String> visitors = new HashMap<>();

    @Override
    public void init() {
        System.out.println(getServletName() + " initialized");
    }

    @Override
    synchronized protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter respBody = resp.getWriter();
        String ipAddress = req.getRemoteAddr();
        String bodyUA = req.getHeader("user-agent");

        resp.setContentType("text/html");
        respBody.println("<h1 align=\"center\">My first Servlet GET method processing</h1>");
        respBody.println("<h3 align=\"center\">Request from: " + ipAddress + "</h3>");

        String client = req.getParameter("client");
        respBody.println("<h2 align=\"center\">Hi, " + client + " </h2>");

        visitors.put(ipAddress, bodyUA);
        respBody.println("<h3>Unique users who visited this page:</h3>");
        visitors.forEach((key, value) -> {
            if (key.equals(ipAddress)) {
                respBody.println("<p><b>" + key + "::" + value + "</b></p>");
            } else respBody.println("<p>" + key + "::" + value + "</p>");
        });
    }

    @Override
    public void destroy() {
        System.out.println(getServletName() + " destroyed");
    }
}
