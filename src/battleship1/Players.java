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
public class Players {
    public static final String REGULAR_PLAYER = "REGULAR";
    public static final String COMPUTER_PLAYER = "COMPUTER"; 
    
    public String name;
    public double age;
    public String playerType;
    public long wins = 0;
    public long losses = 0;
    public long ties = 0;
    public String Ship;
    

    public Players() {
    }

    public Players(String playerType, String Ship) {
        this.playerType = playerType;
        this.Ship = Ship;
    } 

    public String getPlayerStastics() {
        String playerStatistics = 
                this.name + " has won "
                + this.getWinningPercentage(this.wins, this.losses, this.ties) + "% of the games."
                + "\n\t" + this.wins + " wins, "
                + this.losses + " losses and "
                + this.ties + " ties.";
        
        return playerStatistics;
    }

    
    public double getWinningPercentage(long wins, long losses, long ties) {
     
        if (wins < 0 ) {
            System.out.println("\n\tThe number of wins must be "
                    + "greater than or equal to zero.");
            return -999;
        }
        
        if (losses < 0 ) {
            System.out.println("\n\tThe number of losses must be "
                    + "greater than or equal to zero.");
            return -999;
        }
        
        if (ties < 0 ) {
            System.out.println("\n\tThe number of ties must be "
                    + "greater than or equal to zero.");
            return -999;
        }
        
        double totalScore = wins + losses + ties;
        
        if (totalScore ==  0) {
            return 0;
        }
        
        double winLossRatio = wins / totalScore;
        return winLossRatio * 100;
    }

    void displayName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String getPlayerType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
