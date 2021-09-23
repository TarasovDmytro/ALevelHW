package ua.tarasov.horsesrace.repositoriy.models.utils;

import lombok.Getter;
import ua.tarasov.horsesrace.dto.Horse;

@Getter
public class DistanceCounterUtil {

    private int counter;
    private final Horse horse;

    public DistanceCounterUtil(Horse horse) {
        this.counter = 0;
        this.horse = horse;
    }

    public void counterIncr(int counter){
        this.counter += counter;
    }
}
