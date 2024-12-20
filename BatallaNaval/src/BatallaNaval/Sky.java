package BatallaNaval;

public class Sky extends Cell {
    private static final String NAME = "Sky";
    private static final int LENGTH = 1;
    private static final char CHARACTER = ' ';
    
    
    public Sky() {
        super(CHARACTER);
    }
    @Override
    public String getDescription() {
        return NAME;
    }

    @Override
    public int getSpaceRequired() {
        return LENGTH; // Sky occupies one space
    }

}
