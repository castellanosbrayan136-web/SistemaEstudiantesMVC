package View;

//@autor: Brayan C


import Controller.ControllerAsignarMaterias;
import Controller.ControllerEstudiante;
import Controller.ControllerMateria;
import Controller.ControllerMenuPrincipal;
import Controller.ControllerPanelAsignarProfesor;
import Controller.ControllerPanelMatricularEstudiante;
import Controller.ControllerProfesor;
import Model.EstudianteDAO;
import Model.MateriaDAO;
import Model.ProfesorDAO;
import java.awt.BorderLayout;


public class ScreenManager {
    public static void abrirMenuPrincipal() {
        VistaPrincipal vistaPrincipal = new VistaPrincipal();
        ControllerMenuPrincipal controllerPrincipal  = new ControllerMenuPrincipal(vistaPrincipal);
        
        vistaPrincipal.setVisible(true);
    }
    
    public static void cerrarMenuPrincipal(VistaPrincipal vistaPrincipal) {
        vistaPrincipal.dispose();
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
        MateriaDAO materiaDAO = new MateriaDAO();
        
        ControllerMateria controllerMateria = new ControllerMateria(vistaMaterias, materiaDAO);
        
        vistaMaterias.setVisible(true);
    }
    
    public static void cerrarMaterias(VistaMaterias vistaMaterias) {
        vistaMaterias.setVisible(false);
    }
    
    public static void abrirAsignarMaterias() {
        VistaAsignarMaterias vistaAsignarMaterias = new VistaAsignarMaterias();
        ControllerAsignarMaterias controllerAsignarMaterias = new ControllerAsignarMaterias(vistaAsignarMaterias);
        
        vistaAsignarMaterias.setVisible(true);
    }
    
    public static void cerrarMaterias(VistaAsignarMaterias vistaAsignarMaterias) {
        vistaAsignarMaterias.setVisible(false);
    }
    
    public static void cambiarVistaAAsignarProfesor(VistaAsignarMaterias vistaAsignarMaterias) {
    PanelAsignarProfesor vistaAsignarProfesor = new PanelAsignarProfesor();
    MateriaDAO materiaDAO = new MateriaDAO();
    ProfesorDAO profesorDAO = new ProfesorDAO();
    
    ControllerPanelAsignarProfesor controllerPanelAsignarProfesor = new ControllerPanelAsignarProfesor(materiaDAO, profesorDAO, vistaAsignarProfesor);
    
    vistaAsignarProfesor.setSize(550,550);
    vistaAsignarProfesor.setLocation(0, 0);
    
    vistaAsignarMaterias.getContend().removeAll();
    vistaAsignarMaterias.getContend().add(vistaAsignarProfesor, BorderLayout.CENTER);
    vistaAsignarMaterias.revalidate();
    vistaAsignarMaterias.repaint();
}
    
    public static void cambiarAPanelMatricularEstudiante(VistaAsignarMaterias vistaAsignarMaterias) {
        PanelMatricularEstudiante panelMatricularEstudiante = new PanelMatricularEstudiante();
        MateriaDAO materiaDAO = new MateriaDAO();
        EstudianteDAO estudianteDAO = new EstudianteDAO();
        ControllerPanelMatricularEstudiante controllerMatriculaE = new ControllerPanelMatricularEstudiante(materiaDAO, panelMatricularEstudiante, estudianteDAO);
        
        panelMatricularEstudiante.setSize(550,550);
        panelMatricularEstudiante.setLocation(0,0);
        
        vistaAsignarMaterias.getContend().removeAll();
        vistaAsignarMaterias.getContend().add(panelMatricularEstudiante, BorderLayout.CENTER);
        vistaAsignarMaterias.revalidate();
        vistaAsignarMaterias.repaint();
        
    }
}
