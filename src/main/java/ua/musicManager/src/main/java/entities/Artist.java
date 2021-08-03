package entities;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "artists")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "artist_name")
    private String title;

    @ManyToMany(mappedBy = "artists")
    private List<Album> albums = new ArrayList<>();

    public Artist(String title) {
        this.title = title;
    }
}
