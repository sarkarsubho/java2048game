package com.project2048;

import java.util.Random;
import java.util.Scanner;

// for arrow input

//import org.jline.reader.LineReader;
//import org.jline.reader.LineReaderBuilder;
//import org.jline.terminal.Terminal;
//import org.jline.terminal.TerminalBuilder;


public class Runner {
	private final int SIZE = 4;
    private int[][] board = new int[SIZE][SIZE];
    private boolean gameOver = false;
    private int score=0;

    public static void main(String[] args) {
        Runner game = new Runner();
        game.initializeBoard();
        
        game.playGame();
    }

    private void initializeBoard() {
        // Initialize the board with two random tiles
        addRandomTile();
        addRandomTile();
//    	board[1][2] = 2048;
    }

    private void playGame() {
        Scanner scanner = new Scanner(System.in);

        while (!gameOver) {
            printBoard();
            System.out.print("Enter a move (W/A/S/D): ");
            String move = scanner.next().toUpperCase();
            move(move);
            
            if(gameOver != true) {
            	addRandomTile();
            }
        }
        scanner.close();
    }

    private void printBoard() {
    	
        System.out.println("2048 Game");
        System.out.println("Score : "+score);
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private void move(String direction) {
        // Implement the logic to move the tiles and merge them
        // Update the 'gameOver' variable if the game is over
        // Your implementation goes here
    	
    	 boolean moved = false;

    	    switch (direction) {
    	        case "W": // Move Up
    	            for (int col = 0; col < SIZE; col++) {
    	                for (int row = 1; row < SIZE; row++) {
    	                    if (board[row][col] != 0) {
    	                        int currentRow = row;
    	                        while (currentRow > 0 && board[currentRow - 1][col] == 0) {
    	                            // Shift tile upwards
    	                            board[currentRow - 1][col] = board[currentRow][col];
    	                            board[currentRow][col] = 0;
    	                            currentRow--;
    	                            moved = true;
    	                        }
    	                        if (currentRow > 0 && board[currentRow - 1][col] == board[currentRow][col]) {
    	                            // Merge tiles
    	                            board[currentRow - 1][col] *= 2;
    	                            score+= board[currentRow][col] * 2 ;
    	                            board[currentRow][col] = 0;
    	                            moved = true;
    	                        }
    	                    }
    	                }
    	            }
    	            break;

    	        case "S": // Move Down
    	            for (int col = 0; col < SIZE; col++) {
    	                for (int row = SIZE - 2; row >= 0; row--) {
    	                    if (board[row][col] != 0) {
    	                        int currentRow = row;
    	                        while (currentRow < SIZE - 1 && board[currentRow + 1][col] == 0) {
    	                            // Shift tile downwards
    	                            board[currentRow + 1][col] = board[currentRow][col];
    	                            board[currentRow][col] = 0;
    	                            currentRow++;
    	                            moved = true;
    	                        }
    	                        if (currentRow < SIZE - 1 && board[currentRow + 1][col] == board[currentRow][col]) {
    	                            // Merge tiles
    	                            board[currentRow + 1][col] *= 2;
    	                            score+= board[currentRow][col]*2;
    	                            board[currentRow][col] = 0;
    	                            moved = true;
    	                        }
    	                    }
    	                }
    	            }
    	            break;

    	        case "A": // Move Left
    	            for (int row = 0; row < SIZE; row++) {
    	                for (int col = 1; col < SIZE; col++) {
    	                    if (board[row][col] != 0) {
    	                        int currentCol = col;
    	                        while (currentCol > 0 && board[row][currentCol - 1] == 0) {
    	                            // Shift tile to the left
    	                            board[row][currentCol - 1] = board[row][currentCol];
    	                            board[row][currentCol] = 0;
    	                            currentCol--;
    	                            moved = true;
    	                        }
    	                        if (currentCol > 0 && board[row][currentCol - 1] == board[row][currentCol]) {
    	                            // Merge tiles
    	                            board[row][currentCol - 1] *= 2;
    	                            score+=board[row][currentCol] *2;
    	                            board[row][currentCol] = 0;
    	                            moved = true;
    	                        }
    	                    }
    	                }
    	            }
    	            break;

    	        case "D": // Move Right
    	            for (int row = 0; row < SIZE; row++) {
    	                for (int col = SIZE - 2; col >= 0; col--) {
    	                    if (board[row][col] != 0) {
    	                        int currentCol = col;
    	                        while (currentCol < SIZE - 1 && board[row][currentCol + 1] == 0) {
    	                            // Shift tile to the right
    	                            board[row][currentCol + 1] = board[row][currentCol];
    	                            board[row][currentCol] = 0;
    	                            currentCol++;
    	                            moved = true;
    	                        }
    	                        if (currentCol < SIZE - 1 && board[row][currentCol + 1] == board[row][currentCol]) {
    	                            // Merge tiles
    	                            board[row][currentCol + 1] *= 2;
    	                            score+=board[row][currentCol]*2;
    	                            board[row][currentCol] = 0;
    	                            moved = true;
    	                        }
    	                    }
    	                }
    	            }
    	            break;

    	        default:
    	            System.out.println("Invalid input. Please enter W/A/S/D for Up/Left/Down/Right.");
    	    }


    	    	
    	        checkGameOver();

    }
    private void checkGameOver() {
    	
    	 // check Winning Condition
    	   for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                int currentTile = board[row][col];
                
//                System.out.println(currentTile);
                // Check tile value
                if (currentTile == 2048) {
                	gameOver = true;
                	System.out.println("2048 Game");
                    System.out.println("You Win.");
                    System.out.println("Final Score : "+score);
                    
                    return; 
                }
            }
        }
    	   
        // Check if there are any empty cells
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 0) {
                    return; // There is an empty cell, the game is not over
                }
            }
        }
        
       
        
  
        // Check if there are adjacent tiles with the same value
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                int currentTile = board[row][col];

                // Check neighboring tiles (up, down, left, right)
                if ((row > 0 && board[row - 1][col] == currentTile) ||
                    (row < SIZE - 1 && board[row + 1][col] == currentTile) ||
                    (col > 0 && board[row][col - 1] == currentTile) ||
                    (col < SIZE - 1 && board[row][col + 1] == currentTile)) {
                    return; // There are adjacent tiles with the same value, the game is not over
                }
            }
        }
        
   

        // If no empty cells and no adjacent matching tiles, the game is over
        gameOver = true;
        System.out.println("2048 Game");
        System.out.println("Game Over!");
        System.out.println("Final Score : "+score);
        return ;
    }

    private void addRandomTile() {
        // Add a random tile (2 or 4) to an empty spot on the board
        Random random = new Random();
        int value = random.nextInt(2) == 0 ? 2 : 4;
        int row, col;
        do {
            row = random.nextInt(SIZE);
            col = random.nextInt(SIZE);
        } while (board[row][col] != 0);

        board[row][col] = value;
    }
}
