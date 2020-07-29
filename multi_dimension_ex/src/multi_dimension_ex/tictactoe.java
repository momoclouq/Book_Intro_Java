/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multi_dimension_ex;

import java.util.Scanner;

/**
 *
 * @author cis2mye
 */
public class tictactoe {
    public static char whut(int place){
        if (place == 0) return ' ';
        if (place == 1) return 'X';
        if (place == 2) return 'O';
        
        return '?';
    }
    
    public static char showCharacter(int[][] board, int index){
        switch(index){
            case 1: return whut(board[0][0]);
            case 2: return whut(board[0][1]);
           
            case 3: return whut(board[0][2]);
            
            case 4: return whut(board[1][0]);
            
            case 5:return whut(board[1][1]);
            
            case 6:return whut(board[1][2]);
            
            case 7:return whut(board[2][0]);
            
            case 8:return whut(board[2][1]);
            
            case 9:return whut(board[2][2]);
            
            default: break;
        }
        
        return '?';
    }
    
    public static void displayBoard(int[][] board){
        System.out.println("-------------------");
        System.out.println("|  " + showCharacter(board, 1) + "  |  " + showCharacter(board, 2) + "  |  " + showCharacter(board, 3) + "  |");
        System.out.println("-------------------");
        System.out.println("|  " + showCharacter(board, 4) + "  |  " + showCharacter(board, 5) + "  |  " + showCharacter(board, 6) + "  |");
        System.out.println("-------------------");
        System.out.println("|  " + showCharacter(board, 7) + "  |  " + showCharacter(board, 8) + "  |  " + showCharacter(board, 9) + "  |");
        System.out.println("-------------------");
    }
    
    public static boolean isWin(int[][] board){
        if (board[0][0] == 1 && board[0][1] == 1 && board[0][2] == 1) return true;
        if (board[1][0] == 1 && board[1][1] == 1 && board[1][2] == 1) return true;
        if (board[2][0] == 1 && board[2][1] == 1 && board[2][2] == 1) return true;
        
        if (board[0][0] == 2 && board[0][1] == 2 && board[0][2] == 2) return true;
        if (board[1][0] == 2 && board[1][1] == 2 && board[1][2] == 2) return true;
        if (board[2][0] == 2 && board[2][1] == 2 && board[2][2] == 2) return true;
        
        if (board[0][0] == 1 && board[1][0] == 1 && board[2][0] == 1) return true;
        if (board[0][1] == 1 && board[1][1] == 1 && board[2][1] == 1) return true;
        if (board[0][2] == 1 && board[1][2] == 1 && board[2][2] == 1) return true;
        
        if (board[0][0] == 2 && board[0][1] == 2 && board[0][2] == 2) return true;
        if (board[1][0] == 2 && board[1][1] == 2 && board[1][2] == 2) return true;
        if (board[2][0] == 2 && board[2][1] == 2 && board[2][2] == 2) return true;
        
         if (board[0][0] == 2 && board[1][1] == 2 && board[2][2] == 2) return true;
         if (board[0][0] == 1 && board[1][1] == 1 && board[2][2] == 1) return true;
        if (board[2][0] == 2 && board[1][1] == 2 && board[0][2] == 2) return true;
        if (board[2][0] == 1 && board[1][1] == 1 && board[0][2] == 1) return true;
        
        return false;
    }
    
    public static boolean isDraw(int[][] board){
        for (int i = 0; i < board.length; i++){
            for (int k = 0; k < board[i].length; k++) if (board[i][k] == 0) return false;
        }
        
        return true;
    }
    
    public static void loop(boolean currentPlayer, int[][] board, Scanner input){
        displayBoard(board);
        
        int moveR;
        int moveC;
        
        if (currentPlayer){
             System.out.print("Enter a row (0,1,2) for player X: ");
             moveR = input.nextInt(); 
             input.nextLine();
             System.out.println("");
             
             System.out.print("Enter a column (0,1,2) for player X: ");
             moveC = input.nextInt();
             input.nextLine();
             
             board[moveR][moveC] = 1;
        } else {
            System.out.print("Enter a row (0,1,2) for player O: ");
             moveR = input.nextInt(); 
             input.nextLine();
             System.out.println("");
             
             System.out.print("Enter a column (0,1,2) for player O: ");
             moveC = input.nextInt();
             input.nextLine();
             
             board[moveR][moveC] = 2;
        }
        
        
    }
    
    
    public static void play(){
        System.out.println("The game starts!");
        
        int[][] board = new int[3][3];
        
        for (int i = 0; i < board.length; i++){
            for (int k =0; k < board[i].length; k++) board[i][k] = 0;
        }
        
        Scanner terminal = new Scanner(System.in);
        boolean currentPlayer = true;
        
        while(true){
            loop(currentPlayer, board, terminal);
            
            if(isWin(board)) {
                if (currentPlayer) System.out.println("Player X won!");
                else System.out.println("Player O won!");
                displayBoard(board);
                break;
            } 
            
            if (isDraw(board)) {
                System.out.println("Its a tie");
                displayBoard(board);
                break;
            }
            
            currentPlayer = !currentPlayer;
        }
    }
}
