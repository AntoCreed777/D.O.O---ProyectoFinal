package Interfaz;

import Logica.Animales.Animal;
import Logica.TipoHabitat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import static Logica.TipoHabitat.*;

/*
* Clase para graficar el habitat
*/
public class HabitatGrafico extends JFrame implements GeneradorImagen{

    private TipoHabitat tipoHabitat = null;
    private HabitatGrafico habitat;
    private JToggleButton editBtn = null;
    private JPanel panelEdicion = null;
    private ArrayList<AnimalGrafico> listaAnimales = null;
    JPanel panelHabitat = null;
    private JLabel imgLabel = null;

    public HabitatGrafico(TipoHabitat tipo) {

        tipoHabitat = tipo;
        habitat = this;
        listaAnimales = new ArrayList<AnimalGrafico>();

        this.setBackground(Color.blue);
        this.setLayout(null);
        this.setTitle("habitat");
        this.setSize(1100, 670); // tamaño de la ventana


        panelHabitat = new JPanel();
        panelHabitat.setBounds(0, 0, 1100, 670);


        String img = "";
        switch(tipo){
            case POLAR -> img = "src/main/java/Interfaz/Imagenes/habitat_polar_1.jpg";
            case JUNGLA -> img = "src/main/java/Interfaz/Imagenes/habitat_jungla_1.png";
            case DESERTICO -> img = "src/main/java/Interfaz/Imagenes/habitat_desertico_1.png";
        }

        imgLabel = GeneradorImagen.ImageLabel(img, 120, 0, this.getSize().width - 100, this.getSize().height);

        panelHabitat.add(imgLabel);
        this.add(panelHabitat);


        // boton de edicion
        editBtn = new JToggleButton("edit");
        editBtn.setBounds(1000,0,60,30);

        editBtn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mostrarPanelEdicion();
            }

            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });

        this.add(editBtn);



        // panel de edicion
        panelEdicion = new JPanel();
        panelEdicion.setBackground(new Color(0xD7B4FF));
        panelEdicion.setBounds(0, this.getSize().height - 250, this.getSize().width, 250);
        panelEdicion.setVisible(false);

        this.add(panelEdicion);


        this.setVisible(true);
    }


    /*
    * Funcion para añadir accesorios decorativos al habitat
    */
    public void agregarAccesorio(Accesorios accesorio, int posX, int posY){

        String img = "";
        switch(accesorio){
            case ROCA -> img =  "src/main/java/Interfaz/Imagenes/accesorio_roca_1.jpg";
            case ARBOL -> img = "src/main/java/Interfaz/Imagenes/accesorio_arbol_1.png";
        }

        JLabel accesorioLabel = GeneradorImagen.ImageLabel(img, posX, posY, 100, 100);
        accesorioLabel.setVerticalAlignment(JLabel.CENTER);
        accesorioLabel.setHorizontalAlignment(JLabel.LEFT);
        panelHabitat.add(accesorioLabel);

    }

    public void agregarAnimal(AnimalGrafico animal){
        listaAnimales.add(animal);
    }

    public AnimalGrafico sacarAnimal(AnimalGrafico animal){
        int index = listaAnimales.indexOf(animal); // requiere un equals bien definido en animal
        return listaAnimales.get(index);
    }

    public enum Accesorios{
        ARBOL, ROCA,
    }

    public void mostrarPanelEdicion(){

        String img = "";
        switch(tipoHabitat){
            case POLAR -> img = "src/main/java/Interfaz/Imagenes/habitat_polar_1.jpg";
            case JUNGLA -> img = "src/main/java/Interfaz/Imagenes/habitat_jungla_1.png";
            case DESERTICO -> img = "src/main/java/Interfaz/Imagenes/habitat_desertico_1.png";
        }

        if(editBtn.isSelected()){

            panelHabitat.remove(imgLabel);
            panelHabitat.setBounds(200, 0, 1100 - 300 - 100,670 - 250);
            imgLabel = GeneradorImagen.ImageLabel("src/main/java/Interfaz/Imagenes/habitat_polar_1.jpg", 150, 0, 1100 - 300 - 100, 670 - 250 );

            panelHabitat.add(imgLabel);

            panelEdicion.setVisible(true);

        } else {
            panelHabitat.remove(imgLabel);
            panelHabitat.setBounds(0, 0, 1100, 670);
            imgLabel = GeneradorImagen.ImageLabel("src/main/java/Interfaz/Imagenes/habitat_polar_1.jpg", 120, 0, 1000, 670);

            panelHabitat.add(imgLabel);

            panelEdicion.setVisible(false);
        }

        this.repaint();
    }

}
