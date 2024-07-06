package Logica.TipoHabitats;

import Logica.Animales.Animal;
import static Logica.Animales.Animal.Imagenes.*;
import Logica.Habitat;

import java.awt.*;

/**
 * SubClase que representa a un habitat del Planeta marte
 */
public class HabitatMarte extends Habitat {

    /**
     * Constructor que configura las variables
     */
    public HabitatMarte(HabitatMarte.TipoHabitat tipoHabitat){
        super(tipoHabitat,
                new Animal.Imagenes[]{
                        AlienX, Aracne, AsgardianoSG1, Goauld, Depredador, ReplicanteSG1
                }
        );
        super.backgroundColor = new Color(0xFFB788);
        super.editPanelColor = new Color(0xE18158);
        super.btnColor = new Color(0xFFECC4);
        super.btnMarginColor = new Color(0xC68888);
    }


    public enum TipoHabitat implements HabitatTipo {
        CRATER("src/main/java/Interfaz/imagenes/Habitats/Marte/habitat_marte.png"),
        SUBTERRANEO("");

        private final String imagen;
        private TipoHabitat(String imagen) {this.imagen = imagen;}

        @Override
        public String getImagen(){return imagen;}
    }

    /**
     * Enumeracion que representa todos los tipos de Accesorios y sus respectivas imagenes
     */
    public enum Accesorios implements AccesoriosTipo{
        ARBOL("src/main/java/Interfaz/Imagenes/Accesorios/accesorio_marte_arbol.png"),
        ROCA("src/main/java/Interfaz/Imagenes/Accesorios/accesorio_marte_roca.png"),
        PLANTA("src/main/java/Interfaz/Imagenes/Accesorios/accesorio_marte_planta.png");

        private final String imagen;

        /**
         * Constructor privado que asigna las imagenes a los Accesorios
         * @param imagen    Imagen que representa a los Accesorios
         */
        private Accesorios(String imagen) {this.imagen = imagen;}

        /**
         * Getter
         * @return  Retorna la imagen que representa a los Accesorios
         */
        public String getImagen(){return imagen;}
    }
}
