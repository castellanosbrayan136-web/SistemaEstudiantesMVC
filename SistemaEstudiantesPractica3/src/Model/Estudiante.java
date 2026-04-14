package Model;

//@autor: Brayan C

public class Estudiante {
    private String id;
    private String nombre;
    private String apellido;
    private double promedio;

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
