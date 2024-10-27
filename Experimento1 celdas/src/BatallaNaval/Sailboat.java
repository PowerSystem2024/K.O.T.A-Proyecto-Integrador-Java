/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BatallaNaval;

/**
 *
 * @author Mkjdf983
 */
public class Sailboat extends Boat {
    @Override
    public String getDescription() {
        return "Sailboat";
    }

    public void sail() {
        System.out.println("Sailing with the wind!");
    }

    @Override
    public int getSpaceRequired() {
        return 2; // occupies 1 space
    }
}
