package ucema.prog3.app.services;

import ucema.prog3.app.model.*;

public interface UsuarioService {
    Publisher createPublisher(Publisher publisher);

    Listener createListener(Listener listener);

    Usuario updateUsuario(Usuario usuario);

    boolean deleteUsuario(Usuario usuario);
}
