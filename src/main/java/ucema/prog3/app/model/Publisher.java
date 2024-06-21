package ucema.prog3.app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter @Getter @Entity @NoArgsConstructor
public class Publisher extends Usuario{
    @OneToMany(mappedBy = "publisher")
    private List<Playlist> playlists_creadas;

    public Publisher(String p_nombre, String p_apellido/*, String p_usuario, String p_password*/) {
        super(p_nombre, p_apellido/*, p_usuario, p_password*/);
        setPlaylists_creadas(new ArrayList<Playlist>());
    }

    public void addPlaylist(Playlist playlist){
        this.playlists_creadas.add(playlist);
    }
}
