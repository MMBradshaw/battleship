/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package battleship1;

import java.awt.Dimension;

/**
 *
 * @author Niethy
 */
class GamePreferencesMenuControl {
    private final Game game;

    public GamePreferencesMenuControl(Game game) {
        this.game = game;
    }
    
    
    public void getShips(Players player) { 
        
        getShipsView getShipsView = new getShipsView(this.game);
        String Ship = getShipsView.getInput(player);
        
        if (Ship == null) { // user changed there mind and quit??
            return;
        }
      
        player.Ship = Ship; // update the players Ships
        
        return;
    }
        
    
    public void getDimensions()  {
        
        // Check to see if a game is already in progress
        if (this.game.status.equals(Game.PLAYING)) {
            new BattleshipsError().displayError("You can not change the dimensions "
              + "of the board once the game has been started. "
              + "\n\tStart a new game and then change the dimensions "
              + "of the board. ");
            return;
        }
        
        GetDimensionsView getDimensionsView = new GetDimensionsView(this.game);
        Dimension dimension = getDimensionsView.getInput();
        
        if (dimension == null) {    
            return;
        }
        
        int boardRowCount = dimension.width;
        int boardColumnCount= dimension.height;
         
        // no change in the board size so return
        if (boardRowCount == this.game.board.rowCount &&
            boardColumnCount == this.game.board.columnCount) {
            return;
        }
        
        // create new locations in the board
        this.game.board.createBoardLocations(boardRowCount, boardColumnCount);
               
        return;
    }
    
    
    
}
