/*
*
*@author Andrew Pascual
*@date 4/17/2019
*
*/

import java.util.*;

public class TTT {
      
   public static void main(String[] args) {
      Intro();
      Question();
   }
      
   public static void Intro() {
      System.out.println("Hello! Welcome to the game of Tic-Tac-Toe!");
      System.out.println("There are multiple objectives in this two player based game.");
      System.out.println("You want to prevent your opponent from obtaining a full straight of the same character in the same row or column or diagonal.");
      System.out.println("You also want to obtain a full straight of the same character in the same row, or column, or diagonal before your opponent in order to win the game!");
      System.out.println();
   }
   
   public static void Question() {
      Scanner s = new Scanner(System.in);
      System.out.println("Do you wish to play the game? yes or no?");
      String answer = s.next();
      if(answer.equalsIgnoreCase("NO")) {
         System.out.println("Come play next time!");
         return;
      } else if(answer.equalsIgnoreCase("YES")) {
         System.out.println("Enter 1 for HUMAN VS HUMAN, Enter 2 for HUMAN VS AI, Enter 3 for AI vs AI");
         int mode = s.nextInt();
         if(mode == 1) {
            //trigger a game for human vs human 
            System.out.println("Enter a board size to play on!"); 
            int bsize = s.nextInt();
            TTTBoard board = new TTTBoard(bsize); //Humans will decide amongst themselves who goes first
            int player = 1;
            while(!isFull(board,bsize)) {
               System.out.println("For player " + player + " choose a row");
               int hrow = s.nextInt();
               System.out.println("Now choose a column");
               int hcol = s.nextInt();
               System.out.println("Now choose a character");
               char hchar = s.next().charAt(0);
               board.set(hrow,hcol,hchar);
               System.out.println(board);
               if(board.winner() != ' ') {
                  System.out.println("Player " + player + " has won!!!");
                  break;
               }
               if(player == 1) {
                  player = 2;
               }
               else {
                  player = 1;
               }
            }
         
            System.out.println("Board now full and game is over");
         
         } else if(mode == 2) {
            //trrigger a game for human vs ai
            System.out.println("What board size would you like to play on?");
            int bsize = s.nextInt();
            TTTBoard board = new TTTBoard(bsize);
            int player = 1;
            System.out.println("Would you like to go first or second? Input 1 for first and 2 for second");
            int turn = 0;
            turn = s.nextInt();
            if(turn == 1) {
               System.out.println("For player " + player + " choose a row");
               int hrow = s.nextInt();
               System.out.println("Now choose a column");
               int hcol = s.nextInt();
               System.out.println("Now choose a character");
               char hchar = s.next().charAt(0);
               board.set(hrow,hcol,hchar);
               player = 2;
            } else {
               System.out.println("AI turn");
               TTTAI.move(board, 'X');
            }
            System.out.println(board);
            while(!isFull(board,bsize)) {
               if(player == 1) {
                  System.out.println("For player " + player + " choose a row");
                  int hrow = s.nextInt();
                  System.out.println("Now choose a column");
                  int hcol = s.nextInt();
                  System.out.println("Now choose a character");
                  char hchar = s.next().charAt(0);
                  board.set(hrow,hcol,hchar);
                  player = 2;
               }
               else {
                  System.out.println("AI turn");
                  TTTAI.move(board, 'X');
                  player = 1;
               }
               System.out.println(board);
               if(board.winner() != ' ') {
                  if(player == 2) {
                     System.out.println("You have won!!!");
                  }
                  else {
                     System.out.println("The AI has won!!!");
                  }
                  break;
               }
            }
                
            
            
         } else if(mode == 3) {
            //trigger a game for ai vs ai
            System.out.println("What board size would you like these bots to play on?");
            int bsize = s.nextInt(); 
         
            TTTBoard board = new TTTBoard(bsize);
            int player = 1;
            while(!isFull(board, bsize)) {
               System.out.println("AI " + player );
               if(player == 1) {
                  TTTAI.move(board, 'X');
               }
               else {
                  TTTAI.move(board, 'O');
               }
               System.out.println(board);
               if(board.winner() != ' ') {
                  System.out.println("AI " + player + " has won!!!");
               }
               if(player == 1) {
                  player = 2;
               }
               else {
                  player = 1;
               }
            }
            System.out.println("Board now full and game over");
         
         } 
        
      }
      //throw new IllegalArgumentException("Please retry and choose from the given choices");
   }
   
   
   private static boolean isFull(TTTBoard board, int bsize) {
      int size = bsize;
      boolean full = true;
      for(int i=0;i<size;i++) {
         for(int j=0;j<size;j++) {
            if (board.get(i,j) == ' ') {
               full = false;
               break;
            }               
         }
      }
      return full;
   }
        
}         
      
   
