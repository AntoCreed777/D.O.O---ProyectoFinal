package Interfaz;

import Interfaz.imagenes.GeneradorImagen;

import javax.swing.*;
import java.awt.*;

/**
 * Panel que representa al zoologico
 */
public class PanelPrincipal extends JPanel{

    private final Ventana ventana;
    private final PanelPrincipal panel;

    /**
     * Cpnstructor que carga la imagen de fondo del Panel/Zoo
     */

    public PanelPrincipal(Ventana ventana) {
        this.ventana = ventana;
        this.panel = this;
        this.setLayout(null);
        this.setBackground(new Color(0x05072E));
        JLabel fondo = GeneradorImagen.ImageLabel("src/main/java/Interfaz/imagenes/fondo_espacio.png", 25, 25, 1035, 580);


        PanelSelecPlaneta btnTierra = new PanelSelecPlaneta("Tierra", 375, 340, 140, 125, ventana);
        PanelSelecPlaneta btnMarte = new PanelSelecPlaneta("Marte", 488, 258, 123, 115, ventana);
        PanelSelecPlaneta btnJupiter = new PanelSelecPlaneta("Jupiter", 630, 295, 170, 155, ventana);

        this.add(fondo);
        this.add(btnTierra);
        this.add(btnMarte);
        this.add(btnJupiter);
    }

}
