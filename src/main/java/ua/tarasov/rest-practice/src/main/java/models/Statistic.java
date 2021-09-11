package models;

import lombok.Getter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
public final class Statistic {

    private static volatile Statistic statistic;
    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private String currentDate;
    private int requestCounter;

    private Statistic() {
        this.currentDate = LocalDate.now().format(FORMAT);
        this.requestCounter = 0;
    }

    public static Statistic getStatistic() {
        Statistic result = statistic;
        if (result != null) {
            result.requestCounter++;
            result.currentDate = LocalDate.now().format(FORMAT);
            return result;
        }
        synchronized (Statistic.class) {
            if (statistic == null) {
                statistic = new Statistic();
                statistic.requestCounter++;
            }
            return statistic;
        }
    }

    @Override
    public String toString() {
        return "Entity's.Statistic{" +
                "currentDate=" + currentDate +
                ", counter=" + requestCounter +
                '}';
    }
}
