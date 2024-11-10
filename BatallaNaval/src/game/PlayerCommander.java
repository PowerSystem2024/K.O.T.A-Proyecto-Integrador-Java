package game;

import BatallaNaval.Board;
import boats.*;
import java.util.Scanner;
import utils.CleanScreen;

public class PlayerCommander extends Commander {

    public PlayerCommander(Board board) {
        super("Player", board);
    }

    @Override
    public void placeBoats() {
        // Creamos los barcos
        Boat aircraftCarrier = new AircraftCarrier();
        Boat destroyer = new Destroyer();
        Boat submarine = new Submarine();
        Boat cruiser = new Cruise();
        Boat motorboat1 = new Motorboat();

        // Definimos un arreglo con todos los barcos para iterarlos
        Boat[] boats = {aircraftCarrier, destroyer, submarine, cruiser, motorboat1};

        // Iteramos sobre los barcos
        for (Boat boat : boats) {
            CleanScreen.clearScreen();
            boolean placed = false;  // Variable para verificar si el barco fue colocado correctamente
            while (!placed) {                
                //board.displayBothBoards(board, board);
                int [] Arraycoordinates = new int[2];
                Arraycoordinates =  Coordinates(board, boat);
                //CleanScreen.clearScreen();
                int row = Arraycoordinates[0];
                int col = Arraycoordinates[1];
                
                
                if(board.addBoat(row, col, boat)){
                    placed = true;
                    System.out.println(boat.getDescription() + " placed successfully!");
                }
                else {
                    // Aquí solo mostramos un mensaje genérico sin detalles específicos
                    System.out.println("Position already occupied or out of bounds. Please try again.");
                }
                
            }
        }
    }

   
    public int[] Coordinates(Board board, Boat boat) {
        String input;
        int row = -1;
        int col = -1;
        int[] coordinates = new int[2];
        Boolean validInput = false;
        // Usamos el Scanner para pedir las coordenadas al jugador
        Scanner scanner = new Scanner(System.in);
        // Pedimos y validamos la entrada de la coordenada (por ejemplo, A1)
        
        while (!validInput) {
            System.out.printf("Enter the starting position (e.g., A1) for your %s: ", boat.getDescription());
            board.displayBothBoards(board, board);
            input = scanner.nextLine().toUpperCase();
            CleanScreen.clearScreen();
            // Verificamos si la entrada tiene el formato correcto
            if (input.length() >= 2) {
                char rowChar = input.charAt(0);  // La letra es la fila
                String colStr = input.substring(1);  // El número es la columna

                // Validamos la fila (letra)
                if (rowChar >= 'A' && rowChar <= 'J') {
                    row = rowChar - 'A';  // Convertimos la letra en un índice de fila (0-9)
                    coordinates[0] = row;
                } else {
                    System.out.println("Invalid row. Please enter a letter between A and J.");
                    continue;
                }

                // Validamos la columna (número)
                try {
                    col = Integer.parseInt(colStr) - 1;  // Convertimos de 1-10 a 0-9
                    coordinates[1] = col;
                    if (col < 0 || col >= board.getColumnCount()) {
                        System.out.println("Invalid column. Please enter a number between 1 and 10.");
                        continue;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid column. Please enter a valid number between 1 and 10.");
                    continue;
                }
                
                validInput = true;  // Entrada válida
            } else {
                System.out.println("Invalid input. Please enter a valid coordinate (e.g., A1).");
                continue;
            }
        }
                
        return coordinates;
    }
    
        public void playerAttack(Board enemyBoard) {
            Scanner scanner = new Scanner(System.in);
            
            System.out.println("Enter the coordinates of your attack (e.g., A1, B2):");    
            String input = scanner.nextLine().toUpperCase().trim(); // Read input and format it
            CleanScreen.clearScreen();// se limpa la pantalla 
            // Check if input has at least two characters and no more than three
            if (input.length() < 2 || input.length() > 3) {
                //CleanScreen.clearScreen();
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
            attack(enemyBoard, row, column);
    }
}



// futuro 
//    public void playerAttack(Board playerBoard) {
//        int[] coordinates = new int [2];
//        System.out.println("Enter the coordinates of your attack (e.g., A1, B2):");
//        coordinates = Coordinates(playerBoard, null);
//        int row = coordinates[0];
//        int col = coordinates[1];
//        // Realizar el ataque
//        attack(playerBoard, row, col);
//
//    }