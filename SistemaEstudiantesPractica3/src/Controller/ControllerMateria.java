package Controller;

//@autor: Brayan C

import Model.Materia;
import Model.MateriaDAO;
import View.ScreenManager;
import View.VistaMaterias;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ControllerMateria implements ActionListener{
    
    private VistaMaterias vistaMateria;
    private MateriaDAO materiaDAO;

    public ControllerMateria(VistaMaterias vistaMateria, MateriaDAO materiaDAO) {
        this.vistaMateria = vistaMateria;
        this.materiaDAO = materiaDAO;
        
        activarBotones();
        llenarTabla();
        limpiarEspacios();
    }
    
    public void activarBotones() {
        vistaMateria.getBtnRegistrar().addActionListener(this);
        vistaMateria.getBtnBuscar().addActionListener(this);
        vistaMateria.getBtnActualizar().addActionListener(this);
        vistaMateria.getBtnEliminar().addActionListener(this);
        vistaMateria.getBtnResetearDatos().addActionListener(this);
       
        eventoBotoX();
    }
    
    public void eventoBotoX() {
        this.vistaMateria.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                ScreenManager.cerrarGestionMaterias(vistaMateria);
            }
        });
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaMateria.getBtnRegistrar()) {
            registrarMateria();
        } else if (e.getSource() == vistaMateria.getBtnBuscar()) {
            buscarMateria();
        } else if (e.getSource() == vistaMateria.getBtnActualizar()) {
            actualizarMateria();
        } else if (e.getSource() == vistaMateria.getBtnEliminar()) {
            eliminarMateria();
        } else if (e.getSource() == vistaMateria.getBtnResetearDatos()) {
            resetearDatos((DefaultTableModel) vistaMateria.getTablaMaterias().getModel());
        }  
    }
    
    public void registrarMateria() {
        if (leerDatos().getCreditos() < 0) {
            JOptionPane.showMessageDialog(vistaMateria, "Creditos invalidos");
            return;
        }
        if (materiaDAO.registrarMateria(leerDatos())) {
            llenarTabla();
            JOptionPane.showMessageDialog(vistaMateria, "Materia registrada con exito.","Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
            limpiarEspacios();
        } else {
            JOptionPane.showMessageDialog(vistaMateria, "Completa los datos.","Registro fallido", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void buscarMateria() {
        if (leerDatos().getId().trim().isEmpty()  || materiaDAO.buscarMateriaPorId(leerDatos().getId()) == null) {
            JOptionPane.showMessageDialog(vistaMateria, "Materia no encontrada.");
        } else {
            Materia materia = materiaDAO.buscarMateriaPorId(leerDatos().getId());
            
            vistaMateria.setTxtId(materia.getId());
            vistaMateria.setTxtNombreMateria(materia.getNombre());
            vistaMateria.setTxtCreditos(materia.getCreditos());
            
            llenarTabla();
            
            JOptionPane.showMessageDialog(vistaMateria, "Materia encontrada. Los datos se mostraran en las cajas de texto.");
            
        }
    }
    
    
    public void actualizarMateria() {
            if (leerDatos().getCreditos() < 0) {
            JOptionPane.showMessageDialog(vistaMateria, "Creditos invalidos.");
            return;
        }
        Materia materia = leerDatos();
        
        if (materiaDAO.actualizarDatosPorId(materia)) {
            JOptionPane.showMessageDialog(vistaMateria, "Materia actualizada.");
            limpiarEspacios();
            llenarTabla();
        } else {
            JOptionPane.showMessageDialog(vistaMateria, "Materia no encontrada.");
            
            llenarTabla();
        }
    }
    
    public void eliminarMateria() {
        int confirmacionEliminacion = JOptionPane.showConfirmDialog(vistaMateria, 
                "Estas seguro de eliminar a este estudiante?", 
                "Confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (confirmacionEliminacion == JOptionPane.YES_OPTION) {
            if (materiaDAO.eliminarMateriaPorId(leerDatos().getId())) {

                JOptionPane.showMessageDialog(vistaMateria, "Estudiante eliminado.");

                limpiarEspacios();

                llenarTabla();
            } else {
                JOptionPane.showMessageDialog(vistaMateria, "Estudiante no encontrado.");
            }
        }
    }
    
    
    public void llenarTabla() {
        DefaultTableModel modeloTabla = (DefaultTableModel) vistaMateria.getTablaMaterias().getModel();
        
        modeloTabla.setRowCount(0);
        
        Object[] fila = new Object[3];
        
        List<Materia> listaMaterias = materiaDAO.retornarLista();
        
        for (Materia materia: listaMaterias) {
            fila[0] = materia.getId();
            fila[1] = materia.getNombre();
            fila[2] = materia.getCreditos();
            modeloTabla.addRow(fila);
        }
    }
    
    public void resetearDatos(DefaultTableModel modeloTabla) {
        int confirmacionDeEliminacion = JOptionPane.showConfirmDialog(vistaMateria, 
                "Estas seguro de resetear todos lo datos?, esta es una accion irreversible",
                "Confirmacion reseteo",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
        
        if (confirmacionDeEliminacion == JOptionPane.YES_OPTION) {
            modeloTabla.setRowCount(0);
            materiaDAO.resetearTodo();
        } 
    }
    
    private Materia leerDatos() {
        return new Materia(vistaMateria.getTxtId(), vistaMateria.getTxtNombreMateria(), vistaMateria.getIntCreditos());
    }
    
    private void limpiarEspacios() {
        vistaMateria.setTxtId(null);
        vistaMateria.setTxtNombreMateria(null);
        vistaMateria.setTxtCreditos(0);
    }
    
}
