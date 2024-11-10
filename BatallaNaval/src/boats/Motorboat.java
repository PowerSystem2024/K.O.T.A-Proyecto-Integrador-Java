package boats;


// La clase Motorboat extiende la clase Boat
public class Motorboat extends Boat {
    private static final String NAME = "Motorboat";
    private static final int MOTORBOAT_LENGHT  = 1;
    private static final char MOTORBOAT_CHAR  = 'M';

    public Motorboat() {
        super(NAME, MOTORBOAT_LENGHT, MOTORBOAT_CHAR); // Llama al constructor de la clase padre (Boat)
    }

    @Override
    public void sail() {
        System.out.println(this.getDescription()+ " is speeding through the water!"); // Mensaje cuando el motorboat navega
    }
}
