package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Horses")
public class Horse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String horseName;

    public final static int MIN_DISTANCE = 100;
    public final static int MIN_TIME = 400;
    public final static int DELTA = 100;

    public Horse() {
    }

    @Override
    public String toString() {
        return horseName;
    }
}


