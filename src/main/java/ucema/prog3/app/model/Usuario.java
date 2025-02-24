package ucema.prog3.app.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

@Data @NoArgsConstructor @Entity @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Usuario implements UserDetails {
    @Id @GeneratedValue(strategy = GenerationType.TABLE) @Column(name = "id_usuario")
    private Long id;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Apellido")
    private String apellido;
    @Column(nullable = false, length = 50, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;

    public Usuario (String p_nombre, String p_apellido, String usuario, String password){
        setNombre(p_nombre);
        setApellido(p_apellido);
        setUsername(usuario);
        setPassword(password);
    }
}
