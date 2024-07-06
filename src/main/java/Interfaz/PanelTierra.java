package Interfaz;

import Interfaz.imagenes.GeneradorImagen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Panel que permite navegar entre los zoologicos del planeta tierra
 */
public class PanelTierra extends JPanel {
    private final Ventana ventana;

    /**
     *  Funcion que inicializa el panel de la Tierra
     * @param ventana La instancia de la ventana principal
     */
    public PanelTierra(Ventana ventana) {
        this.ventana = ventana;
        this.setLayout(null);

        crearBotonRetorno();

        this.add(new BotonHabitat(this, 178,95,198,217));

        this.add(GeneradorImagen.ImageLabel("src/main/java/Interfaz/imagenes/fondo_tierra.png", 0,0,1088,632));
    }

    /**
     * Funcion que crea y configura el boton para regresar al menu del Espacio con los planetas
     */
    public void crearBotonRetorno(){
        JButton btnRetorno = new JButton();
        btnRetorno.setBounds(31, 29, 70, 90);
        btnRetorno.setMargin(new Insets(0,0,0,0));
        btnRetorno.setBorderPainted(false);
        btnRetorno.setBackground(new Color(0xdef45f));

        ImageIcon img = GeneradorImagen.scaledProducto("src/main/java/Interfaz/imagenes/Habitats/nave_espacial.png",60,90);
        btnRetorno.setIcon(img);// Establecer el ícono del botón

        // Agregar un MouseListener para manejar eventos de clic
        btnRetorno.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ventana.mostrarPanelTierra(false);
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
