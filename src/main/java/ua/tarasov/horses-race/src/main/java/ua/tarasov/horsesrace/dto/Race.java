package ua.tarasov.horsesrace.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Race {

    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private int id = 0;
    private String date;
    private int horsesTotal;
    private int playHorseId;
    private List<Horse> horses = new ArrayList<>();

    public Race(int numberOfHorses, int playHorseId) {
        this.id = 0;
        this.date = LocalDate.now().format(FORMAT);
        this.horsesTotal = numberOfHorses;
        this.playHorseId = playHorseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Race race)) return false;
        return getId() == race.getId() && getHorsesTotal() == race.getHorsesTotal() && getPlayHorseId() == race.getPlayHorseId() && getDate().equals(race.getDate()) && getHorses().equals(race.getHorses());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDate(), getHorsesTotal(), getPlayHorseId(), getHorses());
    }
}
