package services;

import dao.RaceDao;
import entities.Race;
import utils.StatisticOfRacesUtil;

import java.util.List;

public class RaceService {

    RaceDao raceDao = new RaceDao();

    public StatisticOfRacesUtil getStatisticOfRaces() {
        List<Race> races = raceDao.getAllInstance();
        if (!races.isEmpty()) {
            return StatisticOfRacesUtil.getStatisticOfRaces(races);
        } else throw new RuntimeException("Races don't exist");
    }

    public void createRace(Race race) {
        if (race != null) {
            raceDao.createInstance(race);
        } else throw new RuntimeException("The race didn't start");
    }

    public void updateInstance(Race race) {
        if (race != null) {
            raceDao.updateInstance(race);
        } else throw new RuntimeException("The race does not exist");
    }

    public Race getRaceById(int id) {
        return raceDao.getInstanceById(id);
    }

    public List<Race> getAllRaces() {
        return raceDao.getAllInstance();
    }
}
