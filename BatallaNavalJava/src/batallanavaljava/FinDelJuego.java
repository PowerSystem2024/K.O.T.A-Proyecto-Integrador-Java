
package batallanavaljava;

import java.util.Scanner;

public class FinDelJuego {

    public static void finDelJuego(String nombreJugador) {
        // Mostrar mensaje de agradecimiento al usuario
        try (Scanner entrada = new Scanner(System.in)) {
            // Mostrar mensaje de agradecimiento al usuario
            System.out.println();
            System.out.println("¡Gracias por jugar, " + nombreJugador + "! Esperamos que hayas disfrutado del juego.");
            System.out.println("Recuerda: Si lo puedes imaginar, lo puedes programar.");
            System.out.println("Ariel Bentancud");
            System.out.println();
            System.out.println("Presiona enter para continuar...");
            // Esperar que el usuario presione enter para continuar
            entrada.nextLine();
            // Simular borrar pantalla imprimiendo 50 líneas en blanco
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
            // Cerrar el scanner
        }
    }
}
