package Interfaz.Habitat.Paneles_Seleccion;

import Interfaz.Habitat.Listener;
import Interfaz.ObjetosGraficos.AccesorioGrafico;
import Interfaz.imagenes.GeneradorImagen;
import Interfaz.Habitat.HabitatGrafico;

import Logica.TipoHabitats.HabitatMarte;
import Logica.TipoHabitats.HabitatTierra;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Panel que contiene los botones para seleccionar el accesorio a agregar dentro del habitat
 */
public class PanelAgregarAccesorio extends JPanel implements Listener {
    private final Color btnColor;
    private final Color btnMarginColor;
    private final HabitatGrafico habitatGrafico;
    private Enum<?> accesorioSeleccionado = null;
    private final ButtonGroup grupoBotonoes;
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
        this.grupoBotonoes  = new ButtonGroup();

        if(habitatGrafico.getHabitat() instanceof  HabitatTierra){
            HabitatTierra.Accesorios[] accesorios = HabitatTierra.Accesorios.values();

            int padding = 10;
            int ancho = 200;
            int margen = (985 - (ancho + padding)*accesorios.length)/2 ;
            for (int i = 0; i < accesorios.length; i++) {
                JToggleButton btn = agregarBotonesTierra(accesorios[i], ancho);
                btn.setBounds(margen + padding * i + ancho * i, 10, ancho, 180);
                this.add(btn);
                grupoBotonoes.add(btn);
            }

        } else if(habitatGrafico.getHabitat() instanceof  HabitatMarte){

            HabitatMarte.Accesorios[] accesorios = HabitatMarte.Accesorios.values();
            int padding = 10;
            int ancho = 200;
            int margen = (985 - (ancho + padding)*accesorios.length)/2 ;
            for (int i = 0; i < accesorios.length; i++) {
                JToggleButton btn = agregarBotonesMarte(accesorios[i], ancho);
                btn.setBounds(margen + padding * i + ancho * i, 10, ancho, 180);
                this.add(btn);
                grupoBotonoes.add(btn);
            }
        }
    }

    /**
     * Funcion para crear botones
     * @param accesorio    accesorio que creara el boton
     * @param ancho         Ancho del boton
     * @return              Se retorna el boton que se creo
     */

    private JToggleButton agregarBotonesTierra(HabitatTierra.Accesorios accesorio, int ancho){
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

    private JToggleButton agregarBotonesMarte(HabitatMarte.Accesorios accesorio, int ancho){

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
    public void update(Point point) {
        agregarAccesorio(point);
    }
}
