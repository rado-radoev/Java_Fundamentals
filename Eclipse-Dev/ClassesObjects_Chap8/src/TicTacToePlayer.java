import java.util.Scanner;

public class TicTacToePlayer {
	
	private Scanner input = new Scanner(System.in);
	private static int playersCount = 0;
	private TicTacToeEnum playerFigure;
	private static boolean Xoccupied = false;;
	private static boolean Ooccupied = false;;
	
	private TicTacToeEnum player;
	
	public TicTacToePlayer() {
		playersCount++;
	}
	
	public TicTacToeEnum getPlayerFigure() {
		return playerFigure;
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
		if (figure.toUpperCase().equals("X")) {
			Xoccupied = true;
		}
		else if (figure.toUpperCase().equals("O")) {
			Ooccupied = true;
		}
	}
	
	// Check if the selected figure is available
	private boolean checkFicgureAvailable(String figure) {
		if (figure.toUpperCase().equals("X") && !Xoccupied ) {
			return true;
		}
		else if (figure.toUpperCase().equals("O") && !Ooccupied) {
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
			System.out.printf("Select figure. Choose between X and O: ");
			player1Figure = input.nextLine();	// read user input
			reserveFigure(player1Figure);
			if (checkFicgureAvailable(player1Figure)) {
				return;
			}
			else {
				System.out.printf("Figure %s already occupied. Choose another one%n", player1Figure);
				player1Figure = "";
			}
		}
	}
}
