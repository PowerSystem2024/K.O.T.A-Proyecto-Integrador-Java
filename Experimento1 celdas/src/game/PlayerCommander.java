package game;

import BatallaNaval.Board;
import boats.*;
import java.util.Scanner;
import utils.CleanScreen;

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
        Boat[] boats = {aircraftCarrier, destroyer, submarine, cruiser, motorboat1};

        // Usamos el Scanner para pedir las coordenadas al jugador
        Scanner scanner = new Scanner(System.in);

        // Iteramos sobre los barcos
        for (Boat boat : boats) {
            boolean placed = false;  // Variable para verificar si el barco fue colocado correctamente

            while (!placed) {
                String input;
                int row = -1;  // Inicializamos la fila con un valor inválido
                int col = -1;  // Inicializamos la columna con un valor inválido
                boolean validInput = false; // Variable para rastrear si la entrada es válida

                // Pedimos y validamos la entrada de la coordenada (por ejemplo, A1)
                while (!validInput) {
                    System.out.printf("Enter the starting position (e.g., A1) for your %s: ", boat.getDescription());
                    input = scanner.nextLine().toUpperCase();

                    // Verificamos si la entrada tiene el formato correcto
                    if (input.length() >= 2) {
                        char rowChar = input.charAt(0);  // La letra es la fila
                        String colStr = input.substring(1);  // El número es la columna

                        // Validamos la fila (letra)
                        if (rowChar >= 'A' && rowChar <= 'J') {
                            row = rowChar - 'A';  // Convertimos la letra en un índice de fila (0-9)
                        } else {
                            System.out.println("Invalid row. Please enter a letter between A and J.");
                            continue;
                        }

                        // Validamos la columna (número)
                        try {
                            col = Integer.parseInt(colStr) - 1;  // Convertimos de 1-10 a 0-9
                            if (col < 0 || col >= board.getColumnCount()) {
                                System.out.println("Invalid column. Please enter a number between 1 and 10.");
                                continue;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid column. Please enter a valid number between 1 and 10.");
                            continue;
                        }

                        validInput = true;  // Entrada válida
                    } else {
                        System.out.println("Invalid input. Please enter a valid coordinate (e.g., A1).");
                    }
                }

                // Verificamos si hay suficiente espacio para colocar el barco horizontalmente
                if (col + boat.getLength() <= board.getColumnCount()) {
                    boolean canPlace = true;

                    // Comprobamos si hay espacio suficiente y si el área está libre
                    for (int i = 0; i < boat.getLength(); i++) {
                        if (board.getCell(row, col + i) instanceof Boat) {
                            canPlace = false;  // Si hay un barco en la posición, no se puede colocar
                            break;
                        }
                    }

                    if (canPlace) {
                        // Colocamos el barco
                        for (int i = 0; i < boat.getLength(); i++) {
                            board.addBoat(row, col + i, boat);  // Colocamos el barco de manera horizontal
                        }
                        placed = true;
                        System.out.println(boat.getDescription() + " placed successfully!");
                    } else {
                        // Aquí solo mostramos un mensaje genérico sin detalles específicos
                        System.out.println("Position already occupied or out of bounds. Please try again.");
                    }
                } else {
                    // Mensaje si no hay suficiente espacio en la fila
                   
                }
            }
        }
    }

    public void playerAttack(Board playerBoard) {
        // Implementación del método de ataque del jugador, aún por definir
    }
}
