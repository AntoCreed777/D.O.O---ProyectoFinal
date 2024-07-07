package Logica;

/**
 * Enumeracion que representa todos los tipos de Comida y sus respectivas imagenes
 */
public enum Comida {
    Carne("src/main/java/Interfaz/imagenes/Comida/Tierra/Carne.png"),
    Pasto("src/main/java/Interfaz/imagenes/Comida/Tierra/Pasto.png"),
    Pescado("src/main/java/Interfaz/imagenes/Comida/Tierra/Pescado.png"),
    Humano("src/main/java/Interfaz/imagenes/Comida/Marte/Humano.png"),
    RobotLunar("src/main/java/Interfaz/imagenes/Comida/Marte/RobotLunar.png"),
    Vaca("src/main/java/Interfaz/imagenes/Comida/Marte/Vaca.png");

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
