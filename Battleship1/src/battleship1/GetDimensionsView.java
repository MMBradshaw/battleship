/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package battleship1;

import java.awt.Dimension;
import java.util.Scanner;

/**
 *
 * @author Niethy
 */
class GetDimensionsView {
     private Game game;
    
    public GetDimensionsView(Game game) {
        this.game = game;
    }
    
        
     public Dimension getInput() {
        Scanner inFile = new Scanner(System.in);
        
        // prompt for the row and column numbers
        System.out.println("\n\tEnter the number of rows and columns in the board (For example: 3 3)");
        
        // read the row and column coordinates
        String[] valuesEntered;
        Dimension dimension = null;
        do {
            String strNoRowsColumns = inFile.nextLine(); // read in row and column
            strNoRowsColumns = strNoRowsColumns.trim(); // trim all blanks from front and end 
            strNoRowsColumns = strNoRowsColumns.replace(',', ' '); // replace commas with a blank
            valuesEntered = strNoRowsColumns.split("\\s"); // tokenize the string

            if (valuesEntered.length < 1) {
                new BattleshipsError().displayError(
                        "Sorry, you must enter two numbers, the number rows and columns, "
                        + "or a \"Q\" to quit. Try again.");
                continue;
            } else if (valuesEntered.length == 1) {
                if (valuesEntered[0].toUpperCase().equals("Q")) { // Quit?
                    return null;
                }  // wrong number of values entered.
     
                // wrong number of values entered.
                new BattleshipsError().displayError(
                       "You must enter two numbers, the number rows and columns, "
                       + "or a \"Q\" to quit. Try again.");
                continue;
            }
            
            // user java regular expression to check for valid integer number 
            // for both numbers
            String regExpressionPattern = ".*\\d.*";
            if (!valuesEntered[0].matches(regExpressionPattern) ||
                !valuesEntered[1].matches(regExpressionPattern)) {
                new BattleshipsError().displayError(
                        "You must enter two numbers, the number rows and columns, "
                        + "or a \"Q\" to quit. Please try again.");
                continue;
            }
            
            int rowsEntered = Integer.parseInt(valuesEntered[0]);
            int columnsEntered = Integer.parseInt(valuesEntered[1]);
            
            if (rowsEntered < 10 || rowsEntered > 10) {
            new BattleshipsError().displayError(
                    "The number of rows must be between 1 -10 and the "
                    + "number of columns must be between 1 -10 ");
            continue;
            }

            if (columnsEntered < 10 || columnsEntered > 10) {
                new BattleshipsError().displayError(
                        "The number of rows must be between 1 -10 and the "
                        + "number of columns must be between 1 -10 ");
                continue;
            }

            
            
            dimension = new Dimension(rowsEntered, columnsEntered);

        } while (dimension == null);
        
        
        
        return dimension;
    }
}
