package boats;

public class Submarine extends Boat {
    public Submarine(String name, int length) {
        super(name, length);
    }

    @Override
    public void sail() {
        System.out.println(getName() + " is diving underwater!");
    }

    @Override
    public int getSpaceRequired() {
        return 3; // Submarine ocupa 3 espacios
    }

    @Override
    public char getCharacter() {
        return 'S'; // Caracter que representará el barco
    }
}
