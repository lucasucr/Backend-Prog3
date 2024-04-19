package ucema.prog3.app.model;

import lombok.Data;

@Data public class Persona {
    double ID;
    String Nombre;
    String Apellido;

    public Persona (String pNombre, String pApellido){
        setID(Math.random());
        setNombre(pNombre);
        setApellido(pApellido);
    }
}
