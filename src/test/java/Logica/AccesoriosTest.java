
package Logica;

import Interfaz.Habitat.PanelHabitat;
import Interfaz.ObjetosGraficos.AccesorioGrafico;
import Interfaz.ObjetosGraficos.ComidaGrafica;
import Logica.Animales.Animal;
import Logica.Animales.Tierra.*;
        import Logica.TipoHabitats.HabitatTierra;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class AccesoriosTest {

    Habitat habitatTierra;
    PanelHabitat panelHabitat;
    AccesorioGrafico accesorioGrafico;

    final Rectangle maximizado = new Rectangle(100, 0, 900, 630);
    final Rectangle minimizado = new Rectangle(190, 0, 700,420);

    @BeforeEach
    void setUpBeforeClass(){

        try{
            habitatTierra = new HabitatTierra(HabitatTierra.TipoHabitat.DESERTICO);
        }catch(Exception e){ e.printStackTrace();}
        panelHabitat = new PanelHabitat(habitatTierra);
        accesorioGrafico = new AccesorioGrafico(HabitatTierra.Accesorios.ARBOL, 0,0, panelHabitat);
    }


    @Test
    public void rePosicionarDimensionarTest() {
        panelHabitat.ajustarPanel("maximizar");
        accesorioGrafico.rePosicionarDimencionar(maximizado,minimizado);
        Assertions.assertTrue(0 == accesorioGrafico.getPosicionX() && 0 == accesorioGrafico.getPosicionY());

        int posicionX = panelHabitat.getWidth() - 100;
        int posicionY = panelHabitat.getHeight() - 100;

        AccesorioGrafico accesorioGrafico2 = new AccesorioGrafico(HabitatTierra.Accesorios.ROCA, posicionX, posicionY, panelHabitat);
        panelHabitat.ajustarPanel("minimizar");
        accesorioGrafico2.rePosicionarDimencionar(maximizado,minimizado);
        assertFalse(posicionX == accesorioGrafico2.getPosicionX() && posicionY == accesorioGrafico2.getPosicionY());
    }

    @Test
    public void validarPosicionTest() {
        accesorioGrafico.validarPosicion();

        Assertions.assertEquals(0, accesorioGrafico.getPosicionX());
        Assertions.assertEquals(0, accesorioGrafico.getPosicionY());

        AccesorioGrafico accesorioGrafico2 = new AccesorioGrafico(HabitatTierra.Accesorios.ROCA, 1000,1000,panelHabitat);
        accesorioGrafico2.validarPosicion();

        assertFalse(1000 == accesorioGrafico2.getPosicionX() && 1000 == accesorioGrafico2.getPosicionY());
        assertFalse(accesorioGrafico2.getPosicionX() > panelHabitat.getWidth() || accesorioGrafico2.getPosicionY() > panelHabitat.getHeight());
    }


}
