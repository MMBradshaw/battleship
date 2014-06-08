/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package battleship1;

import java.util.Scanner;

/**
 *
 * @author MBradshaw and Jpratt
 */
   public class Location {
   public int row;
    public int column;
    public Players player;

    Location() {
    }
        
    public void occupyLocation(Players player) {
        this.player = player;
    }
    
}
