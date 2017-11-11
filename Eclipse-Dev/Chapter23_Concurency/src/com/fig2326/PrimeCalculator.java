package com.fig2326;

// Calculates the first n primes, displaying them as they are found
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingWorker;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

public class PrimeCalculator extends SwingWorker<Integer, Integer> {

	private static final SecureRandom generator = new SecureRandom();
	private final JTextArea intermediateJTextArea; // display found primes
	private final JButton getPrimesButton;
	private final JButton cancelButton;
	private final JLabel statusJLabel; // display status of calculation
	private final boolean[] primes; // boolean array for finding primes
	
	// consturtor
	public PrimeCalculator(int max, JTextArea intermediateJTextArea, JLabel statusJLabel, JButton getPrimesButton, JButton cancelButton) {
		this.intermediateJTextArea = intermediateJTextArea;
		this.statusJLabel = statusJLabel;
		this.getPrimesButton = getPrimesButton;
		this.cancelButton = cancelButton;
		primes = new boolean[max];
		Arrays.fill(primes, true); // initalize all prime elements to true
	}

	// finds all primes up to max using the Sieve of Earosthenes
	@Override
	protected Integer doInBackground() throws Exception {
		int count = 0; // the number of primes found
		
		// starting at the 3rd value, cycle through the array and put
		// false as the value of any greater number that is a multiple
		for (int i = 2; i < primes.length; i++) {
			if (isCancelled()) { // if calculation has been canceled
				return count;
			}
			else {
				setProgress(100 * (i + 1) / primes.length);
				
				try {
					Thread.sleep(generator.nextInt(5));
				} catch (InterruptedException ex) {
					statusJLabel.setText("Worker thread interrupted");
					return count;
				}
				
				if (primes[i]) { // i is prime 
					publish(i); // make i available to display in prime list
					++count;
					
					for (int j = i + 1; j < primes.length; j += i) {
						primes[j] = false; // i is not prime
					}
				}
			}
		}
		
		return count;
	}
	
	// display published values in primes list
	protected void process(List<Integer> publishedVals) {
		for (int i = 0; i < publishedVals.size(); i++) {
			intermediateJTextArea.append(publishedVals.get(i) + "\n");
		}
	}
	
	// code to execute when doInBackground completes
	protected void done() {
		getPrimesButton.setEnabled(true); // enable Get Primes button
		cancelButton.setEnabled(false); // disable canncel button
		
		try {
			// retireve and display doInBackground return value
			statusJLabel.setText("Found " + get() + " primes.");
		} catch (InterruptedException | ExecutionException | CancellationException ex) {
			statusJLabel.setToolTipText(ex.getMessage());
		}
	}
	
}





















