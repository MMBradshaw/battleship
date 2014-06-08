/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package battleship1;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author J.Pratt
 */
public class Battleship {
    // Instance variables
    private static String[] nameList;
    
    private final static String WELCOME = 
              "\n\t***********************************************************************"
            + "\n\t* Welcome to the game of Battleships!                                 *"                            
            + "\n\t* You will be playing against an opponent. The object of the game     *"
            + "\n\t* is to guess the locations of all the ships of your opponent.        *"
            + "\n\t* Players will hide 5 ships. Then the opponent will be given a number *" 
            + "\n\t* of chances.                                                         *"
            + "\n\t* Good Luck!!!                                                        *"
            + "\n\t***********************************************************************"
            + "\n";

    
    public Battleship() {
        
    }
 
    public static String[] getNameList() {
        return nameList;
    }

    public static void setNameList(String[] nameList) {
        Battleship.nameList = nameList;
    }
    
        
    public static void main(String[] args) {
        Battleship battleShips = new Battleship();
        battleShips.display();
        MainMenuView mainMenu = new MainMenuView();
        mainMenu.getInput();
    }
    
    private void display() {
        System.out.println(Battleship.WELCOME);
    }
    

}
