package BatallaNaval;

import boats.Boat;

public class Board { // Renombrar a Board

    private Cell[][] cellMatrix;

    public Board(int rows, int columns) {
        cellMatrix = new Cell[rows][columns];

        // Initialize the matrix with water
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                cellMatrix[i][j] = new Water(); // Default to water
            }
        }
    }

    public boolean addBoat(int row, int column, Boat boat) {
        int spacesNeeded = boat.getSpaceRequired();

        // Check if the space is available
        for (int i = 0; i < spacesNeeded; i++) {
            if (row >= cellMatrix.length || column + i >= cellMatrix[0].length || !(cellMatrix[row][column + i] instanceof Water)) {
                System.out.println("Not enough space for " + boat.getDescription());
                return false; // Not enough space or cell is occupied
            }
        }

        // Place the boat in the matrix and add the boat's cells
        for (int i = 0; i < spacesNeeded; i++) {
            cellMatrix[row][column + i] = boat;  // Place the boat in the cell
            boat.addPosition(row, column + i);  // Add the position to the boat's list of positions
        }
        return true; // Successfully added the boat
    }



    public Cell getCell(int row, int column) {
        if (row < cellMatrix.length && column < cellMatrix[0].length) {
            return cellMatrix[row][column];
        }
        return null;
    }
    // este se uso para testear en crudo los vores
    public void displayCells() {
        for (int i = 0; i < cellMatrix.length; i++) {
            for (int j = 0; j < cellMatrix[i].length; j++) {
                System.out.print(cellMatrix[i][j].getCharacter() + " ");
            }
            System.out.println();
        }
    }
    
    public void displayBothBoards(Board playerBoard, Board enemyBoard) {
        // Print column numbers (1-10) at the top for both boards
        System.out.println("This is your board :        "
                + "                                                  This is the Enemt's board : ");
        System.out.println();
        System.out.print("   "); // Initial space for alignment
        for (int c = 1; c <= 10; c++) {
            System.out.print(c + "     "); // Print columns 1 to 10
        }
        System.out.print("                "); // Space between the two boards

        for (int c = 1; c <= 10; c++) {
            System.out.print(c + "     "); // Print columns 1 to 10 for enemy board
        }
        System.out.println();
        System.out.println();

        // Now, print the rows (A-J)
        for (int i = 0; i < playerBoard.getRowCount(); i++) {
            // Print the row letter (A-J) for the player's board
            System.out.print((char)('A' + i) + "  "); // Row letter for player's board

            // Print each cell of the player's board
            for (int j = 0; j < playerBoard.getColumnCount(); j++) {
                Cell cell = playerBoard.getCell(i, j);

                if (cell instanceof Boat) {
                    Boat boat = (Boat) cell;

                    // Check if the current cell is part of the boat
                    for (int k = 0; k < boat.getPositions().size(); k++) {
                        int[] position = boat.getPositions().get(k);
                        if (position[0] == i && position[1] == j) {
                            // Show the character for the specific section of the boat
                            System.out.print(boat.getSectionCharacter(k) + "     ");
                            break;
                        }
                    }
                } else {
                    System.out.print(cell.getCharacter() + "     ");
                }
            }

            System.out.print("              "); // Space between boards

            // Print the row letter (A-J) for the enemy's board
            System.out.print((char)('A' + i) + "  "); // Row letter for enemy's board
            for (int j = 0; j < enemyBoard.getColumnCount(); j++) {
                Cell cell = enemyBoard.getCell(i, j);

                if (cell instanceof Boat) {
                    Boat boat = (Boat) cell;

                    // Check if the current cell is part of the boat
                    boolean sectionIsHit = false;
                    for (int k = 0; k < boat.getPositions().size(); k++) {
                        int[] position = boat.getPositions().get(k);
                        if (position[0] == i && position[1] == j) {
                            // Show the character for the specific section of the boat
                            sectionIsHit = boat.getHitSection(k); // Check if this specific section is hit
                            System.out.print(sectionIsHit ? boat.getCELL_CHARAsString(): "~"); // Show boat character if hit, else water
                            System.out.print("     ");
                            break;
                        }
                    }
                } else {
                    System.out.print(cell.getCharacter() + "     ");
                }
            }

            System.out.println();
            System.out.println();
        }
    }






    // Nuevos métodos para obtener el número de filas y columnas por si hacemos 
//  mapas customizados
    public int getRowCount() {
        return cellMatrix.length;
    }

    public int getColumnCount() {
        return cellMatrix[0].length;
    }
}
