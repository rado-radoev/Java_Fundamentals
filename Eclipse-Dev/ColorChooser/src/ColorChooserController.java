/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.Property;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author superlamer
 */
public class ColorChooserController implements Initializable {
    
    @FXML private Slider redSlider;
    @FXML private Slider greenSlider;
    @FXML private Slider blueSlider;
    @FXML private Slider alphaSlider;
    @FXML private TextField redTextField;
    @FXML private TextField greenTextField;
    @FXML private TextField blueTextField;
    @FXML private TextField alphaTextField;
    @FXML private Rectangle colorRectangle;
    
    // instance variable for managing
    private int red = 0, green = 0, blue = 0;
    private double alpha = 1.0;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // bind textfield values to corresponding slider values
        redTextField.textProperty().bindBidirectional(redSlider.idProperty());
        redTextField.textProperty().bind(
            redSlider.valueProperty().asString("%.0f"));
        greenTextField.textProperty().bind(
            greenSlider.valueProperty().asString("%.0f"));
        blueTextField.textProperty().bind(
            blueSlider.valueProperty().asString("%.0f"));
        alphaTextField.textProperty().bind(
            alphaSlider.valueProperty().asString("%.1f"));
    
        // listeners that set rectangle's color based on slider change
        redSlider.valueProperty().addListener(
                (observableValue, oldValue, newValue) -> {
                    red = newValue.intValue();
                    colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
                });
        
        greenSlider.valueProperty().addListener(
                (observableValue, oldValue, newValue) -> {
                    green = newValue.intValue();
                    colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
                });
        
        blueSlider.valueProperty().addListener(
                (observableValue, oldValue, newValue) -> {
                    blue = newValue.intValue();
                    colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
                });
        
        alphaSlider.valueProperty().addListener(
                (observableValue, oldValue, newVlaue) -> {
                    alpha = newVlaue.doubleValue();
                    colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
                });
    }    
    
}
