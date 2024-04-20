package ucema.prog3.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.List;

@Entity public class Listener extends Usuario{
    @ManyToMany List<Playlist> playlists_guardadas;

    public Listener(String p_nombre, String p_apellido, String p_usuario, String p_password) {
        super(p_nombre, p_apellido, p_usuario, p_password);
    }
}
