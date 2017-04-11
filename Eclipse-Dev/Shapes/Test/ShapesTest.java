// Get user input and create JFrame to display Shapes.
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ShapesTest {

	public static void main(String[] args) {
		// Get user's input
		String input = JOptionPane.showInputDialog(
				"Enter 1 to draw rectangles\n" + 
				"Enter 2 to draw ovals");
		
		int choice = Integer.parseInt(input); 	// Convert input to in
		
		// Create the panel with the user's input
		Shapes panel = new Shapes(choice);

		JFrame application = new JFrame();		// Create new JFrame
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.add(panel);
		application.setSize(300, 300);
		application.setVisible(true);
	}

}
