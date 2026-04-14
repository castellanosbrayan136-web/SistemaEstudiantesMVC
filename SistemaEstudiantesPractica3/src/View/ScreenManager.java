package View;

//@autor: Brayan C

import Controller.Controller;
import Model.EstudianteDAO;


public class ScreenManager {
    public static void abrirEstudiantes() {
        VistaEstudiante vistaEstudiante = new VistaEstudiante();
        EstudianteDAO estudianteDAO = new EstudianteDAO();
        Controller controller = new Controller(estudianteDAO, vistaEstudiante);
        
        
        vistaEstudiante.setVisible(true);
    
    }
}
