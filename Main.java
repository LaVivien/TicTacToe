

import java.util.*;

public class Main {
	private static int rows = 4;
	private static int columns = 4;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Tictactoe game = new Tictactoe(rows, columns);
		String player = "X";
		int playerNum = 1;
		int row = -1 , column = -1 ;
		while(true) {
			System.out.println(game.printBoard());
			System.out.println("Player " + playerNum + "'s turn");		
			while (true) {
				System.out.print("enter row (0 ~ "+ (rows-1)+"): ");		
				try {
					row = input.nextInt();			
					break;
				} catch (Exception e) {
					System.out.println("Invalid row input, try again.");
	    			input.next();
				}
			}
			while (true) {
				System.out.print("enter column (0 ~ "+ (columns-1)+"): ");
				try {
					column = input.nextInt();
			
					break;
				} catch (Exception e) {
					System.out.println("Invalid column input, try again.");
	    			input.next();
				}
			}
			if (!checkRange(row, rows) || !checkRange(column, columns)) {
				System.out.println("input are beyond range, try again.");
				continue;
			}
			boolean b = game.setPlayer(row,  column, player);
			if (!b) //check taken
				continue;			
			if (game.checkTie() || game.checkWinner()) {
				if(game.checkWinner())
					System.out.println(game.printBoard() + "\nPlayer " + playerNum + " wins!");
				else
					System.out.println("it is draw");
				break;
			}
			if (player == "X") {
				player = "O";	
				playerNum = 2;
			}
			else {
				player = "X";
				playerNum = 1;
			}
		}
		System.out.println("Goodbye!");
		input.close();
	}
	
	private static boolean checkRange(int n, int max) {
		if (n < 0 || n >= max)
			return false;
		else
			return true;					
	}
}
