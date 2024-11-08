package test;

import BatallaNaval.*;
import utils.Timer;
import boats.*;
import java.util.Random;
import java.util.Scanner;

public class TestBatallaNaval {

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.start(); // Start the timer

        // Initialize boards for the player and the enemy
        Board playerBoard = new Board(10, 10);
        Board enemyBoard = new Board(10, 10);
        
        // Initialize player and enemy
        Jugador player = new Jugador(playerBoard);
        Jugador enemy = new Jugador(enemyBoard);

        // Create boats for the player
        Boat aircraftCarrier = new AircraftCarrier("Aircraft Carrier", 5);
        Boat destroyer = new Destroyer("Destroyer", 4);
        Boat submarine = new Submarine("Submarine", 3);
        Boat cruiser = new Cruise("Cruiser", 2);
        Boat motorboat1 = new Motorboat("Speedster", 1);

        // Add boats to the player’s board
        placeBoats(playerBoard, aircraftCarrier, 0, 0);
        placeBoats(playerBoard, destroyer, 5, 5);
        placeBoats(playerBoard, submarine, 2, 3);
        placeBoats(playerBoard, cruiser, 7, 1);
        placeBoats(playerBoard, motorboat1, 9, 9);

        // Create and place enemy boats (can be randomized)
        Boat enemyAircraftCarrier = new AircraftCarrier("Enemy Aircraft Carrier", 5);
        Boat enemyDestroyer = new Destroyer("Enemy Destroyer", 4);
        Boat enemySubmarine = new Submarine("Enemy Submarine", 3);
        Boat enemyCruiser = new Cruise("Enemy Cruiser", 2);
        Boat enemyMotorboat = new Motorboat("Enemy Speedster", 1);

        placeBoats(enemyBoard, enemyAircraftCarrier, 0, 0);
        placeBoats(enemyBoard, enemyDestroyer, 5, 5);
        placeBoats(enemyBoard, enemySubmarine, 2, 3);
        placeBoats(enemyBoard, enemyCruiser, 7, 1);
        placeBoats(enemyBoard, enemyMotorboat, 9, 9);

        // Show both boards (optional, to visualize both)
        System.out.println("Player's board:");
        playerBoard.displayCells();
//        System.out.println("Enemy's board:");
//        enemyBoard.displayCells();

        // Game loop: Player and enemy alternate turns
        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);
        
        while (!gameOver) {
            playerBoard.displayBothBoards(playerBoard, enemyBoard);
            // Player’s turn
            System.out.println("Player's Turn:");
            playerAttack(enemyBoard);
            
            // Check if the game is over (if all enemy boats are sunk)
            if (isGameOver(enemyBoard)) {
                gameOver = true;
                System.out.println("Player wins!");
                break;
            }

            // Enemy's turn
            System.out.println("Enemy's Turn:");
            enemyAttack(playerBoard);
            
            // Check if the player is out of boats (game over)
            if (isGameOver(playerBoard)) {
                gameOver = true;
                System.out.println("Enemy wins!");
                break;
            }
        }

        // Print elapsed time
        String elapsedTime = timer.getElapsedTime();
        System.out.printf("Total game time: %s%n", elapsedTime);
        scanner.close();
    }

    // Method to place boats on the board
    public static void placeBoats(Board board, Boat boat, int row, int col) {
        if (board.addBoat(row, col, boat)) {
            System.out.println(boat.getName() + " added successfully.");
        } else {
            System.out.println("Failed to add " + boat.getName());
        }
    }

public static void playerAttack(Board enemyBoard) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the coordinates of your attack (e.g., A1, B2):");

    String input = scanner.nextLine().toUpperCase(); // Read the input and convert to uppercase for consistency

    // Validate input length and format (e.g., "A1", "B2", etc.)
    if (input.length() < 2 || input.length() > 3) {
        System.out.println("Invalid input. Please enter in the format <Letter><Number> (e.g., A1).");
        return; // Exit the method if input is invalid
    }

    char colChar = input.charAt(0); // The column character (A-J)
    String rowStr = input.substring(1); // The row number (1-10)

    // Validate the row and column
    if (colChar < 'A' || colChar > 'J' || Integer.parseInt(rowStr) < 1 || Integer.parseInt(rowStr) > 10) {
        System.out.println("Invalid coordinates. Please enter valid row and column values.");
        return; // Exit the method if coordinates are invalid
    }

    // Convert the column letter (A-J) to an index (0-9)
    int column = colChar - 'A';
    int row = Integer.parseInt(rowStr) - 1; // Convert the row number to zero-based index

    System.out.printf("Player attacks: Row %d, Column %d%n", row + 1, column + 1);

    // Attack the enemy board at this position
    Cell targetCell = enemyBoard.getCell(row, column);
    if (targetCell instanceof Boat) {
        Boat attackedBoat = (Boat) targetCell;
        System.out.println("Hit! You hit the " + attackedBoat.getName());
        enemyBoard.getCell(row, column);  // You might want to track damage here
    } else {
        System.out.println("Miss! The shot hit water.");
    }
}


    // Method to handle enemy attack (similarly, can be random)
    public static void enemyAttack(Board playerBoard) {
        Random rand = new Random();
        int row = rand.nextInt(10);  // Random row
        int col = rand.nextInt(10);  // Random column
        System.out.printf("Enemy attacks: Row %d, Column %d%n", row + 1, col + 1);

        // Attack the player board
        Cell targetCell = playerBoard.getCell(row, col);
        if (targetCell instanceof Boat) {
            Boat attackedBoat = (Boat) targetCell;
            System.out.println("Enemy hit your " + attackedBoat.getName());
        } else {
            System.out.println("Enemy missed!");
        }
    }

    // Method to check if all boats on the board are sunk
    public static boolean isGameOver(Board board) {
        for (int i = 0; i < board.getRowCount(); i++) {
            for (int j = 0; j < board.getColumnCount(); j++) {
                if (board.getCell(i, j) instanceof Boat) {
                    return false;  // If there are still boats, the game is not over
                }
            }
        }
        return true;  // If no boats left, game over
    }
}
