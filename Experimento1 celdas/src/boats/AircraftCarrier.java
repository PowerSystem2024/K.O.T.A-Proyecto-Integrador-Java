package boats;

public class AircraftCarrier extends Boat {
    public AircraftCarrier(String name, int length) {
        super(name, length); // Llama al constructor de la clase padre
    }

    @Override
    public void sail() {
        System.out.println(getName() + " is launching aircrafts!");
    }

    @Override
    public int getSpaceRequired() {
        return 5; // AircraftCarrier ocupa 5 espacios
    }

    @Override
    public char getCharacter() {
        return 'A'; // Caracter que representará el barco
    }
}
