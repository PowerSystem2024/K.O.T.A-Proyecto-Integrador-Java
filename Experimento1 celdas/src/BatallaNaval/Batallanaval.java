
package BatallaNaval;
import boats.Motorboat;
import boats.Boat;
import boats.Sailboat;


public class BatallaNaval {
    public static void main(String[] args) {
        Marina marina = new Marina(10, 10);//tamaño matriz
        
        Boat sailboat1 = new Sailboat("Velero", 2);
        Boat motorboat1 = new Motorboat("Speedster", 2);

        marina.addBoat(0, 0, sailboat1);
        if (marina.addBoat(5, 5, motorboat1)) {
            System.out.println("Motorboat added successfully.");
        } else {
            System.out.println("Failed to add Motorboat.");
        }

        if (marina.addBoat(0, 2, motorboat1)) {
            System.out.println("Motorboat added successfully.");
        } else {
            System.out.println("Failed to add Motorboat.");
        }

        marina.displayCells();
    }
}

