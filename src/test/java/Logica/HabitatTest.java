package Logica;

import Interfaz.Habitat.HabitatGrafico;
import Interfaz.Habitat.PanelHabitat;
import Interfaz.Habitat.Paneles_Seleccion.PanelAgregarAnimal;
import Interfaz.ObjetosGraficos.AccesorioGrafico;
import Interfaz.ObjetosGraficos.AnimalGrafico;
import Interfaz.ObjetosGraficos.ComidaGrafica;
import Logica.Animales.Animal;
import Logica.Animales.Marte.Depredador;
import Logica.Animales.Tierra.Vaca;
import Logica.TipoHabitats.HabitatMarte;
import Logica.TipoHabitats.HabitatTierra;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HabitatTest {


    @Test
    public void agregarAnimalesTierra() {
        Habitat habitat;
        HabitatGrafico habitatGrafico;

        try{
            habitat =  new HabitatTierra(HabitatTierra.TipoHabitat.POLAR);
            habitatGrafico = new HabitatGrafico(habitat, null);
            habitatGrafico.setVisible(false);

            PanelHabitat panelHabitat = new PanelHabitat(habitat);
            Animal animalLogico = new Vaca(0, 0, panelHabitat);
            AnimalGrafico animal = new AnimalGrafico(animalLogico);
            panelHabitat.agregarAnimal(animal);

            assertTrue(habitat.getListaAnimales().getFirst() instanceof AnimalGrafico);
        } catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void agregarAnimalesMarte() {
        Habitat habitat;
        HabitatGrafico habitatGrafico;

        try{
            habitat =  new HabitatMarte(HabitatMarte.TipoHabitat.CRATER);
            habitatGrafico = new HabitatGrafico(habitat, null);
            habitatGrafico.setVisible(false);

            PanelHabitat panelHabitat = new PanelHabitat(habitat);
            Animal animalLogico = new Depredador(0, 0, panelHabitat);
            AnimalGrafico animal = new AnimalGrafico(animalLogico);
            panelHabitat.agregarAnimal(animal);

            assertTrue(habitat.getListaAnimales().getFirst() instanceof AnimalGrafico);

        } catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }

}
