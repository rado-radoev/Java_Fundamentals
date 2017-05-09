import java.util.Scanner;

public class TicTacToePlayer {
	
	private Scanner input = new Scanner(System.in);
	private static int playersCount;
	private TicTacToeEnum playerFigure;
	private boolean Xoccupied = false;
	private boolean Ooccupied = false;
	
	private TicTacToeEnum player;
	
	public TicTacToePlayer() {
		++playersCount;
	}
	
	// Check how many players have been initialized. Only 2 allowed.
	private boolean checkNumberOfPlayers() {
		if (playersCount > 2) {
			return false;
		}
		return true;
	}
	
	// reserve a figure, so other player cannot select it
	private void reserveFigure(String figure) { 
		if (figure.toUpperCase() == "X") {
			Xoccupied = true;
		}
		else if (figure.toUpperCase() == "O") {
			Ooccupied = true;
		}
	}
	
	// Check if the selected figure is available
	private boolean checkFicgureAvailable(String figure) {
		if (figure.toUpperCase() == "X" && !Xoccupied ) {
			return true;
		}
		else if (figure.toUpperCase() == "O" && !Ooccupied) {
			return true;
		}
		return false;
	}
	
	public void selectUserFigure() {
		if (!checkNumberOfPlayers()) {	// Exit if more than two player are instantiated
			System.out.printf("Maximum number of players reached - %d%n", playersCount);
			return;
		}
		
		String player1Figure = "";
		// Loop until user selects X or O
		while (!player1Figure.toUpperCase().equals("X") && !player1Figure.toUpperCase().equals("O")) {
			System.out.printf("Select player figure. Choose between X and O: %n");
			player1Figure = input.nextLine();	// read user input
			System.out.print(player1Figure);	
		}


		reserveFigure(player1Figure);	// reserve the user figure 
		playerFigure = TicTacToeEnum.valueOf(player1Figure);
	}
}
