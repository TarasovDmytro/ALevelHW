package ua.tarasov.horsesrace.repositoriy;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.tarasov.horsesrace.repositoriy.models.entities.RaceEntity;

import java.util.List;

public interface RaceRepo extends JpaRepository<RaceEntity, Integer> {
    List<RaceEntity> findRaceEntityByPlayHorseId(int playHorsId);
}
