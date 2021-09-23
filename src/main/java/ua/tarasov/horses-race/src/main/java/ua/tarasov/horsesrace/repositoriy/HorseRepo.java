package ua.tarasov.horsesrace.repositoriy;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.tarasov.horsesrace.repositoriy.models.entities.HorseEntity;

public interface HorseRepo extends JpaRepository<HorseEntity, Integer> {
}
