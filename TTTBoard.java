
public class TTTBoard {
	
	char [][] board;
	int size;	
    /**
     * If no argument is provided to the constructor, a standard 3x3 board
     * is created.
     */
    public static final int DEFAULT_SIZE = 3;
	
	public TTTBoard(int size) {
		if (size < 1)
			throw new IllegalArgumentException("Size must be 1 or greater");
		this.size = size;
		board = new char[size][size];
		for(int i=0; i < size; i++)
			for(int j=0; j < size; j++)
				board[i][j] = ' ';
	}
	
	public TTTBoard() {
		this(DEFAULT_SIZE);
	}
	
	public char winner() {
		boolean win = true;
		char first;
		// Check the columns
		for (int i = 0; i < size; i++) {
			first = board[0][i];
			win = true;
			for (int j = 1; j < size; j++) {
				if (board[j][i] != first) {
					win = false;
					break;
				}
			}
			if (win && first != ' ')
				return first;
		}
		
		// Check the rows
		for (int j = 0; j < size; j++) {
			first = board[j][0];
			win = true;
			for (int i = 1; i < size; i++) {
				if (board[j][i] != first) {
					win = false;
					break;
				}
			}
			if (win && first != ' ')
				return first;
		}
		
		// check the diagonal down
		
		first = board[0][0];
		win = true;
		for (int i = 1; i < size; i++) {
			if (first != board[i][i]) {
				win = false;
				break;
			}
		}
		
		if (win && first != ' ')
			return first;
		
		first = board[size -1][0];
		win = true;
		for (int i = 1; i < size; i++) {
			if (board[size - i - 1][i] != first) {
				win = false;
				break;
			}
		}
		
		if (win && first != ' ')
			return first;
		
		// no winner found, so return a space
		return ' ';

	}
	
	public int size() {
		return size;
	}
	
	public void set(int r, int c, char ch) {
		if (r < 0 || c < 0 || r > size -1 || c > size - 1)
			throw new IndexOutOfBoundsException("Index out of bounds");
		board[r][c] = ch;
	}
	
	public char get(int r, int c) {
		if (r < 0 || c < 0 || r > size -1 || c > size - 1)
			throw new IndexOutOfBoundsException("Index out of bounds");
		return board[r][c];
	}
	
	public String toString() {
		String result = "";
		// first row
		// first x
		result = result + board[0][0];
		// loop to repeat the rest of bar element
		// | x
		for (int j=1;j< size; j++) 
			result = result + "|" + board[0][j];
		result = result + "\n";
		
		// rest of the rows 
		// separator first, then the data
		for (int i=1;i< size;i++) {
			// separator
			result = result + "-";
			for (int j=1;j< size; j++) 
				result = result + "+-";
			result = result + "\n";
			// first element in row
			result = result + board[i][0];
			// rest of row
			for (int j=1;j< size; j++) 
				result = result + "|" + board[i][j];
			result = result + "\n";
		}
		return result;
	}

}
