package Controller;

//@autor: Brayan C

import Model.Estudiante;
import Model.EstudianteDAO;
import Model.Materia;
import Model.MateriaDAO;
import View.PanelMatricularEstudiante;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ControllerPanelMatricularEstudiante implements ActionListener{

    private MateriaDAO materiaDAO;
    private EstudianteDAO estudianteDAO;
    private PanelMatricularEstudiante panelMatricularEstudiante;

    public ControllerPanelMatricularEstudiante(MateriaDAO materiaDAO, PanelMatricularEstudiante panelMatricularEstudiante,EstudianteDAO estudianteDAO) {
        this.materiaDAO = materiaDAO;
        this.estudianteDAO = estudianteDAO;
        this.panelMatricularEstudiante = panelMatricularEstudiante;
        
        
        activarBotones();
        llenarTablaEstudiantes();
        llenarTablaMaterias();
    }
    
                
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == panelMatricularEstudiante.getBtnBuscarEstudiante()) {
            filtrarTablaEstudiantes();
        } else if (e.getSource() == panelMatricularEstudiante.getBtnBuscarMateria()) {
            filtrarTablaMaterias();
        } else if (e.getSource() == panelMatricularEstudiante.getBtnMatricular()) {
            matricularEstudianteEnMateria();
        }
    }
    
    
    
    
    public void activarBotones() {
        panelMatricularEstudiante.getBtnMatricular().addActionListener(this);
        panelMatricularEstudiante.getBtnBuscarEstudiante().addActionListener(this);
        panelMatricularEstudiante.getBtnBuscarMateria().addActionListener(this);
        
    }
    
    public void llenarTablaMaterias() {
        DefaultTableModel modeloTabla = (DefaultTableModel) panelMatricularEstudiante.getTablaMaterias().getModel();
        
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
    
    public void filtrarTablaEstudiantes() {
        DefaultTableModel modeloTabla = (DefaultTableModel) panelMatricularEstudiante.getTablaEstudiantes().getModel();
        
        modeloTabla.setRowCount(0);
        
        Object[] fila = new Object[3];
        
        List<Estudiante> estudiantes = estudianteDAO.filtrarEstudiantePorId(leerIDEstudiante());
        
        for (Estudiante estudiante: estudiantes) {
            fila[0] = estudiante.getId();
            fila[1] = estudiante.getNombre();
            fila[2] = estudiante.getApellido();
            modeloTabla.addRow(fila);
        }
        
    }
    
    public void filtrarTablaMaterias() {
        DefaultTableModel modeloTabla = (DefaultTableModel) panelMatricularEstudiante.getTablaMaterias().getModel();
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
    
    public void llenarTablaEstudiantes() {
        DefaultTableModel modeloTabla = (DefaultTableModel) panelMatricularEstudiante.getTablaEstudiantes().getModel();
        
        modeloTabla.setRowCount(0);
        
        Object[] fila = new Object[3];
        
        List<Estudiante> estudiantes = estudianteDAO.retornarLista();
        
        for (Estudiante estudiante: estudiantes) {
            fila[0] = estudiante.getId();
            fila[1] = estudiante.getNombre();
            fila[2] = estudiante.getApellido();
            modeloTabla.addRow(fila);
        }
    }
    
    public String ObtenerIdEstudianteSeleccionado() {
        DefaultTableModel modeloTabla = (DefaultTableModel) panelMatricularEstudiante.getTablaEstudiantes().getModel();
        
        int indiceEstudianteSeleccionado = panelMatricularEstudiante.getTablaEstudiantes().getSelectedRow();
        
        return modeloTabla.getValueAt(indiceEstudianteSeleccionado, 0).toString();
    }
    
    public String ObtenerIdMateriaSeleccionada() {
        DefaultTableModel modeloTabla = (DefaultTableModel) panelMatricularEstudiante.getTablaMaterias().getModel();
        
        int indiceMateriaSeleccionada = panelMatricularEstudiante.getTablaMaterias().getSelectedRow();
        
        return modeloTabla.getValueAt(indiceMateriaSeleccionada, 0).toString();
    }
    
    public Estudiante obtenerEstudianteSeleccionadoPorId() {
        return estudianteDAO.buscarEstudiantePorId(ObtenerIdEstudianteSeleccionado());
    }
    
    public void matricularEstudianteEnMateria() {
        materiaDAO.matricularEstudiante(ObtenerIdMateriaSeleccionada(), obtenerEstudianteSeleccionadoPorId());
        JOptionPane.showMessageDialog(panelMatricularEstudiante, "Estudiante matriculado con exito.");
    }
    
    public String leerIdMateria() {
        return panelMatricularEstudiante.getTxtidMateria();
    }
    
    public String leerIDEstudiante() {
        return panelMatricularEstudiante.getTxtIdEstudiante();
    }
}
