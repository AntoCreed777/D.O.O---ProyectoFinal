package Interfaz.Habitat;

import Interfaz.BotonHabitat;
import Interfaz.imagenes.GeneradorImagen;
import Logica.Habitat;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
 * Clase para graficar el habitat
 */
public class HabitatGrafico extends JFrame implements GeneradorImagen {

    private final Habitat habitat;
    private final JToggleButton editBtn;
    private final PanelEditar panelEditar;
    private final PanelHabitat panelHabitat;
    private final BotonHabitat botonHabitat;

    public HabitatGrafico(Habitat habitat, BotonHabitat btn) throws NoSuchFieldException, IllegalAccessException {
        this.habitat = habitat;
        this.botonHabitat = btn;
        this.setSize(new Dimension(1100, 670));
        this.getContentPane().setBackground(habitat.getBackgroundColor());
        this.setLayout(null);
        this.setTitle("Hábitat");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        ImageIcon iconoVentana = Interfaz.imagenes.GeneradorImagen.scaledProducto("src/main/java/Interfaz/Imagenes/icono_ventana.png", 40,40);
        this.setIconImage(iconoVentana.getImage());

        panelHabitat = new PanelHabitat(habitat);
        this.add(panelHabitat);


        // boton de edicion
        editBtn = new JToggleButton("MENU");
        editBtn.setFont(new Font("monospaced", Font.BOLD, 16));
        editBtn.setBackground(new Color(0xFFFFFF));
        editBtn.setBorderPainted(false);
        editBtn.setMargin(new Insets(0,0,0,0));
        editBtn.setBounds(1010,5,70,40);
        editBtn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mostrarPanelEditar();
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

        this.add(editBtn);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                editBtn.setSelected(false); // esconder panel editar al ocultar el frame
                mostrarPanelEditar();
                setVisible(false);
            }
        });


        // panel de edicion
        panelEditar = new PanelEditar(this);
        panelEditar.setVisible(false);
        this.add(panelEditar);


        this.setVisible(true);
    }

    public void mostrarPanelEditar(){
        if(editBtn.isSelected()){
            panelHabitat.ajustarPanel("minimizar");
            panelEditar.setVisible(true);
        }
        else {
            panelHabitat.ajustarPanel("maximizar");
            panelHabitat.suscribirse(null);         //Evita que se sigan agregando Objetos al panel

            panelEditar.mostrarPanelAgregarAccesorio(false);
            panelEditar.mostrarPanelAgregarComida(false);
            panelEditar.mostrarPanelAgregarAnimal(false);
            panelEditar.mostrarPanelSeleccion(true);
            panelEditar.setVisible(false);
        }

        this.repaint();
    }

    public PanelHabitat getPanelHabitat(){return panelHabitat;}
    public Habitat getHabitat(){return habitat;}
    public BotonHabitat getBotonHabitat(){return botonHabitat;}
}