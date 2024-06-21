package ucema.prog3.app.services;

import ucema.prog3.app.model.*;

public interface UsuarioService {
    Publisher createPublisher(String nombre, String apellido);

    Listener createListener(String nombre, String apellido);

    Usuario updateUsuario(Usuario usuario);

    boolean deleteUsuario(Usuario usuario);

    void escucharPlaylist(Listener listener, Playlist playlist);
}
