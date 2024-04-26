package ucema.prog3.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity @NoArgsConstructor public class Listener extends Usuario{
    @ManyToMany @Transient List<Playlist> playlists_guardadas;

    public Listener(String p_nombre, String p_apellido, String p_usuario, String p_password) {
        super(p_nombre, p_apellido, p_usuario, p_password);
    }
}
