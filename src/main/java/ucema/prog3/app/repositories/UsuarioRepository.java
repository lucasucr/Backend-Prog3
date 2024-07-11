package ucema.prog3.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ucema.prog3.app.model.Usuario;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Double> {

    Optional<Usuario> findByUsername(String username);
}
