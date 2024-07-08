package Logica.TipoHabitats;

import Logica.Habitat;

import java.awt.*;

/**
 * SubClase que representa a un habitat del Planeta marte
 */
public class HabitatMarte extends Habitat {
    /**
     * Constructor que configura las variables
     */
    public HabitatMarte(HabitatMarte.TipoHabitat tipoHabitat) throws NoSuchFieldException, IllegalAccessException {
        super(tipoHabitat,
                new Class[]{
                        Logica.Animales.Marte.AlienX.class,
                        Logica.Animales.Marte.Aracne.class,
                        Logica.Animales.Marte.AsgardianoSG1.class,
                        Logica.Animales.Marte.Goauld.class,
                        Logica.Animales.Marte.Depredador.class,
                        Logica.Animales.Marte.ReplicanteSG1.class
                }
        );
        super.backgroundColor = new Color(0xFFB788);
        super.editPanelColor = new Color(0xE18158);
        super.btnColor = new Color(0xFFECC4);
        super.btnMarginColor = new Color(0xC68888);
    }

    /**
     * Enumeración que representa los tipos de hábitat en Marte
     */
    public enum TipoHabitat implements HabitatTipo {
        CRATER("src/main/java/Interfaz/imagenes/Habitats/Marte/habitat_marte.png",15,30),
        SUBTERRANEO("src/main/java/Interfaz/imagenes/Habitats/Marte/habitat_marte_SUBTERRANEO.jpg", 0,15);

        private final String imagen;
        private final int[] temperatura;

        private TipoHabitat(String imagen, int minimo, int maximo) {
            this.imagen = imagen;
            temperatura = new int[]{minimo, maximo};
        }

        @Override
        public String getImagen(){return imagen;}

        @Override
        public int[] getTemperatura(){return temperatura;}
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
         * Constructor privado que asigna las imagenes a los accesorios
         * @param imagen Imagen de los accesorios
         */
        private Accesorios(String imagen) {this.imagen = imagen;}

        /**
         * Getter de la imagen que representa a los accesorios
         * @return  Retorna la imagen de los Accesorios
         */
        public String getImagen(){return imagen;}
    }
}
