package ucema.prog3.app.model;

public class Playlist {
    double ID;
    String NombrePlaylist;

    public Playlist(String pNombrePlaylist){
        setID(Math.random());
        setNombrePlaylist(pNombrePlaylist);
    }
    public void setID(double ID) {
        this.ID = ID;
    }

    public void setNombrePlaylist(String nombrePlaylist) {
        NombrePlaylist = nombrePlaylist;
    }
    public double getID() {
        return ID;
    }
    public String getNombrePlaylist() {
        return NombrePlaylist;
    }
}
