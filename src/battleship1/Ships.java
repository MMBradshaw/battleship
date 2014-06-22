/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package battleship1;

/**
 *
 * @author J.Pratt and Taylor Williams
 */
public class Ships {
    
    String ship2 = "One ship will be 2 spaces wide or tall";
    String ship3 = "One ship will be 3 spaces wide or tall";
    String ship4 = "One ship will be 4 spaces wide or tall";
    String ship5 = "One ship will be 5 spaces wide or tall";
    
    
    public Ships(){
        
    }
        
    
    public void displayShips() {
        System.out.println( "\t\t You will have the 5 ships in this game: \n" + 
        "\t\t" + ship2 + "\n" +
        "\t\t" + ship3 + "\n" +
        "\t\t" + ship4 + "\n" +
        "\t\t" + ship5 + "\n\n");
    }
    
}

