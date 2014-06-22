/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package battleship1;

import java.util.Scanner;

/**
 *
 * @author mBradshaw
 */
class MainMenuControl {

    public void startGame(long noPlayers) {
                
        if (noPlayers != 1  &&  noPlayers != 2) {
            new BattleshipsError().displayError("startGame - invalid number of players specified.");
            return;
        }
        
        Game game;
        if (noPlayers == 1) {
            game = this.createGame("ONE_PLAYER");
        }
        else {
            game = this.createGame("TWO_PLAYER");
        }

        GameMenuView gameMenu = new GameMenuView(game);
        gameMenu.getInput();
    }

    
    
    private Game createGame(String gameType) {
        Game game = null;
        Players playerA = null;
        Players playerB = null;
        
        if (gameType == null) {
            new BattleshipsError().displayError("MainCommands - create: gameType is null");
            return null;
        }
        
        switch (gameType) {
            case Game.ONE_PLAYER:
                game = new Game(Game.ONE_PLAYER);
                playerA = new Players(Players.REGULAR_PLAYER, Game.PLAYER_A_DEFAULT_Ship);
                playerA.name = "Player 1";
                playerB = new Players(Players.COMPUTER_PLAYER, Game.PLAYER_B_DEFAULT_Ship);
                playerB.name = "Computer";
                break;
            case Game.TWO_PLAYER:
                game = new Game(Game.TWO_PLAYER);
                playerA = new Players(Players.REGULAR_PLAYER, Game.PLAYER_A_DEFAULT_Ship);
                playerA.name = "Player 1";
                playerB = new Players(Players.REGULAR_PLAYER, Game.PLAYER_B_DEFAULT_Ship);
                playerB.name = "Player 2";
                break;
        }

        // set default Ships for each player
        playerA.Ship = Game.PLAYER_A_DEFAULT_Ship;
        playerB.Ship = Game.PLAYER_B_DEFAULT_Ship;
        
        // save the two players created as the default players of the game
        game.playerA = playerA;
        game.playerB = playerB; 
        
        // set the game status to game not yet in playing mode
        game.status = Game.NO_ACTIVE_GAME;
        
        return game;
    } 
    
    
    private String quitGame() {
        System.out.println("\n\tAre you sure you want to quit? (Y or N)");
        Scanner inFile = new Scanner(System.in);
        String answer = inFile.next().trim().toUpperCase();
        if (answer.equals("Y")) {
            return Game.EXIT;
        }

        return Game.PLAYING;
    }
    
    
    /*
     * Display help menu action
     */
    public void displayHelpMenu() {
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.getInput();
    }
}
