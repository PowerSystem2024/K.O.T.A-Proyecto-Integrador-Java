/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package batallanavaljava;

import static java.lang.Byte.SIZE;
import static java.lang.Math.random;
import static java.lang.StrictMath.random;
import java.util.Scanner;

/**
 *
 * @author Mkjdf983
 */
public class ColocarBarcosEnemigo {
        public static void colocarBarcosEnemigo(int[][] matrizEnemigo) 
{
        int[] barco = new int[5];
        int[] formatos = new int[5];
        
        // Inicializar la matriz con agua (0 representa agua)
        for (int i = 1; i <= SIZE; i++) {
            for (int j = 1; j <= SIZE; j++) {
                matrizEnemigo[i][j] = 0;
            }
        }

        // Definir tamaños y formatos para cada tipo de barco
        barco[1] = 4; // tamaño del portaviones
        barco[2] = 4; // tamaño del crucero
        barco[3] = 4; // tamaño del submarino
        barco[4] = 2; // tamaño de la lancha

        formatos[1] = 9; // formato del portaviones
        formatos[2] = 8; // formato del crucero
        formatos[3] = 7; // formato del submarino
        formatos[4] = 6; // formato de la lancha

        // Colocar cada barco automáticamente
        for (int tipo = 1; tipo <= 4; tipo++) {
            boolean posicionOcupada;

            do {
                int columna = random.nextInt(10 - barco[tipo] + 1) + 1; // Columna aleatoria
                int fila = random.nextInt(10) + 1; // Fila aleatoria
                posicionOcupada = false;

                // Verificar si la posición está ocupada
                if (columna + barco[tipo] > 11) {
                    posicionOcupada = true;
                } else {
                    int i = 0;
                    while (i < barco[tipo] && !posicionOcupada) {
                        if (matrizEnemigo[fila][columna + i] != 0) {
                            posicionOcupada = true;
                        }
                        i++;
                    }
                }
            } while (posicionOcupada);

            // Colocar el barco en la matriz
            for (int h = 0; h < barco[tipo]; h++) {
                matrizEnemigo[fila][columna + h] = formatos[tipo];
            }
        }

        // Indicar al jugador que los barcos enemigos están siendo colocados
        System.out.println("El enemigo colocará sus barcos en el tablero");
        System.out.println("Presione ENTER para continuar");
        
        // Esperar la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        // Mostrar la matriz con los barcos colocados automáticamente
        System.out.println("Los barcos han sido colocados correctamente:");
        for (int i = 1; i <= SIZE; i++) {
            for (int j = 1; j <= SIZE; j++) {
                System.out.print(matrizEnemigo[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Presione ENTER para continuar");
        scanner.nextLine();
        System.out.println();
    }

}
