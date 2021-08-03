package entities;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "albums")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column
    private double price = 0;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "albums_artists",
            joinColumns = @JoinColumn(name = "album_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id")
    )
    private List<Artist> artists = new ArrayList<>();


    @OneToMany(cascade = CascadeType.ALL)
    private List<Track> tracks = new ArrayList<>();
}
