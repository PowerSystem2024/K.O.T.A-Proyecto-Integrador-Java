/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package batallanavaljava;

import java.util.Scanner;

/**
 *
 * @author Mkjdf983
 */
public class AtaqueDelJugador {
        public static void ataqueDelJugador(int[][] matrizEnemigo, int[] contadorBarcosEnemigo, Scanner scanner) {
        System.out.println("Ingresa la coordenada para atacar al enemigo");

        int columna = 0, fila = 0;
        while (columna < 1 || columna > 10) {
            System.out.print("Elija en qué columna quiere disparar (1-10): ");
            columna = scanner.nextInt();
        }

        char filaChar;
        System.out.print("Elija en qué fila quiere disparar (A-J): ");
        filaChar = scanner.next().toUpperCase().charAt(0);
        fila = filaChar - 'A' + 1;

        // Verificar coordenadas
        switch (matrizEnemigo[fila][columna]) {
            case 0:
                System.out.println("Le has dado al agua.");
                matrizEnemigo[fila][columna] = -1; // Representar agua
                break;
            case 6:
                System.out.println("Genial, le diste a la lancha del enemigo.");
                matrizEnemigo[fila][columna] = -6; // Lancha dañada
                contadorBarcosEnemigo[4]--;
                break;
            // Agregar casos para otros barcos
            default:
                System.out.println("Ya has atacado aquí, turno del enemigo.");
                break;
        }
    }
}
