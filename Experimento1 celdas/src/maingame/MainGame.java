package maingame;

import utils.StartAnimation;

public class MainGame {
    public static void main(String[] args) {
        try {
            // Mostrar la animación al inicio del juego
            StartAnimation animacion = new StartAnimation();
            animacion.mostrar();  // Llamar al método que muestra la animación

            // Continuar con el flujo del juego
            utils.Menu menu = new utils.Menu();
            menu.showMenu();  // Mostrar el menú
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
