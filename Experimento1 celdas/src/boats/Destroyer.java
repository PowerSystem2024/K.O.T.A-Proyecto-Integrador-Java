package boats;

public class Destroyer extends Boat {
    public Destroyer(String name, int length) {
        super(name, length);        
    }

    @Override
    public void sail() {
        System.out.println(getName() + " is on patrol!");
    }

    @Override
    public int getSpaceRequired() {
        return this.getLength(); // Destroyer ocupa 4 espacios
    }

    @Override
    public char getCharacter() {
        return 'D'; // Caracter que representará el barco
    }
}
