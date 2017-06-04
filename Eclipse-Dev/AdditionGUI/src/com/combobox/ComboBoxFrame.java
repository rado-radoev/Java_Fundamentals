package com.combobox;
import java.awt.FlowLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ComboBoxFrame extends JFrame {
	
	private final JComboBox<String> imagesJComboBox;
	private final JLabel label;
	
	private static final String[] names = {
			"bug1.gif", "bug2.gif", "travelbug.gif", "buganim.gif"};
	
	private final Icon[] icons = {
			new ImageIcon(getClass().getResource("/resources/bug1.gif")),
			new ImageIcon(getClass().getResource("/resources/bug2.gif")),
			new ImageIcon(getClass().getResource("/resources/travelbug.gif")),
			new ImageIcon(getClass().getResource("/resources/buganim.gif"))};
	
	// combox box constructor add JComboBox to JFrame
	public ComboBoxFrame() {
		super("Testing JComboBox");
		setLayout(new FlowLayout());
		
		imagesJComboBox = new JComboBox<String>(names);
		imagesJComboBox.setMaximumRowCount(3);
		
		imagesJComboBox.addItemListener(
				new ItemListener() {	// annonymous inner class
					
					@Override
					public void itemStateChanged(ItemEvent e) {
						if (e.getStateChange() == ItemEvent.SELECTED) {
							label.setIcon(icons[imagesJComboBox.getSelectedIndex()]);
						}
						
					}
				});
		
		add(imagesJComboBox);
		label = new JLabel(icons[0]);
		add(label);
	}
}
















