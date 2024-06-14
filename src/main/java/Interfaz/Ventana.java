package Interfaz;
import javax.swing.*;

public class Ventana extends  JFrame {
    public Ventana(){
        this.setTitle("panel principal");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // cerrar la aplicacion al apretar x
        this.setSize(1100, 670); // tamaño de la ventana
        this.setVisible(true);
    }
}