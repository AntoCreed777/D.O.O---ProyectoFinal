package Interfaz;

import Interfaz.Habitat.HabitatGrafico;
import Logica.Habitat;
import Logica.TipoHabitats.HabitatMarte;
import Logica.TipoHabitats.HabitatTierra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BotonHabitat extends JButton implements MouseListener {

    private Habitat habitat = null;

    private int width, height;

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

        Habitat habitatEscogido = null;

        JOptionPane optionPane= new JOptionPane();

        String[] options = new String[3];
        options[0] = "Polar";
        options[1] = "Desertico";
        options[2] = "Jungla";



        Object strTipoHabitat = JOptionPane.showInputDialog(null,"Elegir tipo de habitat", "Seleccion Habitat", JOptionPane.QUESTION_MESSAGE, null, options,  "polar");


        switch((String) strTipoHabitat){
            case "Polar" -> habitatEscogido = new HabitatTierra(HabitatTierra.TipoHabitat.POLAR);
            case "Desertico" -> habitatEscogido = new HabitatTierra(HabitatTierra.TipoHabitat.DESERTICO);
            case "Jungla" -> habitatEscogido = new HabitatTierra(HabitatTierra.TipoHabitat.JUNGLA);
        }


        return habitatEscogido;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if(habitat == null){
            habitat = elegirHabitat();
            this.setIcon(GeneradorImagen.scaledProducto(habitat.getBackgroundImg(),width, height));

        } else {
            new HabitatGrafico(habitat);
        }
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
}
