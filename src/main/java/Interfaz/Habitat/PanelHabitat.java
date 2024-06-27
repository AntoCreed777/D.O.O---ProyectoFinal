package Interfaz.Habitat;

import Interfaz.Animal_Y_Comida.*;
import Interfaz.GeneradorImagen;
import Logica.Comida;
import Logica.Excepciones.NoMezclarAnimales;
import Logica.Habitat;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class PanelHabitat extends JPanel implements MouseListener {
    private BufferedImage imagen;

    private final Habitat habitat;
    private final Rectangle maximizado = new Rectangle(100, 0, 900, 630);
    private final Rectangle minimizado = new Rectangle(190, 0, 700,420);
    private String familia = null;
    public Point clickMouse = new Point(0, 0);

    public PanelHabitat(Habitat habitat) {
        this.habitat = habitat;
        this.setBounds(maximizado);
        this.setBackground(habitat.getBackgroundColor());
        this.addMouseListener(this);

        try {imagen = ImageIO.read(new File(habitat.getBackgroundImg()));}
        catch (IOException e) {e.printStackTrace();}

        for(ComidaGrafica comida : habitat.getListaComida()){
            agregarComida(comida);
        }

        for(AccesorioGrafico accesorio : habitat.getListaAccesorios()){
            agregarAccesorio(accesorio);
        }

        for(AnimalGrafico animal : habitat.getListaAnimales()){
            agregarAnimal(animal);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagen != null) {
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public void ajustarPanel(String ajuste){
        if(ajuste.equals("maximizar")){this.setBounds(maximizado);}
        else{this.setBounds(minimizado);}

        for(AnimalGrafico animal : habitat.getListaAnimales()){
            animal.rePosicionar(maximizado,minimizado);
            animal.reDimencionar(maximizado);
        }
        for(ComidaGrafica comida : habitat.getListaComida()){
            comida.rePosicionarDimencionar(maximizado,minimizado);
        }
        this.repaint();
    }

    public void agregarAnimal(AnimalGrafico animal){
        if(familia == null || familia.equals(animal.getFamiliaTaxonomica())){
            familia = animal.getFamiliaTaxonomica();
            habitat.getListaAnimales().add(animal);      //Se agrega a la lista de los animales internos
            animal.validarPosicion();       //Verifica que se encuentre dentro del panel la imagen
            this.add(animal.getLabel());    //Se agrega al Habitat (JPanel)
            new Thread(animal).start();     //Se inicia el movimiento de los animales
        }
        else{
            Exception e = new NoMezclarAnimales(familia);
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void agregarComida(ComidaGrafica comida){
        comida.validarPosicion();       //Verifica que se encuentre dentro del panel la imagen
        this.add(comida.getLabel());    //Se agrega al Habitat (JPanel)
        new Thread(comida).start();     //Animacion de caer de la comida
    }

    public void agregarAccesorio(AccesorioGrafico accesorioGrafico){
        accesorioGrafico.validarPosicion();       //Verifica que se encuentre dentro del panel la imagen
        this.add(accesorioGrafico.getLabel());    //Se agrega al Habitat (JPanel)
        new Thread(accesorioGrafico).start();     //Animacion de caer de la comida
    }

    public Habitat getHabitat(){return habitat;}



    @Override
    public void mouseClicked(MouseEvent e) {
        clickMouse = e.getPoint();
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

}
