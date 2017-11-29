/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author superlamer
 */
public class PainterController implements Initializable {
    
    
    @FXML private RadioButton blackRadioButton;
    @FXML private RadioButton redRadioButton;
    @FXML private RadioButton greenRadioButton;    
    @FXML private RadioButton blueRadioButton;
    @FXML private RadioButton smallRadioButton;
    @FXML private RadioButton mediumRadioButton;
    @FXML private RadioButton largeRadioButton;
    @FXML private AnchorPane drawingAreaAnchorPane;
    @FXML private ToggleGroup colorToggleGroup;
    @FXML private ToggleGroup sizeToggleGroup;
    
    // manage Painter state
    private PenSize radius = PenSize.MEDIUM;
    private Paint brushColor = Color.BLACK;
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // user data on a control can be any Object
        blackRadioButton.setUserData(Color.BLACK);
        redRadioButton.setUserData(Color.RED);
        greenRadioButton.setUserData(Color.GREEN);
        blueRadioButton.setUserData(Color.BLUE);
        smallRadioButton.setUserData(PenSize.SMALL);
        mediumRadioButton.setUserData(PenSize.MEDIUM);
        largeRadioButton.setUserData(PenSize.LARGE);
    }    
    
    // handle drawingArea's onMouseDraggged MouseEvent
    @FXML
    public void drawingAreaMouseDragged(MouseEvent e) {
        Circle newCircle = new Circle(e.getX(), e.getY(),
            radius.getRadius(), brushColor);
        drawingAreaAnchorPane.getChildren().add(newCircle);
    }
    
    // handles color RadioButton's ActionEvents
    @FXML
    private void colorRadioButtonSelected(ActionEvent e) {
        // user data for each color RadioButton is the corresponging color
        brushColor = 
                (Color) colorToggleGroup.getSelectedToggle().getUserData();
    }
    
    // handles size RadioButton's ActionEvents
    @FXML
    private void sizeRadioButtonSelected(ActionEvent e) {
        // user data for each radio button is the corresponging user data
        radius = 
                (PenSize) sizeToggleGroup.getSelectedToggle().getUserData();
    }
    
    // handles Undo Button's ActionEvents
    @FXML
    private void undoButtonPressed(ActionEvent e) {
        int count = drawingAreaAnchorPane.getChildren().size();
    
        // if there are any shapes remove the last one added
        if (count > 0) {
            drawingAreaAnchorPane.getChildren().remove(count - 1);
        }
    }
    
    // handles Clear Button's ActionEvents
    @FXML private void clearButtonActionPressed(ActionEvent e) {
        drawingAreaAnchorPane.getChildren().clear();
    }
} 
