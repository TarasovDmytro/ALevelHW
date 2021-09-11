package services;

import dao.HorseDao;
import entities.Horse;

import java.util.List;

public class HorseService {

    private final HorseDao horseDao = new HorseDao();

    public Horse getHorseById(int id) {
        Horse horse = horseDao.getInstanceById(id);
        if (horse != null) {
            return horse;
        } else throw new RuntimeException("The horse does not exist");
    }

    public List<Horse> getAllHorses() {
        List<Horse> horses = horseDao.getAllInstance();
        if (horses != null) {
            return horses;
        } else throw new RuntimeException("Horses don't exist");
    }

    public void createHorse(Horse horse) {
        if (horse != null) {
            horseDao.createInstance(horse);
        } else throw new RuntimeException("The horse does not exist");
    }

    public void updateHorse(Horse horse) {
        if (horse != null) {
            horseDao.updateInstance(horse);
        } else throw new RuntimeException("The horse does not exist");
    }
}
