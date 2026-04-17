package Controller;

//@autor: Brayan C

import Model.Estudiante;
import Model.Materia;
import Model.MateriaDAO;
import View.ScreenManager;
import View.VistaAsignarMaterias;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public final class ControllerAsignarMaterias implements ActionListener{
    private final VistaAsignarMaterias vistaAsignarMaterias;
    

    public ControllerAsignarMaterias(VistaAsignarMaterias vistaAsignarMaterias) {
        this.vistaAsignarMaterias = vistaAsignarMaterias;
        
        activarBotones();
        llenarTablaEstudianteMateria();
        llenarTablaProfesorMateria();
    }
    
    public void activarBotones() {
        vistaAsignarMaterias.getBtnRegresar().addActionListener(this);
        vistaAsignarMaterias.getBtnAsignarProfesor().addActionListener(this);
        vistaAsignarMaterias.getBtnMatricularEstudiante().addActionListener(this);
    }
    
    public void llenarTablaEstudianteMateria() {
        DefaultTableModel modeloTabla = (DefaultTableModel) vistaAsignarMaterias.getTablaEstudianteMateria().getModel();
        
        modeloTabla.setRowCount(0);
        
        Object[] fila = new Object[2];
        
        MateriaDAO materiaDAO = new MateriaDAO();
        
        List<Materia> materias = materiaDAO.retornarLista();

        
        for (Materia materia: materias) {
            String estudiantesEnMateria = "";
            int i = 1;
            
            fila[0] = materia.getNombre();
            for (Estudiante estudiante : materia.getEstudiantes()) {
                estudiantesEnMateria += i + "." + estudiante.getNombre() + " ";
                i++;
            }
            fila[1] =estudiantesEnMateria;
            modeloTabla.addRow(fila);
        }
    }
    
    public void llenarTablaProfesorMateria() {
        DefaultTableModel modeloTabla = (DefaultTableModel) vistaAsignarMaterias.getTablaProfesorMateria().getModel();
        
        modeloTabla.setRowCount(0);
        
        Object[] fila = new Object[2];
        
        MateriaDAO materiaDAO = new MateriaDAO();
        
        for (Materia materia : materiaDAO.retornarLista()) {
            fila[0] = materia.getProfesor().getNombres();
            fila[1] = materia.getNombre();
            modeloTabla.addRow(fila);
        }
    }
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaAsignarMaterias.getBtnRegresar()) {
            System.out.println("boton regresar");
            ScreenManager.cerrarMaterias(vistaAsignarMaterias);
            ScreenManager.abrirMenuPrincipal();
        } else if (e.getSource() == vistaAsignarMaterias.getBtnAsignarProfesor()) {
            ScreenManager.cambiarVistaAAsignarProfesor(vistaAsignarMaterias);
        } else if (e.getSource() == vistaAsignarMaterias.getBtnMatricularEstudiante()) {
            ScreenManager.cambiarAPanelMatricularEstudiante(vistaAsignarMaterias);
        }
    }
    
}
