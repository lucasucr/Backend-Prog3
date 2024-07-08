package ucema.prog3.app.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @NoArgsConstructor @Entity @Table(name = "song")
public class Cancion {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_song")
    private Double id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false, unique = true)
    private String artista;
    @Column(nullable = false)
    private String album;
    @ManyToMany(mappedBy = "songs") private List<Playlist> playlists;

    public Cancion(String pNombre, String pArtista, String pAlbum){
        setNombre(pNombre);
        setArtista(pArtista);
        setAlbum(pAlbum);
    }
}
