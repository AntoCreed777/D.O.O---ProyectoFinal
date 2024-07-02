package Interfaz;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PanelTierra extends JPanel {

    private BufferedImage imagen;

    public PanelTierra() {
        this.setLayout(null);

        JLabel fondo = GeneradorImagen.ImageLabel("src/main/java/Interfaz/imagenes/fondo.png", 0,0,1088,632);
        this.add(fondo);

        BotonHabitat btn1 = new BotonHabitat(178,95,198,217);
        this.add(btn1);

    }
}
