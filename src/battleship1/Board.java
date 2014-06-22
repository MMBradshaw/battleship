/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package battleship1;

/**
 *
 * @author J.Pratt
 */
public final class Board {
    public int rowCount = 10;
    public int columnCount = 10;
   
    /**
     *
     */
    public battleship1.Location[][] boardLocations;

    public Board() {
    }

    public Board(int noRows, int noColumns) {
  
        this.createBoardLocations(noRows, noColumns);
    }


    public void createBoardLocations(int noRows, int noColumns) {
        this.rowCount= noRows;
        this.columnCount= noColumns;
        
        // add locations to the board
        this.boardLocations = new battleship1.Location[noRows][noColumns];
        for (int row = 0; row < noRows; row++) { // for every row
            // for every column in the row
            for (int column = 0; column < noColumns; column++) { 
                this.boardLocations[row][column] = new battleship1.Location();           
            }            
        }   
    }
    
    
    public void clearTheBoard() {
        // add locations to the board
        for (int row = 0; row < this.rowCount; row++) {
            for (int column = 0; column < this.columnCount; column++) {
                battleship1.Location location = this.boardLocations[row][column];
                location.player = null;           
            }            
        }    
    }

    public void occupyLocation(Players player, int row, int column) {
        battleship1.Location location = this.boardLocations[row][column];
        
        if ( location.player != null) { // location already occupied
            Object displayError = BattleshipsError.displayError("This location is already occupied. "
                    + "Try a different location.");
        }
        
        location.player = player;
    }

    Object getBoardLocations() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Players[][] getBoardLocation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
