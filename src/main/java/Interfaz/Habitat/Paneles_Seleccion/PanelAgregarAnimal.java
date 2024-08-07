package Interfaz.Habitat.Paneles_Seleccion;

import Interfaz.Habitat.Listener;
import Interfaz.ObjetosGraficos.AnimalGrafico;
import Interfaz.imagenes.GeneradorImagen;
import Interfaz.Habitat.HabitatGrafico;
import Logica.Animales.Animal;
import Logica.Animales.Tierra.*;
import Logica.Animales.Marte.*;
import Logica.Excepciones.TemperaturaAnimal;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.*;

/**
 * Panel que contiene los botones para seleccionar el animal a agregar dentro del habitat
 */
public class PanelAgregarAnimal extends JPanel implements Listener {
    private final Color btnColor;
    private final Color btnMarginColor;
    private final HabitatGrafico habitatGrafico;
    private final PanelAgregarAnimal panelAgregarAnimal;
    private final Class<? extends Animal>[] animalesPermitidos;

    private final ButtonGroup grupoBotones;
    int i = 0;
    private JToggleButton btn1;
    private JToggleButton btn2;
    private JToggleButton btn3;

    private Class<? extends Animal> animalSeleccionado = null;
    /**
     * Contructor en donde se inician variables , se configura el panel y se agregan los botones
     *
     * @param habitatGrafico Habitat al que pertenece este panel y sobre el que puede actuar
     */
    public PanelAgregarAnimal(HabitatGrafico habitatGrafico) throws NoSuchFieldException, IllegalAccessException {
        this.habitatGrafico = habitatGrafico;
        this.btnColor = habitatGrafico.getHabitat().getBtnColor();
        this.btnMarginColor = habitatGrafico.getHabitat().getBtnMarginColor();
        this.panelAgregarAnimal = this;

        this.setBounds(50, 10, 1000, 190);
        this.setBackground(habitatGrafico.getHabitat().getEditPanelColor());
        this.setLayout(null);

        this.animalesPermitidos = habitatGrafico.getHabitat().getAnimalesPermitidos();
        this.grupoBotones = new ButtonGroup();

        int ancho = 200;

        btn1 = agregarBotones(animalesPermitidos[i], ancho);
        btn1.setBounds(177, 10, ancho, 180);
        this.add(btn1);
        grupoBotones.add(btn1);

        btn2 = agregarBotones(animalesPermitidos[i + 1], ancho);
        btn2.setBounds(387, 10, ancho, 180);
        this.add(btn2);
        grupoBotones.add(btn2);

        btn3 = agregarBotones(animalesPermitidos[i + 2], ancho);
        btn3.setBounds(597, 10, ancho, 180);
        this.add(btn3);
        grupoBotones.add(btn3);


        JButton btnRetroceder = new JButton("<");
        JButton btnAvanzar = new JButton(">");

        btnRetroceder.setBounds(30, 80, 50, 50);
        btnRetroceder.setBackground(btnColor);
        btnRetroceder.setForeground(Color.BLACK);
        btnRetroceder.setFont(new Font("Monospaced", Font.BOLD, 30));
        btnRetroceder.setMargin(new Insets(0,0,0,0));

        btnAvanzar.setBounds(900, 80, 50, 50);
        btnAvanzar.setFont(new Font("Monospaced", Font.BOLD, 30));
        btnAvanzar.setBackground(btnColor);
        btnAvanzar.setForeground(Color.BLACK);
        btnAvanzar.setMargin(new Insets(0,0,0,0));


        btnRetroceder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cambiarBotones(false);
                } catch (NoSuchFieldException | IllegalAccessException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        btnAvanzar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cambiarBotones(true);
                } catch (NoSuchFieldException | IllegalAccessException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        this.add(btnRetroceder);
        this.add(btnAvanzar);
    }

    /**
     * Funcion para crear botones
     *
     * @param animal Animal que creara el boton
     * @param ancho  Ancho del boton
     * @return Se retorna el boton que se creo
     */
    private JToggleButton agregarBotones(Class<? extends Animal> animal, int ancho) throws NoSuchFieldException, IllegalAccessException {
        JToggleButton btn = new JToggleButton(((Animal.Imagenes)animal.getField("imagen").get(null)).name());

        btn.setBackground(btnColor);
        btn.setHorizontalTextPosition(JButton.CENTER);
        btn.setVerticalTextPosition(JButton.BOTTOM);
        btn.setBorder(new MatteBorder(10, 5, 10, 5, btnMarginColor));
        btn.setBorderPainted(true);

        btn.setIcon(GeneradorImagen.scaledProducto(((Animal.Imagenes)animal.getField("imagen").get(null)).getImagen(), ancho - 100, 100));

        btn.addActionListener(e -> {
            int temperatura = 0;
            try {temperatura = (int)animal.getField("temperaturaAdecuada").get(null);}
            catch (IllegalAccessException | NoSuchFieldException ex) {throw new RuntimeException(ex);}

            if((habitatGrafico.getHabitat().getTemperatura()[0] <= temperatura) && (habitatGrafico.getHabitat().getTemperatura()[1] >= temperatura)){
                animalSeleccionado = animal;
                habitatGrafico.getPanelHabitat().suscribirse(panelAgregarAnimal);
            }
            else{
                try {
                    Exception ext = new TemperaturaAnimal(((Animal.Imagenes)animal.getField("imagen").get(null)).name());
                    JOptionPane.showMessageDialog(null, ext.getMessage());
                } catch (IllegalAccessException | NoSuchFieldException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        btn.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.DESELECTED) {animalSeleccionado = null;}
        });

        return btn;
    }

    public void cambiarBotones(Boolean val) throws NoSuchFieldException, IllegalAccessException {

        if(val){i++;}
        else {i--;}

        if(i < 0){ i++; return;}
        else if (i > animalesPermitidos.length - 3){i--; return;}

        panelAgregarAnimal.remove(btn1);
        panelAgregarAnimal.remove(btn2);
        panelAgregarAnimal.remove(btn3);

        btn1 = agregarBotones(animalesPermitidos[i], 200);
        btn1.setBounds(177, 10, 200, 180);
        panelAgregarAnimal.add(btn1);
        grupoBotones.add(btn1);

        btn2 = agregarBotones(animalesPermitidos[i + 1], 200);
        btn2.setBounds(387, 10, 200, 180);
        panelAgregarAnimal.add(btn2);
        grupoBotones.add(btn2);

        btn3 = agregarBotones(animalesPermitidos[i + 2], 200);
        btn3.setBounds(597, 10, 200, 180);
        panelAgregarAnimal.add(btn3);
        grupoBotones.add(btn3);

        this.repaint();
    }

    private void agregarAnimal(Point point) throws NoSuchFieldException, IllegalAccessException {
        if(animalSeleccionado == null){return;}
        AnimalGrafico animalGrafico = switch (((Animal.Imagenes)animalSeleccionado.getField("imagen").get(null)).name()) {
            case "Pinguino" ->
                    new AnimalGrafico(new Pinguino(point.x, point.y, habitatGrafico.getPanelHabitat()));
            case "Caballo" ->
                    new AnimalGrafico(new Caballo(point.x, point.y, habitatGrafico.getPanelHabitat()));
            case "Nutria" ->
                    new AnimalGrafico(new Nutria(point.x, point.y, habitatGrafico.getPanelHabitat()));
            case "Tigre" ->
                    new AnimalGrafico(new Tigre(point.x, point.y, habitatGrafico.getPanelHabitat()));
            case "Leon" ->
                    new AnimalGrafico(new Leon(point.x, point.y, habitatGrafico.getPanelHabitat()));
            case "Vaca" ->
                    new AnimalGrafico(new Vaca(point.x, point.y, habitatGrafico.getPanelHabitat()));
            case "AlienX" ->
                    new AnimalGrafico(new AlienX(point.x, point.y, habitatGrafico.getPanelHabitat()));
            case "Aracne" ->
                    new AnimalGrafico(new Aracne(point.x, point.y, habitatGrafico.getPanelHabitat()));
            case "AsgardianoSG1" ->
                    new AnimalGrafico(new AsgardianoSG1(point.x, point.y, habitatGrafico.getPanelHabitat()));
            case "Depredador" ->
                    new AnimalGrafico(new Depredador(point.x, point.y, habitatGrafico.getPanelHabitat()));
            case "Goauld" ->
                    new AnimalGrafico(new Goauld(point.x, point.y, habitatGrafico.getPanelHabitat()));
            case "ReplicanteSG1" ->
                    new AnimalGrafico(new ReplicanteSG1(point.x, point.y, habitatGrafico.getPanelHabitat()));
            default -> null;
        };

        if (animalGrafico != null) {habitatGrafico.getPanelHabitat().agregarAnimal(animalGrafico);}
    }

    @Override
    public void update(Point point) {
        try{agregarAnimal(point);}
        catch (NoSuchFieldException | IllegalAccessException e) {e.printStackTrace();}
    }
}