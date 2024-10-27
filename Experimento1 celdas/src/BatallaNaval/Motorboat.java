/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BatallaNaval;


public class Motorboat extends Boat {
    @Override
    public String getDescription() {
        return "Motorboat";
    }

    public void sail() {
        System.out.println("Cruising with the engine!");
    }

    @Override
    public int getSpaceRequired() {
        return 3; // occupies 3 spaces
    }
}
