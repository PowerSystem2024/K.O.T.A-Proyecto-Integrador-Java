package boats;

public class Cruise extends Boat {
    
    private static final String NAME = "Cruise";
    private static final int CRUISE_LENGHT  = 2;
    private static final char CRUISE_CHAR  = 'C';
    
    public Cruise() {
        super(NAME, CRUISE_LENGHT,CRUISE_CHAR );  
        
    }

    @Override
    public void sail() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
