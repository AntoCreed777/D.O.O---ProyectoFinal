package Logica;

/**
 * Enumeracion que representa todos los tipos de Comida y sus respectivas imagenes
 */
public enum Comida {
    Carne("src/main/java/Interfaz/imagenes/Comida/Carne.png"),
    Pasto("src/main/java/Interfaz/imagenes/Comida/pasto.png"),
    Pescado("src/main/java/Interfaz/imagenes/Comida/Pescado.png");

    private final String imagen;

    /**
     * Constructor privado que asigna las imagenes a las Comidas
     * @param imagen    Imagen que representa a la Comida
     */
    private Comida(String imagen){
        this.imagen = imagen;
    }

    /**
     * Getter
     * @return  Retorna la imagen que representa a la Comida
     */
    public String getImagen(){return imagen;}
}
