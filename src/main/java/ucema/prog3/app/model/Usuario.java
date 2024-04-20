package ucema.prog3.app.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @Entity @Table(name = "user")
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private double id;
    @Column(name = "Nombre") private String nombre;
    @Column(name = "Apellido") private String apellido;
    @Column(name = "Usuario") private String usuario;
    @Column(name = "Password") private String password;

    public Usuario (String p_nombre, String p_apellido, String p_usuario, String p_password){
        setNombre(p_nombre);
        setApellido(p_apellido);
        setUsuario(p_usuario);
        setPassword(p_password);
    }
}
