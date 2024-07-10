package ucema.prog3.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ucema.prog3.app.model.*;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlaylistRepository extends CrudRepository<Playlist, Double> {

    List<Playlist> findByPublisher(Publisher publisher);

    List<Playlist> findByNombre(String nombrePlaylist);

    List<Playlist> findByNombreAndPublisher(String nombrePlaylist, Publisher publisher);
}
