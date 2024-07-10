package ucema.prog3.app.services;

import ucema.prog3.app.model.*;

import java.util.List;
import java.util.Optional;

public interface PlaylistService {
    Playlist createPlaylist(String nombre, Publisher publisher, List<Cancion> songs);

    Playlist updatePlaylist(Playlist playlist);

    boolean deletePlaylist(Playlist playlist);

    List<Playlist> getAll();

    List<Playlist> getByNombre(String nombrePlaylist);

    List<Playlist> getByPublisher(Publisher publisher);

    void addSong(Playlist playlist, Cancion cancion);

    void escucharPlaylist(Listener listener, Playlist playlist);
}
