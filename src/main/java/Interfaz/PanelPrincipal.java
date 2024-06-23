package Interfaz;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PanelPrincipal extends JPanel{
    private BufferedImage imagen;

    public PanelPrincipal() {
        try {imagen = ImageIO.read(new File("src/main/java/Interfaz/imagenes/fondo.png"));}
        catch (IOException e) {e.printStackTrace();}
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagen != null) {
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
