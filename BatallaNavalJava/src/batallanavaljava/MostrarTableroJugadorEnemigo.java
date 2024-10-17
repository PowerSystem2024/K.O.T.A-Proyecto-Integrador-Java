
package batallanavaljava;
import static batallanavaljava.BatallaNavalJava.esJugador;
import static batallanavaljava.MostrarValor.mostrarValor;

public class MostrarTableroJugadorEnemigo {
    public static void mostrarTableroJugadorEnemigo(int[][] matrizJugador, int[][] matrizEnemigo) {
        System.out.println("                                Este es tu tablero                                                             Este es el tablero del enemigo");

        for (int i = 0; i <= 10; i++) {
            System.out.println();
            esJugador = true;
            mostrarValor(matrizJugador, i, esJugador);
            esJugador = false;
            mostrarValor(matrizJugador, i, esJugador);
            System.out.println();
        }

        System.out.println();
        System.out.println("                                                                           Presiona Enter para continuar...");
        
    }

}
