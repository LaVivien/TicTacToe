package tictactoe;

public aspect CheckWin {
	pointcut checkGameOver(): call (public boolean Tictactoe.refreeCheck());
	
	after() returning(Object obj): checkGameOver() {
		if ((boolean) obj == true)
			System.out.println("ASPECT: Game over!!!!!!!!!!!!!!");
	}
}
