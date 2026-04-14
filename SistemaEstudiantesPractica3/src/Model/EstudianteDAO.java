package Model;

//@autor: Brayan C

import java.util.ArrayList;
import java.util.List;


public class EstudianteDAO {
    private static List<Estudiante> listaEstudiantes = new ArrayList<>();
    
    public boolean registrarEstudiante(Estudiante estudiante) {
        if (estudiante.getNombre().trim().isEmpty() || estudiante.getApellido().trim().isEmpty() || estudiante.getId().trim().isEmpty()) {
            return false;
        } else {
            listaEstudiantes.add(estudiante);
            return true;
        }
    }
    
    public Estudiante buscarEstudiantePorId(String id) {
        if (!listaEstudiantes.isEmpty()) {
            for (Estudiante estudiante : listaEstudiantes) {
                if (estudiante.getId().equals(id)) {
                    return estudiante;
                }
            }
        }
        return null;
        }
            
    
    public boolean actualizarDatosPorId(Estudiante estudiante) {
        for (int i = 0;i < listaEstudiantes.size();i++) {
            if (listaEstudiantes.get(i).getId().equals(estudiante.getId())) {
                listaEstudiantes.set(i, estudiante);
                return true;
            }
        }
        return false;
    }
    
    public boolean eliminarEstudiantePorId(String id) {
        return listaEstudiantes.removeIf(estudiante -> estudiante.getId().equals(id));
    }
    
    public List<Estudiante> retornarLista() {
        return listaEstudiantes;
    }
    
    public void resetearTodo() {
        listaEstudiantes.clear();;
    }
}
