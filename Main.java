package tictactoe;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Tictactoe game = new Tictactoe();
		String player = "X";
		int playerNum = 1;
		do {
			System.out.println(game.printBoard());
			System.out.println("Player "+playerNum+"'s turn");
			System.out.print("enter row (0 ~ 2, -1 to exit): ");
			int row = input.nextInt();
			if(row == -1) 
				break;
			System.out.print("enter column (0 ~ 2): ");
			int column = input.nextInt();
			boolean b = game.setPlay(row,  column, player);
			if (!b)
				continue;			
			if(game.refreeCheck()) {
				if(game.hasWinner())
					System.out.println(game.printBoard() + "\nPlayer " + playerNum + " wins!");
				else
					System.out.println("it is draw");
				break;
			}
			if(player == "X") {
				player = "O";	
				playerNum =2;
			}
			else {
				player = "X";
				playerNum = 1;
			}
		} while(true);
		System.out.println("Goodbye!");
		input.close();
	}
}
