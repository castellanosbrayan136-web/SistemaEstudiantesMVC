package Model;

//@autor: Brayan C

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class ProfesorDAO {
    private final List<Profesor> listaProfesores;
    private final Gson gson;
    private final String rutaArchivo = "profesores.json";

    public ProfesorDAO() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.listaProfesores = cargarDatos();
    }
    
    
    
    public List<Profesor> cargarDatos() {
        File archivo = new File(rutaArchivo);
        
        if (!archivo.exists()) {
            return new ArrayList<>();
        }
        
        try (Reader reader = new FileReader(archivo)) {
            Type tipoLista = new TypeToken<List<Profesor>>(){}.getType();
            List<Profesor> lista = gson.fromJson(reader , tipoLista);
            return (lista != null) ? lista : new ArrayList<>();
        } catch (IOException ex) {
            return new ArrayList<>();
        }
    }
    
    public void guardarDatos() {
        try (Writer writer = new FileWriter(rutaArchivo)) {
            gson.toJson(listaProfesores , writer);
        } catch (IOException ex) {
            System.err.println("Error al guardar datos:" + ex.getMessage());
        }
    }
    
    
    
    public boolean registrarProfesor(Profesor profesor) {
        if (profesor.getNombres().trim().isEmpty() || profesor.getApellidos().trim().isEmpty() || profesor.getCedula().trim().isEmpty() || profesor.getNumeroTelefono().trim().isEmpty()) {
            return false;
        } else {
            listaProfesores.add(profesor);
            guardarDatos();
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
                guardarDatos();
                return true;
            }
        }
        return false;
    }
    
    public boolean eliminarProfesorPorCedula(String cedula) {
        if (listaProfesores.removeIf(profesor -> profesor.getCedula().equals(cedula))) {
            guardarDatos();
            return true;
        }
        return false;
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
        guardarDatos();
    }
    
    
}
