package Logica;

public enum Comida {
    Carne(""),
    Pasto("src/main/java/Interfaz/imagenes/pasto.png"),
    Pescado("");

    private final String imagen;

    private Comida(String imagen){
        this.imagen = imagen;
    }

    public String getImagen(){return imagen;}
}
