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

        // Arreglo con todos los barcos
        Boat[] boats = {enemyAircraftCarrier, enemyDestroyer, enemySubmarine, enemyCruiser, enemyMotorboat};
        Random rand = new Random();

        // Colocamos los barcos de manera aleatoria (solo horizontal)
        for (Boat boat : boats) {
            boolean placed = false;

            while (!placed) {
                // Generamos una posición aleatoria para el barco (solo horizontal)
                int row = rand.nextInt(board.getRowCount());
                int col = rand.nextInt(board.getColumnCount());

                // Verificamos si el barco cabe en la posición horizontal generada
                if (col + boat.getLength() <= board.getColumnCount()) {
                    boolean canPlace = true;
                    // Verificamos si el espacio está ocupado por otro barco
                    for (int i = 0; i < boat.getLength(); i++) {
                        if (board.getCell(row, col + i) instanceof Boat) {
                            canPlace = false;
                            break;
                        }
                    }

                    if (canPlace) {
                        // Colocamos el barco horizontalmente
                        for (int i = 0; i < boat.getLength(); i++) {
                            board.addBoat(row, col + i, boat);
                        }
                        placed = true;
                    }
                }
            }
        }
    }

    // Método para el ataque del enemigo con coordenadas aleatorias
    public void enemyAttack(Board playerBoard) {
        Random rand = new Random();
        int row, col;
        Cell targetCell;
        boolean validTargetFound;

        do {
            // Generar coordenadas aleatorias
            row = rand.nextInt(playerBoard.getRowCount());
            col = rand.nextInt(playerBoard.getColumnCount());
            targetCell = playerBoard.getCell(row, col);
            
            // Verificar si la celda es agua o una sección no golpeada de un barco
            if (targetCell instanceof Boat attackedBoat) {
                int sectionIndex = attackedBoat.getSectionIndex(row, col);
                validTargetFound = sectionIndex != -1 && !attackedBoat.getHitSection(sectionIndex); // Verificar que la sección no haya sido golpeada
            } else {
                validTargetFound = !targetCell.isHit(); // Celda de agua que no ha sido golpeada
            }
        } while (!validTargetFound);
        
        // Realizar el ataque
        attack(playerBoard, row, col);
    }
}
