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

    private HabitatGrafico habitat = null;
    private final JPanel panel;

    private final int width, height;

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
        String[] opcionesStr;
        Enum<?>[] opciones = null;

        if(panel instanceof PanelTierra){opciones = HabitatTierra.TipoHabitat.values();}
        else if(panel instanceof PanelMarte){opciones = HabitatMarte.TipoHabitat.values();}

        if(opciones != null){
            opcionesStr = new String[opciones.length];
            for(int i = 0; i < opciones.length; i++){
                String name =opciones[i].name();
                opcionesStr[i] = Character.toUpperCase(name.charAt(0)) + name.substring(1).toLowerCase();
            }

            Object strTipoHabitat = JOptionPane.showInputDialog(
                    null,
                    "Elegir tipo de habitat",
                    "Seleccion Habitat",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opcionesStr,
                    opcionesStr[0]
            );

            int selectedIndex = encontrarIndex(opcionesStr, (String)strTipoHabitat);

            if (panel instanceof PanelTierra) {
                habitatEscogido = new HabitatTierra((HabitatTierra.TipoHabitat) opciones[selectedIndex]);
            }
            else if (panel instanceof PanelMarte) {
                habitatEscogido = new HabitatMarte((HabitatMarte.TipoHabitat) opciones[selectedIndex]);
            }
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
    public void mouseExited(MouseEvent e) {}

    public int encontrarIndex(String[] arr, String t){
        if (arr == null) {return -1;}

        for(int i=0;i<arr.length;i++){if (arr[i].equals(t)) {return i;}}

        return -1;
    }
}
