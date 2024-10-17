
package batallanavaljava;

import static batallanavaljava.MostrarTableroJugador.mostrarTableroJugador;
import java.util.InputMismatchException;
import java.util.Scanner;

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
                boolean columnaValida = false;
                while (!columnaValida) {
                    try {
                        System.out.print("Elija en qué columna quiere colocar su barco (1-10): ");
                        columna = scanner.nextInt();
                        if (columna >= 1 && columna <= 10) {
                            columnaValida = true;
                        } else {
                            System.out.println("Columna fuera de rango. Ingrese un valor entre 1 y 10.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida. Ingrese un número entero.");
                        scanner.next(); // Limpiar la entrada inválida
                    }
                }

                // Obtener fila
                char filaChar;
                int fila = -1;
                boolean filaValida = false;
                while (!filaValida) {
                    System.out.print("Elija en qué fila quiere colocar su barco (A-J): ");
                    filaChar = scanner.next().toUpperCase().charAt(0);
                    fila = filaChar - 'A';
                    if (fila >= 0 && fila <= 9) {
                        filaValida = true;
                    } else {
                        System.out.println("Fila fuera de rango. Ingrese un valor entre A y J.");
                    }
                }

                // Verificar si la posición es válida y si el barco cabe en la columna seleccionada
                if ((columna + barco[tipo] - 1) <= 10) {
                    boolean espacioDisponible = true;

                    // Verificar que todas las posiciones necesarias para el barco estén libres
                    for (int h = 0; h < barco[tipo]; h++) {
                        if (matriz[fila][columna + h] != 0) {
                            espacioDisponible = false;
                            break;
                        }
                    }

                    if (espacioDisponible) {
                        // Colocar el barco en el tablero
                        for (int h = 0; h < barco[tipo]; h++) {
                            matriz[fila][columna + h] = tipo + 5; // Usar formato diferente para barcos
                        }
                        posicionValida = true;
                        System.out.println("El barco se ha colocado correctamente.");
                        mostrarTableroJugador(matriz);
                    } else {
                        System.out.println("Ya hay un barco en esta posición. Intente de nuevo.");
                    }
                } else {
                    System.out.println("El barco no cabe en esta posición. Intente de nuevo.");
                }
            }
        }
    }
}