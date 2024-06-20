package Interfaz;
import Logica.Animales.Animal;
import Logica.Animales.Vaca;

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;


public class Ventana extends  JFrame {
    private BufferedImage imagen;

    public Ventana(){
        this.setTitle("ventana");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // cerrar la aplicacion al apretar x
        this.setSize(1100, 670); // tamaño de la ventana

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

        HebraAnimales h = new HebraAnimales(0);
        for (int i = 0; i<50; i++){
            Animal a = new Vaca(100,100,panel);
            AnimalGrafico ag = new AnimalGrafico(a);
            panel.add(ag.getLabel());
            h.addAnimal(ag);
        }
        panel.repaint();


        this.setVisible(true);
        h.run();
    }
}
