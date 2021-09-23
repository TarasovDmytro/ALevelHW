package ua.tarasov.horsesrace.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.tarasov.horsesrace.dto.Horse;
import ua.tarasov.horsesrace.repositoriy.HorseRepo;
import ua.tarasov.horsesrace.repositoriy.models.entities.HorseEntity;

import java.util.ArrayList;
import java.util.List;

@Service
public class HorseService {

    private final HorseRepo horseRepo;

    @Autowired
    public HorseService(HorseRepo horseRepo) {
        this.horseRepo = horseRepo;
    }

    public List<Horse> getAllHorses() {
        List<Horse> horses = new ArrayList<>();
        horseRepo.findAll().forEach(it -> horses.add(new Horse(it.getId(), it.getHorseName())));
        return horses;
    }

    public Horse getHorseById(int id) {
        return horseRepo.findById(id).map(entity -> new Horse(entity.getId(), entity.getHorseName())).orElse(new Horse());
    }

    public Horse saveHorse(Horse horse) {
        HorseEntity entity = horseRepo.save(new HorseEntity(horse.getId(), horse.getHorseName()));
        return new Horse(entity.getId(), entity.getHorseName());
    }

}
