package ucema.prog3.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ucema.prog3.app.dto.PlaylistDTO;
import ucema.prog3.app.model.Cancion;
import ucema.prog3.app.model.Listener;
import ucema.prog3.app.model.Playlist;
import ucema.prog3.app.model.Publisher;
import ucema.prog3.app.services.PlaylistService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/playlist")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @PostMapping(value = "")
    public Playlist createPlaylist(@RequestBody PlaylistDTO playlist){
        return playlistService.createPlaylist(playlist.getNombrePlaylist(), playlist.getPublisher(), playlist.getSongs());
    }

    @PutMapping(value = "")
    public Playlist updatePlaylist(@RequestBody Playlist playlist){
        return playlistService.updatePlaylist(playlist);
    }

    @DeleteMapping(value = "")
    public boolean deletePlaylist(@RequestBody Playlist playlist){
        return playlistService.deletePlaylist(playlist);
    }

    @GetMapping(value = "/all")
    public List<Playlist> getAll(){
        return playlistService.getAll();
    }

    @GetMapping(value = "/search/{nombrePlaylist}")
    public List<Playlist> getByNombre(@PathVariable String nombrePlaylist){
        return playlistService.getByNombre(nombrePlaylist);
    }

    @GetMapping(value = "/search/{publisher}")
    public List<Playlist> getByPublisher(@PathVariable Publisher publisher){
        return playlistService.getByPublisher(publisher);
    }

    @PutMapping(value = "/add")
    public void addSong(@RequestBody Playlist playlist, @RequestBody(required = true) Cancion cancion){
        playlistService.addSong(playlist, cancion);
    }

    @PutMapping(value = "/listen")
    public void escucharPlaylist(@RequestBody Listener listener, @RequestBody Playlist playlist){
        playlistService.escucharPlaylist(listener, playlist);
    }
}
