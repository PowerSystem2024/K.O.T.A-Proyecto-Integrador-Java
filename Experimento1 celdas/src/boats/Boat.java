/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boats;

import BatallaNaval.Cell;



public abstract class Boat extends Cell {
    private String name;
    private int length; // Length in meters
    private char character;
    private boolean[] destruido;

    public Boat(String name, int length) {
        this.name = name;
        this.length = length;
        this.destruido = new boolean[length];
    }


    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String getDescription() {
        return name;
    }
    

            
    public abstract void sail(); // Abstract method to be implemented by subclasses

    @Override
    public abstract char getCharacter();
 
    @Override
    public abstract int getSpaceRequired(); // Abstract method for space requirement
}










/*
public class Boat extends Cell {
    private String description;
    private int size;
    private boolean[] destroyed;

    public Boat(String description, int size, boolean[] destruido) {
        this.description = description;
        this.size = size;
        this.destroyed = destruido;
    }
    
    //public void destroying(int size)
    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public int getSpaceRequired() {
        return this.size;
    }

}
*/
