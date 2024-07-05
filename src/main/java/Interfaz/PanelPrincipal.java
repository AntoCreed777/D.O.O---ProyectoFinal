package Interfaz;

import Interfaz.imagenes.GeneradorImagen;

import javax.swing.*;
import java.awt.*;

/**
 * Panel que representa al zoologico
 */
public class PanelPrincipal extends JPanel{

    /**
     * Constructor que carga la imagen de fondo del Panel/Zoo
     */

    public PanelPrincipal(Ventana ventana) {
        this.setLayout(null);
        this.setBackground(new Color(0x05072E));
        this.add(GeneradorImagen.ImageLabel("src/main/java/Interfaz/imagenes/fondo_espacio.png", 25, 25, 1035, 580));


        PanelSelecPlaneta btnMercurio = new PanelSelecPlaneta("Mercurio", 220, 517, 90, 80, ventana);
        PanelSelecPlaneta btnVenus = new PanelSelecPlaneta("Venus", 318, 465, 102, 96, ventana);
        PanelSelecPlaneta btnTierra = new PanelSelecPlaneta("Tierra", 375, 340, 140, 125, ventana);
        PanelSelecPlaneta btnMarte = new PanelSelecPlaneta("Marte", 487, 258, 123, 115, ventana);
        PanelSelecPlaneta btnJupiter = new PanelSelecPlaneta("Jupiter", 628, 295, 170, 155, ventana);
        PanelSelecPlaneta btnSaturno = new PanelSelecPlaneta("Saturno", 795, 242, 160, 138, ventana);
        PanelSelecPlaneta btnNeptuno = new PanelSelecPlaneta("Urano", 918, 173, 105, 95, ventana);
        PanelSelecPlaneta btnUrano = new PanelSelecPlaneta("Neptuno", 977, 60, 82, 95, ventana);


        this.add(btnMercurio);
        this.add(btnVenus);
        this.add(btnTierra);
        this.add(btnMarte);
        this.add(btnJupiter);
        this.add(btnSaturno);
        this.add(btnUrano);
        this.add(btnNeptuno);
    }

}
