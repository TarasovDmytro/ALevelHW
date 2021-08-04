package entities;

import entities.Album;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany(mappedBy = "artists", cascade = CascadeType.ALL)
    private List<Album> albums = new ArrayList<>();

    public Artist(String title) {
        this.title = title;
    }
}
