package Interfaz.Habitat.Paneles_Seleccion;

import Interfaz.Animal_Y_Comida.ComidaGrafica;
import Interfaz.GeneradorImagen;
import Interfaz.Habitat.HabitatGrafico;
import Logica.Accesorios;
import Logica.Comida;
import Logica.Habitat;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelAgregarAccesorio extends JPanel {

    private final Color btnColor = new Color(0xFAF3DD);
    private final Color backgroundColor = new Color(0x68B0AB);
    private final HabitatGrafico habitatGrafico;

    public PanelAgregarAccesorio(Color backgroundColor, Color btnColor, HabitatGrafico habitat){

        habitatGrafico = habitat;
        this.setBounds(50, 10, 985, 190);
        this.setBackground(backgroundColor);

        Accesorios[] accesorios = Accesorios.values();
        int padding = 10;
        int ancho = 200;
        int margen = (985 - (ancho + padding)*accesorios.length)/2 ;
        for (int i = 0; i < accesorios.length; i++) {
            JButton btn = agregarBotones(accesorios[i], ancho);
            btn.setBounds(margen + padding * i + ancho * i, 10, ancho, 180);
            this.add(btn);
        }

    }


    private JButton agregarBotones(Accesorios accesorio, int ancho){
        JButton btn = new JButton(accesorio.name());
        btn.setBackground(btnColor);
        btn.setHorizontalTextPosition(JButton.CENTER);
        btn.setVerticalTextPosition(JButton.BOTTOM);

        btn.setBorder(new MatteBorder(10,5,10,5, new Color(0xBABABA)));
        btn.setBorderPainted(true);

        ImageIcon img = GeneradorImagen.scaledProducto(accesorio.getImagen(), ancho - 100, 120);
        btn.setIcon(img);

        btn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //ComidaGrafica comidaG = new ComidaGrafica(accesorio,habitatGrafico.getPanelHabitat().clickMouse.x, habitatGrafico.getPanelHabitat().clickMouse.y,habitatGrafico.getPanelHabitat());
                // habitatGrafico.getPanelHabitat().agregarComida(comidaG);
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
