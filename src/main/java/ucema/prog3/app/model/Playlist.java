package ucema.prog3.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data public class Playlist {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private double id;
    @Column(name = "NombrePlaylist") private String nombre_playlist;

    public Playlist(String p_nombre_playlist){
        setNombre_playlist(p_nombre_playlist);
    }
}
