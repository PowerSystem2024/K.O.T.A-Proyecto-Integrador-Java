package game;

import BatallaNaval.Board;
import BatallaNaval.Cell;
import boats.*;
import java.util.Random;

public class EnemyCommander extends Commander {
    
    public EnemyCommander(Board board) {
        super("Enemy", board);
    }

    @Override
    public void placeBoats() {
        Boat enemyAircraftCarrier = new AircraftCarrier();
        Boat enemyDestroyer = new Destroyer();
        Boat enemySubmarine = new Submarine();
        Boat enemyCruiser = new Cruise();
        Boat enemyMotorboat = new Motorboat();

        // Randomly place the enemy boats (or you can implement custom logic for placement)
        board.addBoat(1, 1, enemyAircraftCarrier);
        board.addBoat(2, 2, enemyDestroyer);
        board.addBoat(3, 3, enemySubmarine);
        board.addBoat(7, 1, enemyCruiser);
        board.addBoat(0, 6, enemyMotorboat);
    }
    
    
        // Method for enemy attack with random targeting
    public void enemyAttack(Board playerBoard) {
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

        } while (!validTargetFound);
        
        attack(playerBoard, row, col);
    }   
}
