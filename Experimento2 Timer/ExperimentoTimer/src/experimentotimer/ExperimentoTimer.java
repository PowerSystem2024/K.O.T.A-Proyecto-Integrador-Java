/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package experimentotimer;
import java.util.Scanner;
/**
 *
 * @author Mkjdf983
 */// CON TRREADS
public class ExperimentoTimer {
    private static long tiempoInicio; // Timestamp for when the game starts
    private static volatile boolean running = true; // Control variable for the timer thread

    public static void main(String[] args) {
        // Start the timer
        tiempoInicio = System.currentTimeMillis();
        
        // Create a Scanner to wait for user input
        Scanner scanner = new Scanner(System.in);

        // Simulate the game while updating the timer
        System.out.println("La partida ha comenzado. Presiona Enter para finalizar...");
        
        // Start a loop to update the timer every second
        new Thread(() -> {
            while (running) {
                long tiempoActual = System.currentTimeMillis();
                long tiempoTranscurrido = tiempoActual - tiempoInicio; // Time in milliseconds
                
                // Convert to minutes and seconds
                long minutos = (tiempoTranscurrido / 1000) / 60;
                long segundos = (tiempoTranscurrido / 1000) % 60;
                
                // Clear the line and print the elapsed time
                System.out.printf("\rTiempo de juego: %02d:%02d   ", minutos, segundos);
                
                // Sleep for 1 second
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break; // Exit the loop if interrupted
                }
            }
        }).start(); // Start the timer thread

        // Wait for user input to end the game
        scanner.nextLine(); // Wait for user input

        // End the game
        finalizarPartida();
        scanner.close();
    }

    private static void finalizarPartida() {
        running = false; // Stop the timer thread
        long tiempoFin = System.currentTimeMillis();
        long tiempoTranscurrido = tiempoFin - tiempoInicio; // Time in milliseconds

        // Convert to minutes and seconds
        long minutos = (tiempoTranscurrido / 1000) / 60;
        long segundos = (tiempoTranscurrido / 1000) % 60;

        System.out.println("\nPartida finalizada.");
        System.out.printf("Tiempo total de juego: %02d:%02d%n", minutos, segundos);
    }
}

//ACA EL QUE NO USA THREADS
//
//public class ExperimentoTimer {
//    private static long tiempoInicio; // Timestamp de inicio
//
//    public static void main(String[] args) {
//        // Capturar el timestamp al inicio del juego
//        tiempoInicio = System.currentTimeMillis();
//
//        // Simulación de la partida (puedes reemplazar esto con tu lógica de juego)
//        try {
//            // Simula el tiempo de juego
//            Thread.sleep(20000); // 20 segundos de juego
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        // Finalizar el juego
//        finalizarPartida();
//    }
//
//    private static void finalizarPartida() {
//        long tiempoFin = System.currentTimeMillis();
//        long tiempoTranscurrido = tiempoFin - tiempoInicio; // Tiempo en milisegundos
//
//        // Convertir a minutos y segundos
//        long minutos = (tiempoTranscurrido / 1000) / 60;
//        long segundos = (tiempoTranscurrido / 1000) % 60;
//
//        System.out.println("Partida finalizada.");
//        System.out.printf("Tiempo total de juego: %02d:%02d%n", minutos, segundos);
//    }
//}