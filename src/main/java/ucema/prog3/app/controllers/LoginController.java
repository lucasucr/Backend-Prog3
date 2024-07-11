package ucema.prog3.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ucema.prog3.app.dto.LoginDTO;
import ucema.prog3.app.services.UsuarioService;

@RestController
@RequestMapping(value = "/api/login")
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("")
    public boolean login(@RequestBody LoginDTO dto){
        System.out.println("LoginController.login");
        System.out.println(dto.getUsername());
        System.out.println(dto.getPassword());
        return usuarioService.checkLogin(dto.getUsername(), dto.getPassword());
    }
}
