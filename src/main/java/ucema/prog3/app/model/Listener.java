package ucema.prog3.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity @NoArgsConstructor public class Listener extends Usuario{
    @ManyToMany
    List<Playlist> playlistsGuardadas;

    public Listener(String p_nombre, String p_apellido, String p_usuario, String p_password) {
        super(p_nombre, p_apellido, p_usuario, p_password);
    }
}
