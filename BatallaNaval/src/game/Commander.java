package game;

import BatallaNaval.Board;
import BatallaNaval.Cell;
import boats.*;

public abstract class Commander {
    protected String name;
    protected Board board;

    public Commander(String name, Board board) {//constructor
        this.name = name;
        this.board = board;
    }

    // Abstract method to place boats (Player and Enemy will override this if needed)
    public abstract void placeBoats();// Abstract method

    // Attack method for both Player and Enemy (shared logic)
    public boolean attack(Board targetBoard, int row, int col) {
        Cell targetCell = targetBoard.getCell(row, col);
        
        // If the target is valid (unhit water or boat section)

            targetCell.setHit(true);  // Mark the cell as hit
            System.out.printf("%s attacks: Row %d, Column %d%n", name, row + 1, col + 1);

            // If the target is a boat, check for hit sections
            if (targetCell instanceof Boat attackedBoat) {
                int sectionIndex = attackedBoat.getSectionIndex(row, col);
                if (sectionIndex != -1) {
                    attackedBoat.hitSection(sectionIndex);  // Mark the specific section as hit
                    System.out.println(name + " hit your " + attackedBoat.getDescription() + "!");
                    return true;  // Successful hit
                }
            }
            System.out.println(name + " missed! The shot hit the water.");
            return false;  // Missed attack
        

    }
}

