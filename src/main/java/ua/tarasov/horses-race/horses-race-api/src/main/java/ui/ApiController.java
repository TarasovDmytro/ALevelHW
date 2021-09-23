package ui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class ApiController implements Initializable {

    @FXML
    private WebView webView;

    @FXML
    private Button statisticOfRaces;

    @FXML
    private Button raceResult;

    @FXML
    private TextField raceId;

    @FXML
    private TextField totalHorses;

    @FXML
    private TextField horseId;

    @FXML
    private Button start;

    private WebEngine engine;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        engine = webView.getEngine();
        start.setOnAction(actionEvent -> startRace());
        statisticOfRaces.setOnAction(actionEvent -> loadStatisticOfRaces());
        raceResult.setOnAction(actionEvent -> loadRaceResult());
    }

    @FXML
    private void loadRaceResult() {
        String race = raceId.getText();
        engine.load("http://localhost:8008/race/" + race);
    }

    private void startRace() {

        String totHorses = totalHorses.getText();
        String horse = horseId.getText();
        engine.load("http://localhost:8008/race/start?horses-total=" + totHorses + "&horse-id=" + horse);
    }

    public void loadStatisticOfRaces() {
        engine.load("http://localhost:8008/stats");
    }
}