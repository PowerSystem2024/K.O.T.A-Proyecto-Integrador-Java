package boats;


import BatallaNaval.Cell;
import java.util.ArrayList;
import java.util.List;

public abstract class Boat extends Cell {
    private final String name;
    private final int length;
    private final boolean[] hitSections;  // Array to track hit status of each section
    private final List<int[]> positions;  // List to track the exact coordinates (row, column) of each section

    public Boat(String name, int length, char character) {
        super(character);
        this.name = name;
        this.length = length;
        this.hitSections = new boolean[length]; // Initialize the array for hit sections
        this.positions = new ArrayList<>();
    }

    public int getLength() {
        return length;
    }

    @Override
    public String getDescription() {
        return name;
    }

    @Override
    public int getSpaceRequired() {
        return length;
    }

    // Mark a specific section as hit
    public void hitSection(int sectionIndex) {
        if (sectionIndex >= 0 && sectionIndex < length) {
            hitSections[sectionIndex] = true;
        }
    }
    
    // Find the section index based on a row and column
    public int getSectionIndex(int row, int column) {
        for (int i = 0; i < positions.size(); i++) {
            int[] position = positions.get(i);
            if (position[0] == row && position[1] == column) {
                return i; // Return the section index
            }
        }
        return -1; // Not part of this boat
    }
    // Get the character for the specific section of the boat
    public char getSectionCharacter(int sectionIndex) {
        return hitSections[sectionIndex] ? 'X' : CELL_CHAR;
    }

    // Add the boat's position on the board
    public void addPosition(int row, int col) {
        positions.add(new int[]{row, col});
    }

    // Get the boat's positions
    public List<int[]> getPositions() {
        return positions;
    }

    // Check if the boat is completely sunk
    public boolean isSunk() {
        for (boolean hit : hitSections) {
            if (!hit) {
                return false;
            }
        }
        return true;
    }

    public boolean[] getHitSections() {
        return hitSections;
    }

    // Abstract method for sailing, specific to each boat type
    public abstract void sail();
    
    //devuelve un booleano del araaya de booleanos hitSections
    public boolean getHitSection(int sectionIndex) {// aca rew
        if(sectionIndex >= 0 && sectionIndex < hitSections.length){ // check out of bounds
            return hitSections[sectionIndex];
        } else {// hago un check par ver si le llego un valor erroneo que rompa el juego
            System.out.println("Invalid section index: " + sectionIndex);
            return false;
        }
    }
    
    
}
