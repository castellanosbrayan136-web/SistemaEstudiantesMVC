package Controller;

//@autor: Brayan C

import View.ScreenManager;
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
                vistaPrincipal.dispose();
                ScreenManager.finalizarTodo();
            }
        });
    }
    
 
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaPrincipal.getBtnRegistrarEstudiantes()) {
            ScreenManager.abrirGestionEstudiantes(vistaPrincipal);
        } else if (e.getSource() == vistaPrincipal.getBtnRegistrarProfesores()) {
            ScreenManager.abrirGestionProfesores(vistaPrincipal);
        } else if (e.getSource() == vistaPrincipal.getBtnRegistrarMaterias()){
            ScreenManager.abrirGestionMaterias(vistaPrincipal);
        } else if (e.getSource() == vistaPrincipal.getBtnSalir()) {
            vistaPrincipal.dispose();
            ScreenManager.finalizarTodo();
            ScreenManager.cerrarMenuPrincipal(vistaPrincipal);
        }  else if (e.getSource() == vistaPrincipal.getBtnAsignarMaterias()) {
            ScreenManager.abrirAsignarMaterias(vistaPrincipal);
        }
    }
}
