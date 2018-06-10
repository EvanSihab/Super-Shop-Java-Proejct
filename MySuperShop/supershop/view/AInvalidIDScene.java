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

public class AInvalidIDScene extends Application{
	Text AInvalidIdText;
	Button ABackButton;
	VBox AInvalidIdBox;
	Scene root;
	
	public void start(Stage stage){
		AInvalidIdText = new Text("      Invalid\t");
        AInvalidIdText.setFont(new Font(25));
		AInvalidIdText.setFill(Color.RED);
		AInvalidIdText.setStroke(Color.BLACK);
		AInvalidIdText.setStrokeWidth(.5);
		
		ABackButton=new Button(" BACK ");
		ABackButton.setMaxWidth(Double.MAX_VALUE);
		AInvalidIdBox=new VBox(5,AInvalidIdText,ABackButton);
		AInvalidIdBox.setPadding(new Insets(160));
		root=new Scene(AInvalidIdBox,480,570);
		
		ABackButton.setOnAction(e->{
			DeleteEmployeeScene delete= new DeleteEmployeeScene();
			delete.start(stage);
		});
		
		stage.setScene(root);
		stage.setTitle("Invalid Id");	
	}	
}