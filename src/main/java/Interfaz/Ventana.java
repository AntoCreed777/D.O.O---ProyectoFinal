package Interfaz;
import Logica.TipoHabitat;

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;


public class Ventana extends  JFrame {
    private BufferedImage imagen;
    public Ventana(){
        this.setTitle("ventana");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // cerrar la aplicacion al apretar x
        this.setSize(1100, 670); // tamaño de la ventana
        this.setVisible(true);

        try {
            imagen = ImageIO.read(new File("src/main/java/Interfaz/imagenes/fondo.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (imagen != null) {
                    g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        this.setContentPane(panel);
        this.setVisible(true);

    }

    public void apretarHabitat(){
        HabitatGrafico habitat = new HabitatGrafico(TipoHabitat.POLAR);
    }
}
