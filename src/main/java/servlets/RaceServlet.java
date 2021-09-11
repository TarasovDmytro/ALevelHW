package servlets;

import Controllers.RaceController;
import entities.Horse;
import entities.Race;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class RaceServlet extends HttpServlet {

    private final RaceController controller = new RaceController();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter respBody = resp.getWriter();
        resp.setContentType("text/html");

        String pathValue = req.getPathInfo();

        if (pathValue.matches("/\\d+")) {
            String[] path = pathValue.split("/");
            int id = Integer.parseInt(path[1]);
            List<Race> races = controller.getAllRaces();
            if (races.size() >= id) {
                Race race = controller.getRaceById(id);
                respBody.println("<p><b>" + race + "</b></p>");
                List<Horse> horses = race.getHorses();
                for (int i = 0; i < horses.size(); i++) {
                    respBody.println("<p><b>Place " + (i + 1) + " - " + horses.get(i) + "</b></p>");
                }
            } else resp.sendError(400, "There is no such race");
        } else resp.sendError(400, "Bad request");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter respBody = resp.getWriter();
        resp.setContentType("text/html");

        int playHorseNumber = Integer.parseInt(req.getParameter("horse-number"));
        int horsesTotal = Integer.parseInt(req.getParameter("horses-total"));

        if (playHorseNumber < 1 || playHorseNumber > horsesTotal) {
            resp.sendError(400, "The number of the horse playing cannot be less than 1 or more than the number" +
                    " of horses participating in the race");
        } else {
            synchronized (controller) {
                controller.startRace(horsesTotal, playHorseNumber);
                resp.setStatus(200);
                respBody.println("Congratulations! The race has begun!");
            }
        }
    }
}
