package Logica.Excepciones;

import Logica.Animales.Animal;

/**
 * NoMezclarAnimales es una subclase de Exception que ocurre
 * cuando se trata de ingresar un animal de una familia distinta a la que ya ocupa el habitat
 * @author Antonio Benavides
 */
public class NoMezclarAnimales extends Exception{

    /**
     * Se asigna el nombre de la familia de animales que se pueden colocar en el habitat
     */
    public NoMezclarAnimales(Animal.FamiliaTaxonomica nombre){
        super("No se pueden mezclar familias de animales,\nsolo se pueden colocar animales de la familia de \"" + nombre.name() + "\" en este habitat");
    }
}
