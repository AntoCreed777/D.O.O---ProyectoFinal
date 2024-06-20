package Interfaz;

import Logica.Animales.*;
import Logica.Comida;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PanelPrincipal extends JPanel implements MouseListener {
    private BufferedImage imagen;
    private final ArrayList<ComidaGrafica> contenidoComida;
    private final ArrayList<AnimalGrafico> contenidoAnimal;

    public PanelPrincipal() {
        try {imagen = ImageIO.read(new File("src/main/java/Interfaz/imagenes/fondo.png"));}
        catch (IOException e) {e.printStackTrace();}

        this.addMouseListener(this);

        this.contenidoComida = new ArrayList<>();
        this.contenidoAnimal = new ArrayList<>();

        for (int i = 0; i<50; i++){
            Animal animal = new Vaca(100,100,this);
            AnimalGrafico animalG = new AnimalGrafico(animal);

            contenidoAnimal.add(animalG);
            this.add(animalG.getLabel());

            new Thread(animalG).start();    //Iniciar el movimiento del animal
        }

        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagen != null) {
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        Point point = e.getPoint();

        ComidaGrafica comida = new ComidaGrafica(Comida.Pasto, point.x, point.y, this);
        this.add(comida.getLabel());

        new Thread(comida).start(); //Animacion de caer de la comida
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    public ArrayList<ComidaGrafica> getContenidoComida() {return contenidoComida;}
}
