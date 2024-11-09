package utils;

public class StartAnimation {

    public void mostrar() throws InterruptedException {
        String[] logo = new String[24];

        // Carga manual del logo para la animación
        logo[0] = "      8 888888888o           .8.    8888888 8888888888    .8.          8 8888         8 8888                  .8.";
        logo[1] = "      8 8888    `88.        .888.         8 8888         .888.         8 8888         8 8888                 .888.";
        logo[2] = "      8 8888     `88       :88888.        8 8888        :88888.        8 8888         8 8888                :88888.";
        logo[3] = "      8 8888     ,88      . `88888.       8 8888       . `88888.       8 8888         8 8888               . `88888.";
        logo[4] = "      8 8888.   ,88?     .8. `88888.      8 8888      .8. `88888.      8 8888         8 8888              .8. `88888.";
        logo[5] = "      8 8888888888      .8`8. `88888.     8 8888     .8`8. `88888.     8 8888         8 8888             .8`8. `88888.";
        logo[6] = "      8 8888    `88.   .8? `8. `88888.    8 8888    .8? `8. `88888.    8 8888         8 8888            .8? `8. `88888.";
        logo[7] = "      8 8888      88  .8?   `8. `88888.   8 8888   .8?   `8. `88888.   8 8888         8 8888           .8?   `8. `88888.";
        logo[8] = "      8 8888    ,88? .888888888. `88888.  8 8888  .888888888. `88888.  8 8888         8 8888          .888888888. `88888.";
        logo[9] = "      8 888888888P  .8?       `8. `88888. 8 8888. 8?       `8. `88888. 8 888888888888 8 888888888888 .8?       `8. `88888.";
        logo[10] = "                                    ";
        logo[11] = "                                    ";
        logo[12] = "                                    ";
        logo[13] = "                                                                    b.             8            .8.   `8.`888b           ,8?   .8.            8 8888";
        logo[14] = "                                                                    888o.          8           .888.   `8.`888b         ,8?   .888.           8 8888";
        logo[15] = "                                                                    Y88888o.       8          :88888.   `8.`888b       ,8?   :88888.          8 8888";
        logo[16] = "                                                                    .`Y888888o.    8         . `88888.   `8.`888b     ,8?   . `88888.         8 8888";
        logo[17] = "                                                                    8o. `Y888888o. 8        .8. `88888.   `8.`888b   ,8?   .8. `88888.        8 8888";
        logo[18] = "                                                                    8`Y8o. `Y88888o8       .8`8. `88888.   `8.`888b ,8?   .8`8. `88888.       8 8888";
        logo[19] = "                                                                    8   `Y8o. `Y8888      .8? `8. `88888.   `8.`888b8?   .8? `8. `88888.      8 8888";
        logo[20] = "                                                                    8      `Y8o. `Y8     .8?   `8. `88888.   `8.`888?   .8?   `8. `88888.     8 8888";
        logo[21] = "                                                                    8         `Y8o.`    .888888888. `88888.   `8.`8?   .888888888. `88888.    8 8888";
        logo[22] = "                                                                    8            `Yo   .8?       `8. `88888.   `8.`   .8?       `8. `88888.   8 888888888888";

        // Animación del logo línea por línea
        for (int i = 0; i < logo.length; i++) {
            clearScreen();
            for (int j = 0; j <= i; j++) {
                System.out.println(logo[j]);
            }
            Thread.sleep(200);  // Tiempo de espera ajustado para una animación fluida
        }

        // Animación para ocultar el logo en reversa
        for (int i = logo.length - 1; i >= 0; i--) {
            clearScreen();
            for (int j = 0; j <= i; j++) {
                System.out.println(logo[j]);
            }
            Thread.sleep(250);  // Tiempo ajustado para la animación inversa
        }

        // Finalmente mostrar el logo completo
        for (String line : logo) {
            System.out.println(line);
        }
    }

    // Función para simular el borrado de pantalla
    private static void clearScreen() {
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }
}
