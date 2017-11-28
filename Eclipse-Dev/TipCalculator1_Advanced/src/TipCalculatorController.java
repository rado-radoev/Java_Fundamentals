/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
/**
 *
 * @author superlamer
 */
public class TipCalculatorController {

    // formatters for currency and percentages
    private static final NumberFormat currency = 
            NumberFormat.getCurrencyInstance();
    private static final NumberFormat percent = 
            NumberFormat.getPercentInstance();
    
    private BigDecimal tipPercentage = new BigDecimal(.15); // 15% default
    
    @FXML
    private TextField partySizeTextField;
    
    @FXML
    private TextField totalPerPersonTextField;
    
    @FXML
    private TextField amountTextField;
    
    @FXML
    private Label tipPercentageLabel;
    
    @FXML
    private Slider tippercentagesliSlider;
    
    @FXML
    private TextField tiptextfiField;
    
    @FXML
    private TextField totalTextField;
    
    @FXML
    private void calculateButtonPressed(ActionEvent event) {
        try {
            BigDecimal partySize = new BigDecimal(partySizeTextField.getText());
            BigDecimal amount = new BigDecimal(amountTextField.getText());
            BigDecimal tip = amount.multiply(tipPercentage);
            BigDecimal total = amount.add(tip);
            
            totalPerPersonTextField.setText(currency.format(partyCalculator(total, partySize)));
            tiptextfiField.setText(currency.format(tip));
            totalTextField.setText(currency.format(total));
            
            
        } catch (NumberFormatException nfe) {
            amountTextField.setText("Enter amount");
            amountTextField.selectAll();
            amountTextField.requestFocus();
        }
    }
    
    // called by FXMLLoader to initialize the controller
    public void intialize() {
        // 0-4 rounds down 5-9 rounds up
        currency.setRoundingMode(RoundingMode.HALF_UP);
        
        // listener for changes to tipPercentageSlider's value
        tippercentagesliSlider.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> ov, Number oldValue,
                            Number newValue) {
                        tipPercentage = BigDecimal.valueOf(newValue.intValue() / 100.0);
                        tipPercentageLabel.setText(percent.format(tipPercentage));
                    }
        });
    }
    
    private BigDecimal partyCalculator(BigDecimal total, BigDecimal partySize) {
        BigDecimal perPerson = total.divide(partySize);
        
        return perPerson;
        
    }
}
