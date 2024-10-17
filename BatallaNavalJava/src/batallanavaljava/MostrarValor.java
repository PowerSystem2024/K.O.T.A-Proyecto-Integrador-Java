/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package batallanavaljava;

import static batallanavaljava.BatallaNavalJava.COLUMNAS_LETRAS;

/**
 *
 * @author Mkjdf983
 */
public class MostrarValor {
        public static void mostrarValor(int[][] matriz, int i, boolean esJugador) {
        System.out.print("             "); // Centramos la matriz margen de izquierda a derecha
        System.out.print(COLUMNAS_LETRAS.charAt(i) + "     "); // Separación de la matriz de la primera columna

        for (int j = 0; j <= 9; j++) {
            if (i == 0) { // Si true muestro los números
                System.out.print(j + 1 + "     "); // Separación entre los números
            } else {
                //	System.out.print(matriz[i,j+1]); // MODO DEBUG 
                //	System.out.print("     "); // MODO DEBUG
                if (esJugador) {
                    if (matriz[i][j + 1] == -1) {
                        System.out.print("A"); // 
                    } else if (matriz[i][j + 1] == 0) {
                        System.out.print("~"); // 
                    } else if (matriz[i][j + 1] < -1) {
                        System.out.print("*"); // 
                    } else if (matriz[i][j + 1] == 6) {
                        System.out.print("L"); // 
                    } else if (matriz[i][j + 1] == 7) {
                        System.out.print("S"); // 
                    } else if (matriz[i][j + 1] == 8) {
                        System.out.print("C"); // 
                    } else if (matriz[i][j + 1] == 9) {
                        System.out.print("P"); // 
                    }
                } else {
                //	System.out.print(matriz[i,j+1]); // MODO DEBUG 
                //	System.out.print("     "); // MODO DEBUG
                    if (matriz[i][j + 1] == -1) {
                        System.out.print("A"); // 
                    } else if (matriz[i][j + 1] >= 0) {
                        System.out.print("~"); // 
                    } else if (matriz[i][j + 1] == -6) {
                        System.out.print("L"); // 
                    } else if (matriz[i][j + 1] == -7) {
                        System.out.print("S"); // 
                    } else if (matriz[i][j + 1] == -8) {
                        System.out.print("C"); // 
                    } else if (matriz[i][j + 1] == -9) {
                        System.out.print("P"); // 
                    }
                }
                System.out.print("     "); // Separación
            }
        }
    }
}
