package Interfaz.Habitat.Paneles_Seleccion;

import Interfaz.Animal_Y_Comida.AccesorioGrafico;
import Interfaz.GeneradorImagen;
import Interfaz.Habitat.HabitatGrafico;

import Logica.TipoHabitats.HabitatTierra;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Panel que contiene los botones para seleccionar el accesorio a agregar dentro del habitat
 */
public class PanelAgregarAccesorio extends JPanel {
    private final Color btnColor;
    private final Color btnMarginColor;
    private final HabitatGrafico habitatGrafico;

    /**
     * Contructor en donde se inician variables , se configura el panel y se agregan los botones
     * @param habitatGrafico    Habitat al que pertenece este panel y sobre el que puede actuar
     */
    public PanelAgregarAccesorio(HabitatGrafico habitatGrafico){
        this.habitatGrafico = habitatGrafico;
        this.btnColor = habitatGrafico.getHabitat().getBtnColor();
        this.btnMarginColor = habitatGrafico.getHabitat().getBtnMarginColor();

        this.setBounds(50, 10, 985, 190);
        this.setBackground(habitatGrafico.getHabitat().getEditPanelColor());

        HabitatTierra.Accesorios[] accesorios = HabitatTierra.Accesorios.values();
        int padding = 10;
        int ancho = 200;
        int margen = (985 - (ancho + padding)*accesorios.length)/2 ;
        for (int i = 0; i < accesorios.length; i++) {
            JButton btn = agregarBotones(accesorios[i], ancho);
            btn.setBounds(margen + padding * i + ancho * i, 10, ancho, 180);
            this.add(btn);
        }
    }

    /**
     * Funcion para crear botones
     * @param accesorio    accesorio que creara el boton
     * @param ancho         Ancho del boton
     * @return              Se retorna el boton que se creo
     */
    private JButton agregarBotones(HabitatTierra.Accesorios accesorio, int ancho){
        JButton btn = new JButton(accesorio.name());
        btn.setBackground(btnColor);
        btn.setHorizontalTextPosition(JButton.CENTER);
        btn.setVerticalTextPosition(JButton.BOTTOM);

        btn.setBorder(new MatteBorder(10,5,10,5, btnMarginColor));
        btn.setBorderPainted(true);

        ImageIcon img = GeneradorImagen.scaledProducto(accesorio.getImagen(), ancho - 80, 120);
        btn.setIcon(img);

        btn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AccesorioGrafico accesorioG = new AccesorioGrafico(accesorio ,habitatGrafico.getPanelHabitat().clickMouse.x, habitatGrafico.getPanelHabitat().clickMouse.y,habitatGrafico.getPanelHabitat());
                habitatGrafico.getPanelHabitat().agregarAccesorio(accesorioG);
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

        return btn;
    }
}
