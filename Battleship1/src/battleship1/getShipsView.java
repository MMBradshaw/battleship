/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package battleship1;

import java.util.Arrays;
import java.util.Scanner;


/**
 *
 * @author Niethy
 */
class getShipsView {
      private final Game game; 
    
    /*
     * default constructor
     */
    public getShipsView(Game game) {
        this.game = game;
        
    } 
    
    public String getInput(Players player) {

        String newShips = null;
        Scanner in = new Scanner(System.in);
                
        boolean valid = false; // flag to indicate if valid character entered
        while (!valid) {
            // prompt for input
            System.out.println("\n\t" + player.name 
                    + ", enter a single character that will be used to mark "
                    + "your ships in the game.");
            
            // get input from user           
            newShips = in.nextLine();
           
            // no Ship entered?
            if (newShips == null  || newShips.length() < 1) {
                continue;
            }
            
            // grab only the first character and convert it to upper case
            newShips = newShips.substring(0, 1).toUpperCase();
            
            if (newShips.equals("Q")) { // Quit?
                return null;
            }
            
            // Check to see if the Ship is already in use
            if (this.game.playerA.Ship.equals(newShips) ||
                this.game.playerB.Ship.equals(newShips) ) {
               new BattleshipsError().displayError(
                        "This Ship is currently in use. " +
                        "Select a different character");
               continue; 
            }
            
            valid = true; // signal that a valid Ship was entered
        }
        
        return newShips;
    }
    
}
