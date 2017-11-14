package com.ex_2310;

import javax.swing.JFrame;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class BouncingBallApp {

	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		BouncingBall bb = new BouncingBall();	
		JFrame jf = new JFrame("Bouncing ball");
		jf.add(bb);
		
		executorService.execute(bb);
		
		jf.setVisible(true);
		jf.setSize(300, 200);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
