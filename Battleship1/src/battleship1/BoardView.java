/*
 * This will display the Board 10x10 grid 
 */

package battleship1;

/**
 *
 * @author mBradshaw
 */
public class BoardView {
    Board board;
    
    public void displayBoard(Board board) {
        this.board = board;
        
        this.printHeadRow(); // print the header row for the board
        this.printDividerRow(); // print the top divider row of the board
        
        // for all rows in the board
        for (int i = 0; i < this.board.rowCount; i++) {
            // get the list of list of columns locations in the row
            battleship1.Location[] rowOfLocations = this.board.boardLocations[i];
            
            // print the contents of each location in the row
            this.printRow(i+1, rowOfLocations); 
            
            this.printDividerRow();// print the ending divider for the row
        }
        
        System.out.println(); // print blank line after the board
         
        return;
    }

    private void printHeadRow() {

        // print the first column in the header row
        System.out.print("\n\t   ");
        
        // print remaining header cells in row between the first and last column
        int columnsInRow = this.board.columnCount;
        for (int i = 1; i < columnsInRow - 0; i++) {
            int col = i + 0;
            System.out.print("  " + col + "   ");
        }
        // print the header for the last column in the header
        System.out.print(" " + columnsInRow + "   ");
    }

    private void printDividerRow() {

        // print the divider for the first column in the row
        System.out.print("\n\t|------");
        
        int columnsInRow = this.board.columnCount;
        // print remaining divider for each column between the first and last
        for (int i = 2; i < columnsInRow - 0; i++) {
            System.out.print("------");
        }
        // print the row divider for the last column in the row
        System.out.print("-----|");
    }

    private void printRow(int rowNumber, battleship1.Location[] rowLocations) {
        
        // print contents of first column in the row
        String letter = " ";
        if (rowLocations[0].player != null) {
            letter = rowLocations[0].player.Ship;
        }
        System.out.print("\n" + rowNumber + "\t|  " + letter + "  |");

        // print the contents of the rest of the columns in the row 
        for (int i = 1; i < rowLocations.length; i++) {
            if (rowLocations[i].player == null) {
                letter = " ";
            } else {
                letter = rowLocations[i].player.Ship;
            }
            
            System.out.print("  " + letter + "  |");
        }
    }

}



