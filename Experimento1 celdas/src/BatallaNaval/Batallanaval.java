package BatallaNaval;
import boats.Boat;
<<<<<<< Updated upstream
import boats.Sailboat;
import java.util.Scanner;


public class BatallaNaval {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.start(); // metodo start de la clase Timer

        Marina marina = new Marina(10, 10); // Tamaños matriz
=======
import boats.AircraftCarrier;
import boats.Destroyer;
import boats.Submarine;
import boats.Cruiser;
import boats.Motorboat;

public class BatallaNaval {
    public static void main(String[] args) {
        Marina marina = new Marina(10, 10); // Tamaño de la matriz
>>>>>>> Stashed changes
        
        // Crear instancias de los barcos
        Boat aircraftCarrier = new AircraftCarrier("Aircraft Carrier", 5);
        Boat destroyer = new Destroyer("Destroyer", 4);
        Boat submarine = new Submarine("Submarine", 3);
        Boat cruiser = new Cruiser("Cruiser", 2); // Asegúrate de que esto esté correcto
        Boat motorboat1 = new Motorboat("Speedster", 1); // Motorboat tiene 1 posición

        // Agregar barcos a la marina
        if (marina.addBoat(0, 0, aircraftCarrier)) {
            System.out.println("Aircraft Carrier added successfully.");
        } else {
            System.out.println("Failed to add Aircraft Carrier.");
        }

        if (marina.addBoat(5, 5, destroyer)) {
            System.out.println("Destroyer added successfully.");
        } else {
            System.out.println("Failed to add Destroyer.");
        }

        if (marina.addBoat(2, 3, submarine)) {
            System.out.println("Submarine added successfully.");
        } else {
            System.out.println("Failed to add Submarine.");
        }

        if (marina.addBoat(7, 1, cruiser)) {
            System.out.println("Cruiser added successfully.");
        } else {
            System.out.println("Failed to add Cruiser.");
        }

        if (marina.addBoat(9, 9, motorboat1)) {
            System.out.println("Motorboat added successfully.");
        } else {
            System.out.println("Failed to add Motorboat.");
        }

        // Mostrar la matriz de la marina
        marina.displayCells();

        // Test para ver el tiempo despues del enter
        System.out.println("Game finished. Press Enter to see the elapsed time...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); // Wait for user input

        // Motrar el tiempo pasado
        String elapsedTime = timer.getElapsedTime();
        System.out.printf("Total game time: %s%n", elapsedTime);
        
        scanner.close();
    }
}
