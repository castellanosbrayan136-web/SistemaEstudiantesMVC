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


public class EstudianteDAO {
    private List<Estudiante> listaEstudiantes;
    private Gson gson;
    private final String ruta = "estudiantes.json";

    public EstudianteDAO() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.listaEstudiantes = cargar();
    }
    
    
    
    public void guardar(){
        try (Writer writer = new FileWriter(ruta)) {
            gson.toJson(listaEstudiantes, writer);
        } catch (IOException e) {
            System.err.println("Error al guardar en JSON: " + e.getMessage());
        }
    }
    
    public List<Estudiante> cargar() {
        File archivo = new File(ruta);
        if (!archivo.exists()) {
            return new ArrayList<>();
        }
        
        try (Reader reader = new FileReader(ruta)) {
            Type tipoLista = new TypeToken<ArrayList<Estudiante>>(){}.getType();
            List<Estudiante> lista = gson.fromJson(reader, tipoLista);
            
            return (lista != null) ? lista : new ArrayList<>();
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
    
    public boolean registrarEstudiante(Estudiante estudiante) {
        if (estudiante.getNombre().trim().isEmpty() || estudiante.getApellido().trim().isEmpty() || estudiante.getId().trim().isEmpty()) {
            return false;
        } else {
            listaEstudiantes.add(estudiante);
            guardar();
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
                guardar();
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<Estudiante> filtrarEstudiantePorId(String idEstudiante) {
    ArrayList<Estudiante> resultado = new ArrayList<>();

    for (Estudiante eestudiante : listaEstudiantes) {
        if (eestudiante.getId().startsWith(idEstudiante)) {
            resultado.add(eestudiante);
        }
    }

    return resultado;
}
    
    public boolean eliminarEstudiantePorId(String id) {
        boolean eliminado = listaEstudiantes.removeIf(estudiante -> estudiante.getId().equals(id));
        guardar();
        return eliminado;
    }
    
    public List<Estudiante> retornarLista() {
        return listaEstudiantes;
    }
    
    public void resetearTodo() {
        listaEstudiantes.clear();
        guardar();
    }
}
