package boats;

public class AircraftCarrier extends Boat {
    private static final String NAME = "Aircraft Carrier";
    private static final int AIRCRAFT_LENGHT  = 5;
    private static final char AIRCRAFT_CHAR  = 'A';
    
    public AircraftCarrier() {
        super(NAME, AIRCRAFT_LENGHT , AIRCRAFT_CHAR ); // Establecer carácter específico para el Aircraft Carrier

    }

    @Override
    public void sail() {
        System.out.println(getDescription() + " is launching aircrafts!");
    }
}




