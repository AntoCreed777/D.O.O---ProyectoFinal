package Interfaz.Sonidos;

import javax.sound.sampled.*;
import java.io.File;

/**
 * Esta es la interfaz Sonidos que proporciona métodos estáticos para cargar y
 * reproducir archivos de audio
 */
public interface Sonido {
    /**
     * Carga un archivo de sonido desde la ruta especificada y devuelve un Clip de audio
     * @param ruta esta es la ruta del archivo a reproducir
     * @return el sonido o null si ocurre un error
     */
    static Clip cargarSonido(String ruta) {
        Clip clip = null;
        try {
            File archivoSonido = new File(ruta);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(archivoSonido);
            clip = AudioSystem.getClip();
            clip.open(audioIn);
        } catch (Exception e) {
            System.out.println("No se puede cargar el archivo: " + e.getMessage());
        }

        return clip;
    }

    /**
     * Reproduce el sonido del Clip especificado y ejecuta una acción al terminar
     * la reproducción
     * @param clip este es el clip de audio que se reproduce
     * @param onCompletion esta es la acción que se ejecuta cuando se termina la reprodución del clip
     */
    static void reproducirSonido(Clip clip, Runnable onCompletion) {
        if (clip != null) {
            clip.setFramePosition(0);
            clip.start();
            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    onCompletion.run();
                }
            });
        }
    }
}