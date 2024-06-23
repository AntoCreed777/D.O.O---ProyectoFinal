package Interfaz.Habitat;

import Interfaz.Animal_Y_Comida.*;
import Interfaz.GeneradorImagen;
import Logica.TipoHabitat;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PanelHabitat extends JPanel implements MouseListener {
    private BufferedImage imagen;
    private final ArrayList<AnimalGrafico> listaAnimales;
    private final List<ComidaGrafica> listaComida;
    private final Rectangle maximizado = new Rectangle(100, 0, 900, 630);
    private final Rectangle minimizado = new Rectangle(190, 0, 700,420);
    public Point clickMouse = new Point(0, 0);

    public PanelHabitat(int backgroundColor, TipoHabitat tipo) {
        this.setBounds(maximizado);
        this.setBackground(new Color(backgroundColor));

        listaAnimales = new ArrayList<AnimalGrafico>();
        this.listaComida = Collections.synchronizedList(new ArrayList<>());

        this.addMouseListener(this);

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

    public void ajustarPanel(String ajuste){
        if(ajuste.equals("maximizar")){this.setBounds(maximizado);}
        else{this.setBounds(minimizado);}

        for(AnimalGrafico animal : listaAnimales){
            animal.rePosicionar(maximizado,minimizado);
            animal.reDimencionar(maximizado);
        }
        for(ComidaGrafica comida : listaComida){
            comida.rePosicionarDimencionar(maximizado,minimizado);
        }
        this.repaint();
    }

    public void agregarAnimal(AnimalGrafico animal){
        listaAnimales.add(animal);      //Se agrega a la lista de los animales internos
        animal.validarPosicion();       //Verifica que se encuentre dentro del panel la imagen
        this.add(animal.getLabel());    //Se agrega al Habitat (JPanel)
        new Thread(animal).start();     //Se inicia el movimiento de los animales
    }

    public void agregarComida(ComidaGrafica comida){
        comida.validarPosicion();       //Verifica que se encuentre dentro del panel la imagen
        this.add(comida.getLabel());    //Se agrega al Habitat (JPanel)
        new Thread(comida).start();     //Animacion de caer de la comida
    }

    public synchronized List<ComidaGrafica> getListaComida() {return listaComida;}

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
