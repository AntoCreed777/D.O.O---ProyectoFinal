package Interfaz;

import Interfaz.Habitat.HabitatGrafico;
import Interfaz.imagenes.GeneradorImagen;
import Logica.Habitat;
import Logica.TipoHabitats.HabitatTierra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BotonHabitat extends JButton implements MouseListener {

    private HabitatGrafico habitat = null;
    private final int width, height;

    public BotonHabitat(int posX, int posY, int width, int height) {
        this.width = width;
        this.height = height;
        this.setBounds(posX, posY, width, height);
        this.setBorderPainted(false);
        this.setBackground(Color.WHITE);
        this.setFont(new Font("monospace", Font.PLAIN, 20));
        this.addMouseListener(this);
    }

    public Habitat elegirHabitat(){
        String[] options = {"Polar", "Desertico", "Jungla"};

        Object strTipoHabitat = JOptionPane.showInputDialog(null,"Elegir tipo de habitat", "Seleccion Habitat", JOptionPane.QUESTION_MESSAGE, null, options,  "polar");
        if (strTipoHabitat == null) {return null;}

        return switch((String) strTipoHabitat){
            case "Polar" -> new HabitatTierra(HabitatTierra.TipoHabitat.POLAR);
            case "Desertico" -> new HabitatTierra(HabitatTierra.TipoHabitat.DESERTICO);
            case "Jungla" -> new HabitatTierra(HabitatTierra.TipoHabitat.JUNGLA);
            default -> null;
        };
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
}
