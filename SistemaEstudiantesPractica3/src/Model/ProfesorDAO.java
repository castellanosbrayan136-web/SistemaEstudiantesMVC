package Model;

//@autor: Brayan C

import java.util.ArrayList;
import java.util.List;


public class ProfesorDAO {
    private static final List<Profesor> listaProfesores = new ArrayList<>();
    
    
    public boolean registrarProfesor(Profesor profesor) {
        if (profesor.getNombres().trim().isEmpty() || profesor.getApellidos().trim().isEmpty() || profesor.getCedula().trim().isEmpty() || profesor.getNumeroTelefono().trim().isEmpty()) {
            return false;
        } else {
            listaProfesores.add(profesor);
            return true;
        }
    }
    
    public Profesor buscarProfesorPorCedula(String cedula) {
        if (!listaProfesores.isEmpty()) {
            for (Profesor profesor : listaProfesores) {
                if (profesor.getCedula().equals(cedula)) {
                    return profesor;
                }
            }
        }
        return null;
        }
            
    
    public boolean actualizarDatosPorCedula(Profesor profesor) {
        for (int i = 0;i < listaProfesores.size();i++) {
            if (listaProfesores.get(i).getCedula().equals(profesor.getCedula())) {
                listaProfesores.set(i, profesor);
                return true;
            }
        }
        return false;
    }
    
    public boolean eliminarProfesorPorCedula(String cedula) {
        return listaProfesores.removeIf(profesor -> profesor.getCedula().equals(cedula));
    }
    
    public List<Profesor> retornarLista() {
        return listaProfesores;
    }
    
    public ArrayList<Profesor> filtrarProfesorPorCedula(String cedula) {
    ArrayList<Profesor> listaFiltrada = new ArrayList<>();

    for (Profesor profesor: listaProfesores) {
        if (profesor.getCedula().startsWith(cedula)) {
            listaFiltrada.add(profesor);
        }
    }
    return listaFiltrada;
    }
    
    
    
    public void resetearTodo() {
        listaProfesores.clear();
    }
    
    
}
