package Controller;

//@autor: Brayan C

import View.ScreenManager;
import View.PanelAsignarProfesor;
import View.VistaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControllerMenuPrincipal implements ActionListener{

    private VistaPrincipal vistaPrincipal;

    public ControllerMenuPrincipal(VistaPrincipal vistaPrincipal) {
        this.vistaPrincipal = vistaPrincipal;
        
        activarBotones();
    }

    
    
    public void activarBotones() {
        vistaPrincipal.getBtnRegistrarEstudiantes().addActionListener(this);
        vistaPrincipal.getBtnAsignarMaterias().addActionListener(this);
        vistaPrincipal.getBtnRegistrarProfesores().addActionListener(this);
        vistaPrincipal.getBtnSalir().addActionListener(this);
        vistaPrincipal.getBtnRegistrarMaterias().addActionListener(this);
        
        this.vistaPrincipal.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                ScreenManager.cerrarMenuPrincipal(vistaPrincipal);
            }
        });
    }
    
 
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaPrincipal.getBtnRegistrarEstudiantes()) {
            ScreenManager.cerrarMenuPrincipal(vistaPrincipal);
            ScreenManager.abrirEstudiantes();
        } else if (e.getSource() == vistaPrincipal.getBtnRegistrarProfesores()) {
            ScreenManager.cerrarMenuPrincipal(vistaPrincipal);
            ScreenManager.abrirMenuProfesores();
        } else if (e.getSource() == vistaPrincipal.getBtnRegistrarMaterias()){
            ScreenManager.cerrarMenuPrincipal(vistaPrincipal);
            ScreenManager.abrirMaterias();
        } else if (e.getSource() == vistaPrincipal.getBtnSalir()) {
            vistaPrincipal.dispose();
            ScreenManager.cerrarMenuPrincipal(vistaPrincipal);
        } else if (e.getSource() == vistaPrincipal.getBtnRegistrarProfesores()) {
            ScreenManager.cerrarMenuPrincipal(vistaPrincipal);
            ScreenManager.abrirMenuProfesores();
        } else if (e.getSource() == vistaPrincipal.getBtnAsignarMaterias()) {
            ScreenManager.cerrarMenuPrincipal(vistaPrincipal);
            ScreenManager.abrirAsignarMaterias();
        }
    }
    
    public void finalizar() {
        this.vistaPrincipal.dispose();
        this.vistaPrincipal = null;
    }
}
