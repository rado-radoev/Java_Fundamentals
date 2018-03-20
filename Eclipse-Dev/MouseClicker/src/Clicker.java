import javax.swing.SwingWorker;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
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
	PointerInfo a;
	Point b;
	
	public Clicker(double delay, JLabel label) {
		this.delay = delay;
		this.label = label;
	}
	
	
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
		robot = new Robot();
		Point mouseOldPosition = MouseInfo.getPointerInfo().getLocation();;
	    Point mouseNewPosition = MouseInfo.getPointerInfo().getLocation();
		
		while (!isCancelled()) {
			mouseOldPosition = MouseInfo.getPointerInfo().getLocation();
			
			if (mouseOldPosition.x == mouseNewPosition.x && mouseOldPosition.y == mouseNewPosition.y) {
				click();
				publish(clickCount);
			}
			Thread.sleep((long) (getDelay() * 1000.0));
			mouseNewPosition = MouseInfo.getPointerInfo().getLocation();
			

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
	    // need to get mouse current position, otherwise
		// it is sent back to original position
		a = MouseInfo.getPointerInfo();
		b = a.getLocation();
		robot.mouseMove((int)b.getX(), (int)b.getY());
		
		robot.mousePress(InputEvent.BUTTON1_MASK);
		//System.out.println("mouse clicked");
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		//System.out.println("mouse released");
		robot.waitForIdle();
		++clickCount;
	}
}
