/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package battleship1;

import java.util.Scanner;

/**
 *
 * @author Niethy
 */
class GamePreferencesMenuView {
     Game game;
    private final GamePreferencesMenuControl gamePreferenceControl;

    private final static String[][] menuItems = {
        {"1", "Change Ship of the first Player"},
        {"2", "Change Ship of the second Player"},
        {"D", "Change the dimensions of the board"},
        {"Q", "Return to game menu"}
    };

    public GamePreferencesMenuView(Game game) {
        this.game = game;
        gamePreferenceControl = new GamePreferencesMenuControl(game);
    }

    
    public void getInput() {       
        String command;
        Scanner inFile = new Scanner(System.in);
        
        do {
            this.display();

            // get commaned entered
            command = inFile.nextLine();
            command = command.trim().toUpperCase();
            
            switch (command) {
                case "1":
                    this.gamePreferenceControl.getShips(this.game.playerA);
                    break;
                case "2":
                    this.gamePreferenceControl.getShips(this.game.playerB);
                    break;
                case "D":
                    this.gamePreferenceControl.getDimensions();
                    break;
                case "Q":
                    break;
                default: 
                    new BattleshipsError().displayError("Invalid command. Please enter a valid command.");
            }
        } while (!command.equals("Q"));

    }
    
    
        
    public final void display() {
        System.out.println("\n\t===============================================================");
        System.out.println("\tEnter the letter associated with one of the following commands:");

        for (int i = 0; i < GamePreferencesMenuView.menuItems.length; i++) {
            System.out.println("\t   " + menuItems[i][0] + "\t" + menuItems[i][1]);
        }
        System.out.println("\t===============================================================\n");
    }

    }
 


