package ucema.prog3.app.services;

import ucema.prog3.app.model.*;

public interface UsuarioService {
    Publisher createPublisher(Usuario publisher);

    Listener createListener(Usuario listener);

    Usuario updateUsuario(Usuario usuario);

    boolean deleteUsuario(Usuario usuario);

    Usuario getUserInfo();

    boolean checkLogin(String username, String password);
}
