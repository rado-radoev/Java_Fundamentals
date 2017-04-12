// Fig 5.27
import java.awt.Graphics;
import javax.swing.JPanel;

public class Shapes extends JPanel {

	private int choice; 	// user's choice of which shape to draw
	
	
	public Shapes (int userChoice) {
		choice = userChoice;	
	}
	
	// draws cascade of shapes starting from the top left corner
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
        
        //calculates the centre of the panel
        int xPoint = (int)JPanel.CENTER_ALIGNMENT;

		
		for (int i = 0; i < 12; i++) {
			// pick the shape based on the user's choice
			switch (choice) 
			{
			case 1: // draws rectangles;
				g.drawRect(10 + i * 10, 10 + i * 10, 50 + i * 10, 50 + i * 10);
				break;
			case 2:	// draws ovals
				g.drawOval(10 + i * 10, 10 + i * 10, 50 + i * 10, 50 + i * 10);
				break;
			case 3:
				g.drawOval(xPoint + (i * 5), xPoint + (i * 5), (i * 10), (i * 10));
				break;
			}
		}
	}
}
