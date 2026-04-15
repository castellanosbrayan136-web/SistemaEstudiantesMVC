package Controller;

//@autor: Brayan C

import Model.Materia;
import Model.MateriaDAO;
import View.VistaMaterias;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControllerMateria implements ActionListener{
    
    private VistaMaterias vistaMateria;
    private MateriaDAO materiaDAO;

    public ControllerMateria(VistaMaterias vistaMateria, MateriaDAO materiaDAO) {
        this.vistaMateria = vistaMateria;
        this.materiaDAO = materiaDAO;
        
        activarBotones();
    }
    
    public void activarBotones() {
        vistaMateria.getBtnRegresar().addActionListener(this);
        vistaMateria.getBtnRegistrar().addActionListener(this);
        vistaMateria.getBtnBuscar().addActionListener(this);
        vistaMateria.getBtnActualizar().addActionListener(this);
        vistaMateria.getBtnEliminar().addActionListener(this);
        vistaMateria.getBtnResetearDatos().addActionListener(this);
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
    //@Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == vistaEstudiante.getBtnRegistrar()) {
//            registrarEstudiante();
//        } else if (e.getSource() == vistaEstudiante.getBtnBuscar()) {
//            buscarEstudiante();
//        } else if (e.getSource() == vistaEstudiante.getBtnActualizar()) {
//            actualizarEstudiante();
//        } else if (e.getSource() == vistaEstudiante.getBtnEliminar()) {
//            eliminarEstudiante();
//        } else if (e.getSource() == vistaEstudiante.getBtnLimpiarTabla()) {
//            limpiarTabla((DefaultTableModel) vistaEstudiante.getTablaEstudiantes().getModel());
//        }  else if (e.getSource() == vistaEstudiante.getBtnRegresar()) {
//            vistaEstudiante.dispose();
//            ScreenManager.abrirMenuPrincipal();
//        } 
//    }
    
//    public void registrarMateria() {
//        if (leerDatos().getPromedio() == -404) {
//            JOptionPane.showMessageDialog(vistaEstudiante, "Ingresa un promedio valido!");
//            return;
//        }
//        if (estudianteDAO.registrarEstudiante(leerDatos())) {
//            llenarTabla();
//            JOptionPane.showMessageDialog(vistaEstudiante, "Estudiante registrado con exito.","Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
//            limpiarEspacios();
//        } else {
//            JOptionPane.showMessageDialog(vistaEstudiante, "Completa los datos.","Registro fallido", JOptionPane.INFORMATION_MESSAGE);
//        }
//    }
//    
//    public void buscarEstudiante() {
//        if (leerDatos().getId().trim().isEmpty()  || estudianteDAO.buscarEstudiantePorId(leerDatos().getId()) == null) {
//            JOptionPane.showMessageDialog(vistaEstudiante, "Estudiante no encontrado.");
//        } else {
//            Estudiante estudiante = estudianteDAO.buscarEstudiantePorId(leerDatos().getId());
//            
//            vistaEstudiante.setTxtId(estudiante.getId());
//            vistaEstudiante.setTxtNombre(estudiante.getNombre());
//            vistaEstudiante.setTxtApellido(estudiante.getApellido());
//            vistaEstudiante.setTxtPromedio(estudiante.getPromedio());
//            
//            llenarTabla();
//            
//            JOptionPane.showMessageDialog(vistaEstudiante, "Estudiante encontrado. Los datos se mostraran en las cajas de texto.");
//            
//        }
//        
//    }
//    
//    
//    public void actualizarEstudiante() {
//            if (leerDatos().getPromedio() == -404) {
//            JOptionPane.showMessageDialog(vistaEstudiante, "Ingresa datos validos!");
//            return;
//        }
//        Estudiante estudiante = leerDatos();
//        
//        if (estudianteDAO.actualizarDatosPorId(estudiante)) {
//            JOptionPane.showMessageDialog(vistaEstudiante, "Estudiante actualizado correctamente.");
//            limpiarEspacios();
//            llenarTabla();
//        } else {
//            JOptionPane.showMessageDialog(vistaEstudiante, "Estudiante no encontrado.");
//            
//            llenarTabla();
//        }
//    }
//    
//    public void eliminarEstudiante() {
//        int confirmacionEliminacion = JOptionPane.showConfirmDialog(vistaEstudiante, 
//                "Estas seguro de eliminar a este estudiante?", 
//                "Confirmation",
//                JOptionPane.YES_NO_OPTION,
//                JOptionPane.WARNING_MESSAGE);
//
//        if (confirmacionEliminacion == JOptionPane.YES_OPTION) {
//            if (estudianteDAO.eliminarEstudiantePorId(leerDatos().getId())) {
//
//                JOptionPane.showMessageDialog(vistaEstudiante, "Estudiante eliminado.");
//
//                limpiarEspacios();
//
//                llenarTabla();
//            } else {
//                JOptionPane.showMessageDialog(vistaEstudiante, "Estudiante no encontrado.");
//            }
//        }
//    }
//    
//    
//    public void llenarTabla() {
//        DefaultTableModel modeloTabla = (DefaultTableModel) vistaEstudiante.getTablaEstudiantes().getModel();
//        
//        modeloTabla.setRowCount(0);
//        
//        Object[] fila = new Object[4];
//        
//        List<Estudiante> listaEstudiantes = estudianteDAO.retornarLista();
//        
//        for (Estudiante estudiante: listaEstudiantes) {
//            fila[0] = estudiante.getId();
//            fila[1] = estudiante.getNombre();
//            fila[2] = estudiante.getApellido();
//            fila[3] = estudiante.getPromedio();
//            modeloTabla.addRow(fila);
//        }
//    }
//    
//    public void limpiarTabla(DefaultTableModel modeloTabla) {
//        int confirmacionDeEliminacion = JOptionPane.showConfirmDialog(vistaEstudiante, 
//                "Estas seguro de resetear todos lo datos?",
//                "Confirmacion reseteo",
//                JOptionPane.YES_NO_OPTION,
//                JOptionPane.WARNING_MESSAGE);
//        
//        if (confirmacionDeEliminacion == JOptionPane.YES_OPTION) {
//            modeloTabla.setRowCount(0);
//            estudianteDAO.resetearTodo();
//        } 
//    }
    
    //private Materia leerDatos() {
        //return new Materia(vistaMateria.getTxtId(), vistaMateria.getTxtNombreMateria(), vistaMateria.getTxtCreditos());
    //}
//    
//    private void limpiarEspacios() {
//        vistaEstudiante.setTxtId(null);
//        vistaEstudiante.setTxtNombre(null);
//        vistaEstudiante.setTxtApellido(null);
//        vistaEstudiante.setTxtPromedio(0.0);
//    }
//    
//    
//}

    
}
