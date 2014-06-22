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
class GameMenuView {

    private final Game game;
    private final GameMenuControl gameMenuControl ; 


    private final static String[][] menuItems = {
        {"T", "Take your turn"},
        {"D", "Display the board"},
        {"N", "New Game"},
        {"R", "Report stastics"},
        {"P", "Change game preferences"},
        {"H", "Help"},
        {"Q", "QUIT"}
    };

    public GameMenuView(Game game) {
        this.game = game;
        this.gameMenuControl = new GameMenuControl(game);
        
    }
   
    public void getInput() {
   
        String command;
        Scanner inFile = new Scanner(System.in);

        do {    
            this.display(); // display the menu

            // get commaned entered
            command = inFile.nextLine();
            command = command.trim().toUpperCase();
            
            switch (command) {
                case "T":
                    this.gameMenuControl.takeTurn();
                    break;
                case "D":
                    gameMenuControl.displayBoard();
                    break;
                case "N":
                    gameMenuControl.startNewGame();
                    break;
                case "R":
                    gameMenuControl.displayStatistics();
                    break;
                case "P":
                    gameMenuControl.displayPreferencesMenu();
                    break;
                case "H":
                    gameMenuControl.displayHelpMenu();
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
        System.out.println("\tEnter your choice command:");

          for (String[] menuItem : GameMenuView.menuItems) {
              System.out.println("\t   " + menuItem[0] + "\t" + menuItem[1]);
          }
        System.out.println("\t===============================================================\n");
    }
  
}
