package Interfaz;

import Interfaz.Habitat.HabitatGrafico;
import Interfaz.imagenes.GeneradorImagen;
import Logica.Habitat;
import Logica.TipoHabitats.HabitatTierra;
import Logica.TipoHabitats.HabitatMarte;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BotonHabitat extends JButton implements MouseListener {

    private Habitat habitat = null;
    private JPanel panel = null;

    private int width, height;

    public BotonHabitat(JPanel panel, int posX, int posY, int width, int height) {

        this.panel = panel;
        this.width = width;
        this.height = height;
        this.setBounds(posX, posY, width, height);
        this.setBorderPainted(false);
        this.setBackground(Color.WHITE);
        this.setFont(new Font("monospace", Font.PLAIN, 20));
        this.addMouseListener(this);


    }

    public Habitat elegirHabitat(){


        Habitat habitatEscogido = null;
        JOptionPane optionPane = new JOptionPane();

        if(panel instanceof PanelTierra) {

            HabitatTierra.TipoHabitat[] opciones = HabitatTierra.TipoHabitat.values();

            String[] opcionesStr = new String[opciones.length]; // String para elegir la opcion


            // Capitalizar la primera letra
            for(int i = 0; i < opciones.length; i++){
                String name = opciones[i].name();
                StringBuilder result = new StringBuilder();

                result.append(Character.toUpperCase(name.charAt(0)))
                        .append(name.substring(1).toLowerCase())
                        .append(" "); // Add a space between words

                opcionesStr[i] = result.toString().trim();
            }

            // JOptionPane para que el usuario escoja el habitat
            Object strTipoHabitat = JOptionPane.showInputDialog(null, "Elegir tipo de habitat", "Seleccion Habitat", JOptionPane.QUESTION_MESSAGE, null, opcionesStr, opcionesStr[0]);

            habitatEscogido = new HabitatTierra( opciones[encontrarIndex(opcionesStr, (String) strTipoHabitat)]);



        } else if (panel instanceof PanelMarte){

            HabitatMarte.TipoHabitat[] opciones = HabitatMarte.TipoHabitat.values();

            String[] opcionesStr = new String[opciones.length]; // String para elegir la opcion

            // Capitalizar la primera letra
            for(int i = 0; i < opciones.length; i++){
                String name = opciones[i].name();
                StringBuilder result = new StringBuilder();

                result.append(Character.toUpperCase(name.charAt(0)))
                        .append(name.substring(1).toLowerCase())
                        .append(" "); // Add a space between words

                opcionesStr[i] = result.toString().trim();
            }

            // JOptionPane para que el usuario escoja el habitat
            Object strTipoHabitat = JOptionPane.showInputDialog(null, "Elegir tipo de habitat", "Seleccion Habitat", JOptionPane.QUESTION_MESSAGE, null, opcionesStr, opcionesStr[0]);

            habitatEscogido = new HabitatMarte( opciones[encontrarIndex(opcionesStr, (String) strTipoHabitat)]);

        }
            return habitatEscogido;

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(habitat == null){
            Habitat aux = elegirHabitat();
            if(aux != null){
                habitat = new HabitatGrafico(aux);
                this.setIcon(GeneradorImagen.scaledProducto(aux.getBackgroundImg(),width, height));
            }
        }
        else{habitat.setVisible(true);}
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public int encontrarIndex(String[] arr, String t){

        if (arr == null) {
            return -1;
        }


        int len = arr.length;
        int i = 0;

        while (i < len) {

            if (arr[i] == t) {
                return i;
            }
            else {
                i = i + 1;
            }
        }
        return -1;
    }

}
