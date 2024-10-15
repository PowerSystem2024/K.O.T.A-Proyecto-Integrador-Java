/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package batallanavaljava;


import static batallanavaljava.BatallaNavalJava.TAMANO_MATRIZ;

import static batallanavaljava.AtaqueDelEnemigo.ataqueDelEnemigo;
import static batallanavaljava.AtaqueDelJugador.ataqueDelJugador;
import static batallanavaljava.ColocarBarcosEnemigo.colocarBarcosEnemigo;
import static batallanavaljava.Creditos.creditos;
import static batallanavaljava.FinDelJuego.finDelJuego;
import static batallanavaljava.IngresarPosicionBarcoJugador.ingresarPosicionBarcoJugador;
import static batallanavaljava.MostrarTableroJugador.mostrarTableroJugador;

import java.util.Scanner;

/**
 *
 * @author Mkjdf983
 */
public class BatallaNavalLoop {
    
        public static void batallaNavalLoop(String nombreJugador) {
        int[][] matrizJugador = new int[TAMANO_MATRIZ][TAMANO_MATRIZ];
        int[][] matrizEnemigo = new int[TAMANO_MATRIZ][TAMANO_MATRIZ];
        int[] contadorBarcosEnemigo = {0, 4, 4, 4, 2}; // Portaviones, Crucero, Submarino, Lancha
        int[] contadorBarcosJugador = {0, 4, 4, 4, 2}; // Portaviones, Crucero, Submarino, Lancha
        boolean ganar = false;
        boolean perder = false;

        // Inicialización de la matriz jugador
        for (int i = 0; i < TAMANO_MATRIZ; i++) {
            for (int j = 0; j < TAMANO_MATRIZ; j++) {
                matrizJugador[i][j] = 0;
            }
        }

        mostrarTableroJugador(matrizJugador);
        Scanner scanner = new Scanner(System.in);
        ingresarPosicionBarcoJugador(matrizJugador, scanner);
        colocarBarcosEnemigo(matrizEnemigo);
        System.out.println("\n");

        while (!ganar && !perder) {
            mostrarTableroJugadorEnemigo(matrizJugador, matrizEnemigo);
            ataqueDelJugador(matrizEnemigo, contadorBarcosEnemigo, scanner);
            ataqueDelEnemigo(matrizJugador, contadorBarcosJugador);

            // Verificar si el jugador ha ganado
            ganar = true;
            for (int i = 1; i < contadorBarcosEnemigo.length; i++) {
                if (contadorBarcosEnemigo[i] != 0) {
                    ganar = false;
                    break;
                }
            }

            // Verificar si el jugador ha perdido
            perder = true;
            for (int i = 1; i < contadorBarcosJugador.length; i++) {
                if (contadorBarcosJugador[i] != 0) {
                    perder = false;
                    break;
                }
            }
        }

        if (ganar) {
            System.out.println("\nFelicitaciones ha ganado!!!");
        } else {
            System.out.println("\nHas sido derrotado. No te rindas, vuelve a jugar.");
        }

        finDelJuego(nombreJugador);
        creditos();
    }

    private static void mostrarTableroJugadorEnemigo(int[][] matrizJugador, int[][] matrizEnemigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
