package ucema.prog3.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ucema.prog3.app.model.Listener;
import ucema.prog3.app.model.Publisher;
import ucema.prog3.app.model.Usuario;
import ucema.prog3.app.repositories.UsuarioRepository;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public Publisher createPublisher(Publisher publisher) {
        Publisher newPublisher = new Publisher(publisher.getNombre(), publisher.getApellido(), publisher.getUsername(), publisher.getPassword());
        newPublisher.setPassword(passwordEncoder.encode(newPublisher.getPassword()));
        System.out.println("banana");
        this.usuarioRepository.save(newPublisher);
        return newPublisher;
    }

    @Override
    @Transactional
    public Listener createListener(Listener listener) {
        Listener newListener = new Listener(listener.getNombre(), listener.getApellido(), listener.getUsername(), listener.getPassword());
        newListener.setPassword(passwordEncoder.encode(newListener.getPassword()));
        this.usuarioRepository.save(newListener);
        return newListener;
    }

    @Override
    @Transactional
    public Usuario updateUsuario(Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }

    @Override
    @Transactional
    public boolean deleteUsuario(Usuario usuario) {
        if (usuario == null || usuario.getId() == null) {
            return false;
        }
        try {
            usuarioRepository.delete(usuario);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Usuario getUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }

        Usuario usuario = (Usuario) authentication.getPrincipal();
        return usuario; //Obtengo el usuario autenticado

    }

    @Override
    public boolean checkLogin(String username, String password) {
        Optional<Usuario> usuario = usuarioRepository.findByUsername(username);
        if(usuario.isPresent()) {
            return passwordEncoder.matches(password, usuario.get().getPassword());
        }
        return false;
    }
}
