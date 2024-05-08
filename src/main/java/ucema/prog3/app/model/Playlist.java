package ucema.prog3.app.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data @NoArgsConstructor @Entity
public class Playlist {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_playlist") private double id;
    @Column(name = "NombrePlaylist") private String nombre_playlist;
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Publisher publisher;
    @Transient
    private List<Listener> listeners;

    @ManyToMany
    @JoinTable(
            name = "playlist_songs",
            joinColumns = @JoinColumn(name = "id_playlist"),
            inverseJoinColumns = @JoinColumn(name = "id_song")
    )
    private List<Cancion> songs;

    public Playlist(String p_nombre_playlist){
        setNombre_playlist(p_nombre_playlist);
    }
}
