
package BatallaNaval;



public class Batallanaval {
    public static void main(String[] args) {
        Marina marina = new Marina(10, 10);

        Cell sailboat1 = new Sailboat();
        Cell motorboat1 = new Motorboat();
        Cell sky = new Sky();

        // Add sailboat at (0, 0)
        marina.addBoat(0, 0, sailboat1);
        // Add motorboat at (0, 1)
        if (marina.addBoat(5, 5, motorboat1)) {
            System.out.println("Motorboat added successfully.");
        } else {
            System.out.println("Failed to add Motorboat.");
        }

        // Optionally, add sky at (1, 0)
        marina.getCell(1, 0); // You could set this as sky if you wish

        marina.displayCells();
    }
}

