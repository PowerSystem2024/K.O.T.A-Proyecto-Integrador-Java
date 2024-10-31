package BatallaNaval;

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

    public boolean addBoat(int row, int column, Cell boat) {
        int spacesNeeded = boat.getSpaceRequired();

        // Check if the space is available
        for (int i = 0; i < spacesNeeded; i++) {
            if (row >= cellMatrix.length || column + i >= cellMatrix[0].length || !(cellMatrix[row][column + i] instanceof Water)) {
                System.out.println("Not enough space for " + boat.getDescription());
                return false; // Not enough space or cell is occupied
            }
        }

        // Place the boat in the matrix
        for (int i = 0; i < spacesNeeded; i++) {
            cellMatrix[row][column + i] = boat;
        }
        return true; // Successfully added the boat
    }

    public Cell getCell(int row, int column) {
        if (row < cellMatrix.length && column < cellMatrix[0].length) {
            return cellMatrix[row][column];
        }
        return null;
    }

    public void displayCells() {
        for (int i = 0; i < cellMatrix.length; i++) {
            for (int j = 0; j < cellMatrix[i].length; j++) {
                System.out.print(cellMatrix[i][j].getCharacter() + " ");
            }
            System.out.println();
        }
    }

    // Nuevos métodos para obtener el número de filas y columnas
    public int getRowCount() {
        return cellMatrix.length;
    }

    public int getColumnCount() {
        return cellMatrix[0].length;
    }
}
