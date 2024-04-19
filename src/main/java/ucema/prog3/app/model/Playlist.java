package ucema.prog3.app.model;

import lombok.Data;

@Data public class Playlist {
    double ID;
    String NombrePlaylist;

    public Playlist(String pNombrePlaylist){
        setID(Math.random());
        setNombrePlaylist(pNombrePlaylist);
    }
}
