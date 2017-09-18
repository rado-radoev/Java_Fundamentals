package com.ex2210;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.BorderLayout;

public class TextClass extends JFrame {
	
	private final JTextField jTextField;
	private final JLabel jLabel;
	private final JSliderCurVal jSliderCurVal;
	private final JSlider jSlider;
	private final JPanel jPanel;

	public TextClass() {
		super("Synchronizing a JSlider and a JTextField");
		
		jTextField = new JTextField(2);
		jLabel = new JLabel("JSlider value: ");
		jSliderCurVal = new JSliderCurVal();
		jPanel = new JPanel();
		
		// setup JSlider
		jSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 100, 50);
		jSlider.setMajorTickSpacing(1);
		jSlider.setPaintTicks(true);
		
		// JSlider event listener
		jSlider.addChangeListener(
				event -> {jTextField.setText(String.valueOf(jSlider.getValue()));}
				);
		
		jPanel.add(jLabel);
		jPanel.add(jTextField);
		
		add(jPanel, BorderLayout.NORTH);
		add(jSlider, BorderLayout.SOUTH);
	}
	
}
