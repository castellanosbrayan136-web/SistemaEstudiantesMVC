package Controller;

//@autor: Brayan C

import Model.Profesor;
import Model.ProfesorDAO;
import View.ScreenManager;
import View.ViewProfesor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ControllerProfesor implements ActionListener{

    private ProfesorDAO profesorDAO;
    private ViewProfesor vistaProfesor;

    public ControllerProfesor(ProfesorDAO profesorDAO, ViewProfesor vistaProfesor) {
        this.profesorDAO = profesorDAO;
        this.vistaProfesor = vistaProfesor;
        
        activarBotones();
    }
    
    
    
    public void activarBotones() {
        vistaProfesor.getBtnBuscar().addActionListener(this);
        vistaProfesor.getBtnActualizar().addActionListener(this);
        vistaProfesor.getBtnEliminar().addActionListener(this);
        vistaProfesor.getBtnRegistrar().addActionListener(this);
        vistaProfesor.getBtnResetearDatos().addActionListener(this);
        vistaProfesor.getBtnRegresar().addActionListener(this);
        
        
        limpiarEspacios();
        llenarTabla();
    }
    


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaProfesor.getBtnRegistrar()) {
            registrarProfesor();
        } else if (e.getSource() == vistaProfesor.getBtnBuscar()) {
            buscarProfesor();
        } else if (e.getSource() == vistaProfesor.getBtnActualizar()) {
            actualizarProfesor();
        } else if (e.getSource() == vistaProfesor.getBtnEliminar()) {
            eliminarProfesor();
        } else if (e.getSource() == vistaProfesor.getBtnResetearDatos()) {
            limpiarTabla((DefaultTableModel) vistaProfesor.getTablaProfesores().getModel());
        } else if (e.getSource() == vistaProfesor.getBtnRegresar()) {
            ScreenManager.cerrarMenuProfesores(vistaProfesor);
            ScreenManager.abrirMenuPrincipal();
        }
    }
    
    public void registrarProfesor() {
        if (profesorDAO.registrarProfesor(leerDatos())) {
            llenarTabla();
            JOptionPane.showMessageDialog(vistaProfesor, "Profesor registrado con exito.","Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
            limpiarEspacios();
        } else {
            JOptionPane.showMessageDialog(vistaProfesor, "Completa los datos.","Registro fallido", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void buscarProfesor() {
        if (leerDatos().getCedula().trim().isEmpty()  || profesorDAO.buscarProfesorPorCedula(leerDatos().getCedula()) == null) {
            JOptionPane.showMessageDialog(vistaProfesor, "Profesor no encontrado.");
        } else {
            Profesor profesor = profesorDAO.buscarProfesorPorCedula(leerDatos().getCedula());
            
            vistaProfesor.setTxtCedula(profesor.getCedula());
            vistaProfesor.setTxtNombres(profesor.getNombres());
            vistaProfesor.setTxtApellidos(profesor.getApellidos());
            vistaProfesor.setTxtTelefono(profesor.getNumeroTelefono());
            
            llenarTabla();
            
            JOptionPane.showMessageDialog(vistaProfesor, "Profesor encontrado. Los datos se mostraran en las cajas de texto.");
            
        }
        
    }
    
    
    public void actualizarProfesor() {
        Profesor profesor = leerDatos();
        
        if (profesorDAO.actualizarDatosPorCedula(profesor)) {
            JOptionPane.showMessageDialog(vistaProfesor, "Profesor actualizado correctamente.");
            limpiarEspacios();
            llenarTabla();
        } else {
            JOptionPane.showMessageDialog(vistaProfesor, "Profesor no encontrado.");
            
            llenarTabla();
        }
    }
    
    public void eliminarProfesor() {
        int confirmacionEliminacion = JOptionPane.showConfirmDialog(vistaProfesor, 
                "Estas seguro de eliminar a este profesor?", 
                "Confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (confirmacionEliminacion == JOptionPane.YES_OPTION) {
            if (profesorDAO.eliminarProfesorPorCedula(leerDatos().getCedula())) {

                JOptionPane.showMessageDialog(vistaProfesor, "Profesor eliminado.");

                limpiarEspacios();

                llenarTabla();
            } else {
                JOptionPane.showMessageDialog(vistaProfesor, "Profesor no encontrado.");
            }
        }
    }
    
    
    public void llenarTabla() {
        DefaultTableModel modeloTabla = (DefaultTableModel) vistaProfesor.getTablaProfesores().getModel();
        
        modeloTabla.setRowCount(0);
        
        Object[] fila = new Object[4];
        
        List<Profesor> listaProfesores = profesorDAO.retornarLista();
        
        for (Profesor profesor: listaProfesores) {
            fila[0] = profesor.getCedula();
            fila[1] = profesor.getNombres();
            fila[2] = profesor.getApellidos();
            fila[3] = profesor.getNumeroTelefono();
            modeloTabla.addRow(fila);
        }
    }
    
    public void limpiarTabla(DefaultTableModel modeloTabla) {
        int confirmacionDeEliminacion = JOptionPane.showConfirmDialog(vistaProfesor, 
                "Estas seguro de resetear todos lo datos?",
                "Confirmacion reseteo",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
        
        if (confirmacionDeEliminacion == JOptionPane.YES_OPTION) {
            modeloTabla.setRowCount(0);
            profesorDAO.resetearTodo();
        } 
    }
    
    private Profesor leerDatos() {
        return new Profesor(vistaProfesor.getTxtCedula(), vistaProfesor.getTxtNombres(), vistaProfesor.getTxtApellidos(), vistaProfesor.getTxtTelefono());
    }
    
    private void limpiarEspacios() {
        vistaProfesor.setTxtCedula(null);
        vistaProfesor.setTxtNombres(null);
        vistaProfesor.setTxtApellidos(null);
        vistaProfesor.setTxtTelefono(null);
    }
    
    public void cerrarVentana() {
        this.vistaProfesor.dispose();
    }
}

