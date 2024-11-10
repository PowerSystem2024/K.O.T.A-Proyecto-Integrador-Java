package game;

import BatallaNaval.Board;
import boats.*;
import java.util.Scanner;

public class PlayerCommander extends Commander {

    public PlayerCommander(Board board) {
        super("Player", board);
    }

    @Override
    public void placeBoats() {
        // Creamos los barcos
        Boat aircraftCarrier = new AircraftCarrier();
        Boat destroyer = new Destroyer();
        Boat submarine = new Submarine();
        Boat cruiser = new Cruise();
        Boat motorboat1 = new Motorboat();

        // Definimos un arreglo con todos los barcos para iterarlos
        Boat[] boats = { aircraftCarrier, destroyer, submarine, cruiser, motorboat1 };

        // Usamos el Scanner para pedir las coordenadas al jugador
        Scanner scanner = new Scanner(System.in);

        // Iteramos sobre los barcos
        for (Boat boat : boats) {
            boolean placed = false;  // Variable para verificar si el barco fue colocado correctamente

            while (!placed) {
            int row = -1; // Inicializamos la fila con un valor inválido
            boolean validInput = false; // Variable para rastrear si la entrada es válida

            // Pedimos y validamos la entrada de la fila
            while (!validInput) {
                System.out.printf("Enter the starting row (1-10) for your %s: ", boat.getDescription());
                if (scanner.hasNextInt()) {
                    row = scanner.nextInt() - 1;  // Convertimos de 1-10 a 0-9
                    scanner.nextLine();  // Limpiar el buffer del scanner
                    if (row >= 0 && row < board.getRowCount()) {
                        validInput = true; // Marcamos la entrada como válida si está en el rango correcto
                    } else {
                        System.out.println("Invalid row. Please enter a number between 1 and 10.");
                    }
                } else {
                    // Si la entrada no es un número, mostramos un mensaje de error y limpiamos el buffer
                    System.out.println("Invalid input. Please enter a number between 1 and 10.");
                    scanner.nextLine(); // Limpiar el buffer para evitar bucles infinitos
                }
            }

            // Pedimos la entrada de la columna
            System.out.printf("Enter the starting column (A-J) for your %s: ", boat.getDescription());
            char colChar = scanner.nextLine().toUpperCase().charAt(0);
            int col = colChar - 'A';  // Convertimos 'A'-'J' a 0-9

            // Validamos si las coordenadas están dentro de los límites del tablero
            if (col < 0 || col >= board.getColumnCount()) {
                System.out.println("Invalid column. Column must be a letter between A and J. Try again.");
                continue; // Volvemos al inicio del bucle para intentar colocar el barco nuevamente
            }

            // Intentamos agregar el barco
            if (board.addBoat(row, col, boat)) {
                placed = true;
                System.out.println(boat.getDescription() + " placed successfully!");
            } else {
                // Si no se puede colocar, mostramos un mensaje de error
                System.out.println("Invalid placement. Not enough space or position is already occupied. Try again.");
            }
        }
    }
}

    public void playerAttack(Board playerBoard) {
        // Implementación del método de ataque del jugador, aún por definir
    }
}
