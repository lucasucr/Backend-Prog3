package ucema.prog3.app.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @NoArgsConstructor @Entity @Table(name = "song")
public class Cancion {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_song")
    private double id;
    @Column(nullable = false)
    private String Nombre;
    @Column(nullable = false, unique = true)
    private String Artista;
    @Column(nullable = false)
    private String Album;
    @ManyToMany(mappedBy = "songs") private List<Playlist> playlists;
}
