package Interfaz.imagenes;

import javax.swing.*;
import java.awt.*;

/**
 * La interfaz GeneradorImagen proporciona métodos estáticos para cargar,
 * redimensionar y generar etiquetas con imágenes.
 */
public interface GeneradorImagen {

    /**
     * Cargar y redimensionar la imagen del Producto
     * @param nombre esta es la ruta del archivo de la imagen
     * @param width este es el ancho deseado para la imagen redimensionada
     * @param height esta es la altura deseada para la imagen redimensionada
     * @return la imagen redimensionada
     */
    static ImageIcon scaledProducto(String nombre, int width, int height){
        ImageIcon originalIcon = new ImageIcon(nombre);
        Image originalIconImage = originalIcon.getImage();
        Image scaledIconImage = originalIconImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledIconImage);
    }

    /**
     * Generar una JLabel Custom para cada imagen
     * @param nombre es la ruta del archivo de la imagen
     * @param x la coordenada x donde se ubicará la etiqueta en el contenedor
     * @param y la coordenada y donde se ubicará la etiqueta en el contenedor
     * @param width este es el ancho de la etiqueta
     * @param height esta es la altura de la etiqueta
     * @return la imagen especificada
     */
    static JLabel ImageLabel(String nombre, int x, int y, int width, int height){
        ImageIcon icon = scaledProducto(nombre, width, height);

        JLabel label = new JLabel(icon);
        label.setBounds(x, y, width, height);

        return label;
    }
}