/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package battleship1;

import java.util.Scanner;

/**
 *
 * @author MBradshaw
 */
public class GetMarkerView {
      private final Game game; 
    
    /*
     * default constructor
     */
    public GetMarkerView(Game game) {
        this.game = game;
        
    } 
    
    public String getInput(Players player) {

        String newMarker = null;
        Scanner in = new Scanner(System.in);
                
        boolean valid = false; // flag to indicate if valid character entered
        while (!valid) {
            // prompt for input
            System.out.println("\n\t" + player.name 
                    + ", enter a single character that will be used to mark "
                    + "your ships in the game.");
            
            // get input from user           
            newMarker = in.nextLine();
           
            // no marker entered?
            if (newMarker == null  || newMarker.length() < 1) {
                continue;
            }
            
            // grab only the first character and convert it to upper case
            newMarker = newMarker.substring(0, 1).toUpperCase();
            
            if (newMarker.equals("Q")) { // Quit?
                return null;
            }
            
            // Check to see if the marker is already in use
            if (this.game.playerA.marker.equals(newMarker) ||
                    this.game.playerB.marker.equals(newMarker) ) {
                new BattleshipsError().displayError(
                        "This marker is currently in use. " +
                                "Select a different character");
                continue; 
            } else {
            }
            
            valid = true; // signal that a valid marker was entered
        }
        
        return newMarker;
    }
    
}


