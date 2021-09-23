package ua.tarasov.horsesrace.controllers;

import org.springframework.web.bind.annotation.*;
import ua.tarasov.horsesrace.dto.Horse;
import ua.tarasov.horsesrace.dto.Race;
import ua.tarasov.horsesrace.repositoriy.models.utils.DistanceCounterUtil;
import ua.tarasov.horsesrace.repositoriy.models.utils.StatisticOfRacesUtil;
import ua.tarasov.horsesrace.services.HorseService;
import ua.tarasov.horsesrace.services.RaceService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

@RestController
@RequestMapping("")
public record RaceController(RaceService racesService, HorseService horseService) {

    private static final ReentrantLock reentrantLock = new ReentrantLock(true);


    @GetMapping("/races")
    public List<Race> getAllRaces() {
        return racesService.getAllRaces();
    }

    @GetMapping("/race/start")
    public String startRace(@RequestParam(value = "horses-total") int horsesTotal,
                            @RequestParam(value = "horse-id") int playHorseId) {
        if (horsesTotal >= playHorseId && playHorseId > 0) {
            var race = new Race(horsesTotal, playHorseId);
            race = racesService.saveRace(race);
            while (horseService.getAllHorses().size() < race.getHorsesTotal() || horseService.getAllHorses() == null) {
                horsesInit();
            }

            var executor = Executors.newCachedThreadPool();
            for (int i = 0; i < race.getHorsesTotal(); i++) {
                int finalI = (i + 1);
                Race finalCurrentRace = race;
                executor.execute(() -> {
                    Horse horse = horseService.getHorseById(finalI);
                    DistanceCounterUtil counter = new DistanceCounterUtil(horse);
                    try {
                        horseRun(counter, finalCurrentRace);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
            executor.shutdown();
            return "Your bid has been accepted ... Congratulations, the race has begun !!!";
        } else return "Bad idea - horse number cannot be less than 1 or more than the number of horses" +
                " participating in the race";
    }

    @GetMapping("/race/{id}")
    public Race getRace(@PathVariable int id){
        Race race = racesService.getRace(id).orElse(new Race());
        if (race.getId() == 0){
            throw new RuntimeException("This race doesn't exist");
        } else return race;
    }

    @GetMapping("/stats")
    public StatisticOfRacesUtil getStatisticOfRaces() {
        List<Race> races = racesService.getAllRaces();
        if (races.isEmpty()) {
            throw new RuntimeException("Races don't exist");
        } else {
            return StatisticOfRacesUtil.getStatisticOfRaces(races);
        }
    }


    private void horseRun(DistanceCounterUtil counter, Race race) throws InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(race.getHorsesTotal());
        try {
            while (counter.getCounter() < 1000) {
                counter.counterIncr(Horse.MIN_DISTANCE + new Random().nextInt(Horse.DELTA));
                Thread.sleep((Horse.MIN_TIME + new Random().nextInt(Horse.DELTA)));
            }

            reentrantLock.lock();
            try {
                Horse horse = counter.getHorse();
                List<Integer> horsesId = new ArrayList<>();
                race.getHorses().forEach(currentHorse -> horsesId.add(currentHorse.getId()));
                if (!horsesId.contains(horse.getId())) {
                    race.getHorses().add(horse);
                }
                racesService.saveRace(race);
            } finally {
                reentrantLock.unlock();
            }

            barrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    private void horsesInit() {
        var horse = new Horse();
        horse = horseService.saveHorse(horse);
        horse.setHorseName("Hors " + (horse.getId()));
        horseService.saveHorse(horse);
    }
}
