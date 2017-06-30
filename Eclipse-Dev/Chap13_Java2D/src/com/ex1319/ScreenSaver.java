package com.ex1319;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;


public class ScreenSaver extends JPanel implements ActionListener {

	private Random rnd;
	private Timer timer;
	
	public ScreenSaver() {
		rnd = new Random(System.currentTimeMillis());
		timer = new Timer(900, this);
		timer.start();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	

		for (int i = 0; i < UserInput.getIterations(); i++) {
			g.setColor(new Color(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
			g.drawLine(rnd.nextInt(this.getParent().getSize().width), 
					rnd.nextInt(this.getParent().getSize().height),
					rnd.nextInt(this.getParent().getSize().width),
					rnd.nextInt(this.getParent().getSize().height));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		
	}
}
