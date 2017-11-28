/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.NumberFormat;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Slider;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author superlamer
 */
public class MortageCalculatorController implements Initializable {
    
    private Alert alert;
    
    private static final NumberFormat currency = 
            NumberFormat.getCurrencyInstance();
    
    private static final NumberFormat percent = 
            NumberFormat.getPercentInstance();
    
    @FXML
    private TextField purchagePriceTextField;
    
    @FXML
    private TextField downPaymentTextField;
    
    @FXML
    private TextField interestRateTextField;
    
    @FXML
    private TextField monthlyPaymentTextField;
    
    @FXML
    private Label durationLabel;
    
    @FXML
    private Button calculateButton;
    
    @FXML
    private Slider durationSlider;
    
    @FXML
    private void buttonHandler (ActionEvent event) {
        if (event.getSource() == calculateButton) {
            try {
                monthlyPaymentTextField.setText("");
                checkEmptyFields();
                
                double purcasePrice = Double.valueOf(purchagePriceTextField.getText());
                double downPayment = Double.valueOf(downPaymentTextField.getText());
                double annualInterest = Double.valueOf(interestRateTextField.getText());
                double monthlyInterest = annualInterest / 12;
                double loanYears = durationSlider.getValue();
                double loanMonths = loanYears * 12; 
                double price = purcasePrice - downPayment;
                
                double monthlyPayment = price * (
                         (monthlyInterest * Math.pow(1 + monthlyInterest, loanMonths)) / (Math.pow(1 + monthlyInterest, loanMonths) - 1));
                //BigDecimal purchasePrice = new BigDecimal(purchagePriceTextField.getText());
                //BigDecimal downPayment = new BigDecimal(downPaymentTextField.getText());
                //BigDecimal annualInterest = new BigDecimal(interestRateTextField.getText());
                //BigDecimal monthlyInterest = annualInterest.divide(new BigDecimal("12"), MathContext.DECIMAL32);

                

                monthlyPaymentTextField.setText(currency.format(monthlyPayment));
                
            } catch (NumberFormatException nfe) {
                NumberFormatEx();
            }   
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        currency.setRoundingMode(RoundingMode.HALF_UP);
        currency.setMaximumFractionDigits(5);
        currency.setMaximumIntegerDigits(5);
                
        durationSlider.valueProperty().addListener(
                new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                durationLabel.setText("Duration " + (newValue.intValue() % 10 == 0 ? newValue.intValue() : oldValue.intValue()) + "years");
            }
        });
    }    
    
    private void NumberFormatEx() {
        alert = new Alert(Alert.AlertType.ERROR, "Only number accepted", ButtonType.OK);
        alert.showAndWait();
        purchagePriceTextField.setText("Enter price");
        purchagePriceTextField.selectAll();
        downPaymentTextField.clear();
        durationSlider.setValue(20);
        monthlyPaymentTextField.clear();
    }
    
    private void checkEmptyFields() throws NumberFormatException {
        if (purchagePriceTextField.getText().equals("") || 
            downPaymentTextField.getText().equals("") || 
            interestRateTextField.getText().equals("")) {
                throw new NumberFormatException("Empty fileds are not allowed!");
        }
    }
}
