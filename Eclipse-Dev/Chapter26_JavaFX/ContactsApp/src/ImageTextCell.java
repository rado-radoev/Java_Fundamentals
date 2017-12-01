/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author superlamer
 */

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

public class ImageTextCell extends ListCell<Contact> {
    @Override
    protected void updateItem(Contact contact, boolean empty) {
        // required to ensure that cell displayes propertly
        super.updateItem(contact, empty);
        
        if (empty || contact == null) {
            setGraphic(null); // don't display anything
        } else {         
            
            // create layout for cell
            HBox hbox = new HBox(4.0); // 4 point of gap between controls
            hbox.setAlignment(Pos.CENTER_LEFT); // center contentes horizontally
            
            // configure thumbnail image
            ImageView thumbImageView = 
                    new ImageView(new Image(contact.getAvatar()));
            thumbImageView.setPreserveRatio(true);
            thumbImageView.setFitHeight(20.0); // thumbnail 100 point tall
            hbox.getChildren().add(thumbImageView); // attach to vbox
            
            // configure text
            Label label = new Label(contact.toString());
            label.setWrapText(true);
            label.setTextAlignment(TextAlignment.JUSTIFY);
            hbox.getChildren().add(label);
            
            setGraphic(hbox); // attach custom layout to listview cell
            setPrefWidth(USE_PREF_SIZE);
        }
    }
}
