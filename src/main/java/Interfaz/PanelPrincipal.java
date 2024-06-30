package Interfaz;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Panel que representa al zoologico
 */
public class PanelPrincipal extends JPanel{
    private BufferedImage imagen;

    /**
     * Cpnstructor que carga la imagen de fondo del Panel/Zoo
     */
    public PanelPrincipal() {
        try {imagen = ImageIO.read(new File("src/main/java/Interfaz/imagenes/fondo.png"));}
        catch (IOException e) {e.printStackTrace();}
    }

    /**
     * Funcion que pinta el fondo del Panel/Zoo
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagen != null) {
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
