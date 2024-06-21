package ucema.prog3.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ucema.prog3.app.model.Listener;
import ucema.prog3.app.model.Playlist;
import ucema.prog3.app.model.Publisher;
import ucema.prog3.app.model.Usuario;
import ucema.prog3.app.repositories.UsuarioRepository;

import java.util.List;

public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    @Transactional
    public Publisher createPublisher(String nombre, String apellido) {
        Publisher publisher = new Publisher(nombre, apellido);
        this.usuarioRepository.save(publisher);
        return publisher;
    }

    @Override
    @Transactional
    public Listener createListener(String nombre, String apellido) {
        Listener listener = new Listener(nombre, apellido);
        this.usuarioRepository.save(listener);
        return listener;
    }

    @Override
    @Transactional
    public Usuario updateUsuario(Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }

    @Override
    @Transactional
    public boolean deleteUsuario(Usuario usuario) {
        if(usuario == null ||usuario.getId() == null){
            return false;
        }
        try{
            usuarioRepository.delete(usuario);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    @Transactional
    public void escucharPlaylist(Listener listener, Playlist playlist) {
        listener.addPlaylist(playlist);
    }
}
