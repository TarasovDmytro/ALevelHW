package controllers;

import entities.Horse;
import entities.Race;
import services.HorseService;
import services.RaceService;
import utils.StatisticOfRacesUtil;

import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class RaceController {

    private final RaceService raceService = new RaceService();
    private final HorseService horseService = new HorseService();
    private final ReentrantLock reentrantLock = new ReentrantLock();

    public Race startRace(int numberOfHorses, int playHorseId) {
        var race = new Race(numberOfHorses, playHorseId);
        raceService.createRace(race);
        while (horseService.getAllHorses().size() < numberOfHorses || horseService.getAllHorses() == null) {
            horsesInit();
        }

        var executor = Executors.newCachedThreadPool();
        for (int i = 0; i < race.getHorsesTotal(); i++) {
            int finalI = (i + 1);
            executor.execute(() -> {
                Horse horse = horseService.getHorseById(finalI);
                try {
                    horseRun(horse, race);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executor.shutdown();
        return race;
    }

    private void horseRun(Horse horse, Race race) throws InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(race.getHorsesTotal());
        int distanceCounter = 0;

        try {
            while (distanceCounter < 1000) {
                distanceCounter += (Horse.MIN_DISTANCE + new Random().nextInt(Horse.DELTA));
                Thread.sleep((Horse.MIN_TIME + new Random().nextInt(Horse.DELTA)));
            }

            reentrantLock.lock();
            try {
                race.getHorses().add(horse);
                raceService.updateInstance(race);
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
        horseService.createHorse(horse);
        horse.setHorseName("Hors " + (horse.getId()));
        horseService.updateHorse(horse);
    }

    public StatisticOfRacesUtil getStatisticOfRaces() {
        return raceService.getStatisticOfRaces();
    }

    public Race getRaceById(int id) {
        return raceService.getRaceById(id);
    }

    public List<Race> getAllRaces() {
        return raceService.getAllRaces();
    }
}
