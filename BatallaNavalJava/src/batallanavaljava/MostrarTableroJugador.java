
package batallanavaljava;

import static batallanavaljava.BatallaNavalJava.esJugador;
import static batallanavaljava.MostrarValor.mostrarValor;
import java.util.Scanner;

/**
 *
 * @author Mkjdf983
 */
public class MostrarTableroJugador {
    
    public static void mostrarTableroJugador(int[][] matrizJugador) {
    System.out.println("Este es tu tablero, piensa en donde ubicar tus barcos :");
    System.out.println();
    for (int i = 0; i < 10; i++) {
        esJugador = true;
         /*
        System.out.print(COLUMNAS_LETRAS.charAt(i) + " ");
        for (int j = 0; j < 10; j++) {
            System.out.print(matrizJugador[i][j] == 0 ? "~" : "X");
            System.out.print(" ");
        }
        System.out.println();
*/
        mostrarValor(matrizJugador, i, esJugador);
        System.out.print("\n\n"); //separacion entre filas
    }
    System.out.println();
    System.out.println("Presiona Enter para continuar...");

    new Scanner(System.in).nextLine(); // Esperar a que el jugador presione Enter
}
}
