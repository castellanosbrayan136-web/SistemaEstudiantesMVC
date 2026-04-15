package View;

//@autor: Brayan C


import Controller.ControllerEstudiante;
import Controller.ControllerMenuPrincipal;
import Controller.ControllerProfesor;
import Model.EstudianteDAO;
import Model.ProfesorDAO;


public class ScreenManager {
    public static void abrirMenuPrincipal() {
        VistaPrincipal vistaPrincipal = new VistaPrincipal();
        ControllerMenuPrincipal controllerPrincipal  = new ControllerMenuPrincipal(vistaPrincipal);
        
        vistaPrincipal.setVisible(true);
    }
    
    public static void cerrarMenuPrincipal(VistaPrincipal vistaPrincipal) {
        vistaPrincipal.setVisible(false);
    }
    public static void abrirEstudiantes() {
        VistaEstudiante vistaEstudiante = new VistaEstudiante();
        EstudianteDAO estudianteDAO = new EstudianteDAO();
        
        ControllerEstudiante controllerEstudiante = new ControllerEstudiante(estudianteDAO, vistaEstudiante);
        
        vistaEstudiante.setVisible(true);
    }
    
    public static void cerrarEstudiantes(VistaEstudiante vistaEstudiante) {
        vistaEstudiante.setVisible(false);
    }
    
    public static void abrirMenuProfesores() {
        ViewProfesor vistaProfesor = new ViewProfesor();
        ProfesorDAO profesorDAO = new ProfesorDAO();
        
        ControllerProfesor controllerProfesor = new ControllerProfesor(profesorDAO, vistaProfesor);
        
        vistaProfesor.setVisible(true);
    }
    
    public static void cerrarMenuProfesores(ViewProfesor vistaProfesor) {
        vistaProfesor.setVisible(false);
    }
    
    public static void abrirMaterias() {
        VistaMaterias vistaMaterias = new VistaMaterias();
        
        vistaMaterias.setVisible(true);
    }
    
    public static void cerrarMaterias(VistaMaterias vistaMaterias) {
        vistaMaterias.setVisible(false);
    }
}
