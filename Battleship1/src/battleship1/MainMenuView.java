/*
 * Display the main menu
 */
 
package battleship1;
 
import java.util.Scanner;
 
/**
 *
 * @author MBradshaw
 */
public class MainMenuView {
      private static final String[][] menuItems = {
        {"1", "One player game"},
        {"2", "Two player game"},
        {"H", "Help"},
        {"X", "Exit Battleship Board"},
        {"#Rows", "Number of Rows: " + 10},
        {"#Columns", "Number of Columns: "+ 10},
        {"Grids-", "Number of Rows * Number of Columns: " + 10*10}
    }; 
      public MainMenuControl mainMenuControl = new MainMenuControl();
    
    public MainMenuView() {
 
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
                case "1":
                    mainMenuControl.startGame(1);
                    break;
                case "2":
                    mainMenuControl.startGame(2);
                    break;
                case "H":
                    mainMenuControl.displayHelpMenu();            
                    break;
                case "X":
                    break;
                default: 
                    new BattleshipsError().displayError("Invalid command. Please enter a valid command.");
            }
        } while (!command.equals("X"));
 
    }
    
 
    
    
   public final void display() {
        System.out.println("\n\t===============================================================");
        System.out.println("\tEnter your choices:");
 
        
          for (String[] menuItem : MainMenuView.menuItems) {
              System.out.println("\t   " + menuItem[0] + "\t" + menuItem[1]);
          }
        System.out.println("\t===============================================================\n");
    }   
    
}