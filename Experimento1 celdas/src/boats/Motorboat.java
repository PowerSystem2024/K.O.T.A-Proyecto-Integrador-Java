/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boats;


public class Motorboat extends Boat {
    public Motorboat(String name, int length) {
        super(name, length); // Call the constructor of the parent class
    }

    @Override
    public void sail() {
        System.out.println(getName() + " is cruising with the engine!");
    }

    @Override
    public int getSpaceRequired() {
        return 3; // Motorboat occupies 3 spaces
    }

    @Override
    public char getCharacter() {
        return 'L';
    }

}