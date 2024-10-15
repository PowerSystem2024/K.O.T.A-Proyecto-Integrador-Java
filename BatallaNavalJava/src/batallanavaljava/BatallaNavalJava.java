package batallanavaljava;
import java.util.Scanner;

public class BatallaNavalJava {
    private static final int TAMANO_MATRIZ = 11;
    private static final String COLUMNAS_LETRAS = " ABCDEFGHIJ";
    private static final String FILAS_NUMEROS = " 1234567890";

    public static void main(String[] args) {
        // Your code logic here
        System.out.println("Bienvenido a Batalla Naval!");
        String nombreJugador = "Pacnhito";
        
        batallaNavalLoop(nombreJugador);  
        
        
        
    }

    
    public static void batallaNavalLoop(String nombreJugador) {
        int[][] matrizJugador = new int[TAMANO_MATRIZ][TAMANO_MATRIZ];
        int[][] matrizEnemigo = new int[TAMANO_MATRIZ][TAMANO_MATRIZ];
        int[] contadorBarcosEnemigo = {0, 4, 4, 4, 2}; // Portaviones, Crucero, Submarino, Lancha
        int[] contadorBarcosJugador = {0, 4, 4, 4, 2}; // Portaviones, Crucero, Submarino, Lancha
        boolean ganar = false;
        boolean perder = false;

        // Inicialización de la matriz jugador
        for (int i = 0; i < TAMANO_MATRIZ; i++) {
            for (int j = 0; j < TAMANO_MATRIZ; j++) {
                matrizJugador[i][j] = 0;
            }
        }

        mostrarTableroJugador(matrizJugador);
        Scanner scanner = new Scanner(System.in);
        ingresarPosicionBarcoJugador(matrizJugador, scanner);
        colocarBarcosEnemigo(matrizEnemigo);
        System.out.println("\n");

        while (!ganar && !perder) {
            mostrarTableroJugadorEnemigo(matrizJugador, matrizEnemigo);
            ataqueDelJugador(matrizEnemigo, contadorBarcosEnemigo, scanner);
            ataqueDelEnemigo(matrizJugador, contadorBarcosJugador);

            // Verificar si el jugador ha ganado
            ganar = true;
            for (int i = 1; i < contadorBarcosEnemigo.length; i++) {
                if (contadorBarcosEnemigo[i] != 0) {
                    ganar = false;
                    break;
                }
            }

            // Verificar si el jugador ha perdido
            perder = true;
            for (int i = 1; i < contadorBarcosJugador.length; i++) {
                if (contadorBarcosJugador[i] != 0) {
                    perder = false;
                    break;
                }
            }
        }

        if (ganar) {
            System.out.println("\nFelicitaciones ha ganado!!!");
        } else {
            System.out.println("\nHas sido derrotado. No te rindas, vuelve a jugar.");
        }

        finDelJuego(nombreJugador);
        creditos();
    }

    // Métodos adicionales como mostrarTableroJugador, ingresarPosicionBarcoJugador, etc.
    
    public static void mostrarTableroJugador(int[][] matrizJugador) {
    System.out.println("Este es tu tablero, piensa en donde ubicar tus barcos");
    for (int i = 0; i < 10; i++) {
        System.out.print(COLUMNAS_LETRAS.charAt(i) + " ");
        for (int j = 0; j < 10; j++) {
            System.out.print(matrizJugador[i][j] == 0 ? "~" : "X");
            System.out.print(" ");
        }
        System.out.println();
    }
    System.out.println("Presiona Enter para continuar...");
    new Scanner(System.in).nextLine(); // Esperar a que el jugador presione Enter
}

public static void ingresarPosicionBarcoJugador(int[][] matriz, Scanner scanner) {
    int[] barco = {0, 4, 4, 4, 2}; // Tamaños de los barcos
    String[] nombreDeBarco = {"", "portaviones", "crucero", "submarino", "lancha"};
    
    for (int tipo = 1; tipo < barco.length; tipo++) {
        boolean posicionValida = false;

        while (!posicionValida) {
            System.out.printf("Coloque el %s en el tablero, con tamaño %d.\n", nombreDeBarco[tipo], barco[tipo]);
            mostrarTableroJugador(matriz);
            
            // Obtener columna
            int columna = 0;
            while (columna < 1 || columna > 10) {
                System.out.print("Elija en qué columna quiere colocar su barco (1-10): ");
                columna = scanner.nextInt();
            }

            // Obtener fila
            char filaChar;
            System.out.print("Elija en qué fila quiere colocar su barco (A-J): ");
            filaChar = scanner.next().toUpperCase().charAt(0);
            int fila = filaChar - 'A' + 1;

            // Verificar si la posición es válida y colocar el barco
            if ((columna + barco[tipo]) <= 10 && matriz[fila][columna] == 0) {
                for (int h = 0; h < barco[tipo]; h++) {
                    matriz[fila][columna + h] = tipo + 5; // Usar formato diferente para barcos
                }
                posicionValida = true;
                mostrarTableroJugador(matriz);
            } else {
                System.out.println("Posición no válida. Intente de nuevo.");
            }
        }
    }
}
    
public static void ataqueDelJugador(int[][] matrizEnemigo, int[] contadorBarcosEnemigo, Scanner scanner) {
    System.out.println("Ingresa la coordenada para atacar al enemigo");
    
    int columna = 0, fila = 0;
    while (columna < 1 || columna > 10) {
        System.out.print("Elija en qué columna quiere disparar (1-10): ");
        columna = scanner.nextInt();
    }
    
    char filaChar;
    System.out.print("Elija en qué fila quiere disparar (A-J): ");
    filaChar = scanner.next().toUpperCase().charAt(0);
    fila = filaChar - 'A' + 1;

    // Verificar coordenadas
    switch (matrizEnemigo[fila][columna]) {
        case 0:
            System.out.println("Le has dado al agua.");
            matrizEnemigo[fila][columna] = -1; // Representar agua
            break;
        case 6:
            System.out.println("Genial, le diste a la lancha del enemigo.");
            matrizEnemigo[fila][columna] = -6; // Lancha dañada
            contadorBarcosEnemigo[4]--;
            break;
        // Agregar casos para otros barcos
        default:
            System.out.println("Ya has atacado aquí, turno del enemigo.");
            break;
    }
}

public static void ataqueDelEnemigo(int[][] matrizJugador, int[] contadorBarcosJugador) {
    int fila, columna;

    do {
        fila = (int) (Math.random() * 10) + 1; // 1-10
        columna = (int) (Math.random() * 10) + 1; // 1-10
    } while (matrizJugador[fila][columna] < 0); // Asegúrate de que no haya sido atacado antes

    // Verificar coordenadas
    switch (matrizJugador[fila][columna]) {
        case 0:
            System.out.println("El enemigo le ha dado al agua.");
            matrizJugador[fila][columna] = -1; // Representar agua
            break;
        case 6:
            System.out.println("El enemigo ha dañado tu lancha.");
            matrizJugador[fila][columna] = -6; // Lancha dañada
            contadorBarcosJugador[4]--;
            break;
        // Agregar casos para otros barcos
        default:
            break;
    }
}

    public static void colocarBarcosEnemigo(int[][] matrizEnemigo) {
        int[] barco = new int[5];
        int[] formatos = new int[5];
        
        // Inicializar la matriz con agua (0 representa agua)
        for (int i = 1; i <= SIZE; i++) {
            for (int j = 1; j <= SIZE; j++) {
                matrizEnemigo[i][j] = 0;
            }
        }

        // Definir tamaños y formatos para cada tipo de barco
        barco[1] = 4; // tamaño del portaviones
        barco[2] = 4; // tamaño del crucero
        barco[3] = 4; // tamaño del submarino
        barco[4] = 2; // tamaño de la lancha

        formatos[1] = 9; // formato del portaviones
        formatos[2] = 8; // formato del crucero
        formatos[3] = 7; // formato del submarino
        formatos[4] = 6; // formato de la lancha

        // Colocar cada barco automáticamente
        for (int tipo = 1; tipo <= 4; tipo++) {
            boolean posicionOcupada;

            do {
                int columna = random.nextInt(10 - barco[tipo] + 1) + 1; // Columna aleatoria
                int fila = random.nextInt(10) + 1; // Fila aleatoria
                posicionOcupada = false;

                // Verificar si la posición está ocupada
                if (columna + barco[tipo] > 11) {
                    posicionOcupada = true;
                } else {
                    int i = 0;
                    while (i < barco[tipo] && !posicionOcupada) {
                        if (matrizEnemigo[fila][columna + i] != 0) {
                            posicionOcupada = true;
                        }
                        i++;
                    }
                }
            } while (posicionOcupada);

            // Colocar el barco en la matriz
            for (int h = 0; h < barco[tipo]; h++) {
                matrizEnemigo[fila][columna + h] = formatos[tipo];
            }
        }

        // Indicar al jugador que los barcos enemigos están siendo colocados
        System.out.println("El enemigo colocará sus barcos en el tablero");
        System.out.println("Presione ENTER para continuar");
        
        // Esperar la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        // Mostrar la matriz con los barcos colocados automáticamente
        System.out.println("Los barcos han sido colocados correctamente:");
        for (int i = 1; i <= SIZE; i++) {
            for (int j = 1; j <= SIZE; j++) {
                System.out.print(matrizEnemigo[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Presione ENTER para continuar");
        scanner.nextLine();
        System.out.println();
    }

public static void finDelJuego(String nombreJugador) {
    System.out.println("Gracias por jugar, " + nombreJugador + "!");
}

public static void creditos() {
    System.out.println("Desarrollado por [Tu Nombre]");
}

}

