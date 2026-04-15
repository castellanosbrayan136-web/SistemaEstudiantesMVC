package Model;

//@autor: Brayan C

public class Estudiante {
    private final String id;
    private final String nombre;
    private final String apellido;
    private final double promedio;

    public Estudiante(String id, String nombre, String apellido, double promedio) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.promedio = promedio;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public double getPromedio() {
        return promedio;
    }
    
    
}
