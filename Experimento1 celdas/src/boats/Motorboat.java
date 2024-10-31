package boats;

import BatallaNaval.Cell;

// La clase Motorboat extiende la clase Boat
public class Motorboat extends Boat {

    // Constructor de la clase Motorboat
    public Motorboat(String name, int length) {
        super(name, length); // Llama al constructor de la clase padre (Boat)
    }

    @Override
    public void sail() {
        System.out.println(getName() + " is speeding through the water!"); // Mensaje cuando el motorboat navega
    }

    @Override
    public int getSpaceRequired() {
        return 1; // Motorboat ocupa 1 espacio
    }

    @Override
    public char getCharacter() {
        return 'M'; // Caracter que representará el motorboat
    }
}
