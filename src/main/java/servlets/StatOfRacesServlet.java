package servlets;

import controllers.RaceController;
import utils.StatisticOfRacesUtil;

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
        resp.setContentType("text/html");

        StatisticOfRacesUtil statistic = controller.getStatisticOfRaces();

        if (statistic == null || statistic.getTotalRaces() == 0) {
            resp.sendError(400, "Races have not yet taken place");
        } else {
            respBody.println("<p><b>" + statistic + "</b></p>");
            respBody.println("<p>Place in races:</p>");
            statistic.getRacesPlaces().forEach((key, value) -> respBody.println("<p>" + key + " - place = " + value + "</p>"));
        }
    }
}
