/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author UIS
 */
public class Materia {
    private String id;
    private String nombre;
    private int creditos;

    public Materia(String id, String nombre, int creditos) {
        this.id = id;
        this.nombre = nombre;
        this.creditos = creditos;
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
