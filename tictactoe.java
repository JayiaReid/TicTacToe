
package tictactoe;

/**
 *
 * @author jayia
 */

public class Tgame {
    private char[][] board;
    char currentPlayer;
    
    //constructor
    public Tgame() {
        board = new char[3][3];
        currentPlayer = 'X';
        initializeBoard();
    }
    
    //inputting board into an array for moves puprposes
    public void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }
    
    //swicthing players
    public void switchPlayer() {
        if (currentPlayer == 'X'){
            currentPlayer='O';
        }
        else{
            currentPlayer='X';
        }
    }
    
    //printing board after move replacing value in array
    public void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
        if (isWinner()!=true){
            switchPlayer();
        }
    }
    
    //the time when everyone loses
    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isWinner() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
        }
        
        // Check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == currentPlayer && board[1][j] == currentPlayer && board[2][j] == currentPlayer) {
                return true;
            }
        }
        
        // Check diagonals
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }
        
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        }
        return false;
    }
    
    public boolean isValidMove(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3) {
            return false;
        }
        if (board[row][col] != '-') {
            return false;
        }
        return true;
    }
    
    public void makeMove(int row, int col) {
            board[row][col] = currentPlayer;
            isWinner();  
    }

    
    
    
}
