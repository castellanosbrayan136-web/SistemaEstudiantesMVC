/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author UIS
 */
public class Materia {
    private String id;
    private String nombre;
    private int creditos;
    private Profesor profesor;
    private ArrayList<Estudiante> estudiantes;

    public Materia(String id, String nombre, int creditos) {
        this.id = id;
        this.nombre = nombre;
        this.creditos = creditos;
        this.profesor = new Profesor("Aun no se ah asignado profesor","Aun no se ah asignado profesor", "Aun no se ah asignado profesor", "Aun no se ah asignado profesor");
        this.estudiantes = new ArrayList<>();
    }

    public boolean setProfesor(Profesor profesor) {
        if (profesor != null) {
            this.profesor = profesor;
            return true;
        }
        return false;
    }
    
    public boolean agregarEstudiante(Estudiante estudiante) {
        if (estudiante != null) {
            estudiantes.add(estudiante);
            return true;
        }
        return false;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    
    
    
    

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCreditos() {
        return creditos;
    }
    
    
}
