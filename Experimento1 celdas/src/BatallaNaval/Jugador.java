package BatallaNaval;

import java.util.Scanner;

public class Jugador {
    private Marina marina;
    private Scanner scanner;

    public Jugador(Marina marina) {
        this.marina = marina;
        this.scanner = new Scanner(System.in);
    }
    
    public Jugador(Marina marina) {
        this.marina = marina;
        this.scanner = new Scanner(System.in);
    }
    public void colocarBarcos() {
        // Puedes agregar un arreglo de barcos aquí si lo deseas
        Boat[] barcos = {
            new AircraftCarrier("Aircraft Carrier", 5),
            new Destroyer("Destroyer", 4),
            new Submarine("Submarine", 3),
            new Cruise("Cruise", 2),
            new Motorboat("Speedster", 1)
        };

        for (Boat barco : barcos) {
            boolean colocado = false;
            while (!colocado) {
                System.out.println("Coloca tu barco: " + barco.getDescription());
                System.out.print("Ingresa la fila (0-" + (marina.getRowCount() - 1) + "): ");
                int fila = scanner.nextInt();
                System.out.print("Ingresa la columna (0-" + (marina.getColumnCount() - 1) + "): ");
                int columna = scanner.nextInt();

                colocado = marina.addBoat(fila, columna, barco);
                if (!colocado) {
                    System.out.println("No se pudo colocar el barco. Intenta de nuevo.");
                } else {
                    System.out.println(barco.getDescription() + " colocado en (" + fila + ", " + columna + ")");
                }
            }
        }
    }
}
