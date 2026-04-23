package Controller;

//@autor: Brayan C

import Model.Materia;
import Model.MateriaDAO;
import Model.Profesor;
import Model.ProfesorDAO;
import View.PanelAsignarProfesor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ControllerPanelAsignarProfesor implements ActionListener{
    
    private final MateriaDAO materiaDAO;
    private final ProfesorDAO profesorDAO;
    private final PanelAsignarProfesor panelAsignarProfesor;

    public ControllerPanelAsignarProfesor(MateriaDAO materiaDAO, ProfesorDAO profesorDAO, PanelAsignarProfesor panelAsignarProfesor) {
        this.materiaDAO = materiaDAO;
        this.profesorDAO = profesorDAO;
        this.panelAsignarProfesor = panelAsignarProfesor;
        
        activarBotones();
        llenarTablaMaterias();
        llenarTablaProfesores();
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == panelAsignarProfesor.getBtnBuscarMateria()) {
            filtrarTablaMaterias();
        } else if (e.getSource() == panelAsignarProfesor.getBtnBuscarProfesor()) {
            filtrarTablaProfesores();
        } else if (e.getSource() == panelAsignarProfesor.getBtnAsignar()) {
            AsignarProfesorAMateria();
        }
    }
    
    public void activarBotones() {
        panelAsignarProfesor.getBtnAsignar().addActionListener(this);
        panelAsignarProfesor.getBtnBuscarMateria().addActionListener(this);
        panelAsignarProfesor.getBtnBuscarProfesor().addActionListener(this);
    }
    
    public void llenarTablaMaterias() {
        DefaultTableModel modeloTabla = (DefaultTableModel) panelAsignarProfesor.getTablaMaterias().getModel();
        
        modeloTabla.setRowCount(0);
        
        Object[] fila = new Object[3];
        
        List<Materia> materias = materiaDAO.retornarLista();
        
        for (Materia materia: materias) {
            fila[0] = materia.getId();
            fila[1] = materia.getNombre();
            fila[2] = materia.getCreditos();
            modeloTabla.addRow(fila);
        }
    }
    
        
    public void filtrarTablaMaterias() {
        DefaultTableModel modeloTabla = (DefaultTableModel) panelAsignarProfesor.getTablaMaterias().getModel();
        
        modeloTabla.setRowCount(0);
        
        Object[] fila = new Object[3];
        
        List<Materia> materias = materiaDAO.filtrarMateriaPorId(leerIdMateria());
        
        for (Materia materia: materias) {
            fila[0] = materia.getId();
            fila[1] = materia.getNombre();
            fila[2] = materia.getCreditos();
            modeloTabla.addRow(fila);
        }
        
    }
    
    public void llenarTablaProfesores() {
        DefaultTableModel modeloTabla = (DefaultTableModel) panelAsignarProfesor.getTablaProfesores().getModel();
        
        modeloTabla.setRowCount(0);
        
        Object[] fila = new Object[3];
        
        List<Profesor> profesores = profesorDAO.retornarLista();
        
        for (Profesor profesor: profesores) {
            fila[0] = profesor.getCedula();
            fila[1] = profesor.getNombres();
            fila[2] = profesor.getApellidos();
            modeloTabla.addRow(fila);
        }
    }
    
    public void filtrarTablaProfesores() {
        DefaultTableModel modeloTabla = (DefaultTableModel) panelAsignarProfesor.getTablaProfesores().getModel();
        
        modeloTabla.setRowCount(0);
        
        Object[] fila = new Object[3];
        
        List<Profesor> profesores = profesorDAO.filtrarProfesorPorCedula(leerCedulaProfesor());
        
        for (Profesor profesor: profesores) {
            fila[0] = profesor.getCedula();
            fila[1] = profesor.getNombres();
            fila[2] = profesor.getApellidos();
            modeloTabla.addRow(fila);
        }
        
    }
    
     public String ObtenerCedulaProfesorSeleccionado() {
        DefaultTableModel modeloTabla = (DefaultTableModel) panelAsignarProfesor.getTablaProfesores().getModel();
        
        int indiceProfesorSeleccionado = panelAsignarProfesor.getTablaProfesores().getSelectedRow();
        
        return modeloTabla.getValueAt(indiceProfesorSeleccionado, 0).toString();
    }
    
    public String ObtenerIdMateriaSeleccionada() {
        DefaultTableModel modeloTabla = (DefaultTableModel) panelAsignarProfesor.getTablaMaterias().getModel();
        
        int indiceMateriaSeleccionada = panelAsignarProfesor.getTablaMaterias().getSelectedRow();
        
        return modeloTabla.getValueAt(indiceMateriaSeleccionada, 0).toString();
    }
    
    public Profesor obtenerProfesorSeleccionadoPorId() {
        return profesorDAO.buscarProfesorPorCedula(ObtenerCedulaProfesorSeleccionado());
    }
    
    public void AsignarProfesorAMateria() {
        
        if (materiaDAO.asignarProfesorAMateria(obtenerProfesorSeleccionadoPorId(), ObtenerIdMateriaSeleccionada())) {
            JOptionPane.showMessageDialog(panelAsignarProfesor, "Profesor asignado correctamente.");
        } else {
        JOptionPane.showMessageDialog(panelAsignarProfesor, "Ya existe profesor para esta materia");
        }
    }

    
    public String leerIdMateria() {
        return panelAsignarProfesor.getTxtIdMateria();
    }
    
    public String leerCedulaProfesor() {
        return panelAsignarProfesor.getTxtICedulaProfesor();
    }
}
