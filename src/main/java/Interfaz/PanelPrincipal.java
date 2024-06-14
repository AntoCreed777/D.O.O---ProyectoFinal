package Interfaz;
import
import javax.swing.*;

public class PanelPrincipal extends  JFrame {
    public PanelPrincipal(){
        this.setTitle("panel principal");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // cerrar la aplicacion al apretar x
        this.setSize(1100, 670); // tamaño de la ventana
        this.setResizable(false); // no se puede cambiar el tamaño
        frame.setVisible(true);
    }
}