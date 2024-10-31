
package BatallaNaval;
import boats.Motorboat;
import boats.Boat;
import boats.Sailboat;
import java.util.Scanner;


public class BatallaNaval {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.start(); // metodo start de la clase Timer

        Marina marina = new Marina(10, 10); // Tamaños matriz
        
        Boat sailboat1 = new Sailboat("Velero", 2);
        Boat motorboat1 = new Motorboat("Speedster", 2);

        marina.addBoat(0, 0, sailboat1);
        if (marina.addBoat(5, 5, motorboat1)) {
            System.out.println("Motorboat added successfully.");
        } else {
            System.out.println("Failed to add Motorboat.");
        }

        if (marina.addBoat(0, 2, motorboat1)) {
            System.out.println("Motorboat added successfully.");
        } else {
            System.out.println("Failed to add Motorboat.");
        }

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

