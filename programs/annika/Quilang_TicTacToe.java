package programs.annika;

import java.util.Scanner;
import core.ProgramInterface;

public class Quilang_TicTacToe implements ProgramInterface {
    
    @Override
    public String getName() { 
        return "Tic Tac Toe"; 
    }
    
    @Override
    public String getDescription() { 
        return "A classic Tic Tac Toe game for two players"; 
    }
    
    @Override
    public String getAuthor() { 
        return "Annika Quilang"; 
    }
    
    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Tic Tac Toe ===");
        System.out.println("Player 1: X | Player 2: O");
        
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
        
        boolean player1Turn = true;
        boolean gameEnded = false;
        
        while (!gameEnded) {
            printBoard(board);
            
            char symbol = player1Turn ? 'X' : 'O';
            System.out.println("Player " + (player1Turn ? "1" : "2") + "'s turn (" + symbol + ")");
            System.out.print("Enter row (0-2): ");
            int row = sc.nextInt();
            System.out.print("Enter column (0-2): ");
            int col = sc.nextInt();
            
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-') {
                board[row][col] = symbol;
                
                if (checkWinner(board, symbol)) {
                    printBoard(board);
                    System.out.println("Player " + (player1Turn ? "1" : "2") + " wins!");
                    gameEnded = true;
                } else if (isBoardFull(board)) {
                    printBoard(board);
                    System.out.println("It's a draw!");
                    gameEnded = true;
                } else {
                    player1Turn = !player1Turn;
                }
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }
    }
    
    private void printBoard(char[][] board) {
        System.out.println("\n  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    private boolean checkWinner(char[][] board, char symbol) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) return true;
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol) return true;
        }
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) return true;
        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) return true;
        return false;
    }
    
    private boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') return false;
            }
        }
        return true;
    }
}
