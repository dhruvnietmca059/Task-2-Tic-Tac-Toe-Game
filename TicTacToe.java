// Tic Tac Toe Game
// Developed by Dhruv Kumar

import java.util.Scanner;

public class TicTacToe {
    private static char[][] board;
    private static char currentPlayer;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;
        
        do {
            initializeGame();
            playGame(scanner);
            System.out.println("Do you want to play again? (yes/no)");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        } while (playAgain);
        
        scanner.close();
    }
    
    private static void initializeGame() {
        board = new char[][] {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };
        currentPlayer = 'X';
        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("Players take turns to mark X or O on the board.");
        System.out.println("First to get three in a row, column, or diagonal wins!");
    }
    
    private static void playGame(Scanner scanner) {
        boolean gameRunning = true;
        
        while (gameRunning) {
            printBoard();
            playerMove(scanner);
            if (isWinner()) {
                printBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                gameRunning = false;
            } else if (isBoardFull()) {
                printBoard();
                System.out.println("It's a draw!");
                gameRunning = false;
            } else {
                switchPlayer();
            }
        }
    }
    
    private static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }
    
    private static void playerMove(Scanner scanner) {
        int row, col;
        while (true) {
            System.out.println("Player " + currentPlayer + ", enter row and column (1-3): ");
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                board[row][col] = currentPlayer;
                break;
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }
    }
    
    private static boolean isWinner() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer)
                return true;
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)
                return true;
        }
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer)
            return true;
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)
            return true;
        return false;
    }
    
    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
    
    private static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
}
