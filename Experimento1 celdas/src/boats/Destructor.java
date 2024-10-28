/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boats;

/**
 *
 * @author Mkjdf983
 */

public class Destructor extends Barco {
    public BarcoDestructor() {
        super("Destructor", 3);
    }

    @Override
    public void recibirAtaque() {
        posicionesOcupadas++;
    }
}
