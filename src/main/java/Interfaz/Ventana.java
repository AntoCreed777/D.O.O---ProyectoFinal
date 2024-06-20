package Interfaz;
import Logica.Animales.Animal;
import Logica.Animales.Vaca;
import Logica.Comida;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.*;
import java.io.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;


public class Ventana extends  JFrame{

    public Ventana(){
        this.setTitle("ventana");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // cerrar la aplicacion al apretar x
        this.setSize(1100, 670); // tamaño de la ventana

        PanelPrincipal panel = new PanelPrincipal();
        this.setContentPane(panel);

        this.setVisible(true);
    }
}
