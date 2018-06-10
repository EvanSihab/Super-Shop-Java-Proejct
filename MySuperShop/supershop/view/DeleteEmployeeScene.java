package supershop.view;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.control.Separator;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import supershop.service.EmployeeService;

public class DeleteEmployeeScene extends Application{
	Scene root;
	Label DeleteEmployeeIDLabel;
	TextField DeleteIdField;
	Button DeleteAEmployeeButton,CancelDeleteEmployeeButton;
	HBox DeleteCancelBox;
	Separator DeleteBottomSeparate;
	VBox DeleteIdSearchBox;
	EmployeeService ES=new EmployeeService();
	public void start(Stage stage){
		DeleteEmployeeIDLabel=new Label("Enter Employee ID");
		DeleteIdField=new TextField();
		DeleteAEmployeeButton=new Button("DELETE");
		CancelDeleteEmployeeButton=new Button("CANCEL");
		DeleteAEmployeeButton.setMaxWidth(Double.MAX_VALUE);
		CancelDeleteEmployeeButton.setMaxWidth(Double.MAX_VALUE);
		DeleteCancelBox=new HBox(40);
		DeleteCancelBox.setPadding(new Insets(10));
		DeleteCancelBox.setPrefWidth(300);
		DeleteCancelBox.setSpacing(40);
		DeleteCancelBox.getChildren().addAll(DeleteAEmployeeButton,CancelDeleteEmployeeButton);
		DeleteBottomSeparate=new Separator();
		
		DeleteIdSearchBox = new VBox(5);
		DeleteIdSearchBox.getChildren().addAll(DeleteEmployeeIDLabel,DeleteIdField,DeleteBottomSeparate,DeleteCancelBox);
		DeleteIdSearchBox.setPadding(new Insets(150));
        root = new Scene(DeleteIdSearchBox,480,570);
		
		DeleteAEmployeeButton.setOnAction(e->{
		String DeleteID = DeleteIdField.getText();
			int i = ES.Delete(DeleteID);
			if(i==1){
            DeleteAEmployeeScene delete=new DeleteAEmployeeScene();
			delete.start(stage);
			}
			else
			{
				AInvalidIDScene invalidID= new AInvalidIDScene();
				invalidID.start(stage);
			}		
		});
		CancelDeleteEmployeeButton.setOnAction(e->{
		AdminControl admin=new AdminControl();
		admin.start(stage);
		});
		stage.setScene(root);
		stage.setTitle("Successfully Deleted");
	}
}