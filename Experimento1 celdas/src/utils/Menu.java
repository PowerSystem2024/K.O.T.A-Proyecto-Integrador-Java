package utils;

import java.util.Scanner;
import test.TestBatallaNaval;

public class Menu {

    public void showMenu() {
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
                        System.out.println("Exiting the game. See you soon!");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } else {
                System.out.println("Please, enter a valid number.");
                scanner.next(); // Limpiar la entrada incorrecta
            }
        } while (opcion != 4);

        scanner.close();
    }

    private void iniciarJuego() {
        System.out.println("Starting the game...");
        TestBatallaNaval.main(new String[]{}); // Llama al método main de la clase TestBatallaNaval
    }

    private void showRules() {
        // Llamamos a la clase GameRules para mostrar las reglas
        GameRules gameRules = new GameRules();
        gameRules.showRules();
    }

    private void showCredits() {
        // Llamamos a la clase Credits para mostrar los créditos
        Credits credits = new Credits();
        credits.mostrarCreditos();
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); // Esperar a que presionen Enter
    }
}
