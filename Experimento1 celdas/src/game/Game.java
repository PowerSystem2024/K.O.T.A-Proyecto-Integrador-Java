package game;

import BatallaNaval.Board;
import BatallaNaval.Cell;
import boats.Boat;
import score.Score;
import static test.TestBatallaNaval.playerAttack; // remover desp de que este player commander
import utils.CleanScreen;
import utils.Timer;

public class Game {
    private Board playerBoard;
    private Board enemyBoard;
    private Score score;  // Instancia de la clase Score
    private Timer timer;
    
    public Game() {
        
        playerBoard = new Board(10, 10);
        enemyBoard = new Board(10, 10);
        score = new Score();  // Crear la instancia de puntaje
        timer = new Timer();
        
    }
    
    public void gameLoop(){

        timer.start(); // Start the timer
        
        // Initialize player and enemy
        PlayerCommander playerCommander = new PlayerCommander(playerBoard);
        EnemyCommander enemyCommander = new EnemyCommander(enemyBoard);
        // Place boats on the boards
        playerCommander.placeBoats();
        enemyCommander.placeBoats(); 
        boolean gameOver = false;       
        String elapsedTime = timer.getElapsedTime();
        elapsedTime = timer.getElapsedTime();
        //System.out.printf("Total game time: %s%n", elapsedTime);

        
        while (!gameOver) {        
            // Player’s turn
            //CleanScreen.clearScreen();
            System.out.println("Player's Turn:");
            elapsedTime = timer.getElapsedTime();
            System.out.printf("Current game time: %s%n", elapsedTime);
            playerCommander.playerAttack(enemyBoard);

            // Check if the game is over (if all enemy boats are sunk)
            if (isGameOver(enemyBoard)) {
                gameOver = true;
                System.out.println("Player wins!");
                break;
            }
            // Enemy's turn
            System.out.println("Enemy's Turn:"); 
            enemyCommander.enemyAttack(playerBoard); 
            //enemyAttack(playerBoard);
            playerBoard.displayBothBoards(playerBoard, enemyBoard);

            // Check if the player is out of boats (game over)
            if (isGameOver(playerBoard)) {
                gameOver = true;
                System.out.println("Enemy wins!");
                break;
            }

 
        }
        
        // Print elapsed time

        System.out.printf("Total game time: %s%n", elapsedTime);
    
    }
            
    public static void placeBoats(Board board, Boat boat, int row, int col) {
        if (board.addBoat(row, col, boat)) {
            System.out.println(boat.getDescription() + " added successfully.");
        } else {
            System.out.println("Failed to add " + boat.getDescription());
        }
    }

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


