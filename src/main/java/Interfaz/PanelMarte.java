package Interfaz;

import Interfaz.imagenes.GeneradorImagen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelMarte extends JPanel implements GeneradorImagen {
    private final Ventana ventana;

    public PanelMarte(Ventana ventana) {
        this.ventana = ventana;
        this.setLayout(null);

        crearBotonRetorno();

        this.add(new BotonHabitat(this ,178,95,198,217));

        this.add(GeneradorImagen.ImageLabel("src/main/java/Interfaz/imagenes/fondo_marte.png", 0,0,1088,632));
    }


    public void crearBotonRetorno(){
        JButton btnRetorno = new JButton();
        btnRetorno.setBounds(31, 29, 70, 90);
        btnRetorno.setMargin(new Insets(0,0,0,0));
        btnRetorno.setBackground(new Color(0xff6634));
        btnRetorno.setBorderPainted(false);
        ImageIcon img = GeneradorImagen.scaledProducto("src/main/java/Interfaz/imagenes/Habitats/nave_espacial.png",60,90);
        btnRetorno.setIcon(img);


        btnRetorno.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ventana.mostrarPanelMarte(false);
                ventana.mostrarPanelPrincipal(true);
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
        this.add(btnRetorno);
    }
}
