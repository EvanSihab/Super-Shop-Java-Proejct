package supershop.view;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class DeleteAEmployeeScene extends Application{
	Text AEmployeeSuccessful;
	Button ASuccessfulButton,DeleteMoreEmployeeButton;
	VBox ABackVBox;
	Scene root;
	public void start(Stage stage){
		AEmployeeSuccessful = new Text(" Successfully Deleted ");
        AEmployeeSuccessful.setFont(new Font(18));
		AEmployeeSuccessful.setFill(Color.GREEN);
		AEmployeeSuccessful.setStroke(Color.BLACK);
		AEmployeeSuccessful.setStrokeWidth(.5);
		
		ASuccessfulButton=new Button("Back To Menu");
		ASuccessfulButton.setMaxWidth(Double.MAX_VALUE);
		DeleteMoreEmployeeButton=new Button("Delete More Employee");
		DeleteMoreEmployeeButton.setMaxWidth(Double.MAX_VALUE);
		ABackVBox=new VBox(5,AEmployeeSuccessful,DeleteMoreEmployeeButton,ASuccessfulButton);
		ABackVBox.setPadding(new Insets(160));
		root=new Scene(ABackVBox,480,570);
		
		ASuccessfulButton.setOnAction(e->{
		AdminControl admin=new AdminControl();
		admin.start(stage);});
		DeleteMoreEmployeeButton.setOnAction(e->{
			DeleteEmployeeScene delete=new DeleteEmployeeScene();
			delete.start(stage);
		});
		stage.setScene(root);
		stage.setTitle("Successfully Deleted");
		
	}
}