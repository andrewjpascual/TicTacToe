import java.util.*;

public class TicTac {
    private static char SPACE = ' ';

    ArrayList<String> myBoards;

    public TicTac() {
        myBoards = new ArrayList<String>();
    }

    public void printResults() {
        System.out.println("#boards = " + myBoards.size());
    }

    public void process(char[] board) {
        myBoards.add(new String(board));
        if (myBoards.size() % 10000 == 0) {
            System.out.println(myBoards.size());
        }
    }

    /**
     * Make a move and generate all subsequent moves from  a board and 
     * given the player to move.
     * @param board contains X's and O's and there are some number of 
     * spaces on the board as specified by <code>spacesFree</code>
     * @param spacesFree the number of spaces in parameter <code>board</code>, i.e.,
     * non X/O characters
     * @param toMove is either 'X' or 'O' depending on who is to move
     */
   
    private void makeMove(char[] board, int spacesFree, char toMove)

    {
        char nextToMove = 'O';   // next character to move
        if (toMove == 'O') {     // 'O' about to move?
            nextToMove = 'X';    // 'X' goes next if 'O' goes now
        }
        if (spacesFree != 0) {   // some place to go?
            
            int len = board.length;

            // look at all 9 board locations, for each one
            // that's a space, put the toMove character in
            // that location, then recurse with one less
            // free location. When the recursion returns,
            // undo the placing of the toMove character
            // by making it a space, then continue looking
            // for the next location in which toMove char
            // could be placed

            for (int k = 0; k < len; k++) {
                if (board[k] == SPACE) {
                    board[k] = toMove;
                    process(board);                 // record another board

                    makeMove(board, spacesFree - 1, // one less location free
                            nextToMove);

                    board[k] = SPACE;               // undo move, continue
                }
            }
        }
    }

    public void genBoards() {
        String allBlank = "         "; // 9 spaces
        makeMove(allBlank.toCharArray(), 9, 'X');
    }

    public static void main(String[] args) {
        TicTac tt = new TicTac();
        tt.genBoards();
        tt.printResults();
    }
}