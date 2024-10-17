/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package batallanavaljava;

import static batallanavaljava.MostrarTableroJugador.mostrarTableroJugador;
import java.util.Scanner;

/**
 *
 * @author Mkjdf983
 */
public class IngresarPosicionBarcoJugador {
       public static void ingresarPosicionBarcoJugador(int[][] matriz, Scanner scanner) {
    int[] barco = {0, 4, 4, 4, 2}; // Tamaños de los barcos
    String[] nombreDeBarco = {"", "portaviones", "crucero", "submarino", "lancha"};
    
    for (int tipo = 1; tipo < barco.length; tipo++) {
        boolean posicionValida = false;

        while (!posicionValida) {
            System.out.printf("Coloque el %s en el tablero, con tamaño %d.\n", nombreDeBarco[tipo], barco[tipo]);
            mostrarTableroJugador(matriz);
            
            // Obtener columna
            int columna = 0;
            while (columna < 1 || columna > 10) {
                System.out.print("Elija en qué columna quiere colocar su barco (1-10): ");
                columna = scanner.nextInt();
            }

            // Obtener fila
            char filaChar;
            System.out.print("Elija en qué fila quiere colocar su barco (A-J): ");
            filaChar = scanner.next().toUpperCase().charAt(0);
            int fila = filaChar - 'A' + 1;

            // Verificar si la posición es válida y colocar el barco
            if ((columna + barco[tipo]) <= 10 && matriz[fila][columna] == 0) {
                for (int h = 0; h < barco[tipo]; h++) {
                    matriz[fila][columna + h] = tipo + 5; // Usar formato diferente para barcos
                }
                posicionValida = true;
                mostrarTableroJugador(matriz);
            } else {
                System.out.println("Posición no válida. Intente de nuevo.");
            }
        }
    }
}
}
