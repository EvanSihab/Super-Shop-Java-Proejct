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
import supershop.service.UserNameIdService;

public class ASuccessfulAddScene extends Application{
	public String newUserID,newUserPass;
	Text AEmployeeSuccessful,NewUserIdText,NewUserPassText;
	Button ASuccessfulButton,AddMoreEmployeeButton;
	VBox ASuccessfulVBox;
	Scene scene;
	UserNameIdService user;
	Separator top,bottom;
	
public void start(Stage stage){
	user=new UserNameIdService();
	newUserID=user.getnewUserId();
	newUserPass=user.getnewUserPass();
	top=new Separator();
	bottom=new Separator();
	
	AEmployeeSuccessful = new Text(" Successfully Added ");
	AEmployeeSuccessful.setFont(new Font(18));
		AEmployeeSuccessful.setFill(Color.GREEN);
		AEmployeeSuccessful.setStroke(Color.BLACK);
		AEmployeeSuccessful.setStrokeWidth(.5);
		
		NewUserIdText= new Text(" ID   \t\t : "+newUserID);
		NewUserIdText.setFont(new Font(15));
		NewUserIdText.setFill(Color.BLACK);
		NewUserIdText.setStroke(Color.WHITE);
		NewUserIdText.setStrokeWidth(.5);
		
		NewUserPassText= new Text(" Password : "+newUserPass);
		NewUserPassText.setFont(new Font(15));
		NewUserPassText.setFill(Color.BLACK);
		NewUserPassText.setStroke(Color.WHITE);
		NewUserPassText.setStrokeWidth(.5);
		
		ASuccessfulButton=new Button("Back To Menu");
		ASuccessfulButton.setMaxWidth(Double.MAX_VALUE);
		AddMoreEmployeeButton=new Button("Add More Employee");
		AddMoreEmployeeButton.setMaxWidth(Double.MAX_VALUE);
		ASuccessfulVBox=new VBox(10,AEmployeeSuccessful,top,NewUserIdText,NewUserPassText,bottom,AddMoreEmployeeButton,ASuccessfulButton);
		ASuccessfulVBox.setPadding(new Insets(160));
		scene=new Scene(ASuccessfulVBox,480,570);
		
		ASuccessfulButton.setOnAction(e->{
		AdminControl admin=new AdminControl();
		admin.start(stage);
		});
		AddMoreEmployeeButton.setOnAction(e->{
		EmployeeAddForm Form= new EmployeeAddForm();
		Form.start(stage);
		});
		
		stage.setScene(scene);
		stage.setTitle("Successfully Added");
}
}