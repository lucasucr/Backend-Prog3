package ucema.prog3.app.dto;

import lombok.Data;
import ucema.prog3.app.model.*;

import java.util.List;

@Data
public class PlaylistDTO {
    private String nombrePlaylist;
    private Publisher publisher;
    private List<Cancion> songs;

    public PlaylistDTO(String pNombrePlaylist, Publisher pPublisher, List<Cancion> pSongs){
        this.nombrePlaylist = pNombrePlaylist;
        this.publisher = pPublisher;
        this.songs = pSongs;
    }
}
