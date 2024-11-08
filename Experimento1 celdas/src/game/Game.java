package game;

import BatallaNaval.Board;
import boats.AircraftCarrier;
import boats.Cruise;
import boats.Destroyer;
import boats.Motorboat;
import boats.Submarine;
import score.Score;

public class Game {
    private Board playerBoard;
    private Board enemyBoard;
    private Score score;  // Instancia de la clase Score

    public Game() {
        playerBoard = new Board(10, 10);
        enemyBoard = new Board(10, 10);
        score = new Score();  // Crear la instancia de puntaje
    }

    // Método para realizar un ataque
    public void attack(int row, int column) {
        // Lógica de ataque (simplificada)
        if (enemyBoard.getCell(row, column) instanceof Water) {
            System.out.println("Miss!");
        } else {
            System.out.println("Hit!");
            score.incrementPlayerScore();  // Si acierta, aumenta el puntaje del jugador
        }

        // Mostrar puntaje
        score.displayScore();
    }

    // Método para simular que el jugador fue alcanzado
    public void enemyAttack() {
        System.out.println("You have been hit!");
        score.incrementEnemyScore();  // Si el jugador es alcanzado, aumenta el puntaje del enemigo
    }
}


