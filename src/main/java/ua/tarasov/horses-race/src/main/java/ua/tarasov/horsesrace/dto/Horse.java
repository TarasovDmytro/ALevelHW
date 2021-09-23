package ua.tarasov.horsesrace.dto;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.lang.reflect.GenericArrayType;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Horse {

    private int id;
    private String horseName;

    public final static int MIN_DISTANCE = 100;
    public final static int MIN_TIME = 400;
    public final static int DELTA = 100;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Horse horse)) return false;
        return getId() == horse.getId() && getHorseName().equals(horse.getHorseName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getHorseName());
    }
}
