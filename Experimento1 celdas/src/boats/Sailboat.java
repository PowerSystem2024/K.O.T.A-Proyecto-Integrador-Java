/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boats;

import boats.Boat;

/**
 *
 * @author Mkjdf983
 */
public class Sailboat extends Boat {
    public Sailboat(String name, int length) {
        super(name, length); // Call the constructor of the parent class
    }

    @Override
    public void sail() {
        System.out.println(getName() + " is sailing with the wind!");
    }

    @Override
    public int getSpaceRequired() {
        return 2; // Sailboat occupies 1 space
    }

    @Override
    public char getCharacter() {
        return 'L'; 
    }
}
