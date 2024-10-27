/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BatallaNaval;

/**
 *
 * @author Mkjdf983
 */
public class Marina {
    private Cell[][] cellMatrix;

    public Marina(int rows, int columns) {
        cellMatrix = new Cell[rows][columns];

        // Initialize the matrix with water
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                cellMatrix[i][j] = new Water(); // Default to water
            }
        }
    }


    public boolean addBoat(int row, int column, Cell boat) {
        int  spacesNeeded = ((Cell) boat).getSpaceRequired();
        
        // Check if the space is available
        for (int i = 0; i < spacesNeeded; i++) {
            if (column + i >= cellMatrix[0].length || cellMatrix[row][column + i] instanceof Cell) {
                System.out.println("Not enough space for " + boat.getDescription());
                return false; // Not enough space
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
                System.out.print(cellMatrix[i][j].getDescription() + " ");
            }
            System.out.println();
        }
    }
}


