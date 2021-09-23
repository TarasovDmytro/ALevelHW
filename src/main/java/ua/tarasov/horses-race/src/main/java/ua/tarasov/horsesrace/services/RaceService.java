package ua.tarasov.horsesrace.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.tarasov.horsesrace.dto.Horse;
import ua.tarasov.horsesrace.dto.Race;
import ua.tarasov.horsesrace.repositoriy.RaceRepo;
import ua.tarasov.horsesrace.repositoriy.models.entities.HorseEntity;
import ua.tarasov.horsesrace.repositoriy.models.entities.RaceEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RaceService {

    private final RaceRepo raceRepo;

    @Autowired
    public RaceService(RaceRepo raceRepo) {
        this.raceRepo = raceRepo;
    }

    public List<Race> getAllRaces() {
        List<Race> races = new ArrayList<>();
        raceRepo.findAll().forEach(raceEntity -> {
            List<Horse> currentHorses = new ArrayList<>();
            raceEntity.getHorses().forEach(horseEntity -> currentHorses.add(new Horse(horseEntity.getId(),
                    horseEntity.getHorseName())));
            races.add(new Race(raceEntity.getId(), raceEntity.getDate(), raceEntity.getHorsesTotal(),
                    raceEntity.getPlayHorseId(), currentHorses));
        });
        return races;
    }

    public List<Race> getAllRacesByPlayHorse(int playHorseId) {
        List<Race> races = new ArrayList<>();
        List<Horse> horses = new ArrayList<>();
        raceRepo.findRaceEntityByPlayHorseId(playHorseId).forEach(it -> {
            it.getHorses().forEach(horse -> horses.add(new Horse(horse.getId(), horse.getHorseName())));
            races.add(new Race(it.getId(), it.getDate(),
                    it.getHorsesTotal(), it.getPlayHorseId(), horses));
        });
        return races;
    }

    public Race saveRace(Race race) {
        List<HorseEntity> horsesEntity = new ArrayList<>();
        List<Horse> horses = new ArrayList<>();
        race.getHorses().forEach(horse -> horsesEntity.add(new HorseEntity(horse.getId(), horse.getHorseName())));
        RaceEntity entity = raceRepo.save(new RaceEntity(race.getId(), race.getDate(), race.getHorsesTotal(),
                race.getPlayHorseId(), horsesEntity));
        entity.getHorses().forEach(horseEntity -> horses.add(new Horse(horseEntity.getId(), horseEntity.getHorseName())));
        return new Race(entity.getId(), entity.getDate(), entity.getHorsesTotal(), entity.getPlayHorseId(), horses);
    }

    public void deleteRace(int id) {
        raceRepo.deleteById(id);
    }

    public Optional<Race> getRace(int id) {
        List<Horse> horses = new ArrayList<>();
        return raceRepo.findById(id).map(entity -> {
            entity.getHorses().forEach(horse -> horses.add(new Horse(horse.getId(), horse.getHorseName())));
            return new Race(entity.getId(), entity.getDate(), entity.getHorsesTotal(), entity.getPlayHorseId(), horses);
        });
    }
}
