package com.passwordprompt;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * HPassword Prompt
 *
 */
public class PasswordPrompt extends JFrame
{
    // set fields
    private final JTextField username;
    private final JPasswordField password;
    private final JButton ok;
    private final JButton cancel;
    private final JCheckBox bold;
    private final JCheckBox italic;

    public PasswordPrompt()  {
      super("Password prompt");
      setLayout(new FlowLayout());

      // Construct username textField
      username = new JTextField("Enter username here");
      add(username);  // add username to JFrame

      // Construct password fields
      password = new JPasswordField("Password");
      add(password);

      // Construct OK button
      ok = new JButton("OK");
      add(ok);

      // construct fancy cancel
       Icon cancelIcon = new ImageIcon(getClass().getResource("cancelIcon.gif"));
     // Icon cancelRollOverIcon = new ImageIcon(getClass().getResource("cancelRollOverIcon.jpg"));
      cancel = new JButton("Cancel");
      //cancel.setRolloverIcon(cancelRollOverIcon);
      add(cancel);

      // construct bold checkbox
      bold = new JCheckBox("Bold");
      add(bold);


      // construct italic checkbox
      italic = new JCheckBox("Italic");
      add(italic);

      // create handlers for all fields
      TextFieldHandler textFieldHandler = new TextFieldHandler();
      PasswordFieldHandler passwordFieldHandler = new PasswordFieldHandler();
      ButtonHandler buttonHandler = new ButtonHandler();
      CheckBoxHandler checkBoxHandler = new CheckBoxHandler();

      username.addActionListener(textFieldHandler);
      password.addActionListener(passwordFieldHandler);
      ok.addActionListener(buttonHandler);
      cancel.addActionListener(buttonHandler);
      bold.addItemListener(checkBoxHandler);
      italic.addItemListener(checkBoxHandler);

    } // end PasswordPrompt constructor

    // Inner classes to handle events
    private class TextFieldHandler implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent event) {
        String str = "";

        if (event.getSource() == username)
          str = String.format("Your username is: %s", event.getActionCommand());
        
        JOptionPane.showMessageDialog(PasswordPrompt.this, str);
        
      }
    } // end TextFieldHandler

    private class PasswordFieldHandler implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent event) {
        String passwordComplexity = "^[a-zA-Z]\\w{3,14}$";
        if (event.getActionCommand().matches(passwordComplexity)) {
          JOptionPane.showMessageDialog(PasswordPrompt.this, "Your password is complex!");
        } else {
          JOptionPane.showMessageDialog(PasswordPrompt.this, "Your password is weak!");
        }

      }
    } // end PasswordFieldPainter

    private class ButtonHandler implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent event) {
        JOptionPane.showMessageDialog(PasswordPrompt.this, "You pressed " + event.getSource());
      }
    } // end ButtonHandler

    private class CheckBoxHandler implements ItemListener {
      @Override
      public void itemStateChanged(ItemEvent event) {
        Font font = null;

        if (bold.isSelected() && italic.isSelected())
          font = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
        else if (bold.isSelected())
          font = new Font("Serif", Font.BOLD, 14);
        else if (italic.isSelected())
          font = new Font("Serif", Font.ITALIC, 14);
        else
          font = new Font("Serif", Font.PLAIN, 14);


        username.setFont(font);
      }

    } // end CheckBoxHandler


} // end PasswordPrompt class
