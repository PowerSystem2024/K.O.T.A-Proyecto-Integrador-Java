package batallanavaljava;

import java.util.Scanner;

public class MensajeBienvenida {

    // Subproceso MensajeBienvenida
    public static void MensajeBienvenida() {
        Scanner scanner = new Scanner(System.in);
        String nombreJugador;
        String confirmacion = null;
        int minLongitud = 3; // Longitud mínima para el nombre

        System.out.println("\n\n\n\n\n");
        System.out.println("                                                                              ¡¡¡ Bienvenido Soldado !!!");
        System.out.println("                                                                   Estas Listo y preparado para esta Gran Aventura");
        System.out.println("                                                                                 Presentate Soldado ");
        System.out.println("");

        do {
            // Solicitar el nombre del jugador
            System.out.println("                                                                       Escribe Tu Nombre (mínimo " + minLongitud + " caracteres):");
            nombreJugador = scanner.nextLine();

            // Verificar que el nombre tenga la longitud mínima
            if (nombreJugador.length() < minLongitud) {
                System.out.println("El nombre debe tener al menos " + minLongitud + " caracteres. Inténtalo de nuevo.");
            } else {
                // Confirmar el nombre ingresado
                System.out.println("¿Es correcto el nombre " + nombreJugador + "? (S/N):");
                confirmacion = scanner.nextLine().toUpperCase(); // Convertir a mayúsculas
            }

        // Repetir hasta que el nombre sea válido y la confirmación sea 'S'
        } while (nombreJugador.length() < minLongitud || !confirmacion.equals("S"));

        // Nombre confirmado
        System.out.println("Nombre confirmado: " + nombreJugador);
        System.out.println("");
        System.out.println("                                                             Perfecto soldado " + nombreJugador + " ¡¡¡ Que comience la Batalla !!!");
        System.out.println("\n\n                                                                           Presione Enter para continuar...");
        scanner.nextLine(); // Espera la tecla enter
        System.out.println("\n\n\n\n");
    }

    public static void main(String[] args) {
        MensajeBienvenida(); // Llamada al método
        // Aquí continuarías con el resto del código del juego
    }
}
