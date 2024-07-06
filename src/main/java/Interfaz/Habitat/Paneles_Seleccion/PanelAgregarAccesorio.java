package Interfaz.Habitat.Paneles_Seleccion;

import Interfaz.ObjetosGraficos.AccesorioGrafico;
import Interfaz.imagenes.GeneradorImagen;
import Interfaz.Habitat.HabitatGrafico;
import Interfaz.Habitat.Listener;

import Logica.Habitat;
import Logica.TipoHabitats.*;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ItemEvent;

/**
 * Panel que contiene los botones para seleccionar el accesorio a agregar dentro del habitat
 */
public class PanelAgregarAccesorio extends JPanel implements Listener {
    private final Color btnColor;
    private final Color btnMarginColor;
    private final HabitatGrafico habitatGrafico;
    private Habitat.AccesoriosTipo accesorioSeleccionado = null;
    private final ButtonGroup grupoBotones;
    private final PanelAgregarAccesorio panelAgregarAccesorio;

    /**
     * Contructor en donde se inician variables , se configura el panel y se agregan los botones
     * @param habitatGrafico    Habitat al que pertenece este panel y sobre el que puede actuar
     */
    public PanelAgregarAccesorio(HabitatGrafico habitatGrafico){
        this.habitatGrafico = habitatGrafico;
        this.btnColor = habitatGrafico.getHabitat().getBtnColor();
        this.btnMarginColor = habitatGrafico.getHabitat().getBtnMarginColor();
        this.panelAgregarAccesorio = this;

        this.setBounds(50, 10, 985, 190);
        this.setBackground(habitatGrafico.getHabitat().getEditPanelColor());
        this.grupoBotones  = new ButtonGroup();

        Habitat.AccesoriosTipo[] accesorios = null;
        if(habitatGrafico.getHabitat() instanceof HabitatTierra){
            accesorios = HabitatTierra.Accesorios.values();
        } else if(habitatGrafico.getHabitat() instanceof HabitatMarte){
            accesorios = HabitatMarte.Accesorios.values();
        }

        int padding = 10;
        int ancho = 200;
        int margen = (985 - (ancho + padding)*accesorios.length)/2 ;
        for (int i = 0; i < accesorios.length; i++) {
            JToggleButton btn = agregarBotones(accesorios[i], ancho);
            btn.setBounds(margen + padding * i + ancho * i, 10, ancho, 180);
            this.add(btn);
            grupoBotones.add(btn);
        }
    }

    /**
     * Funcion para crear botones
     * @param accesorio    accesorio que creara el boton
     * @param ancho         Ancho del boton
     * @return              Se retorna el boton que se creo
     */

    private JToggleButton agregarBotones(Habitat.AccesoriosTipo accesorio, int ancho){
        JToggleButton btn = new JToggleButton(accesorio.name());
        btn.setBackground(btnColor);
        btn.setHorizontalTextPosition(JButton.CENTER);
        btn.setVerticalTextPosition(JButton.BOTTOM);

        btn.setBorder(new MatteBorder(10,5,10,5, btnMarginColor));
        btn.setBorderPainted(true);

        ImageIcon img = GeneradorImagen.scaledProducto(accesorio.getImagen(), ancho - 80, 120);
        btn.setIcon(img);

        btn.addActionListener(e -> {
            accesorioSeleccionado = accesorio;
            habitatGrafico.getPanelHabitat().suscribirse(panelAgregarAccesorio);
        });

        btn.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.DESELECTED) {accesorioSeleccionado = null;}
        });

        return btn;
    }

    public void agregarAccesorio(Point point){
        AccesorioGrafico accesorioG = new AccesorioGrafico(accesorioSeleccionado ,point.x, point.y,habitatGrafico.getPanelHabitat());
        habitatGrafico.getPanelHabitat().agregarAccesorio(accesorioG);
    }

    @Override
    public void update(Point point) {agregarAccesorio(point);}
}