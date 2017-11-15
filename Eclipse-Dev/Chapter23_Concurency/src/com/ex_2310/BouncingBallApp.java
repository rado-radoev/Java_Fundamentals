package com.ex_2310;

import javax.swing.JFrame;
import java.util.concurrent.Executors;
import java.awt.Color;
import java.util.concurrent.ExecutorService;

public class BouncingBallApp {

	 
	  public static void main(String[] args) {
	    JFrame.setDefaultLookAndFeelDecorated(true);
	    JFrame frame = new JFrame("Bouncing Ball");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(300, 200);
	    frame.setContentPane(new BouncingBallTest());
	    BouncingBallTest bb = new BouncingBallTest(20, Color.YELLOW);
	    frame.setContentPane(bb);
	    frame.setVisible(true);
	  }

}
