package com.ex1328_1329;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.PaintContext;
import java.awt.Rectangle;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.BasicStroke;
import java.awt.Color;
import java.util.Random;

public class ShapeChooser extends JPanel {
	
	private Random rnd;

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		rnd = new Random(System.currentTimeMillis());
		
		for (int i = 0; i < 20; i++) {
			g2d.setPaint(new Color(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
	 		if (UserPanel.getSelectedItem() == 0) {
				g2d.draw(new Rectangle(rnd.nextInt(getParent().getWidth()), rnd.nextInt(getParent().getHeight()), rnd.nextInt(100), rnd.nextInt(100)));		
			}
	 		else if (UserPanel.getSelectedItem() == 1) {
	 			g2d.draw(new Ellipse2D.Double(rnd.nextInt(getParent().getWidth()), rnd.nextInt(getParent().getHeight()), rnd.nextInt(200), rnd.nextInt(200)));
	 		}
	 		else if (UserPanel.getSelectedItem() == 2) {
				g2d.draw(new Arc2D.Double(rnd.nextInt(getParent().getWidth()), rnd.nextInt(getParent().getHeight()), rnd.nextInt(200), rnd.nextInt(200), 0, rnd.nextInt(360), Arc2D.OPEN));
	 		} 
	 		else if (UserPanel.getSelectedItem() == 3) {
	 			g2d.draw(new Arc2D.Double(rnd.nextInt(getParent().getWidth()), rnd.nextInt(getParent().getHeight()), rnd.nextInt(200), rnd.nextInt(200), 0, rnd.nextInt(360), Arc2D.PIE));
	 		} 
	 		else if (UserPanel.getSelectedItem() == 4) {
	 			if (i % 2 == 0) {
	 	 			g2d.setStroke(new BasicStroke(rnd.nextFloat()));
		 			g2d.draw(new Line2D.Double(rnd.nextInt(getParent().getWidth()), rnd.nextInt(getParent().getHeight()), rnd.nextInt(getParent().getWidth() / 2), rnd.nextInt(getParent().getHeight() / 2)));;
		 			
		 			float[] dashes = {10};
		 			g2d.setStroke(new BasicStroke(1,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND,10,dashes,0));;
		 			g2d.draw(new Line2D.Double(rnd.nextInt(getParent().getWidth()), rnd.nextInt(getParent().getHeight()), rnd.nextInt(getParent().getWidth() / 2), rnd.nextInt(getParent().getHeight() / 2)));;

		 			g2d.setStroke(new BasicStroke(1.0f));	 				
	 			}

	 		}
		}


	}
}
