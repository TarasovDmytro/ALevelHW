package utils;

import entities.Race;
import lombok.Getter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Getter
public class StatisticOfRacesUtil {

    private static volatile StatisticOfRacesUtil statisticOfRaces;
    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private String currentDate;
    private Map<Race, Integer> racesPlaces = new HashMap<>();
    private int totalRaces;

    private StatisticOfRacesUtil() {
        this.currentDate = LocalDate.now().format(FORMAT);
    }

    public static StatisticOfRacesUtil getStatisticOfRaces(List<Race> races) {
        StatisticOfRacesUtil result = statisticOfRaces;
        if (result != null) {
            result.currentDate = LocalDate.now().format(FORMAT);
            result.totalRaces = races.size();
            extractPlaceOfRace(races, result);
            return result;
        }
        if (statisticOfRaces == null) {
            statisticOfRaces = new StatisticOfRacesUtil();
            extractPlaceOfRace(races, statisticOfRaces);
            statisticOfRaces.totalRaces = races.size();
        }
        return statisticOfRaces;
    }

    private static void extractPlaceOfRace(List<Race> races, StatisticOfRacesUtil statisticOfRaces) {
        Map<Race, Integer> currentPlaces = new HashMap<>();
        for (Race race : races) {
            for (int i = 0; i < race.getHorses().size(); i++) {
                if (race.getHorses().get(i).getId() == race.getPlayHorseId()) {
                    currentPlaces.put(race, (i + 1));
                }
            }
        }
        statisticOfRaces.racesPlaces = currentPlaces;
    }

    @Override
    public String toString() {
        return "current date - " + currentDate +
                ", total races = " + totalRaces;
    }
}
