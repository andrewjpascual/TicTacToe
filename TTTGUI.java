/*
*
*@author Andrew Pascual
*
*Program 5 TicTacToeGUI
*
*/

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TTTGUI {
   
   
   //Size var for 16 sized board
   public static final int SIZE = 4;

   public static void main(String[] args) {
   
      TTTBoard board = new TTTBoard(SIZE);
      char player = 'X';
      char opponent = 'O';
      
      // Initializes a JFrame with a close button.
      JFrame frame = new JFrame("Tic Tac Toe GUI");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      JButton[][] b = new JButton[SIZE][SIZE];
      JLabel status = new JLabel("Your turn");
      
      //Tic Tac Toe 4x4 Grid Layout
      JPanel gameBoard = new JPanel();
		gameBoard.setLayout (new GridLayout (SIZE, SIZE));
		gameBoard.setBorder (BorderFactory.createLineBorder(Color.gray, 3));
		gameBoard.setBackground (Color.white);
      
      //Construction buttons
      for(int i=0; i< SIZE; i++) {
		   for(int j=0; j < SIZE; j++) {
			   b[i][j] = new JButton(" ");
            gameBoard.add(b[i][j]);
		   }
		}
      
      //Constructing action listeners for buttons
      for(int i=0; i< SIZE; i++) {
		   for(int j=0; j < SIZE; j++) {
            b[i][j].addActionListener(new ButtonActionListener(b,SIZE,i,j,board,player,opponent,status));
		   }
		} 

      //Dimensions and Layout
      frame.setLayout(new BorderLayout());
      frame.add(gameBoard, BorderLayout.CENTER);
      frame.pack();
      frame.setSize(new Dimension(400, 400));
		frame.setVisible(true);      
      
      //Bottom game status
      JPanel curAction = new JPanel();
      curAction.add(status);
      frame.add(curAction, BorderLayout.SOUTH);    

   }
}
