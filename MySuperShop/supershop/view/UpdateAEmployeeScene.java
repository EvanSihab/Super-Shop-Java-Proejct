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
import java.util.ArrayList;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.text.Text;
import javafx.scene.control.Separator;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import supershop.service.EmployeeService;

public class UpdateAEmployeeScene extends Application{
	public static String ID;
	public static String FName;
	public static String LName;
	public static String DOB;
	public static String EAds;
	public static String ContactNumber;
	public static String EType;
	public static String Esalary;
	
	Scene  UpdateEmployeescene;
	Button UpdateNewEmployeeButton,CancelUpdateEmployeeButton;
	Label FirstNameLabel,LastNameLabel,DateOfBirthLabel,AddressLabel,PhoneNumberLabel,EmployeeTypeLabel,EmployeeSalaryLabel;
	TextField firstnameField,lastnameField,dateofbirthField,addressField,phonenumberField,employeetypeField,employeesalaryField;
	HBox UpdateCancelBox;
	Separator FormBottomSeparate;
    VBox NewEmployeeBox;
	EmployeeUpdateScene update;
	EmployeeService ES=new EmployeeService();
	
	public void start(Stage stage){
		update=new EmployeeUpdateScene();
		ID=update.getEmployeeId();
		FName=update.getFirstName();
		LName=update.getLastName();
		DOB=update.getDateOfBirth();
		EAds=update.getAddress();
		ContactNumber=update.getPhoneNumber();
		EType=update.getType();
		Esalary=update.getsalary();
		
		UpdateNewEmployeeButton = new Button("\t\tUPDATE\t \t");
		CancelUpdateEmployeeButton = new Button("\t\tCANCEL\t\t\t");
		
		FirstNameLabel=new Label("First Name");
		LastNameLabel=new Label("Last Name");
		DateOfBirthLabel=new Label("Date Of Birth");
		AddressLabel=new Label("Address");
		PhoneNumberLabel=new Label("Phone Number");
		EmployeeTypeLabel=new Label("Employee Type");
		EmployeeSalaryLabel=new Label("Salary");
	
		firstnameField= new TextField(FName);
		lastnameField=new TextField(LName);
		dateofbirthField=new TextField(DOB);
		addressField=new TextField(EAds);
		phonenumberField=new TextField(ContactNumber);
		employeetypeField=new TextField(EType);
		employeesalaryField=new TextField(Esalary);
		
		UpdateCancelBox=new HBox(80);
		UpdateCancelBox.setPadding(new Insets(15));
		UpdateCancelBox.setPrefWidth(300);
		UpdateCancelBox.setSpacing(78);
		UpdateCancelBox.getChildren().addAll(UpdateNewEmployeeButton,CancelUpdateEmployeeButton);
		
		FormBottomSeparate=new Separator();
		
		NewEmployeeBox = new VBox(5);
		NewEmployeeBox.getChildren().addAll(FirstNameLabel,firstnameField,LastNameLabel,lastnameField,DateOfBirthLabel,dateofbirthField,AddressLabel,addressField,PhoneNumberLabel,phonenumberField,EmployeeTypeLabel,employeetypeField,EmployeeSalaryLabel,employeesalaryField,FormBottomSeparate,UpdateCancelBox);
		NewEmployeeBox.setPadding(new Insets(25));
		
		UpdateNewEmployeeButton.setOnAction(e->{
			String firstName = firstnameField.getText();
			String lastName = lastnameField.getText();
			String dateofbirth = dateofbirthField.getText();
			String address=addressField.getText();
			String phonenumber = phonenumberField.getText();
			String Type = employeetypeField.getText();
			String salary=employeesalaryField.getText();
			
			int i=ES.Update(ID,firstName,lastName,dateofbirth,address,phonenumber,Type,salary);
			if(i==1){
            EmployeeSuccessfullyUpdateScene success= new EmployeeSuccessfullyUpdateScene();
			success.start(stage);
			}
			else{
				System.out.println("ERROR");
				FailedAddScene failed=new FailedAddScene();
				failed.start(stage);
			}
		});
		CancelUpdateEmployeeButton.setOnAction(e->{
		AdminControl admin=new AdminControl();
		admin.start(stage);
		});
		
        UpdateEmployeescene = new Scene(NewEmployeeBox,480,570);
		stage.setScene( UpdateEmployeescene);
		stage.setTitle("Update Employee");
	}
}