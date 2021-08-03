package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "tracks")
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private double price;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Artist artist;

    public Track(String title, double price, Artist artist) {
        this.title = title;
        this.price = price;
        this.artist = artist;
    }
}
