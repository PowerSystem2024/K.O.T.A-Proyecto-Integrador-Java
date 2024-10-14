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

    public static void ingresarPosicionBarcoJugador(int[][] matriz) {
        int columna = 12, fila = 12;
        boolean posicionOcupada, encontrado;
        int[] barco = {0, 4, 4, 4, 2};  // Tamaño de los barcos
        int[] formatos = {0, 9, 8, 7, 6}; // Formatos de los barcos
        String[] nombreDeBarco = {"", "portaviones", "crucero", "submarino", "lancha"};

        // Colocar los barcos
        for (int tipo = 1; tipo <= 4; tipo++) {
            boolean esPosicionValida = false;
            while (!esPosicionValida) {
                System.out.print("Coloque el " + nombreDeBarco[tipo] + " en el tablero, con tamaño " + barco[tipo] + ".");

                // Solicitar columna al usuario
                columna = solicitarColumna();

                // Solicitar fila al usuario
                fila = solicitarFila();

                // Verificar si el barco cabe en la posición
                if ((columna + barco[tipo]) > 10) {
                    System.out.println("El " + nombreDeBarco[tipo] + " se ubicaría fuera del tablero, elija otra ubicación.");
                    System.out.println();
                } else {
                    // Verificar si hay un barco en esa posición
                    posicionOcupada = false;
                    for (int i = 0; i < barco[tipo]; i++) {
                        if (matriz[fila][columna + i] != 0) {
                            posicionOcupada = true;
                            break;
                        }
                    }
                    if (posicionOcupada) {
                        System.out.println("Ya hay un barco en esta posición, elija otra.");
                        System.out.println();
                    } else {
                        esPosicionValida = true;
                    }
                }
            }

            // Colocar el barco en la matriz
            for (int i = 0; i < barco[tipo]; i++) {
                matriz[fila][columna + i] = formatos[tipo];
            }

            System.out.println("El barco ha sido colocado en la posición (" + columna + "," + COLUMNAS.charAt(fila) + ").");
            mostrarTableroJugador(matriz);
            System.out.println();
        }
    }

    public static int solicitarColumna() {
        String dato;
        boolean encontrado;
        int columna = -1;

        do {
            mostrarTableroJugador(new int[10][10]);  // Asume que la matriz se pasa para ser mostrada
            System.out.print("Elija en qué columna quiere colocar su barco (1-10): ");
            dato = sc.next();

            encontrado = false;
            for (int i = 1; i <= 10; i++) {
                if (String.valueOf(i).equals(dato)) {
                    encontrado = true;
                    columna = i;
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("El valor dado está fuera del rango.");
            }
        } while (!encontrado);

        return columna;
    }

    public static int solicitarFila() {
        String dato;
        boolean encontrado;
        int fila = -1;

        do {
            System.out.print("Elija en qué fila quiere colocar su barco (A-J): ");
            dato = sc.next().toUpperCase();

            encontrado = false;
            for (int i = 1; i <= 10; i++) {
                if (String.valueOf(COLUMNAS.charAt(i)).equals(dato)) {
                    encontrado = true;
                    fila = i;
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("El valor dado está fuera del rango.");
            }
        } while (!encontrado);

        return fila;
    }

    public static void mostrarTableroJugador(int[][] matriz) {
        // Implementa aquí la lógica para mostrar el tablero
        // Ejemplo básico:
        System.out.println("Tablero del jugador:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrizJugador = new int[10][10];
        ingresarPosicionBarcoJugador(matrizJugador);
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

public class Juego {
    public static void finDelJuego(String nombre_jugador) {
        Scanner entrada = new Scanner(System.in);
        String tecla;
        
        //Mostar mensaje de agradecimiento al usuario
        System.out.println();
        System.out.println("¡Gracias por jugar, "+ nombre_jugador +"!Esperamos que hayas disfrutado del juego.");
        System.out.println("Recuerda: Si lo puedes imaginar, lo puedes programar.");
        System.out.println("Ariel Betancud");
        System.out.println();
        System.out.println("Presiona enter para continuar...");
        tecla = entrada.nextLine(); //Leer la tecla enter para continuar
        
        // Simular borrar pantalla (puedes cambiar esta parte si deseas)
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}