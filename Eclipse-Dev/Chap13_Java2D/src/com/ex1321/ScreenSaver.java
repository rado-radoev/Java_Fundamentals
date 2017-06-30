package com.ex1321;

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
	private int shapes;
	
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
			shapes = rnd.nextInt(50);
			if (shapes >= 0 && shapes <= 10) {
				g.drawLine(rnd.nextInt(this.getParent().getSize().width), 
						rnd.nextInt(this.getParent().getSize().height),
						rnd.nextInt(this.getParent().getSize().width),
						rnd.nextInt(this.getParent().getSize().height));
			}
			else if (shapes >= 11 && shapes <= 20) {
				g.drawOval(rnd.nextInt(this.getParent().getSize().width),
						rnd.nextInt(this.getParent().getSize().height),
						this.getParent().getSize().width,
						this.getParent().getSize().height);
			}
			else if (shapes >= 21 && shapes <= 30) {
				g.draw3DRect(this.getParent().getSize().width,
						rnd.nextInt(this.getParent().getSize().height),
						this.getParent().getSize().width,
						this.getParent().getSize().height, true);
			}
			else if (shapes >= 31 && shapes <= 40) {
				g.drawRoundRect(this.getParent().getSize().width,
						rnd.nextInt(this.getParent().getSize().height),
						this.getParent().getSize().width,
						this.getParent().getSize().height, rnd.nextInt(10), rnd.nextInt(20));
			}
			else if (shapes >= 41 && shapes <= 50) {
				int[] x = {10,80,90, 160, 200};
				int[] y = {90, 1 , 150, 96 ,55};
				g.drawPolygon(x, y, x.length);
			}
			
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		
	}
}
