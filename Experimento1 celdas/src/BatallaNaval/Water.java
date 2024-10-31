/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BatallaNaval;

/**
 *
 * @author Mkjdf983
 */
public class Water extends Cell {
    @Override
    public String getDescription() {
        return "Water";
    }

    @Override
    public int getSpaceRequired() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public char getCharacter() {
        return '~'; // agregar una constante
    }
    

}

