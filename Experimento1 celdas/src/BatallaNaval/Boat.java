/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BatallaNaval;

/**
 *
 * @author Mkjdf983
 */
public class Boat extends Cell {
    private String description;
    private int size;
    private boolean[] destroyed;

    public Boat(String description, int size, boolean[] destruido) {
        this.description = description;
        this.size = size;
        this.destroyed = destruido;
    }
    
    public void destroying(int size)
    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public int getSpaceRequired() {
        return this.size;
    }

}