/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package group.cit260.bship.menuview;

import jeremy.cit260.bship.control.Battleship;
import jeremy.cit260.bship.control.BattleshipsError;
import java.awt.Dimension;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Jeremy and Melanie
 */
 
    public class GamePreferencesMenuView extends Menu {
    
    private jeremy.cit260.bship.models.Game game;
    private final jeremy.cit260.bship.control.GamePreferencesMenuControl gamePreferenceCommands;

    private final static String[][] menuItems = {
        {"1", "Change Marker of the first Player"},
        {"2", "Change Marker of the second Player"},
        {"D", "Change the dimensions of the board"},
        {"Q", "Return to game menu"}
    };

    public GamePreferencesMenuView() {
        super(GamePreferencesMenuView.menuItems);
        gamePreferenceCommands = new jeremy.cit260.bship.control.GamePreferencesMenuControl();
    }
    
    @Override
    public String executeCommands(Object object) {       
        this.game = (jeremy.cit260.bship.models.Game) object;
        this.gamePreferenceCommands.setGame(game);
        
        String gameStatus = jeremy.cit260.bship.models.Game.PLAYING;
        do {
            this.display();

            // get commaned entered
            String command = this.getCommand();
            
            switch (command) {
                case "1":
                    getMarker(this.game.getPlayerA());
                    break;
                case "2":
                    getMarker(this.game.getPlayerB());
                    break;
                case "D":
                    this.getDimensions();
                    break;
                case "Q":
                    return jeremy.cit260.bship.models.Game.QUIT;
            }
        } while (!gameStatus.equals(jeremy.cit260.bship.models.Game.QUIT));

        return gameStatus;
    }
    
    
    public void getMarker(jeremy.cit260.bship.models.Player player) {
        String marker = null;
                
        boolean valid = false;
        do {
            System.out.println("\n\t" + player.getName() 
                + ", enter a single character that will be used to mark your squares in the game.");
            Scanner in = Battleship.getInputFile();
            marker = in.nextLine();
            if (marker == null  || marker.length() < 1) {
                continue;
            }
            
            marker = marker.trim().substring(0, 1);
            marker = marker.toUpperCase();
            valid = this.gamePreferenceCommands.saveMarker(player, marker);
        } while (!valid);

        this.gamePreferenceCommands.saveMarker(player, marker);
   
    }
    
     public boolean getDimensions() {

        if (game.getStatus().equals(jeremy.cit260.bship.models.Game.PLAYING)) {
            new BattleshipsError().displayError("You can not change the dimensions "
              + "of the board once the game has been started. "
              + "\n\tStart a new game and then change the dimensions "
              + "of the board. ");
            return false;
        }

        // prompt for the row and column numbers
        System.out.println("\n\tEnter the number of rows and columns in the board (For example: 3 3)");

        Scanner inFile = Battleship.getInputFile(); // get input file 
        
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
                        "You must enter two numbers, the number rows and columns, "
                        + "or a \"Q\" to quit. Try again.");
                continue;
            } else if (valuesEntered.length == 1) {
                if (valuesEntered[0].toUpperCase().equals("Q")) { // Quit?
                    return false;
                }  // wrong number of values entered.
     
                // wrong number of values entered.
                new BattleshipsError().displayError(
                       "You must enter two numbers, the number rows and columns, "
                       + "or a \"Q\" to quit. Try again.");
                continue;
            }
            
            // user java regular expression to check for valid integer number?
            Pattern digitPattern = Pattern.compile(".*\\D.*");
            if (digitPattern.matcher(valuesEntered[0]).matches()  || 
                digitPattern.matcher(valuesEntered[1]).matches()
               ) {
                new BattleshipsError().displayError(
                        "You must enter two numbers, the number rows and columns, "
                        + "or a \"Q\" to quit. Try again.");
                continue;
            }
            
            int rowsEntered = Integer.parseInt(valuesEntered[0]);
            int columnsEntered = Integer.parseInt(valuesEntered[1]);
            dimension = new Dimension(rowsEntered, columnsEntered);

        } while (dimension == null);
        
        this.gamePreferenceCommands.saveDimensions(dimension);
        
        return true;
    }
   
}
