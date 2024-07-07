package Interfaz;

import Interfaz.imagenes.GeneradorImagen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *La clase PanelTierra representa un panel que permite navegar entre los zoológicos del planeta Tierra
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

        crearBotonRetorno(); // Crea y configura el botón de retorno al menú principal
        Color color = new Color(0xECD4CE);

        // Agrega los botones de hábitat al panel con sus respectivas posiciones y tamaños
        this.add(new BotonHabitat(this, color,178,94,199,111));
        this.add(new BotonHabitat(this, color, 178,204,199,108));

        this.add(new BotonHabitat(this, color,405, 94, 238, 96));
        this.add(new BotonHabitat(this, color,713, 94, 236, 110));
        this.add(new BotonHabitat(this, color,178, 339, 150, 200));

        this.add(new BotonHabitat(this, color,723, 365, 150, 150));

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
