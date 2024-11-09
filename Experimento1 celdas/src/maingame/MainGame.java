package maingame;

import java.util.Scanner;
import utils.StartAnimation;

public class MainGame {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        // Mostrar mensaje para mejorar la experiencia
        System.out.println("To enhance your gaming experience, double-click on the Output window of the console to maximize it to full screen.");
        System.out.println("Then, press Enter to continue...");

        // Esperar a que el usuario presione Enter
        scanner.nextLine();

        // Iniciar la animación
        StartAnimation startAnimation = new StartAnimation();
        startAnimation.mostrar();

        // Mostrar el Menu del juego
        utils.Menu menu = new utils.Menu();
        menu.showMenu();
    }
}
