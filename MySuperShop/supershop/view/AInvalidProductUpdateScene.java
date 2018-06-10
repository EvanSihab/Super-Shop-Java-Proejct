package supershop.view;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.text.Text;
import javafx.scene.control.Separator;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class AInvalidProductUpdateScene extends Application{
	Text AInvalidProductUpdateText;
	Button ABackButton;
	VBox AInvalidProductUpdateSceneBox;
	Scene root;
	
	public void start(Stage stage){
		AInvalidProductUpdateText = new Text("      Invalid\t");
        AInvalidProductUpdateText.setFont(new Font(25));
		AInvalidProductUpdateText.setFill(Color.RED);
		AInvalidProductUpdateText.setStroke(Color.BLACK);
		AInvalidProductUpdateText.setStrokeWidth(.5);
		
		ABackButton=new Button(" BACK ");
		ABackButton.setMaxWidth(Double.MAX_VALUE);
		AInvalidProductUpdateSceneBox=new VBox(5,AInvalidProductUpdateText,ABackButton);
		AInvalidProductUpdateSceneBox.setPadding(new Insets(160));
		root=new Scene(AInvalidProductUpdateSceneBox,480,570);
		
		ABackButton.setOnAction(e->{
			UpdateProductInfoScene update=new UpdateProductInfoScene();
			update.start(stage);
		});
		
		stage.setScene(root);
		stage.setTitle("Invalid IMEI");
		stage.show();
		
	}
	
}