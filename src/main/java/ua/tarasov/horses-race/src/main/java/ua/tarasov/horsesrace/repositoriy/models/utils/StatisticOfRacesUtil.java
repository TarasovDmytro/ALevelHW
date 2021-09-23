package ua.tarasov.horsesrace.repositoriy.models.utils;

import lombok.Getter;
import ua.tarasov.horsesrace.dto.Race;

import javax.persistence.Transient;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class StatisticOfRacesUtil {

    @Transient
    private static volatile StatisticOfRacesUtil statisticOfRaces;
    @Transient
    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private String currentDate;
    private final Map<Race, String> racesPlaces = new HashMap<>();
    private int totalRaces;

    private StatisticOfRacesUtil() {
        this.currentDate = LocalDate.now().format(FORMAT);
    }

    public static StatisticOfRacesUtil getStatisticOfRaces(List<Race> race) {
        if (statisticOfRaces != null) {
            statisticOfRaces.currentDate = LocalDate.now().format(FORMAT);
            statisticOfRaces.totalRaces = race.size();
            extractPlaceOfRace(race);
        } else {
            statisticOfRaces = new StatisticOfRacesUtil();
            extractPlaceOfRace(race);
            statisticOfRaces.totalRaces = race.size();
        }
        return statisticOfRaces;
    }

    private static void extractPlaceOfRace(List<Race> races) {
        Map<Race, String> currentPlaces = new HashMap<>();
        for (Race race : races) {
            for (int i = 0; i < race.getHorses().size(); i++) {
                if (race.getHorses().get(i).getId() == race.getPlayHorseId()) {
                    currentPlaces.put(race, "Place = " + (i + 1));
                }
            }
        }
        statisticOfRaces.getRacesPlaces().putAll(currentPlaces);
    }

    @Override
    public String toString() {
        return "StatisticOfRacesUtil{" +
                "currentDate='" + currentDate + '\'' +
                ", racesPlaces=" + racesPlaces +
                ", totalRaces=" + totalRaces +
                '}';
    }
}