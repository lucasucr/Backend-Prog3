package ucema.prog3.app.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data @NoArgsConstructor @Entity
public class Playlist {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private double id;
    @Column(name = "NombrePlaylist") private String nombre_playlist;

    @ManyToMany @Transient private List<Cancion> canciones;

    public Playlist(String p_nombre_playlist){
        setNombre_playlist(p_nombre_playlist);
    }
}
