/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

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

/**
 *
 * @author UIS
 */
public class MateriaDAO {
    private final List<Materia> listaMaterias;
    private final Gson gson;
    private final String ruta = "materias.json";

    public MateriaDAO() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.listaMaterias = cargarDatos();
        
    }
    
    public List<Materia> cargarDatos() {
        File archivo = new File(ruta);
        
        if (!archivo.exists()) {
            return new ArrayList<>();
        }
        
        try (Reader reader =  new FileReader(archivo)) {
            Type tipoLista = new TypeToken<ArrayList<Materia>>(){}.getType();
            List<Materia> lista = gson.fromJson(reader, tipoLista);
            
            return (lista != null) ? lista:new ArrayList<>();
        } catch (IOException e){
            return new ArrayList<>();
            
        }
    }
    
    public void guardarDatos() {
        try (Writer writer = new FileWriter(ruta)) {
            gson.toJson(listaMaterias, writer);
        } catch (IOException ex) {
            System.err.println("Error al guardar: " + ex.getMessage());
        }
    }
    
    public boolean registrarMateria(Materia materia) {
        if (materia.getNombre().trim().isEmpty() || materia.getId().trim().isEmpty()) {
            return false;
        } else {
            listaMaterias.add(materia);
            guardarDatos();
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
                guardarDatos();
                return true;
            }
        }
        return false;
    }
    
    public boolean eliminarMateriaPorId(String id) {
        if (listaMaterias.removeIf(materia -> materia.getId().equals(id))) {
            guardarDatos();
            return true;
        }
        return false;
    }
    
    public boolean asignarProfesorAMateria(Profesor profesor, String idMateria) {
        
        for (Materia materia : listaMaterias) {
            if (materia.getId().equals(idMateria)) {
                if (materia.setProfesor(profesor)) {
                    guardarDatos();
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
                 guardarDatos();
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
        guardarDatos();
    }
}

