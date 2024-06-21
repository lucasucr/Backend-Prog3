package ucema.prog3.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ucema.prog3.app.model.*;

import java.util.List;
import java.util.Optional;

@Repository
public interface CancionRepository extends CrudRepository<Cancion, Double> {
    List<Cancion> findByNombre(String nombre);

    Optional<Cancion> findByArtista(String artista);

    List<Cancion> findByAlbum(String album);
}
