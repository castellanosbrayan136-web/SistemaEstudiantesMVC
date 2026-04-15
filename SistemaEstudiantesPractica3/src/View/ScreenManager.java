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
    
    public static void abrirProfesores() {
        VistaProfesor vistaProfesor = new VistaProfesor();
        ProfesorDAO profesorDAO = new ProfesorDAO();
        
        ControllerProfesor controllerProfesor = new ControllerProfesor(profesorDAO, vistaProfesor);
        vistaProfesor.setLocationRelativeTo(null);
        vistaProfesor.setVisible(true);
    }
    
    public static void cerrarProfesores(ControllerProfesor controllerProfesor) {
        controllerProfesor.cerrarVentana();
    }
    
    public static void abrirMaterias() {
        VistaMaterias vistaMaterias = new VistaMaterias();
        
        vistaMaterias.setVisible(true);
    }
    
    public static void cerrarMaterias(VistaMaterias vistaMaterias) {
        vistaMaterias.setVisible(false);
    }
}
