/*
*
*@author Andrew Pascual
*
*Program 5 ButtonActionListener
*
*/

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonActionListener implements ActionListener {
   // Private Static Methods
   private static TTTBoard theBoard;

   private TTTAI bot = new TTTAI();
   private char user;
   private char computer;
   private JLabel status;   
   
   private static boolean winner = false;
   private static boolean draw = false;
   
   private JButton[][] b;
   private int x;
   private int y;
   private int size;

   // Constructor(s)
   public ButtonActionListener(JButton[][] b, int size, int x, int y, TTTBoard board, char player, char comp, JLabel status) {
      this.b = b;
      this.size = size;
      this.x = x;
      this.y = y;
      this.theBoard = board;
      this.user = player;
      this.computer = comp;
      this.status = status;
   }
   
   
   //Logic for game
   @Override
   public void actionPerformed(ActionEvent event) {
      // No more moves
      if(winner || draw)
         return;
     
      // User turn to move and will determine if user won
      boardSet(theBoard, user, x,y);
      if (theBoard.winner()==user) {
         if (!winner) {
            winner = true;
            b[x][y].setText("X");
            status.setText("You won!  End the game");
            return;
         }
      
      //Determines if the game is a draw
      } else if (!winner && boardIsFull()) {
         draw = true;
         updateBoard();
         status.setText("It’s a draw!");
         return;
      }
      
      // Computer turn to move and will determine if computer won
      bot.move(theBoard,computer);
      if (theBoard.winner()==computer) {
         if (!winner) {
            winner = true;
            b[x][y].setText("O");
            updateBoard();
            status.setText("Sorry, the computer won!  End the game");
            return;
         }
      
      // Determines if the game is a draw
      } else if (!winner && boardIsFull()) {
         draw = true;
         updateBoard();
         status.setText("It’s a draw!");
         return;
         
      } else {
         updateBoard();
      }
   }

   // helper methods

   //Looks for full board
   public boolean boardIsFull() {
      boolean full = true;
      for(int i=0;i<size;i++) {
         for(int j=0;j<size;j++) {
            if (theBoard.get(i,j) == ' ') {
               full = false;
               break;
            }               
         }
      }
      return full;
   }
  
   // Updates TTTBoard to GUI
   public void updateBoard() {
      for(int i=0; i< size; i++) {
         for(int j=0; j < size; j++) {
            char spot = theBoard.get(i,j);
            String ch = Character.toString(spot);
            b[i][j].setText(ch);
         }
      }
   }
  
   // Sets the move on a TTTBoard
   public void boardSet(TTTBoard theBoard, char c, int x, int y) {
      theBoard.set(x,y,c);
   }
      
   
}
