import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseClickerFrame extends JFrame {

	private JLabel delayJLabel;
	private JLabel clickCounterJLabel = new JLabel();
	private JTextField delayJTextField;
	private JButton okJButton;
	private JButton cancelJButton;
	private final JPanel mainJpanel;
	private Clicker clicker;
	
	public MouseClickerFrame() {
		
		// set default layout	
		setLayout(new BorderLayout());
		
		// create mainPanel
		mainJpanel = new JPanel(new FlowLayout());
		
		// set up JLabel
		delayJLabel = new JLabel("Seconds delay:");
		mainJpanel.add(delayJLabel);
		
		// create text field
		delayJTextField = new JTextField("seconds", 10);
		mainJpanel.add(delayJTextField);
		
		
		// create the two JButtons
		okJButton = new JButton("OK");
		cancelJButton = new JButton("Cancel");
		
		
		delayJTextField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				delayJTextField.setText("");
			}
		});
		
		okJButton.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						int delay = Integer.valueOf(delayJTextField.getText());
						clicker = new Clicker(delay, clickCounterJLabel);
						
						clicker.execute();
						okJButton.setEnabled(false);
						cancelJButton.setEnabled(true);
					}
				}
			);
			

		cancelJButton.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						clicker.cancel(true);
						okJButton.setEnabled(true);
						cancelJButton.setEnabled(false);
					}
				}
			);
		
		// add the two buttons to the JPanel
		mainJpanel.add(okJButton);
		mainJpanel.add(cancelJButton);
		
		
		
		// construct the JFrame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 200);
		
		// add mainJPanel to JFrame
		add(mainJpanel, BorderLayout.CENTER);
		add(clickCounterJLabel, BorderLayout.SOUTH);
	}
	
	
	
}
















