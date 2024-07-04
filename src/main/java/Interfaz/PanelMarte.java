package Interfaz;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelMarte extends JPanel {

    private final Ventana ventana;

    public PanelMarte(Ventana ventana) {

        this.ventana = ventana;
        this.setLayout(null);

        crearBotonRetorno();

        BotonHabitat btn1 = new BotonHabitat(this ,178,95,198,217);
        this.add(btn1);

        JLabel fondo = GeneradorImagen.ImageLabel("src/main/java/Interfaz/imagenes/fondo_marte.png", 0,0,1088,632);
        this.add(fondo);
    }


    public void crearBotonRetorno(){
        JButton btnRetorno = new JButton("Volver a espacio");
        btnRetorno.setBounds(20, 20, 150, 70);
        btnRetorno.setMargin(new Insets(0,0,0,0));
        btnRetorno.setBackground(new Color(0xffffff));

        btnRetorno.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ventana.mostrarPanelMarte(false);
                ventana.mostrarPanelPrincipal(true);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        this.add(btnRetorno);
    }
}
