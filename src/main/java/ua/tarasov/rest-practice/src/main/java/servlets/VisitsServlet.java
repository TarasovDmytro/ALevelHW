package servlets;

import com.google.gson.Gson;
import models.Statistic;
import models.Visit;
import services.VisitService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class VisitsServlet extends HttpServlet {

    private final VisitService service = new VisitService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter respBody = resp.getWriter();
        resp.setContentType("application/json");
        Statistic.getStatistic();

        List<Visit> visits = service.getVisits();
        resp.setStatus(200);
        respBody.println(new Gson().toJson(visits));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter respBody = resp.getWriter();
        resp.setContentType("application/json");
        Statistic.getStatistic();

        String visitorName = req.getParameter("name");
        String visitorDate = req.getParameter("date");
        String visitorCity = req.getParameter("city");
        Visit visit = service.postVisit(visitorName, visitorDate, visitorCity);

        resp.setStatus(204);
        respBody.println(new Gson().toJson(visit));
    }
}
