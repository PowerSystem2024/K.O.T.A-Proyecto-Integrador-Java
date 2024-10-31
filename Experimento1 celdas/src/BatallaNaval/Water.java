package BatallaNaval;

public class Water extends Cell {
    @Override
    public String getDescription() {
        return "Water";
    }

    @Override
    public int getSpaceRequired() {
        return 1; // Water occupies one space
    }

    @Override
    public char getCharacter() {
        return '~'; // agregar una constante
    }
}
