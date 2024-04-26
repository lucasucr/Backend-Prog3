package ucema.prog3.app.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity public class Publisher extends Usuario{
    @ManyToOne @Transient private List<Playlist> playlists_creadas;

    public Publisher(String p_nombre, String p_apellido, String p_usuario, String p_password) {
        super(p_nombre, p_apellido, p_usuario, p_password);
    }
}
