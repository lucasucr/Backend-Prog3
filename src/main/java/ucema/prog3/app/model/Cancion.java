package ucema.prog3.app.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @Entity @Table(name = "cancion")
public class Cancion {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private double id;
    @Column(nullable = false)
    private String Nombre;
    @Column(nullable = false, unique = true)
    private String Artista;
    @Column(nullable = false)
    private String Album;
}
