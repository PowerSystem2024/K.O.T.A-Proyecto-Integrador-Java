package boats;

import BatallaNaval.Cell;
import java.util.ArrayList;
import java.util.List;

public abstract class Boat extends Cell {
    private final String name;
    private final int length;  // El tamaño del barco
    private final boolean[] hitSections;  // Array para hacer seguimiento de las secciones impactadas
    private final List<int[]> positions;  // Lista para hacer seguimiento de las coordenadas exactas de cada sección

    // Constructor que inicializa el barco con su nombre, longitud y carácter
    public Boat(String name, int length, char character) {
        super(character);  // Llamamos al constructor de la clase padre (Cell)
        this.name = name;
        this.length = length;
        this.hitSections = new boolean[length];  // Inicializamos el array para las secciones impactadas
        this.positions = new ArrayList<>();  // Inicializamos la lista para las posiciones
    }

    // Método para obtener el tamaño del barco
    public int getSize() {
        return length;
    }
    // Método público para acceder a la longitud del barco
    public int getLength() {
        return length;
    }

    @Override
    public String getDescription() {
        return name;
    }

    @Override
    public int getSpaceRequired() {
        return length;
    }

    // Marcar una sección como impactada
    public void hitSection(int sectionIndex) {
        if (sectionIndex >= 0 && sectionIndex < length) {
            hitSections[sectionIndex] = true;
        }
    }
    
    // Buscar el índice de la sección de un barco basado en las coordenadas (fila y columna)
    public int getSectionIndex(int row, int column) {
        for (int i = 0; i < positions.size(); i++) {
            int[] position = positions.get(i);
            if (position[0] == row && position[1] == column) {
                return i;  // Retorna el índice de la sección
            }
        }
        return -1;  // Si no pertenece a este barco
    }

    // Obtener el carácter de la sección del barco, dependiendo de si está impactada o no
    public char getSectionCharacter(int sectionIndex) {
        return hitSections[sectionIndex] ? 'X' : CELL_CHAR;
    }

    // Agregar la posición de una sección del barco en el tablero
    public void addPosition(int row, int col) {
        positions.add(new int[]{row, col});
    }

    // Obtener las posiciones del barco (todas las celdas ocupadas por el barco)
    public List<int[]> getPositions() {
        return positions;
    }

    // Verificar si el barco está completamente hundido (todas las secciones están impactadas)
    public boolean isSunk() {
        for (boolean hit : hitSections) {
            if (!hit) {
                return false;  // Si hay al menos una sección no impactada, el barco no está hundido
            }
        }
        return true;  // Si todas las secciones están impactadas, el barco está hundido
    }

    public boolean[] getHitSections() {
        return hitSections;
    }

    // Método abstracto para navegar, específico de cada tipo de barco (subclases de Boat)
    public abstract void sail();
    
    // Método que devuelve un booleano del array de hitSections
    public boolean getHitSection(int sectionIndex) {
        if (sectionIndex >= 0 && sectionIndex < hitSections.length) {
            return hitSections[sectionIndex];  // Verificamos si la sección está impactada
        } else {
            System.out.println("Invalid section index: " + sectionIndex);  // En caso de un índice inválido
            return false;
        }
    }
}
