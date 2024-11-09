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
        Boat aircraftCarrier = new AircraftCarrier();
        Boat destroyer = new Destroyer();
        Boat submarine = new Submarine();
        Boat cruiser = new Cruise();
        Boat motorboat1 = new Motorboat();

        // Add boats to the player’s board
        placeBoats(playerBoard, aircraftCarrier, 0, 0);
        placeBoats(playerBoard, destroyer, 5, 5);
        placeBoats(playerBoard, submarine, 2, 3);
        placeBoats(playerBoard, cruiser, 7, 1);
        placeBoats(playerBoard, motorboat1, 9, 9);

        // Create and place enemy boats (can be randomized)
        Boat enemyAircraftCarrier = new AircraftCarrier();
        Boat enemyDestroyer = new Destroyer();
        Boat enemySubmarine = new Submarine();
        Boat enemyCruiser = new Cruise();
        Boat enemyMotorboat = new Motorboat();

        placeBoats(enemyBoard, enemyAircraftCarrier, 1, 1);
        placeBoats(enemyBoard, enemyDestroyer, 2, 2);
        placeBoats(enemyBoard, enemySubmarine, 3, 3);
        placeBoats(enemyBoard, enemyCruiser, 7, 1);
        placeBoats(enemyBoard, enemyMotorboat, 0, 6);

        // Show both boards (optional, to visualize both)
        System.out.println("Player's board:");
        //playerBoard.displayCells();
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
            System.out.println(boat.getDescription() + " added successfully.");
        } else {
            System.out.println("Failed to add " + boat.getDescription());
        }
    }

public static void playerAttack(Board enemyBoard) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the coordinates of your attack (e.g., A1, B2):");

    String input = scanner.nextLine().toUpperCase().trim(); // Read input and format it

    // Check if input has at least two characters and no more than three
    if (input.length() < 2 || input.length() > 3) {
        System.out.println("Invalid input format. Please enter a letter followed by a number (e.g., A1).");
        return;
    }

    char rowChar = input.charAt(0); // The first character should be a letter
    String columnStr = input.substring(1); // The remaining characters should represent the row number

    // Validate that the row is within the range 'A' to 'J'
    if (rowChar < 'A' || rowChar > 'J') {
        System.out.println("Invalid row. Please enter a letter between A and J.");
        return;
    }

    int column;
    try {
        column = Integer.parseInt(columnStr) - 1; // Convert row to zero-based index
    } catch (NumberFormatException e) {
        System.out.println("Invalid column number. Please enter a number between 1 and 10.");
        return;
    }

    // Ensure the column is within the board limits (1-10 becomes index 0-9)
    if (column < 0 || column >= enemyBoard.getColumnCount()) {
        System.out.println("Column out of range. Please enter a number between 1 and 10.");
        return;
    }

    // Convert the row letter (A-J) to an index (0-9)
    int row = rowChar - 'A';

    System.out.printf("Player attacks: Row %d, Column %d%n", row + 1, column + 1);

    // Proceed with the attack on the enemy board
    Cell targetCell = enemyBoard.getCell(row, column);
    targetCell.setHit(true); // Marcar la celda como disparada

    if (targetCell instanceof Boat) {
        Boat boat = (Boat) targetCell;
        int sectionIndex = boat.getSectionIndex(row, column);  // Get the section index based on position
        if (sectionIndex != -1) {
            boat.hitSection(sectionIndex);  // Mark the specific section as hit
            System.out.println("Hit! You hit the " + boat.getDescription());
        }
    } else {
        System.out.println("Miss! The shot hit water.");
    }
}



    // Method to handle enemy attack (similarly, can be random)

    public static void enemyAttack(Board playerBoard) {
        Random rand = new Random();
        int row, col;
        Cell targetCell;
        boolean validTargetFound;

        do {
        // Generate random coordinates
        row = rand.nextInt(playerBoard.getRowCount());
        col = rand.nextInt(playerBoard.getColumnCount());
        targetCell = playerBoard.getCell(row, col);
        
        // Check if the cell is water or an unhit section of a boat
        if (targetCell instanceof Boat attackedBoat) {
            int sectionIndex = attackedBoat.getSectionIndex(row, col);
            validTargetFound = sectionIndex != -1 && !attackedBoat.getHitSection(sectionIndex); // Check if specific section isn't hit
        } else {
            validTargetFound = !targetCell.isHit(); // Water cell that hasn't been hit
        }

        } while (!validTargetFound); // Repeat until an unhit cell is found // Repetir hasta encontrar una celda que no haya sido atacada

        // Marcar la celda como disparada
        targetCell.setHit(true);
        System.out.printf("Enemy attacks: Row %d, Column %d%n", row + 1, col + 1);

        // Determinar si el ataque fue exitoso o falló
        if (targetCell instanceof Boat attackedBoat) {
            int sectionIndex = attackedBoat.getSectionIndex(row, col);
            if (sectionIndex != -1) {
                attackedBoat.hitSection(sectionIndex); // Mark this specific section as hit
                System.out.println("Enemy hit your " + attackedBoat.getDescription() + "!");
            }
        } else {
            System.out.println("Enemy missed!");
        }
    }

    // Method to check if all boats on the board are sunk

    public static boolean isGameOver(Board board) {
        for (int i = 0; i < board.getRowCount(); i++) {
            for (int j = 0; j < board.getColumnCount(); j++) {
                Cell cell = board.getCell(i, j);
                if (cell instanceof Boat && !((Boat) cell).isSunk()) {
                    return false;  // Si hay al menos un barco no hundido, el juego no ha terminado
                }
            }
        }
        return true;  // Todos los barcos están hundidos, juego terminado
    }
}
