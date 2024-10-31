package BatallaNaval;

public class Sky extends Cell {
    @Override
    public String getDescription() {
        return "Sky";
    }

    @Override
    public int getSpaceRequired() {
        return 1; // Sky occupies one space
    }

    @Override
    public char getCharacter() {
        return ' '; // Represents the sky (could be a space or any other character)
    }
}
