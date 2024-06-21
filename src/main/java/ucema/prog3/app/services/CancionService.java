package ucema.prog3.app.services;

import ucema.prog3.app.model.*;

import java.util.List;
import java.util.Optional;

public interface CancionService {
    Cancion createCancion(String nombre, String artista, String album);

    Cancion updateCancion(Cancion cancion);

    boolean deleteCancion(Cancion cancion);

    List<Cancion> getAll();

    List<Cancion> getByNombre(String nombre);

    Optional<Cancion> getByArtista(String artista);

    List<Cancion> getByAlbum(String album);
}
