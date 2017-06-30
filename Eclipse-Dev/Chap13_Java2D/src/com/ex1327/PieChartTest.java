package com.ex1327;

import javax.swing.JFrame;

public class PieChartTest {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Pie chart");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.setVisible(true);
		
		PieChart pieChart = new PieChart();
		frame.add(pieChart);

	}

}
