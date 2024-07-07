package Logica;

import Interfaz.Habitat.PanelHabitat;
import Interfaz.ObjetosGraficos.ComidaGrafica;
import Logica.TipoHabitats.HabitatTierra;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;


public class ComidaTest {

    Habitat habitatTierra;
    PanelHabitat panelHabitat;
    ComidaGrafica comidaGrafica;

    final Rectangle maximizado = new Rectangle(100, 0, 900, 630);
    final Rectangle minimizado = new Rectangle(190, 0, 700, 420);

    @BeforeEach
    void setUpBeforeClass() {

        try {

            habitatTierra = new HabitatTierra(HabitatTierra.TipoHabitat.DESERTICO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        panelHabitat = new PanelHabitat(habitatTierra);
        comidaGrafica = new ComidaGrafica(Comida.Carne, 0, 0, panelHabitat);
    }

    @Test
    public void rePosicionarDimensionarTest() {
        panelHabitat.ajustarPanel("maximizar");
        comidaGrafica.rePosicionarDimencionar(maximizado, minimizado);
        Assertions.assertTrue(0 == comidaGrafica.getPosicionX() && 0 == comidaGrafica.getPosicionY());

        int posicionX = panelHabitat.getWidth() - 100;
        int posicionY = panelHabitat.getHeight() - 100;

        ComidaGrafica comidaGrafica2 = new ComidaGrafica(Comida.Carne, posicionX, posicionY, panelHabitat);
        panelHabitat.ajustarPanel("minimizar");
        comidaGrafica2.rePosicionarDimencionar(maximizado, minimizado);
        assertFalse(posicionX == comidaGrafica2.getPosicionX() && posicionY == comidaGrafica2.getPosicionY());
    }

    @Test
    public void validarPosicionTest() {
        comidaGrafica.validarPosicion();

        Assertions.assertEquals(0, comidaGrafica.getPosicionX());
        Assertions.assertEquals(0, comidaGrafica.getPosicionY());

        ComidaGrafica comidaGrafica2 = new ComidaGrafica(Comida.Carne, 1000, 1000, panelHabitat);
        comidaGrafica2.validarPosicion();

        assertFalse(1000 == comidaGrafica2.getPosicionX() && 1000 == comidaGrafica.getPosicionY());
        assertFalse(comidaGrafica2.getPosicionX() > panelHabitat.getWidth() || comidaGrafica2.getPosicionY() > panelHabitat.getHeight());
    }
}