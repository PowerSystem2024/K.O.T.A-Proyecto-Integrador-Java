/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package batallanavaljava;

/**
 *
 * @author Mkjdf983
 */
public class AtaqueDelEnemigo {
        public static void ataqueDelEnemigo(int[][] matrizJugador, int[] contadorBarcosJugador) {
        int fila, columna;

        do {
            fila = (int) (Math.random() * 10) + 1; // 1-10
            columna = (int) (Math.random() * 10) + 1; // 1-10
        } while (matrizJugador[fila][columna] < 0); // Asegúrate de que no haya sido atacado antes

        // Verificar coordenadas
        switch (matrizJugador[fila][columna]) {
            case 0:
                System.out.println("El enemigo le ha dado al agua.");
                matrizJugador[fila][columna] = -1; // Representar agua
                break;
            case 6:
                System.out.println("El enemigo ha dañado tu lancha.");
                matrizJugador[fila][columna] = -6; // Lancha dañada
                contadorBarcosJugador[4]--;
                break;
            // Agregar casos para otros barcos
            default:
                break;
        }
    }
}
