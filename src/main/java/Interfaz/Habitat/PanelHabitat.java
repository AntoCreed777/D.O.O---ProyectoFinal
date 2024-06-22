package Interfaz.Habitat;

import Interfaz.Animal_Y_Comida.*;
import Interfaz.GeneradorImagen;
import Logica.TipoHabitat;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PanelHabitat extends JPanel {
    private BufferedImage imagen;
    private final ArrayList<AnimalGrafico> listaAnimales;
    private final List<ComidaGrafica> contenidoComida;
    private final Rectangle maximizado = new Rectangle(100, 0, 900, 630);
    private final Rectangle minimizado = new Rectangle(190, 0, 700,420);

    public PanelHabitat(int backgroundColor, TipoHabitat tipo) {
        this.setBounds(maximizado);
        this.setBackground(new Color(backgroundColor));

        listaAnimales = new ArrayList<AnimalGrafico>();
        this.contenidoComida = Collections.synchronizedList(new ArrayList<>());

        String img = switch(tipo){
            case POLAR -> "src/main/java/Interfaz/Imagenes/habitat_polar_1.jpg";
            case JUNGLA -> "src/main/java/Interfaz/Imagenes/habitat_jungla_1.png";
            case DESERTICO -> "src/main/java/Interfaz/Imagenes/habitat_desertico_1.png";
        };

        try {imagen = ImageIO.read(new File(img));}
        catch (IOException e) {e.printStackTrace();}
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagen != null) {
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        }
    }

    /*
     * Funcion para añadir accesorios decorativos al habitat
     */
    public void agregarAccesorio(Accesorios accesorio, int posX, int posY){

        String img = switch(accesorio){
            case ROCA -> "src/main/java/Interfaz/Imagenes/accesorio_roca_1.jpg";
            case ARBOL -> "src/main/java/Interfaz/Imagenes/accesorio_arbol_1.png";
        };

        JLabel accesorioLabel = GeneradorImagen.ImageLabel(img, posX, posY, 100, 100);
        accesorioLabel.setVerticalAlignment(JLabel.CENTER);
        accesorioLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(accesorioLabel);
    }

    //???????
    public AnimalGrafico sacarAnimal(AnimalGrafico animal){
        int index = listaAnimales.indexOf(animal); // requiere un equals bien definido en animal
        return listaAnimales.get(index);
    }

    public enum Accesorios{
        ARBOL, ROCA,
    }

    public void maximizarPanel(){
        this.setBounds(maximizado);
        for(AnimalGrafico animal : listaAnimales){
            animal.rePosicionar(maximizado,minimizado);
            animal.reDimencionar(maximizado);
        }
        this.repaint();
    }

    public void minimizarPanel(){
        this.setBounds(minimizado);
        for(AnimalGrafico animal : listaAnimales){
            animal.rePosicionar(maximizado,minimizado);
            animal.reDimencionar(maximizado);
        }
        this.repaint();
    }

    public void agregarAnimal(AnimalGrafico animal){
        listaAnimales.add(animal);      //Se agrega a la lista de los animales internos
        this.add(animal.getLabel());    //Se agrega al Habitat (JPanel)
        new Thread(animal).start();     //Se inicia el movimiento de los animales
    }

    public synchronized List<ComidaGrafica> getContenidoComida() {return contenidoComida;}

}
