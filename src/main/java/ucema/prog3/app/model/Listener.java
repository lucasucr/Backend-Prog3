package ucema.prog3.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Setter
@Getter
@Entity @NoArgsConstructor public class Listener extends Usuario{
    @ManyToMany(mappedBy = "playlist_listeners")
    List<Playlist> playlistsGuardadas;

    public Listener(String p_nombre, String p_apellido, String usuario, String password) {
        super(p_nombre, p_apellido, usuario, password);
        setPlaylistsGuardadas(new ArrayList<Playlist>());
    }

    public void addPlaylist(Playlist playlist){
        this.playlistsGuardadas.add(playlist);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("LISTENER"));
        return authorities;
    }
}
