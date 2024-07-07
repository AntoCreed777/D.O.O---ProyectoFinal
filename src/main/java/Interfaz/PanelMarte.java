package Interfaz;

import Interfaz.imagenes.GeneradorImagen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * el panel que muestra el planeta Marte y permite navegar y selecciónar hábitats
 */
public class PanelMarte extends JPanel implements GeneradorImagen {
    private final Ventana ventana;

    /**
     * inicializa el panel de Marte, configurando su imagen de fondo y botones
     * @param ventana instancia de la ventana principal
     */
    public PanelMarte(Ventana ventana) {
        this.ventana = ventana;
        this.setLayout(null);

        crearBotonRetorno();

        // Añadir botón de hábitat y fondo al panel
        Color color = new Color(0xEAA38D);
        this.add(new BotonHabitat(this ,color, 80,421,150,150));
        this.add(new BotonHabitat(this ,color, 227,84,100,220));
        this.add(new BotonHabitat(this ,color, 356,207,229,97));
        this.add(new BotonHabitat(this ,color, 356,330,229,97));
        this.add(new BotonHabitat(this ,color, 613,451,238,97));
        this.add(new BotonHabitat(this ,color, 637,110,191,220));


        this.add(GeneradorImagen.ImageLabel("src/main/java/Interfaz/imagenes/fondo_marte.png", 0,0,1088,632));
    }

    /**
     * Crea y configura el botón para regresar al menú principal con los planetas
     */
    public void crearBotonRetorno(){
        JButton btnRetorno = new JButton();
        btnRetorno.setBounds(31, 29, 70, 90);
        btnRetorno.setMargin(new Insets(0,0,0,0));
        btnRetorno.setBackground(new Color(0xff6634));
        btnRetorno.setBorderPainted(false);
        ImageIcon img = GeneradorImagen.scaledProducto("src/main/java/Interfaz/imagenes/Habitats/nave_espacial.png",60,90);
        btnRetorno.setIcon(img);

        // Añadir listener para gestionar la acción del botón de retorno
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
