package boats;

import BatallaNaval.Cell;

public abstract class Boat extends Cell {
    private String name;
    private int length;

    public Boat(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    // Método abstracto para ser implementado por las subclases
    public abstract void sail();

    @Override
    public abstract int getSpaceRequired(); // Método abstracto para requerimiento de espacio

    @Override
    public abstract char getCharacter(); // Método abstracto para el carácter que representa al barco

    @Override
    public String getDescription() {
        return name; // Devuelve el nombre del barco como descripción
    }
}
