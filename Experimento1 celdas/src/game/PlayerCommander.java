/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;
import BatallaNaval.Board;
import boats.*;

public class PlayerCommander extends Commander {
    
    public PlayerCommander(Board board) {
        super("Player", board);
    }

    @Override
    public void placeBoats() {
        Boat aircraftCarrier = new AircraftCarrier();
        Boat destroyer = new Destroyer();
        Boat submarine = new Submarine();
        Boat cruiser = new Cruise();
        Boat motorboat1 = new Motorboat();

        // Place the boats on the player's board (you could ask the player for coordinates or place them randomly)
        board.addBoat(0, 0, aircraftCarrier);
        board.addBoat(5, 5, destroyer);
        board.addBoat(2, 3, submarine);
        board.addBoat(7, 1, cruiser);
        board.addBoat(9, 9, motorboat1);
    }
    
    public void playerAttack(Board playerBoard){
        
    }
}

