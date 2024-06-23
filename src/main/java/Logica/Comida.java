package Logica;

public enum Comida {
    Carne("src/main/java/Interfaz/imagenes/Carne.png"),
    Pasto("src/main/java/Interfaz/imagenes/pasto.png"),
    Pescado("src/main/java/Interfaz/imagenes/Pescado.png");

    private final String imagen;

    private Comida(String imagen){
        this.imagen = imagen;
    }

    public String getImagen(){return imagen;}
}
