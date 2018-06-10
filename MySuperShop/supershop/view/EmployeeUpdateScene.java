package supershop.view;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import java.util.ArrayList;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.text.Text;
import javafx.scene.control.Separator;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import supershop.service.EmployeeService;

public class EmployeeUpdateScene extends Application{
	public static String EmployeeID;
	public static String FirstName;
	public static String LastName;
	public static String DateOfBirth;
	public static String Address;
	public static String PhoneNumber;
	public static String JoinDate;
	public static String Type;
	public static String salary;
	
	public void SetAll(String EmployeeID,String FirstName,String LastName,String DateOfBirth,String Address,String PhoneNumber,String JoinDate,String Type,String salary)
	{
		this.EmployeeID=EmployeeID;
		this.FirstName=FirstName;
		this.LastName=LastName;
		this.DateOfBirth=DateOfBirth;
		this.Address=Address;
		this.PhoneNumber=PhoneNumber;
		this.JoinDate=JoinDate;
		this.Type=Type;
		this.salary=salary;
	}
	public String getEmployeeId(){return this.EmployeeID;}
	public String getFirstName(){return this.FirstName;}
	public String getLastName(){return this.LastName;}
	public String getDateOfBirth(){return this.DateOfBirth;}
	public String getAddress(){return this.Address;}
	public String getPhoneNumber(){return this.PhoneNumber;}
	public String getType(){return this.Type;}
	public String getsalary(){return this.salary;}
	public String getJoinDate(){return this.JoinDate;}
	
	Scene root;
	Label UpdateEmployeeIDLabel;
	TextField UpdateIdField;
	Button UpdateAEmployeeButton,CancelUpdateEmployeeButton;
	HBox UpdateCancelBox;
	Separator UpdateBottomSeparate;
	VBox UpdateIdSearchBox;
	EmployeeService ES;
	public void start(Stage stage){
		ES=new EmployeeService();
		UpdateEmployeeIDLabel=new Label("Enter Employee ID");
		UpdateIdField=new TextField();
		UpdateAEmployeeButton=new Button("CONTINUE");
		CancelUpdateEmployeeButton=new Button(" CANCEL  ");
		UpdateAEmployeeButton.setMaxWidth(Double.MAX_VALUE);
		CancelUpdateEmployeeButton.setMaxWidth(Double.MAX_VALUE);
		UpdateCancelBox=new HBox(15);
		UpdateCancelBox.setPadding(new Insets(10));
		UpdateCancelBox.setPrefWidth(300);
		UpdateCancelBox.setSpacing(15);
		UpdateCancelBox.getChildren().addAll(UpdateAEmployeeButton,CancelUpdateEmployeeButton);
		UpdateBottomSeparate=new Separator();
		
		UpdateIdSearchBox = new VBox(5);
		UpdateIdSearchBox.getChildren().addAll(UpdateEmployeeIDLabel,UpdateIdField,UpdateBottomSeparate,UpdateCancelBox);
		UpdateIdSearchBox.setPadding(new Insets(150));
        root = new Scene(UpdateIdSearchBox,480,570);
		
		UpdateAEmployeeButton.setOnAction(e->{
		String UpdateID = UpdateIdField.getText();
			int i = ES.Search(UpdateID);
			if(i==1){
            UpdateAEmployeeScene update=new UpdateAEmployeeScene();
			update.start(stage);
			}
			else
			{
				AInvalidIDScene invalidID= new AInvalidIDScene();
				invalidID.start(stage);
			}		
		});
		CancelUpdateEmployeeButton.setOnAction(e->{
		AdminControl admin=new AdminControl();
		admin.start(stage);
		});
		stage.setScene(root);
		stage.setTitle("Update Employee Info");
	}
}