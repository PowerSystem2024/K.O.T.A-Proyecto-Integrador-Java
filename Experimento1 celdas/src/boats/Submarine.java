package boats;

public class Submarine extends Boat {
    private static final String NAME = "Submarine";
    private static final int SUBMARINE_LENGHT  = 3;
    private static final char SUBMARINE_CHAR  = 'S';
    
    public Submarine() {
        super(NAME, SUBMARINE_LENGHT, SUBMARINE_CHAR);
    }

    
    @Override
    public void sail() {
        System.out.println(this.getDescription()+ " is diving underwater!");
    }

}
