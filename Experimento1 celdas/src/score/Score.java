/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package score;


/**
 *
 * @author Mkjdf983
 */
public class Score {
    private int playerScore;
    private int enemyScore;

    // Constructor inicializa ambos puntajes en 0
    public Score() {
        this.playerScore = 0;
        this.enemyScore = 0;
    }

    // Incrementar el puntaje del jugador (cuando acierta en el tablero enemigo)
    public void incrementPlayerScore() {
        playerScore++;
    }

    // Incrementar el puntaje del enemigo (cuando el jugador es alcanzado)
    public void incrementEnemyScore() {
        enemyScore++;
    }

    // Obtener el puntaje del jugador
    public int getPlayerScore() {
        return playerScore;
    }

    // Obtener el puntaje del enemigo
    public int getEnemyScore() {
        return enemyScore;
    }

    // Mostrar el puntaje actual de ambos jugadores
    public void displayScore() {
        System.out.println("Player Score: " + playerScore);
        System.out.println("Enemy Score: " + enemyScore);
    }
    

}

