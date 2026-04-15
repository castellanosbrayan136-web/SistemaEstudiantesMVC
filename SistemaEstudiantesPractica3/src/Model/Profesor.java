package Model;

//@autor: Brayan C

public class Profesor {
    private final String cedula;
    private final String nombres;
    private final String apellidos;
    private final String numeroTelefono;

    public Profesor(String cedula, String nombres, String apellidos, String numeroTelefono) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.numeroTelefono = numeroTelefono;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }
    
    
}
