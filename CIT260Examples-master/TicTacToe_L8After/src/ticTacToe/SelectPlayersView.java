/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ticTacToe;

import java.util.Scanner;

/**
 *
 * @author jacksonrkj
 */
public class SelectPlayersView {
    
    private Game game;
    private String[] playerNames;

    public SelectPlayersView(Game game) {
        this.game = game;
        playerNames = TicTacToe.getNameList();
    }

    
    public String[] selectPlayers(String[] nameList) {
        String[] selectedPlayerNames = new String[2];
        
        this.displayNameList(); // display the list of names
        
        // if one player game
        if (Game.ONE_PLAYER.equals(this.game.getGameType())) {
           System.out.println("\tPlease enter the number of the player.");

            // get the players name
            selectedPlayerNames[0] = this.getName(TicTacToe.getNameList());

            if (selectedPlayerNames[0] ==  null) {
                return null;
            }
            
            selectedPlayerNames[1] = "Computer";
        }
        
        // else two player game
        else { 
            System.out.println("\tPlease enter the number of the first player.");
            
            // get first players name
            selectedPlayerNames[0] = this.getName(TicTacToe.getNameList());
            if (selectedPlayerNames[0] ==  null) {
                return null;
            }
            
            // get the second players name
            System.out.println("\tPlease enter the number of the second player.");
            selectedPlayerNames[1] = this.getName(TicTacToe.getNameList());
            if (selectedPlayerNames[0].equals(selectedPlayerNames[1])) {
                
            }
            if (selectedPlayerNames[1] ==  null) {
                return null;
            }
        }
        
        return null;
        
    }
    

    public String getName(String[] nameList) {

        Scanner inFile = TicTacToe.getInputFile();
        String name = null;
        boolean valid = false;
        do {
            String strNumber = inFile.nextLine();
            
            if (strNumber.length() < 1) { // was a value entered ?
                new TicTacToeError().displayError("You must enter a name or enter a \"Q\" to quit. Try again.");
                continue;
            }
            
            strNumber = strNumber.trim(); // trim off all blanks from front and back    
            strNumber = strNumber.substring(0, 1); // get only the first character
            
            if (strNumber.toUpperCase().equals("Q")) { // quit?
                return null;
            }
                       
            if (!strNumber.matches("[0-9]+")) { // is the value entered a number?
                new TicTacToeError().displayError("You must enter a number in the list. Try again.");
                continue;
            }
            
            int numberSelected = Integer.parseInt(strNumber); // convert string to integer
            
            // is the number outside the range of the list of names
            if (numberSelected < 1  ||  numberSelected > nameList.length) {
                new TicTacToeError().displayError(
                        "You must enter a number from the list. Try again.");
                continue;
            }
            
            name = nameList[numberSelected-1]; // get the name from the list
            if (alreadyInList(nameList, name)) {
                new TicTacToeError().displayError(
                        "That name has already been selected. Try again.");
                continue;
            }
            
            valid = true; // names selected successfully
      
        } while (!valid);
        
        return name;
    }

    
    
    public void displayNameList() {
        System.out.println("\n\t===============================================================");
        System.out.println("\tSelect the player/s who will be playing the game.");
        System.out.println("\tEnter the number of a player below:");

        for (int i = 0; i < this.playerNames.length; i++) {
            int namePosition = i+1;
            System.out.println("\t   " + namePosition + "\t" + playerNames[i]);
        }
        System.out.println("\t===============================================================\n");
    }
    
    private boolean alreadyInList(String[] listOfNames, String name) {
        for (String currentName : listOfNames) {
            if (currentName.equals(name)) {
                return true;
            }           
        }
        return false;
    }
    
}
