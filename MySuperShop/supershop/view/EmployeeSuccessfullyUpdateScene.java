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

public class EmployeeSuccessfullyUpdateScene extends Application{
	Text AEmployeeSuccessfulUpdate;
	Button ASuccessfulButton;
	VBox ASuccessfulVBox;
	Scene scene;
	
public void start(Stage stage){
	AEmployeeSuccessfulUpdate = new Text("Successfully Updated ");
	AEmployeeSuccessfulUpdate.setFont(new Font(18));
		AEmployeeSuccessfulUpdate.setFill(Color.GREEN);
		AEmployeeSuccessfulUpdate.setStroke(Color.BLACK);
		AEmployeeSuccessfulUpdate.setStrokeWidth(.5);
		
		ASuccessfulButton=new Button("Back To Menu");
		ASuccessfulButton.setMaxWidth(Double.MAX_VALUE);
		ASuccessfulVBox=new VBox(10,AEmployeeSuccessfulUpdate,ASuccessfulButton);
		ASuccessfulVBox.setPadding(new Insets(160));
		scene=new Scene(ASuccessfulVBox,480,570);
		
		ASuccessfulButton.setOnAction(e->{
		AdminControl admin=new AdminControl();
		admin.start(stage);
		});
		
		stage.setScene(scene);
		stage.setTitle("Successfully Updated");
}
}