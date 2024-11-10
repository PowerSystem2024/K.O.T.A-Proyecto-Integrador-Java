package boats;

public class Destroyer extends Boat {
    private static final String NAME = "Destroyer";
    private static final int DESTROYER_LENGHT  = 4;
    private static final char DESTROYER_CHAR  = 'D';
    
    
    public Destroyer() {
        super(NAME, DESTROYER_LENGHT, DESTROYER_CHAR);        
    }

    @Override
    public void sail() {
        System.out.println(this.getDescription()+ " is on patrol!");
    }

}