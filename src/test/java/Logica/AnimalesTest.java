package Logica;

import Interfaz.Habitat.PanelHabitat;
import Logica.Animales.Animal;
import Logica.Animales.Tierra.*;
import Logica.TipoHabitats.HabitatTierra;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class AnimalesTest {
    Habitat habitatTierra;
    PanelHabitat panelHabitat;
    Animal animal;

    final Rectangle maximizado = new Rectangle(100, 0, 900, 630);
    final Rectangle minimizado = new Rectangle(190, 0, 700,420);

    @BeforeEach
    void setUpBeforeClass(){
        habitatTierra = new HabitatTierra(HabitatTierra.TipoHabitat.DESERTICO);
        panelHabitat = new PanelHabitat(habitatTierra);
        animal = new Leon(0,0,panelHabitat);
    }

    @Test
    public void moverseTest() {
        animal.Moverse();   //Como esta en una esquina se queda quieto pensando en una nueva direccion
        animal.Moverse();   //Se mueve a la direccion que ya eligio

        assertFalse(0 == animal.getPosicionX() && 0 == animal.getPosicionY());
    }

    @Test
    public void rePosicionarTest() {
        panelHabitat.ajustarPanel("maximizar");
        animal.rePosicionar(maximizado,minimizado);
        Assertions.assertTrue(0 == animal.getPosicionX() && 0 == animal.getPosicionY());

        int posicionX = panelHabitat.getWidth() - 100;
        int posicionY = panelHabitat.getHeight() - 100;

        Animal animal2 = new Leon(posicionX, posicionY, panelHabitat);
        panelHabitat.ajustarPanel("minimizar");
        animal2.rePosicionar(maximizado,minimizado);
        assertFalse(posicionX == animal2.getPosicionX() && posicionY == animal2.getPosicionY());
    }

    @Test
    public void validarPosicionTest() {
        animal.validarPosicion();

        Assertions.assertEquals(0, animal.getPosicionX());
        Assertions.assertEquals(0, animal.getPosicionY());

        Animal animal2 = new Leon(1000,1000,panelHabitat);
        animal2.validarPosicion();

        assertFalse(1000 == animal2.getPosicionX() && 1000 == animal.getPosicionY());
        assertFalse(animal2.getPosicionX() > panelHabitat.getWidth() || animal2.getPosicionY() > panelHabitat.getHeight());
    }

    @Test
    public void ComerTest() {
        //Leon
        assertFalse(animal.Comer(Comida.Pasto));
        assertFalse(animal.Comer(Comida.Pescado));
        Assertions.assertTrue(animal.Comer(Comida.Carne));

        Pinguino pinguino = new Pinguino(0,0,panelHabitat);
        assertFalse(pinguino.Comer(Comida.Pasto));
        assertFalse(pinguino.Comer(Comida.Carne));
        Assertions.assertTrue(pinguino.Comer(Comida.Pescado));

        Vaca vaca = new Vaca(0,0,panelHabitat);
        assertFalse(vaca.Comer(Comida.Pescado));
        assertFalse(vaca.Comer(Comida.Carne));
        Assertions.assertTrue(vaca.Comer(Comida.Pasto));
    }
}
