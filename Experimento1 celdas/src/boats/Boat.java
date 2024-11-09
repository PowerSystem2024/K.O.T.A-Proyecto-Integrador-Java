package boats;


import BatallaNaval.Board;
import BatallaNaval.Cell;



public abstract class Boat extends Cell {
    private final String name;
    private final int length;


    public Boat(String name, int length, char character) {
        super(character); // Pasar el carácter al constructor de Cell
        this.name = name;
        this.length = length;
    }

    @Override
    public String getDescription() {
        return name;
    }

    @Override
    public int getSpaceRequired() {
        return length;
    }

    // Método abstracto sail para que cada tipo de barco lo implemente
    public abstract void sail();
    

    
    // Verifica si el barco está completamente hundido
// En la clase Boat
    public boolean isSunk(Board board) {
        for (int i = 0; i < board.getRowCount(); i++) {
            for (int j = 0; j < board.getColumnCount(); j++) {
                Cell cell = board.getCell(i, j);
                if (cell == this && !cell.isHit()) {  // Si la celda pertenece al barco y no fue atacada
                    return false;  // El barco no está hundido
                }
            }
        }
        return true;  // Todas las celdas del barco están atacadas
    }

    
}

