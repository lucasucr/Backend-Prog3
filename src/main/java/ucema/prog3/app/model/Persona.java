package ucema.prog3.app.model;

public class Persona {
    double ID;
    String Nombre;
    String Apellido;

    public Persona (String pNombre, String pApellido){
        setID(Math.random());
        setNombre(pNombre);
        setApellido(pApellido);
    }
    public void setID(double ID) {
        this.ID = ID;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public double getID() {
        return ID;
    }

    public String getApellido() {
        return Apellido;
    }

    public String getNombre() {
        return Nombre;
    }
}
