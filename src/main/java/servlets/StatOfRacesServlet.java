package servlets;

import Controllers.RaceController;
import com.google.gson.Gson;
import utils.StatisticOfRacesUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class StatOfRacesServlet extends HttpServlet {

    private final RaceController controller = new RaceController();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter respBody = resp.getWriter();
        resp.setContentType("application/json");

        StatisticOfRacesUtil statistic = controller.getStatisticOfRaces();

        if (statistic == null || statistic.getTotalRaces() == 0) {
            resp.sendError(400, "Races have not yet taken place");
        } else {
            respBody.println(new Gson().toJson(statistic));
        }
    }
}
