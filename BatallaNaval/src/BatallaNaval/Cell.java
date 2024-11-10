package BatallaNaval;

public abstract class Cell {
    private boolean isHit = false; // Atributo para saber si fue disparada
    protected final char CELL_CHAR; // Carácter constante para la celda
    private static final char CELL_IS_HIT_CHAR = 'X';

    // Constructor que recibe el carácter inicial para la celda
    public Cell(char CELL_CHAR) {
        this.CELL_CHAR = CELL_CHAR;
    }

    public void setHit(boolean isHit) {
        this.isHit = isHit;
    }

    public boolean isHit() {
        return isHit;
    }

    // Método para devolver 'X' si fue disparada, o el carácter de la celda si no
    public char getCharacter() {
        return isHit ? CELL_IS_HIT_CHAR : CELL_CHAR;
    }

    public char getCELL_CHAR() {
        return CELL_CHAR;
    }
    // uso este por si necesito imprimir en consola sout me daba erro co nel CHAR
    public String getCELL_CHARAsString() {
        return String.valueOf(getCELL_CHAR());
    }

    // Método abstracto para obtener la descripción de la celda
    public abstract String getDescription();

    // Método abstracto para obtener el espacio requerido por la celda
    public abstract int getSpaceRequired();


    
    
    
}