package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@BatchSize(size = 50)
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

    public Track(Track track) {

        this.id = track.getId();
        this.title = track.getTitle();
        this.price = track.getPrice();
        this.artist = track.getArtist();
    }
}
