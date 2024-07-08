package ucema.prog3.app.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @NoArgsConstructor @Entity
public class Playlist {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_playlist") private Double id;
    @Column(name = "NombrePlaylist") private String nombre;
    @ManyToOne
    @JoinColumn(name = "id_usuario", insertable = false, updatable = false)
    private Publisher publisher;
    @ManyToMany
    @JoinTable(
            name = "playlist_listeners",
            joinColumns = @JoinColumn(name = "id_playlist"),
            inverseJoinColumns = @JoinColumn(name = "id_usuario")
    )
    private List<Listener> playlist_listeners;

    @ManyToMany
    @JoinTable(
            name = "playlist_songs",
            joinColumns = @JoinColumn(name = "id_playlist"),
            inverseJoinColumns = @JoinColumn(name = "id_song")
    )
    private List<Cancion> songs;

    public Playlist(String pNombre, Publisher pPublisher, List<Cancion> pSongs){
        setNombre(pNombre);
        setPublisher(pPublisher);
        setSongs(pSongs);
    }

    public void addSong(Cancion cancion){
        this.songs.add(cancion);
    }
}
