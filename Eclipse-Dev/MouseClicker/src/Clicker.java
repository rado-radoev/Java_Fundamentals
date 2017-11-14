import javax.swing.SwingWorker;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.List;
import javax.swing.JLabel;

public class Clicker extends SwingWorker<Void, Integer> {

	private Robot robot;
	private double delay;
	private int clickCount;
	private JLabel label = new JLabel();
	
	public JLabel getLabel() {
		return label;
	}
	
	public double getDelay() {
		return delay;
	}
	
	public void setDelay(double delay) {
		this.delay = delay;
	}
	
	@Override
	protected Void doInBackground() throws Exception {
		while (!isCancelled()) {
			click();
			publish(clickCount);
			Thread.sleep((long) getDelay());
		}
		return null;
	}
	
	protected void process (List<Integer> publishedValues) {
		for (Integer i : publishedValues) {
			label.setText(String.valueOf(i));
		}
	}
	
	protected void done() {
		// add code to execute when SwingWorker thread finished executing.
		// nothing here. I may add something later. 
	}
	
	
	private void click() {
		robot.mousePress(InputEvent.BUTTON1_MASK);
		try {
			robot.wait(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		++clickCount;
	}
}
