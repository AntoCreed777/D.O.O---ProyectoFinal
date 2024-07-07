package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *  La clase PanelSelecPlaneta representa un botón interactivo para seleccionar un planet permitiendo
 * la navegación entre los diferentes planetas.
 */
public class PanelSelecPlaneta extends JPanel {
    private final PanelSelecPlaneta btn;

    /**
     *  Funcion que inicializa el panel de selección de planeta
     * @param nombre el nombre del planeta vinciulado con este botón
     * @param x es la posición x del botón
     * @param y es la posición y del botón
     * @param width es el ancho del botón
     * @param height es la altura del botón
     * @param ventana instancia de la ventana principal a la que este botón está asociado
     */
    public PanelSelecPlaneta(String nombre, int x, int y , int width, int height, Ventana ventana){
        this.btn = this;
        this.setBounds(x, y, width, height);
        this.setBackground(new Color(0x05072E));

        // se agregar un MouseListener para manejar eventos de clic
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                switch(nombre){
                    case "Tierra": ventana.mostrarPanelTierra(true); ventana.mostrarPanelPrincipal(false); break;
                    case "Marte" : ventana.mostrarPanelMarte(true); ventana.mostrarPanelPrincipal(false); break;
                    default:
                        JOptionPane.showMessageDialog(null, "Este planeta no ha sido desbloqueado");
                        ventana.mostrarPanelPrincipal(true);
                        break;
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                btn.setBackground(new Color(0x330742));
                ventana.getPanelPrincipal().repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn.setBackground(new Color(0x05072E));
                ventana.getPanelPrincipal().repaint();
            }
        });
    }
}
