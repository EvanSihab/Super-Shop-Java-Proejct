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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class AInvalidIMEI extends Application{
	Text AInvalidIMEI;
	Button ABackButton;
	VBox AInvalidIMEIBox;
	Scene root;
	
	public void start(Stage stage){
		AInvalidIMEI = new Text("      Invalid\t");
        AInvalidIMEI.setFont(new Font(25));
		AInvalidIMEI.setFill(Color.RED);
		AInvalidIMEI.setStroke(Color.BLACK);
		AInvalidIMEI.setStrokeWidth(.5);
		
		ABackButton=new Button(" BACK ");
		ABackButton.setMaxWidth(Double.MAX_VALUE);
		AInvalidIMEIBox=new VBox(5,AInvalidIMEI,ABackButton);
		AInvalidIMEIBox.setPadding(new Insets(160));
		root=new Scene(AInvalidIMEIBox,480,570);
		
		ABackButton.setOnAction(e->{
			DeleteProductScene deleteproduct= new DeleteProductScene();
			deleteproduct.start(stage);
		});
		
		stage.setScene(root);
		stage.setTitle("Invalid IMEI");
		
	}
	
}