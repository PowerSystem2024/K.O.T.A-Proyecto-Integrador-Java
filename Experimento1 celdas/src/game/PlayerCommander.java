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
                // Pedimos las coordenadas para colocar el barco
                System.out.printf("Enter the starting row (0-%d) for your %s: ", board.getRowCount() - 1, boat.getDescription());
                int row = scanner.nextInt();
                System.out.printf("Enter the starting column (0-%d) for your %s: ", board.getColumnCount() - 1, boat.getDescription());
                int col = scanner.nextInt();

                // Intentamos agregar el barco, si addBoat devuelve true, el barco se coloca correctamente
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
