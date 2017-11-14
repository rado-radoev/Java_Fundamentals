import javax.swing.SwingWorker;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.List;
import javax.swing.JLabel;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class Clicker extends SwingWorker<Void, Integer> {

	private Robot robot;
	private double delay;
	private int clickCount;
	private JLabel label = new JLabel();
	
	public JLabel getLabel() {
		return label;
	}
	
	public int getClickCount() {
		return clickCount;
	}
	
	public double getDelay() {
		return delay;
	}
	
	public void setDelay(double delay) {
		this.delay = delay;
	}
	
	@Override
	protected Void doInBackground() throws Exception {
		//ExecutorService executorService = Executors.newCachedThreadPool();
		while (!isCancelled()) {
			click();
			publish(clickCount);
			Thread.sleep((long) (getDelay() / 1000.0));
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
		System.out.println("mouse clicker");
		try {
			robot.wait(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		System.out.println("mouse released");
		++clickCount;
	}
}
