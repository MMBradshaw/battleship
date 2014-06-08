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
public class Game {
    public final static String PLAYER_A_DEFAULT_MARKER = "S";
    public final static String PLAYER_B_DEFAULT_MARKER = "O";
    
    
    public static final String ONE_PLAYER = "ONE_PLAYER";
    public static final String TWO_PLAYER = "TWO_PLAYER";
    
    public static final String NO_ACTIVE_GAME = "NO_GAME_STARTED";
    public static final String NEW_GAME = "NEW_GAME";
    public static final String PLAYING = "PLAYING"; 
    public static final String WINNER = "WINNER"; 
    public static final String TIE = "TIE"; 
    public static final String QUIT = "QUIT"; 
    public static final String ERROR = "ERROR";
    public static final String EXIT = "EXIT";
    private static String PLAYERS_A_DEFAULT_MARKER;
    private static String PLAYERS_B_DEFAULT_MARKER;

    public String gameType;
    public Players playerA;
    public Players playerB;
    public Players currentPlayer;
    public Players otherPlayer;
    public Players winner;
    public Players loser;
    public String status;
    public Board board;

    public Game() {
   
       this.playerA = new Players();
       this.playerB = new Players();
       
       this.playerA.marker = Game.PLAYERS_A_DEFAULT_MARKER;
       this.playerB.marker = Game.PLAYERS_B_DEFAULT_MARKER;
    }

    public Game(String gameType) {
        this();

        this.gameType = gameType;
        this.board = new Board(10, 10);
        
    }


    public void start() {

        this.setPlayingOrder(playerA, playerB);

        this.board.clearTheBoard();
        this.status = Game.NEW_GAME;
        this.setPlayingOrder(this.playerA, this.playerB);
    }

    public void setPlayingOrder(Players player1, Players player2) {

        double randomValue = Math.random();

        if (randomValue < 0.5) {
            this.currentPlayer = player1;
            this.otherPlayer = player2;
        } else {
            this.otherPlayer = player2;
            this.currentPlayer = player1;
        }

    }

    public void recordWinner() {
        if (this.currentPlayer == this.playerA) {
            this.winner = this.playerA;
            this.loser = this.playerB;
        } else {
            this.winner = this.playerB;
            this.loser = this.playerA;
        }

        long noWins = this.winner.wins;
        noWins++;
        this.winner.wins = noWins;
        long noLosses = this.loser.losses;
        noLosses++;
        this.loser.losses = noLosses;

        this.status = Game.WINNER;
        
    }

    



    public String getWinningMessage () {
        return "\n\t*******************************************************************************"
             + "\n\t Congratulations " + winner.name + "! You won the game."
             + "\n\t Sorry " + loser.name + ", You are the loser." 
             + "\n\t*******************************************************************************";
    }

    
}
