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
    public static EstudianteDAO estudianteDAO = new EstudianteDAO();
    public static MateriaDAO materiaDAO = new MateriaDAO();
    public static ProfesorDAO profesorDAO = new ProfesorDAO();
    
    
    public static void abrirMenuPrincipal() {
        VistaPrincipal vistaPrincipal = new VistaPrincipal();
        new ControllerMenuPrincipal(vistaPrincipal);
        
        vistaPrincipal.setVisible(true);
    }
    
    public static void cerrarMenuPrincipal(VistaPrincipal vistaPrincipal) {
        vistaPrincipal.setVisible(false);
    }

    public static void finalizarTodo() {
        System.exit(0);
    }
    
    
    public static void abrirGestionEstudiantes(VistaPrincipal vistaPrincipal) {
        cerrarMenuPrincipal(vistaPrincipal);
        VistaEstudiante vistaEstudiante = new VistaEstudiante();
        
        ControllerEstudiante controllerEstudiante = new ControllerEstudiante(estudianteDAO, vistaEstudiante);
        
        vistaEstudiante.setVisible(true);
    }
    
    public static void cerrarGestionEstudiantes(VistaEstudiante vistaEstudiante) {
        vistaEstudiante.setVisible(false);
        abrirMenuPrincipal();
    }
    
    public static void abrirGestionProfesores(VistaPrincipal vistaPrincipal) {
        cerrarMenuPrincipal(vistaPrincipal);
        ViewProfesor vistaProfesor = new ViewProfesor();
        
        new ControllerProfesor(profesorDAO, vistaProfesor);
        
        vistaProfesor.setVisible(true);
    }
    
    public static void cerrarGestionProfesores(ViewProfesor vistaProfesor) {
        vistaProfesor.setVisible(false);
        abrirMenuPrincipal();
        
    }
    
    public static void abrirGestionMaterias(VistaPrincipal vistaPrincipal) {
        cerrarMenuPrincipal(vistaPrincipal);
        VistaMaterias vistaMaterias = new VistaMaterias();
        
        new ControllerMateria(vistaMaterias, materiaDAO);
        
        vistaMaterias.setVisible(true);
    }
    
    public static void cerrarGestionMaterias(VistaMaterias vistaMaterias) {
        vistaMaterias.setVisible(false);
        abrirMenuPrincipal();
        
    }
    
    public static void abrirAsignarMaterias(VistaPrincipal vistaPrincipal) {
        cerrarMenuPrincipal(vistaPrincipal);
        VistaAsignarMaterias vistaAsignarMaterias = new VistaAsignarMaterias();
        new ControllerAsignarMaterias(vistaAsignarMaterias);
        
        vistaAsignarMaterias.setVisible(true);
    }
    
    public static void cerrarAsignarMaterias(VistaAsignarMaterias vistaAsignarMaterias) {
        vistaAsignarMaterias.setVisible(false);
        abrirMenuPrincipal();
        
    }
    
    public static void mostrarPanelAsignarProfesor(VistaAsignarMaterias vistaAsignarMaterias) {
    PanelAsignarProfesor vistaAsignarProfesor = new PanelAsignarProfesor();
    
    new ControllerPanelAsignarProfesor(materiaDAO, profesorDAO, vistaAsignarProfesor);
    
    vistaAsignarProfesor.setSize(550,550);
    vistaAsignarProfesor.setLocation(0, 0);
    
    vistaAsignarMaterias.getContend().removeAll();
    vistaAsignarMaterias.getContend().add(vistaAsignarProfesor, BorderLayout.CENTER);
    vistaAsignarMaterias.revalidate();
    vistaAsignarMaterias.repaint();
}
    
    public static void mostrarPanelMatricularEstudiante(VistaAsignarMaterias vistaAsignarMaterias){
        PanelMatricularEstudiante panelMatricularEstudiante = new PanelMatricularEstudiante();
        
        new ControllerPanelMatricularEstudiante(materiaDAO, panelMatricularEstudiante, estudianteDAO);
        
        panelMatricularEstudiante.setSize(550,550);
        panelMatricularEstudiante.setLocation(0,0);
        
        vistaAsignarMaterias.getContend().removeAll();
        vistaAsignarMaterias.getContend().add(panelMatricularEstudiante, BorderLayout.CENTER);
        vistaAsignarMaterias.revalidate();
        vistaAsignarMaterias.repaint();
        
    }
}
