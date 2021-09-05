package servlets;

import com.google.gson.Gson;
import models.Statistic;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class StatisticsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter respBody = resp.getWriter();
        Statistic statistic = Statistic.getStatistic();

        resp.setContentType("application/json");

        respBody.println(new Gson().toJson(statistic, statistic.getClass()));
    }
}
