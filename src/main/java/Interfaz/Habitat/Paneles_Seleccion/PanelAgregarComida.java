package Interfaz.Habitat.Paneles_Seleccion;

import Interfaz.Habitat.Listener;
import Interfaz.ObjetosGraficos.ComidaGrafica;
import Interfaz.imagenes.GeneradorImagen;
import Interfaz.Habitat.HabitatGrafico;

import Logica.Comida;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Panel que contiene los botones para seleccionar la comida a agregar dentro del habitat
 */
public class PanelAgregarComida extends JPanel implements Listener {
    private final Color btnColor;
    private final Color btnMarginColor;
    private final HabitatGrafico habitatGrafico;
    private final PanelAgregarComida panelAgregarComida;
    private final ArrayList<Comida> comidasPermitidas;
    private Comida comidaSeleccionada = null;
    private final ButtonGroup grupoBotones;

    /**
     * Contructor en donde se inician variables , se configura el panel y se agregan los botones
     * @param habitatGrafico    Habitat al que pertenece este panel y sobre el que puede actuar
     */
    public PanelAgregarComida(HabitatGrafico habitatGrafico) {
        this.habitatGrafico = habitatGrafico;
        this.btnColor = habitatGrafico.getHabitat().getBtnColor();
        this.btnMarginColor = habitatGrafico.getHabitat().getBtnMarginColor();
        this.panelAgregarComida = this;

        this.setBounds(50, 10, 1000, 190);
        this.setBackground(habitatGrafico.getHabitat().getEditPanelColor());
        this.setLayout(null);

        this.comidasPermitidas = habitatGrafico.getHabitat().getComidasPermitidas();
        this.grupoBotones = new ButtonGroup();

        int padding = 10;
        int ancho = 200;
        int margen = (985 - (ancho + padding)*comidasPermitidas.size())/2 ;
        for (int i = 0; i < comidasPermitidas.size(); i++) {
            JToggleButton btn = agregarBotones(comidasPermitidas.get(i), ancho);
            btn.setBounds(margen + padding*i + ancho*i, 10, ancho,180);
            this.add(btn);
            grupoBotones.add(btn);
        }
    }

    /**
     * Funcion para crear botones
     * @param comida    Comida que creara el boton
     * @param ancho     Ancho del boton
     * @return          Se retorna el boton que se creo
     */
    private JToggleButton agregarBotones(Comida comida, int ancho){
        JToggleButton btn = new JToggleButton(comida.name());
        btn.setBackground(btnColor);
        btn.setHorizontalTextPosition(JButton.CENTER);
        btn.setVerticalTextPosition(JButton.BOTTOM);

        ImageIcon img = GeneradorImagen.scaledProducto(comida.getImagen(), ancho - 100, 120);
        btn.setIcon(img);

        btn.setBorder(new MatteBorder(10,5,10,5, btnMarginColor));
        btn.setBorderPainted(true);

        btn.addActionListener(e ->{
            comidaSeleccionada = comida;
            habitatGrafico.getPanelHabitat().suscribirse(panelAgregarComida);
        });

        btn.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.DESELECTED) {comidaSeleccionada = null;}
        });

        return btn;
    }

    private void agregarComida(Point point){
        ComidaGrafica comidaG = new ComidaGrafica(comidaSeleccionada,point.x, point.y,habitatGrafico.getPanelHabitat());
        habitatGrafico.getPanelHabitat().agregarComida(comidaG);
    }

    @Override
    public void update(Point point) {agregarComida(point);}
}
