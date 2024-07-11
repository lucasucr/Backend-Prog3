package ucema.prog3.app.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ucema.prog3.app.services.UsuarioService;
import ucema.prog3.app.model.*;

@RestController
@RequestMapping(value = "/api/usuario")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(value = "")
    public Usuario getUserInfo(){
        return usuarioService.getUserInfo();
    }

    @PostMapping(value = "/publisher")
    public Usuario createPublisher(@RequestBody Publisher publisher){
        return usuarioService.createPublisher(publisher);
    }

    @PostMapping(value = "/listener")
    public Usuario createListener(@RequestBody Listener listener){
        return usuarioService.createListener(listener);
    }

    @PutMapping(value = "")
    public Usuario updateUsuario(@RequestBody Usuario usuario){
        return usuarioService.updateUsuario(usuario);
    }

    @DeleteMapping(value = "")
    public boolean deleteUsuario(@RequestBody Usuario usuario) {
        return usuarioService.deleteUsuario(usuario);
    }
}
