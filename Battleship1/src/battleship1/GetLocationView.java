/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package battleship1;

import java.awt.Point;
import java.util.Scanner;

/**
 *
 * @author Niethy
 */
public class GetLocationView {
    private Game game;
    
    public GetLocationView(Game game) {
        this.game = game;
    }
    
    /*
     * Prompt the user to enter the location (row and column) to place their 
     * Ship on the board
     * @Param game the object representing the game
     */
    public Point getInput() {

        Scanner inFile = new Scanner(System.in); // get input file      
        String[] coordinates;
        Point location = null;
        
        boolean valid = false;
        

        // prompt the use to enter the locaton to placeread the row and column coordinates
        while (!valid) {
            // prompt for the row and column numbers
            System.out.println("\n\n\t" + this.game.currentPlayer.name + " it is your turn."
                + " Enter a row and column number (For example: 1 3)");
            
            // get the value entered by the user 
            String strRowColumn = inFile.nextLine(); 
            
            // trim off all extra blanks from the input
            strRowColumn = strRowColumn.trim();  
            
            // replace any commas enter with blanks
            strRowColumn = strRowColumn.replace(',', ' '); 
            
            // tokenize the string into an array of words
            coordinates = strRowColumn.split("\\s"); 

            if (coordinates.length < 1) { // the value entered was not blank?
                new BattleshipsError().displayError(
                        "You must enter two numbers, a row and the column, "
                        + "or a \"Q\" to quit. Try again.");
                continue;
            }    

            else if (coordinates.length == 1) { // only one coordinate entered?
                if (coordinates[0].toUpperCase().equals("Q")) { // Quit?
                    return null;
                } else { // wrong number of values entered.
                    new BattleshipsError().displayError(
                        "You must enter two numbers, a row and the column, "
                        + "or a \"Q\" to quit. Try again.");
                    continue;
                }
            }

            
            // user java regular expression to check for valid integer number 
            // for both numbers
            String regExpressionPattern = ".*\\d.*";
            if (!coordinates[0].matches(regExpressionPattern) ||
                !coordinates[1].matches(regExpressionPattern)) {
                new BattleshipsError().displayError(
                        "You must enter two numbers, the number rows and columns, "
                        + "or a \"Q\" to quit. Try again.");
                continue;
            }
            
            // convert each of the cordinates from a String type to 
            // an integer type
            int row = Integer.parseInt(coordinates[0]);
            int column = Integer.parseInt(coordinates[1]);
                     
            Board board = this.game.board; // get the game board
            
            // Check for invalid row and column entered
            if (row < 1   ||  row > board.rowCount ||
                column < 1  ||  column > board.columnCount) {
                new BattleshipsError().displayError(
                        "Enter a valid number of rows and columns from 3 to 10. Try again.");
                continue;
            }
            
            // create a Point object to store the row and column coordinates in
            location = new Point(row-1, column-1);
            
            // check to see if the location entered is already occupied
            if ( board.boardLocations[row-1][column-1].player != null ) {
                new BattleshipsError().displayError(
                    "The current location is taken. Select another location");
                continue;
            }

            valid = true; // a valid location was entered

        }
        
        return location; 
            
    }

}
