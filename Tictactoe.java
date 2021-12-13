
public class Tictactoe {
	private String[][] board;
	private int rows, columns;
	private int turnNum = 0;
	
	//constructor
	public Tictactoe(int r, int c) {
		rows = r;
		columns = c;
		board = new String[rows][columns];
		this.initializeBoard();
	}
	
	//initializing board and fill with empty spaces
	public void initializeBoard() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				board[i][j] = "   ";
			}
		}
	}

	//set player's move
	public boolean setPlayer(int i, int j, String player) {
		if (board[i][j].equals("   ")) {
			board[i][j] = " " + player + " ";
			return true;
		} else {
			System.out.println("The cell is already taken.");
			return false;
		}
	}
	
	public boolean checkTie() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (board[i][j].equals("   "))
					return false;
			}
		}
		return true;
	}
	
	//checking
	public boolean checkWinner() {		 	
    	//check rows
    	if (checkRows())	
    		return true;
    	
    	//checking columns
    	if (checkColumns())
    		return true;
    	
    	//checking diagonals, top left to bottom right
    	if (checkDiagonal())
    		return true;
    	
    	//checking diagonals, bottom left to top right
    	if (checkDiagonal2())
    		return true;
    	return false;	
	}
	
	//check rows
	private boolean checkRows() {		
    	for (int i = 0; i < rows; i++) {   
    		boolean res=true;
    		for (int j = 0 ; j < columns-1 ; j++ ) {
    			if ( board[i][j].equals("   ") || !board[i][j].equals(board[i][j+1])) {
    				res=false;
    			} 
    		}
    		if (res==true)
    			return true;
    	}
    	return false;
	}
	
	//checking columns
	private boolean checkColumns() {		
		for (int j = 0; j < columns; j++) {
			boolean res = true;
			for (int i = 0 ;i < rows-1 ; i++ ) {
    			if ( board[i][j].equals("   ") || !board[i][j].equals(board[i+1][j])) {
    				res= false;
    			}
    		}		
			if (res==true)
				return true;
    	}
    	return false;
	}
	
	//checking diagonals, top left to bottom right
	private boolean checkDiagonal() { 	 	
    	for (int i = 0; i < rows-1; i++) {   		
    		if (board[i][i].equals("   ") || !board[i][i].equals(board[i+1][i+1]))
   				return false;
    	}	
    	return true;
	}
	
	//checking diagonals, bottom left to top right
	private boolean checkDiagonal2() { 	 	
    	for (int i = 0, j= columns-1; i < rows-1; i++, j--) { 	  		
    		if (board[i][j].equals("   ") || !board[i][j].equals(board[i+1][j-1]))
    				return false;
    	}	
    	return true;
	}

	//Print board to screen
	public String printBoard() {
		String strBoard = "\nTurn " + (++turnNum) + ":\n";
		for (int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				if(j == columns-1)
					strBoard += board[i][j];
				else
					strBoard += board[i][j] + "|";
			}
			if (i != rows-1) {
				strBoard += "\n";
				for (int j=0;j< columns;j++) {
					if (j == columns-1)
						strBoard += "___";
					else
						strBoard +="____";
				}
				strBoard += "\n";
			}
		}
		return strBoard;
	}
}
