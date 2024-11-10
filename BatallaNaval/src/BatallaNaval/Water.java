package BatallaNaval;

public class Water extends Cell { 
    
    private static final String NAME = "Water";
    private static final int LENGTH = 1;
    private static final char CHARACTER = '~';
    
    public Water() {
        super(CHARACTER);
    }
    @Override
    public String getDescription() {
        return NAME;
    }

    @Override
    public int getSpaceRequired() {
        return LENGTH; // Water occupies one space
    }

}
