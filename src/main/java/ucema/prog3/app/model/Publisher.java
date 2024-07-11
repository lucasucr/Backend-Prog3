package ucema.prog3.app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Setter @Getter @Entity @NoArgsConstructor
public class Publisher extends Usuario{
    @OneToMany(mappedBy = "publisher")
    private List<Playlist> playlists_creadas;

    public Publisher(String p_nombre, String p_apellido, String usuario, String password) {
        super(p_nombre, p_apellido, usuario, password);
        setPlaylists_creadas(new ArrayList<Playlist>());
    }

    public void addPlaylist(Playlist playlist){
        this.playlists_creadas.add(playlist);
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
        authorities.add(new SimpleGrantedAuthority("PUBLISHER"));
        return authorities;
    }
}
