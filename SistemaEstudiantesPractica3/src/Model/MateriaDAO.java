/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author UIS
 */
public class MateriaDAO {
    private static List<Materia> listaMaterias = new ArrayList<>();
    
    public boolean registrarMateria(Materia materia) {
        if (materia.getNombre().trim().isEmpty() || materia.getId().trim().isEmpty()) {
            return false;
        } else {
            listaMaterias.add(materia);
            return true;
        }
    }
    
    public Materia buscarMateriaPorId(String id) {
        if (!listaMaterias.isEmpty()) {
            for (Materia materia: listaMaterias) {
                if (materia.getId().equals(id)) {
                    return materia;
                }
            }
        }
        return null;
        }
            
    
    public boolean actualizarDatosPorId(Materia materia) {
        for (int i = 0;i < listaMaterias.size();i++) {
            if (listaMaterias.get(i).getId().equals(materia.getId())) {
                listaMaterias.set(i, materia);
                return true;
            }
        }
        return false;
    }
    
    public boolean eliminarMateriaPorId(String id) {
        return listaMaterias.removeIf(materia -> materia.getId().equals(id));
    }
    
    public boolean asignarProfesorAMateria(Profesor profesor, String idMateria) {
        for (Materia materia : listaMaterias) {
            if (materia.getId().equals(idMateria)) {
                if (materia.setProfesor(profesor)) {
                    return true;
                }
            }
        }
        return false;
    }
    
     public boolean matricularEstudiante(String idMateria, Estudiante estudiante) {
         for (Materia materia : listaMaterias) {
             if (materia.getId().equals(idMateria)) {
                 materia.agregarEstudiante(estudiante);
                 return true;
             }
         }
         return false;
     }
     
    public ArrayList<Materia> filtrarMateriaPorId(String idMateria) {
    ArrayList<Materia> listaFiltrada = new ArrayList<>();

    for (Materia materia : listaMaterias) {
        if (materia.getId().startsWith(idMateria)) {
            listaFiltrada.add(materia);
        }
    }
    return listaFiltrada;
    }
    
    public List<Materia> retornarLista() {
        return listaMaterias;
    }
    
    public void resetearTodo() {
        listaMaterias.clear();
    }
}

