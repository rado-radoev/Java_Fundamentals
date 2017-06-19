package com.ex1300;

import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.Graphics;


public class Shapes extends JPanel  {

	Eyes eyes = new Eyes();
	Iris iris = new Iris();
	
	JPanel shapes;
	
	public Shapes() {
		super();
		setLayout(new FlowLayout());
		
		shapes = new JPanel();
		shapes.add(eyes);
		shapes.add(iris);
	}
}

