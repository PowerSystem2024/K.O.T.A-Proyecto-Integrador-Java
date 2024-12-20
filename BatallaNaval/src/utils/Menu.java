package utils;

import game.Game;
import java.util.Scanner;

public class Menu {

    public void showMenu() {
        System.out.println("Starting the menu"); // Mensaje de depuración
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("----- Main Menu -----");
            System.out.println("1. Play");
            System.out.println("2. Game Rules");
            System.out.println("3. Credits");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        iniciarJuego(); // Llamada al método que inicia el juego
                        break;
                    case 2:
                        showRules();
                        break;
                    case 3:
                        showCredits(); // Mostrar los créditos
                        break;
                    case 4:
                        System.out.println("Thank you for playing Battleship! We hope you enjoyed the adventure. See you next time!");
                        scanner.close();
                        break;

                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } else {
                System.out.println("Please, enter a valid number.");
                scanner.next(); // Limpiar la entrada incorrecta
            }
        } while (opcion != 4);

        
    }

    private void iniciarJuego() {
        System.out.println("Starting the game...");
        Game newGame = new Game();
        newGame.gameLoop(); // Creamos el loop del juego
    }

    private void showRules() {
        // Llamamos a la clase GameRules para mostrar las reglas
        GameRules gameRules = new GameRules();
        gameRules.showRules();
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    private void showCredits() {
        // Llamamos a la clase Credits para mostrar los créditos
        Credits credits = new Credits();
        credits.mostrarCreditos();
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); // Esperar a que presionen Enter
    }
}
