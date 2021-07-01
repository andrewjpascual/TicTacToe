/*
*
*@Andrew Pascual
*@date 4/17/2019
*/

public class TTTAI {

   private static char firstChar;
   private static boolean winChance;
   private static int size;
   private static int r;
   private static int c;
   private static int dag;
   private static int dag2;
   private static int spaceCount;
   private static int whoCount;

   public static void move(TTTBoard board, char who) {
      int size = board.size;
      if (isFull(board))
         throw new IllegalArgumentException("Board is Full");
      if (board.winner() != ' ')
         throw new IllegalArgumentException("Already have a winner");
      if(checkWinner(board,who)){
         return;
      }  
      if (winCondition(board,who) != true) {
         int stop = 0;
         for(int i=0;i<size;i++) {
            for(int j=0;j<size;j++) {
               if (board.get(i,j) == ' ') {
                  board.set(i,j,who);
                  stop = 1;
                  break;
               }
            }
            if(stop == 1) {
               break;
            }
         }
      }
   }
   
   private static boolean isFull(TTTBoard board) {
      int size = board.size();
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
   
   private static boolean winCondition(TTTBoard board, char who) {
   //Check if columns has a win condition
      int size = board.size;
      

   
   
      
      //checks columns
      for(int i = 0; i < size; i++) {
         firstChar = board.get(0,i);
         winChance = true;
         spaceCount = 0;
         //checks rows
         for(int j = 0; j < size; j++) {
         
            if(board.get(j,i) == ' ') {
               r = j;
               c = i;
               spaceCount++;
               
               if(spaceCount > 1) {
                  winChance = false;
                  break;
               }
            }
            
            else if(firstChar!= board.get(j,i)) {
               winChance = false;
               break;
            
            }
         }
      
         if(winChance == true) {
            board.set(r,c,who);
            return true;
         }
      
      }
   
 
   
   
   
   
   //Check if rows has a win condition
      for (int j = 0; j < size; j++) {
         firstChar = board.get(j,0);
         winChance = true;
         spaceCount = 0;
         //goes through columns
         for (int i = 0; i < size; i++) {
         
            if (board.get(j,i) == ' ') {
               r = j;
               c = i;
               spaceCount++;
               
               if(spaceCount > 1) {
                  winChance = false;
                  break;
               
               }
            }
                                
            else if (firstChar != board.get(j,i)) {
               winChance = false;
               break;
            
            }  
             
         }         
      
         if(winChance == true) {
            board.set(r,c,who);
            return true;
         
         }
      
      }
        
        
      //Check if diagonal from top left to bottom right has a win condition 
      firstChar = board.get(0,0);
      winChance = true;
      spaceCount = 0;
      for (int i = 0; i < size; i++) {
      
         if(board.get(i,i) == ' ') {
            dag = i;
            spaceCount++;    
         
            if(spaceCount > 1) {
               winChance = false;
               break;
            }
         
         }
                 
         else if (firstChar != board.get(i,i)) {
            winChance = false;
            break;
         }
                  
      }
        
      if(winChance == true) {
         board.set(dag,dag,who);
         return true;
      }
      
  
   
         
      //Check if diagonal from bottom left to top right has win condition
      firstChar = board.get(size-1,0);
      winChance = true;
      spaceCount = 0;
      for (int i = 0; i < size; i++) {
      
         if(board.get(size - i - 1,i) == ' ') {
            dag2 = size - i -1;
            dag = i;
            spaceCount++;
            
            if(spaceCount > 1) {
               winChance = false;
               break;
            }
         }
         
         else if(firstChar != board.get(size - i - 1,i)) {
            winChance = false;
            break;
         
         }      
      
      }
       
      if (winChance == true) {
         board.set(dag2,dag,who);
         return true;
      }
      
      return false;
   }
   
   private static boolean checkWinner(TTTBoard board,char who) {
      int size = board.size();
      for(int i=0; i<size; i++) {
         for (int j=0; j<size; j++) {
            if(board.get(i,j) == ' ') {
               board.set(i,j,who);
               if(board.winner() == who)
                  return true;
               else
                  board.set(i,j,' ');
            }
         }
      }
      return false;
   } 

}