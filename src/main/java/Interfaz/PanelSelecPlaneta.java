package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelSelecPlaneta extends JPanel {

    private final PanelSelecPlaneta btn;

    public PanelSelecPlaneta(String nombre, int x, int y , int width, int height, Ventana ventana){

        this.btn = this;
        this.setBounds(x, y, width, height);
        this.setBackground(new Color(0x05072E));


        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                switch(nombre){
                    case "Tierra": ventana.mostrarPanelTierra(true); ventana.mostrarPanelPrincipal(false); break;
                    case "Marte" : ventana.mostrarPanelMarte(true); ventana.mostrarPanelPrincipal(false); break;
                    default:
                        JOptionPane.showMessageDialog(null, "No se puede acceder a este planeta");
                        ventana.mostrarPanelPrincipal(true);
                        break;
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {btn.setBackground(new Color(0x330742));
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
