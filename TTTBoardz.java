/**
 * Program that simulates a tic tac toe board game.
 * 
 *
 * @author Andrew Pascual
 * @version 03/6/2019
 */
 
import java.util.*;
 
 
public class TTTBoardz{

   private int size;
   private char[][] board;
   private int boardSize;
   public static final int DEFAULT_PUZZLE_SIZE = 3;
   
   public TTTBoardz(int size){
      this.size = size;
      if(size < 1){
         throw new IllegalArgumentException("Size must be atleast 1"); 
      }
      board = new char[size][size];
      boardSize = size;
      for(int i=0; i < boardSize; i++){
         for(int j=0; j < boardSize; j++){
            board[i][j] = ' ';
         }
      }
   
   }

   public TTTBoardz(){
      this(DEFAULT_PUZZLE_SIZE); 
   }

   public char get(int r, int c){
      return board[r][c];
   }

   public void set(int r, int c, char ch){
      if(r > size || c > size || r < 0 || c < 0){
         throw new IndexOutOfBoundsException("Please retry and choose a spot within the board limits");
      } else {
         board[r][c] = ch;
      }
   }

   public int size(){
      return size;
   }

   // Returns the winning character
   public char winner() {
      if(inColumn() != ' ') {
         return inColumn();
      } else if (inRow() != ' ') {
         return inRow();
      } else if (inDiag() != ' ') {
         return inDiag();
      } else if (inDiag2() != ' ') {
         return inDiag2();
      } else {
         return ' ';
      }
   }
   
   // Checks columns
   public char inColumn() {
      for (int i = 0; i < size; i++) {                  
         char last = board[0][i];
         boolean wincol = true;
         for (int j = 1; j < size; j++) {
            if (board[i][j] != last) {
               wincol = false;
               break;
            }
         }
         if (wincol && last != ' ')
            return last;
      }
      return ' ';
   }
   
   //Checks Rows
   public char inRow() { 
      for (int i = 0; i < size; i++) {                
         char roo = board[i][0];
         boolean winroo = true;
         for (int j = 1; j < size; j++) {
            if (board [i][j] != roo) {
               winroo = false;
               break;
            }
         }
         if (winroo && roo != ' ')
            return roo;
      }
      return ' ';
   
   }
   
   //Checks Diagonals  1st way
   public char inDiag() {
      for (int i = 0; i < size; i++) {
         int j = 0;
         char diag = board[i][j];
         boolean windiag = true;
         if(board[i][j] != diag){
            windiag = false;
            break;
         }
         j++;
         if(windiag && diag != ' '){
            return diag;
         }
      }
      return ' ';
   }         
   
   
   //Checks Diagonals  2nd way
   public char inDiag2() {
      for (int i = 0; i < size ; i--) {
         int j = size;
         char diag = board[i][j];
         boolean windiag = true;
         if(board[i][j] != diag){
            windiag = false;
            break;
         }
         j--;
         if(windiag && diag != ' '){
            return diag;
         }
      }
      return ' ';
   }         
 

   public String toString(){
      String boardd = "";
      for(int n =0; n < boardSize; n++){
         for(int i=0; i < boardSize-1; i++){
            String str =" |";
            boardd += str;
         } 
         boardd += "\n";
         if(n < boardSize-1){
            for(int k =0; k < boardSize-1; k++){
               boardd += "-+";
            }
            boardd += "-\n";
         }
         else{
            boardd += "";
         }
      }
      return boardd;
   }
}