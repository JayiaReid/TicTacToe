/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tictactoe;
/**
 *
 * @author jayia
 */
import java.util.Scanner;


public class TicTacGame{
     private static boolean gameover = false;
     
    public static void main(String[] args) {
        Tgame game = new Tgame();
        Scanner scanner = new Scanner(System.in);
       
        System.out.println("-------------Welcome to Tic Tac Toe------------------");
        System.out.println("=====================================================");
        System.out.println("Enter row and column (0-2) to make a move.");
        
        game.printBoard();
            
        do{
            
            if (game.isBoardFull()!=true){
                //prompting user
                System.out.print("Player " + game.currentPlayer + ", make your move: ");
                int row = scanner.nextInt();
                int col = scanner.nextInt();

                //inputing on board
                if (game.isValidMove(row, col)) {
                    game.makeMove(row, col);
                    game.printBoard();
                }else{
                    System.out.println("Invalid move. Try again");
                }
                
               if(game.isWinner() == true){
               
                System.out.println("Player " + game.currentPlayer + " wins!");
                gameover = true;
                
                }
            }
            else{
                if (game.isBoardFull()) {
                    game.printBoard();
                    System.out.println("It's a draw!");
                    gameover = true;

                }
                
            }
        }while(gameover == false);
    }
}
