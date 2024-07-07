package Logica.TipoHabitats;

import Logica.Habitat;

import java.awt.*;

/**
 * SubClase que representa a un habitat del Planeta Tierra
 */
public class HabitatTierra extends Habitat {
    /**
     * Constructor que configura las variables
     */
    public HabitatTierra(TipoHabitat tipoHabitat) throws NoSuchFieldException, IllegalAccessException {
        super(tipoHabitat,
                new Class[]{
                        Logica.Animales.Tierra.Leon.class,
                        Logica.Animales.Tierra.Vaca.class,
                        Logica.Animales.Tierra.Nutria.class,
                        Logica.Animales.Tierra.Caballo.class,
                        Logica.Animales.Tierra.Pinguino.class,
                        Logica.Animales.Tierra.Tigre.class,
                }
        );
        super.backgroundColor = new Color(0xF6FFEC);
        super.editPanelColor = new Color(0x68B0AB);
        super.btnColor = new Color(0xFAF3DD);
        super.btnMarginColor = new Color(0xBABABA);
    }

    /**
     * Enumeración que representa los tipos de hábitat en la Tierra
     */
    public enum TipoHabitat implements HabitatTipo {
        DESERTICO("src/main/java/Interfaz/imagenes/Habitats/Tierra/habitat_desertico_1.jpg", 25, 30),
        POLAR("src/main/java/Interfaz/imagenes/Habitats/Tierra/habitat_polar_1.jpg", 0,0),
        JUNGLA("src/main/java/Interfaz/imagenes/Habitats/Tierra/habitat_jungla_1.jpg",0,0);

        private final String imagen;
        private final int[] temperatura;

        private TipoHabitat(String imagen, int minimo, int maximo) {
            this.imagen = imagen;
            this.temperatura = new int[]{minimo, maximo};
        }

        @Override
        public String getImagen(){return imagen;}

        @Override
        public int[] getTemperatura(){return temperatura;}
    }


    /**
     * Enumeracion que representa todos los tipos de Accesorios y sus respectivas imagenes
     */
    public enum Accesorios implements AccesoriosTipo {

        ARBOL("src/main/java/Interfaz/Imagenes/Accesorios/accesorio_tierra_arbol.png"),
        ROCA("src/main/java/Interfaz/Imagenes/Accesorios/accesorio_tierra_roca.png"),
        PLANTA("src/main/java/Interfaz/Imagenes/Accesorios/accesorio_tierra_planta.png");


        private final String imagen;

        /**
         * Constructor privado que asigna las imagenes a los Accesorios
         * @param imagen  Imagen de los accesorios
         */
        private Accesorios(String imagen) {this.imagen = imagen;}

        /**
         * Getter de la imagen que representa a los accesorios
         * @return Retorna la imagen de los Accesorios
         */
        public String getImagen(){return imagen;}
    }

}
