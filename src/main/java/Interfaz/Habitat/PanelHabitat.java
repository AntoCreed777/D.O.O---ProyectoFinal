package Interfaz.Habitat;

import Interfaz.ObjetosGraficos.*;
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
import java.util.Iterator;
import java.util.List;

/**
 * Clase PanelHabitat donde se muestra el habitat en si dentro del JFrame HabitatGrafico,
 * dentro de este panel se mostrara el fondo, los animales, la comida, etc.
 */
public class PanelHabitat extends JPanel implements MouseListener {
    private BufferedImage imagen;

    private final Habitat habitat;
    private final Rectangle maximizado = new Rectangle(100, 0, 900, 630);
    private final Rectangle minimizado = new Rectangle(190, 0, 700,420);
    private String familia = null;
    public Point clickMouse = new Point(0, 0);

    /**
     * Constructor que configura el panel, inicia las variables y agrega los elementos del habitat
     * al panel
     * @param habitat   Habitat que se representara en este panel
     */
    public PanelHabitat(Habitat habitat) {
        this.habitat = habitat;
        this.setBounds(maximizado);
        this.setBackground(habitat.getBackgroundColor());
        this.addMouseListener(this);

        try {imagen = ImageIO.read(new File(habitat.getBackgroundImg()));}
        catch (IOException e) {e.printStackTrace();}

        List<ComidaGrafica> comidas = habitat.getListaComida();
        synchronized (comidas){
            Iterator<ComidaGrafica> iterator = comidas.iterator();
            while (iterator.hasNext()){
                ComidaGrafica comida = iterator.next();
                agregarComida(comida);
            }
        }

        List<AccesorioGrafico> accesorios = habitat.getListaAccesorios();
        synchronized (accesorios){
            Iterator<AccesorioGrafico> iterator = accesorios.iterator();
            while (iterator.hasNext()){
                AccesorioGrafico accesorio = iterator.next();
                agregarAccesorio(accesorio);
            }
        }

        List<AnimalGrafico> animales = habitat.getListaAnimales();
        synchronized (animales){
            Iterator<AnimalGrafico> iterator = animales.iterator();
            while (iterator.hasNext()){
                AnimalGrafico animal = iterator.next();
                agregarAnimal(animal);
            }
        }
    }

    /**
     * Funcion encargada de pintar el fondo del panel
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagen != null) {
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        }
    }

    /**
     * Funcion que reDimensiona el panel y todos los elementos que contenga, a los cuales tambien
     * se les adapta la posicion dentro del panel
     * @param ajuste    Argumento para indicar que accion de debe realizar
     *                  (maximixar o minimizar)
     */
    public void ajustarPanel(String ajuste){
        if(ajuste.equals("maximizar")){this.setBounds(maximizado);}
        else{this.setBounds(minimizado);}

        for(AnimalGrafico animal : habitat.getListaAnimales()){
            animal.rePosicionar(maximizado,minimizado);
            animal.reDimencionar(maximizado);
        }

        List<ComidaGrafica> comidas = habitat.getListaComida();
        synchronized (comidas){
            Iterator<ComidaGrafica> iterator = comidas.iterator();
            while (iterator.hasNext()){
                ComidaGrafica comida = iterator.next();
                comida.rePosicionarDimencionar(maximizado,minimizado);
            }
        }
        this.repaint();
    }

    /**
     * Funcion que agrega un animal dentro del habitat
     * @param animal    Animal que se desea agregar
     */
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

    /**
     * Funcion que agrega una comida dentro del habitat
     * @param comida    Comida que se desea agregar
     */
    public void agregarComida(ComidaGrafica comida){
        comida.validarPosicion();       //Verifica que se encuentre dentro del panel la imagen
        this.add(comida.getLabel());    //Se agrega al Habitat (JPanel)
        new Thread(comida).start();     //Animacion de caer de la comida
    }

    /**
     * Funcion que agrega un accesorio dentro del habitat
     * @param accesorioGrafico  Accesorio que se dedsea agregar
     */
    public void agregarAccesorio(AccesorioGrafico accesorioGrafico){
        accesorioGrafico.validarPosicion();       //Verifica que se encuentre dentro del panel la imagen
        this.add(accesorioGrafico.getLabel());    //Se agrega al Habitat (JPanel)
        new Thread(accesorioGrafico).start();     //Animacion de caer de la comida
    }

    /**
     * Funcion para retornar el habitat que contiene el panel
     * @return Habitat que contiene el panel
     */
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
