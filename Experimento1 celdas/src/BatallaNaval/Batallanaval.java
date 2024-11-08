package BatallaNaval;

import utils.Timer;
import boats.Boat;
import boats.AircraftCarrier;
import boats.Destroyer;
import boats.Submarine;
import boats.Cruise;
import boats.Motorboat;
import java.util.Scanner;

public class BatallaNaval {
    public static void main(String[] args) {
        // Asegúrate de que Timer esté implementado y que el import esté correcto si está en otro paquete.
        Timer timer = new Timer();
        timer.start(); // Iniciar el temporizador

        Board board = new Board(10, 10); // Tamaño de la matriz
        Jugador player = new Jugador(board);
        // Crear instancias de los barcos
        Boat aircraftCarrier = new AircraftCarrier("Aircraft Carrier", 5);
        Boat destroyer = new Destroyer("Destroyer",4);
        Boat submarine = new Submarine("Submarine", 3);
        Boat cruiser = new Cruise("Cruiser", 2);
        Boat motorboat1 = new Motorboat("Speedster", 1);

        // Agregar barcos a la marina
        if (board.addBoat(0, 0, aircraftCarrier)) {
            System.out.println("Aircraft Carrier added successfully.");
        } else {
            System.out.println("Failed to add Aircraft Carrier.");
        }

        if (board.addBoat(5, 5, destroyer)) {
            System.out.println("Destroyer added successfully.");
        } else {
            System.out.println("Failed to add Destroyer.");
        }

        if (board.addBoat(2, 3, submarine)) {
            System.out.println("Submarine added successfully.");
        } else {
            System.out.println("Failed to add Submarine.");
        }

        if (board.addBoat(7, 1, cruiser)) {
            System.out.println("Cruiser added successfully.");
        } else {
            System.out.println("Failed to add Cruiser.");
        }

        if (board.addBoat(9, 9, motorboat1)) {
            System.out.println("Motorboat added successfully.");
        } else {
            System.out.println("Failed to add Motorboat.");
        }

        // Mostrar la matriz de la marina
//        board.displayCells(true);
//        board.displayCells(false);
        board.displayBothBoards(board, board);

        // Test para ver el tiempo después de presionar Enter
        System.out.println("Game finished. Press Enter to see the elapsed time...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); // Esperar entrada del usuario

        // Mostrar el tiempo pasado
        String elapsedTime = timer.getElapsedTime();
        System.out.printf("Total game time: %s%n", elapsedTime);
        
        scanner.close();
    }
}
