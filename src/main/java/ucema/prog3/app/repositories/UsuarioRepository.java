package ucema.prog3.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ucema.prog3.app.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Double> {
    //No uso ninguna funcion especifica, por lo que lo dejo asi
}
