/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author superlamer
 */
public class MPGCalculatorController implements Initializable {
    
    @FXML
    private TextField milesDrivenTextField;
    
    @FXML
    private TextField gasUsedTextField;
    
    @FXML
    private TextField mpgTextField;
    
    @FXML
    private Button calculateButton;
    
    @FXML
    private void buttonAcrion(ActionEvent event) {
        double miles = Double.valueOf(milesDrivenTextField.getText());
        double gas = Double.valueOf(gasUsedTextField.getText());
        
        double mpg = miles / gas;
        
        mpgTextField.setText(String.valueOf(mpg));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
