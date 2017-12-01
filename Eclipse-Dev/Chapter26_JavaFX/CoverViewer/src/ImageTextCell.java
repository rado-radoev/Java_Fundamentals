// Fig. 26.16: ImageTextCell.java
// Custom ListView cell factory that displays an Image and text
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

public class ImageTextCell extends ListCell<Book>
{
   @Override 
   protected void updateItem(Book item, boolean empty) 
   {
       // required to ensure that cell displays properly
      super.updateItem(item, empty);

      if (empty || item == null)
      {
         setGraphic(null); // don't display anything
      }
      else 
      {
         // create layout for cell
         VBox vbox = new VBox(8.0); // 8 points of gap between controls
         vbox.setAlignment(Pos.CENTER); // center contents horizontally
         
         // configure thumbnail image
         ImageView thumbImageView = 
            new ImageView(new Image(item.getThumbImage()));
         thumbImageView.setPreserveRatio(true);
         thumbImageView.setFitHeight(100.0); // thumbnail 100 points tall
         vbox.getChildren().add(thumbImageView); // attach to Vbox
         
         // configure text
         Label label = new Label(item.getTitle());
         label.setWrapText(true); // wrap if text too wide to fit in cell
         label.setTextAlignment(TextAlignment.CENTER); // center text
         vbox.getChildren().add(label); // attach to VBox
         
         setGraphic(vbox); // attach custom layout to ListView cell
         setPrefWidth(USE_PREF_SIZE); // use preferred size for cell width
      }
   }
}
