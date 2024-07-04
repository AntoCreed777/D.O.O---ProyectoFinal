package Interfaz.Habitat.Paneles_Seleccion;

import Interfaz.ObjetosGraficos.ComidaGrafica;
import Interfaz.imagenes.GeneradorImagen;
import Interfaz.Habitat.HabitatGrafico;

import Logica.Comida;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Panel que contiene los botones para seleccionar la comida a agregar dentro del habitat
 */
public class PanelAgregarComida extends JPanel {
    private final Color btnColor;
    private final Color btnMarginColor;
    private final HabitatGrafico habitatGrafico;

    /**
     * Contructor en donde se inician variables , se configura el panel y se agregan los botones
     * @param habitatGrafico    Habitat al que pertenece este panel y sobre el que puede actuar
     */
    public PanelAgregarComida(HabitatGrafico habitatGrafico) {
        this.btnColor = habitatGrafico.getHabitat().getBtnColor();
        this.btnMarginColor = habitatGrafico.getHabitat().getBtnMarginColor();
        this.habitatGrafico = habitatGrafico;

        this.setBounds(50, 10, 1000, 190);
        this.setBackground(habitatGrafico.getHabitat().getEditPanelColor());

        Comida[] comidaStr = Comida.values();

        this.setLayout(null);

        int padding = 10;
        int ancho = 200;
        int margen = (985 - (ancho + padding)*comidaStr.length)/2 ;
        for (int i = 0; i < comidaStr.length; i++) {
            JButton btn = agregarBotones(comidaStr[i], ancho);
            btn.setBounds(margen + padding*i + ancho*i, 10, ancho,180);
            this.add(btn);
        }
    }

    /**
     * Funcion para crear botones
     * @param comida    Comida que creara el boton
     * @param ancho     Ancho del boton
     * @return          Se retorna el boton que se creo
     */
    private JButton agregarBotones(Comida comida, int ancho){
        JButton btn = new JButton(comida.name());
        btn.setBackground(btnColor);
        btn.setHorizontalTextPosition(JButton.CENTER);
        btn.setVerticalTextPosition(JButton.BOTTOM);

        ImageIcon img = GeneradorImagen.scaledProducto(comida.getImagen(), ancho - 100, 120);
        btn.setIcon(img);

        btn.setBorder(new MatteBorder(10,5,10,5, btnMarginColor));
        btn.setBorderPainted(true);

        btn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ComidaGrafica comidaG = new ComidaGrafica(comida,habitatGrafico.getPanelHabitat().clickMouse.x, habitatGrafico.getPanelHabitat().clickMouse.y,habitatGrafico.getPanelHabitat());
                habitatGrafico.getPanelHabitat().agregarComida(comidaG);
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
