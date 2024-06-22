package Interfaz.Habitat.Paneles_Seleccion;

import javax.swing.*;
import java.awt.*;

public class PanelAgregarAccesorio extends JPanel {

    private final Color btnColor = new Color(0xFAF3DD);
    private final Color backgroundColor = new Color(0x68B0AB);

    public PanelAgregarAccesorio(){

        this.setBounds(50, 10, 985, 190);
        this.setBackground(backgroundColor);

        String[] animalstr = {"roca", "arbol", "nave", "planta"};
        int padding = 10;
        int ancho = 200;
        int margen = (985 - (ancho + padding)*animalstr.length)/2 ;
        for (int i = 0; i < animalstr.length; i++) {
            JButton btn = new JButton(animalstr[i]);
            btn.setBounds(margen + padding * i + ancho * i, 10, ancho, 200);
            btn.setBackground(btnColor);

            this.add(btn);
        }
    }
}
