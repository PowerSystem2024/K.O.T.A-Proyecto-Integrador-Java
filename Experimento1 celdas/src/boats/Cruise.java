package boats;

public class Cruise extends Boat {
    public Cruise(String name, int length) {
        super(name, length);
    }

    @Override
    public void sail() {
        System.out.println(getName() + " is cruising along the waves!");
    }

    @Override
    public int getSpaceRequired() {
        return 2; // Cruise ocupa 2 espacios
    }

    @Override
    public char getCharacter() {
        return 'C'; // Caracter que representará el barco
    }
}
