package ucema.prog3.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ucema.prog3.app.model.*;
import ucema.prog3.app.repositories.PlaylistRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    @Override
    @Transactional
    public Playlist createPlaylist(String nombre, Publisher publisher, List<Cancion> songs) {
        Playlist playlist = new Playlist(nombre, publisher, songs);
        this.playlistRepository.save(playlist);
        publisher.addPlaylist(playlist);
        return playlist;
    }

    @Override
    @Transactional
    public Playlist updatePlaylist(Playlist playlist) {
        return this.playlistRepository.save(playlist);
    }

    @Override
    @Transactional
    public boolean deletePlaylist(Playlist playlist) {
        if(playlist == null || playlist.getId() == null || playlist.getSongs().isEmpty()) {
            return false;
        }
        try{
            this.playlistRepository.delete(playlist);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Playlist> getAll() {
        return (List<Playlist>) this.playlistRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Playlist> getByNombre(String nombrePlaylist) {
        return (List<Playlist>) this.playlistRepository.findByNombre(nombrePlaylist);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Playlist> getByPublisher(Publisher publisher) {
        return this.playlistRepository.findByPublisher(publisher);
    }

    @Override
    @Transactional
    public void addSong(Playlist playlist, Cancion cancion) {
        playlist.addSong(cancion);
    }

    @Override
    @Transactional
    public void escucharPlaylist(Listener listener, Playlist playlist) {
        listener.addPlaylist(playlist);
        playlist.addListener(listener);
    }
}
