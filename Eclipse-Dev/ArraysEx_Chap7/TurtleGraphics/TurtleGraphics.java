import java.util.Collections;

public class TurtleGraphics {
	
	private int[][] board = new int[20][20];	// board
	private int[] commands = {1,2,3,4,5,6,9};	// commands array
	int direction = 0;
	int positionX;	// row position
	int positionY; 	// column position
	int penPosition;

	public static void main(String[] args) {
		TurtleGraphics tg = new TurtleGraphics();
		int[] userCommands = {2,12,3,12,3,12,3,12,1,6,9};
		
		for (int i = 0; i < userCommands.length; i++) {
			switch (userCommands[i]) {
			case 1:
				tg.setPenPosition(0);
				break;
			case 2:
				tg.setPenPosition(1);
				break;
			case 3:
				tg.setDirection(userCommands[i]);
				break;
			case 4:
				tg.setDirection(userCommands[i]);
				break;
			case 6:
				tg.displayBoard();
				break;
			case 9:
				i = userCommands.length + 1;
				break;
			default:
				tg.move(userCommands[i]);
				break;
			}
		}
	}
	
	public int getPenPosition() {
		return penPosition;
	}

	public void setPenPosition(int penPosition) {
		this.penPosition = penPosition;
	}
	
	public void move(int position) {
		if (getDirection() == 0)
			moveDown(position);
		else if (getDirection() == 1)
			moveRight(position);
		else if	(getDirection() == -1)
			moveLeft(position);
		else
			moveUp(position);
	}

	public void moveUp(int position) {
		int row = positionX;
		int column = positionY;
		int i = 1;
		for (; position > 2; position--) {
			if (getPenPosition() == 0)
				board[row][column] = 0;
			else
				board[row][column] = 1;
			
			row -= i;			
		}
		positionX = row;
	}

	
	public void moveDown(int position) {
		int row = positionX;
		int column = positionY;
		
		for (; row < position; row++) {
			if (getPenPosition() == 0)
				board[row][column] = 0;
			else
				board[row][column] = 1;
		}
		positionX = row -1;
	}
	
	public void moveLeft(int position) {
		int row = positionX;
		int column = positionY;
		for (; row <= positionX; row++) {
			for (; position > 0; position--) {
				column -= 1;
				if (getPenPosition() == 0)
					board[row][column] = 0;
				else
					board[row][column] = 1;
			}
		}
		positionX = row - 1;
		positionY = column -1;
	}
	
	public void moveRight(int position) {
		int row = positionX;
		int column = positionY;
		for (; row <= positionX; row++) {
			for (int i = 0; i < position; i++)  {
				if (getPenPosition() == 0)
					board[row][column] = 0;
				else 
					board[row][column] = 1;
				
				column += 1;
			}
		}
		positionX = row - 1;
		positionY = column - 1;
	}
	
	public void setDirection(int direction) {
		// direction 0 -> down, 1 -> right, 2/-2 -> up, -1 -> left
		
		switch (direction) {
		case 3:
			if (this.direction == 0)
				this.direction++;
			else if (this.direction == 1)
				this.direction++;
			else if (this.direction == 2)
				this.direction = -1;
			else 
				this.direction = 0;
			break;
		case 4:
			if (this.direction == 0)
				this.direction--;
			else if(this.direction == -1)
				this.direction--;
			else if (this.direction == -2)
				this.direction = 1;
			else
				this.direction = 0;
			break;
		default:
			break;
		}
	}
	
	
	public int getDirection() {
		return direction;
	}

	public void displayBoard() {
		System.out.println(String.join("", Collections.nCopies(22, "-")));
		for (int row = 0; row < board.length; row++) {
			System.out.printf("%s", "|");
			for (int col = 0; col < board[row].length; col++) {
				System.out.printf("%d", board[row][col]);
			}
			System.out.printf("%s%n", "|");
		}
		System.out.println(String.join("", Collections.nCopies(22, "-")));
	}
	
}
