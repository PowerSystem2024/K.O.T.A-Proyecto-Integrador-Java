package utils;

public class GameRules {

    public static void showRules() {
        System.out.println("\n----- Game Rules -----");
        System.out.println("1. The objective of the game is to sink all of the opponent's ships.");
        System.out.println("2. The game is played on a 10x10 grid.");
        System.out.println("3. Each player places 5 ships on the board: Aircraft Carrier (5 spaces),");
        System.out.println("   Destroyer (4 spaces), Submarine (3 spaces), Cruiser (2 spaces),");
        System.out.println("   and Motorboat (1 space). Ships cannot overlap and must be placed entirely.");
        System.out.println("4. Players take turns attacking the opponent's board by calling out coordinates.");
        System.out.println("5. Coordinates are in the format <Letter><Number> (e.g., A1, B3).");
        System.out.println("6. When a player hits an opponent's ship, the ship takes damage.");
        System.out.println("7. If all parts of a ship are hit, the ship is considered sunk.");
        System.out.println("8. The game ends when all of a player's ships are sunk.");
        System.out.println("9. The first player to sink all the opponent's ships wins the game.");
        System.out.println("10. Players must stay alert, and every attack counts!");
        System.out.println("11. Remember, the enemy may attack back after your turn.");
        System.out.println();
    }
}
