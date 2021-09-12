package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Races")
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Column(name = "Date_of_race")
    private String date;

    @Column(name = "Number_of_Horses")
    private int horsesTotal;

    @Column(name = "Play_horse")
    private int playHorseId;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "Races_horses",
            joinColumns = @JoinColumn(name = "race_id"),
            inverseJoinColumns = @JoinColumn(name = "horses_id"))
    private List<Horse> horses = new ArrayList<>();

    public Race(int numberOfHorses, int playHorseId) {
        this.date = LocalDate.now().format(FORMAT);
        this.horsesTotal = numberOfHorses;
        this.playHorseId = playHorseId;
    }

    public Race() {
    }

    @Override
    public String toString() {
        return "Race{ " +
                "id = " + id +
                ", date = '" + date + '\'' +
                ", horsesTotal = " + horsesTotal +
                ", playHorseId = " + playHorseId +
                " }";
    }
}
