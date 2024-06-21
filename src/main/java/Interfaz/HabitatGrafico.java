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
    private PanelEditar panelEditar = null;
    private ArrayList<AnimalGrafico> listaAnimales = null;
    private JPanel panelHabitat = null;
    private JLabel imgLabel = null;
    private final int backgroundColor = 0xF6FFEC;

    public HabitatGrafico(TipoHabitat tipo) {

        tipoHabitat = tipo;
        habitat = this;
        listaAnimales = new ArrayList<AnimalGrafico>();

        this.setSize(new Dimension(1100, 670));
        this.getContentPane().setBackground(new Color(backgroundColor));
        this.setLayout(null);
        this.setTitle("habitat");
        this.setResizable(true);


        String img = "";
        switch(tipo){
            case POLAR -> img = "src/main/java/Interfaz/Imagenes/habitat_polar_1.jpg";
            case JUNGLA -> img = "src/main/java/Interfaz/Imagenes/habitat_jungla_1.png";
            case DESERTICO -> img = "src/main/java/Interfaz/Imagenes/habitat_desertico_1.png";
        }

        imgLabel = GeneradorImagen.ImageLabel(img, 0, 0, 900, 630);

        panelHabitat = new JPanel();
        panelHabitat.setBounds(90, 0, 900, 630);
        panelHabitat.setBackground(new Color(backgroundColor));

        panelHabitat.add(imgLabel);
        this.add(panelHabitat);


        // boton de edicion
        editBtn = new JToggleButton("edit");
        editBtn.setBackground(new Color(0xFFCFF4FB, true));
        editBtn.setBounds(1020,0,60,30);
        editBtn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mostrarPanelEditar();
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
        panelEditar = new PanelEditar();
        panelEditar.setVisible(false);
        this.add(panelEditar);

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

    public void mostrarPanelEditar(){

        String img = "";
        switch(tipoHabitat){
            case POLAR -> img = "src/main/java/Interfaz/Imagenes/habitat_polar_1.jpg";
            case JUNGLA -> img = "src/main/java/Interfaz/Imagenes/habitat_jungla_1.png";
            case DESERTICO -> img = "src/main/java/Interfaz/Imagenes/habitat_desertico_1.png";
        }

        if(editBtn.isSelected()){

            panelHabitat.remove(imgLabel);
            panelHabitat.setBounds(190, 0, 700,420);
            imgLabel = GeneradorImagen.ImageLabel(img, 0, 0, 700, 420);
            panelHabitat.add(imgLabel);

            panelEditar.setVisible(true);

        } else {

            panelHabitat.remove(imgLabel);
            panelHabitat.setBounds(90, 0, 900, 630);

            imgLabel = GeneradorImagen.ImageLabel(img, 0, 0, 900, 630);
            panelHabitat.add(imgLabel);

            panelEditar.mostrarPanelAgregarAnimal(false);
            panelEditar.mostrarPanelSeleccion(true);

            panelEditar.setVisible(false);
        }

        panelHabitat.repaint();
        panelEditar.repaint();
        this.repaint();

    }
}





