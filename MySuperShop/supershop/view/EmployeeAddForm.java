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
import supershop.model.Employee;
import supershop.service.EmployeeService;
import supershop.service.UserNameIdService;

public class EmployeeAddForm extends Application{
	Scene  AddEmployeescene;
	Button AddNewEmployeeButton,CancelAddEmployeeButton;
	Label FirstNameLabel,LastNameLabel,DateOfBirthLabel,AddressLabel,PhoneNumberLabel,JoinDateLabel,EmployeeTypeLabel,EmployeeSalaryLabel,EmployeePasswordLabel;
	TextField firstnameField,lastnameField,dateofbirthField,addressField,phonenumberField,joindateField,employeetypeField,employeesalaryField,NewEmployeePassword;
	HBox AddCancelBox;
	Separator FormBottomSeparate;
    VBox NewEmployeeBox;
	Employee EMP;
	UserNameIdService user;
	EmployeeService ES=new EmployeeService();
	
	public void start(Stage stage){
		AddNewEmployeeButton = new Button("\t\tADD    \t \t");
		CancelAddEmployeeButton = new Button("\t\tCANCEL\t\t\t");
		
		FirstNameLabel=new Label("First Name");
		LastNameLabel=new Label("Last Name");
		DateOfBirthLabel=new Label("Date Of Birth");
		AddressLabel=new Label("Address");
		PhoneNumberLabel=new Label("Phone Number");
		JoinDateLabel=new Label("Join Date");
		EmployeeTypeLabel=new Label("Employee Type");
		EmployeeSalaryLabel=new Label("Salary");
		EmployeePasswordLabel=new Label("Password");
		
		firstnameField= new TextField();
		lastnameField=new TextField();
		dateofbirthField=new TextField("DAY-MONTH-YEAR");
		addressField=new TextField();
		phonenumberField=new TextField();
		joindateField=new TextField("DAY-MONTH-YEAR");
		employeetypeField=new TextField("ADMIN/MANAGER/STAFF");
		employeesalaryField=new TextField();
		NewEmployeePassword=new PasswordField();
		
		AddCancelBox=new HBox(80);
		AddCancelBox.setPadding(new Insets(15));
		AddCancelBox.setPrefWidth(300);
		AddCancelBox.setSpacing(78);
		AddCancelBox.getChildren().addAll(AddNewEmployeeButton,CancelAddEmployeeButton);
		
		FormBottomSeparate=new Separator();
		
		NewEmployeeBox = new VBox(5);
		NewEmployeeBox.getChildren().addAll(FirstNameLabel,firstnameField,LastNameLabel,lastnameField,DateOfBirthLabel,dateofbirthField,AddressLabel,addressField,PhoneNumberLabel,phonenumberField,JoinDateLabel,joindateField,EmployeeTypeLabel,employeetypeField,EmployeeSalaryLabel,employeesalaryField,EmployeePasswordLabel,NewEmployeePassword,FormBottomSeparate,AddCancelBox);
		NewEmployeeBox.setPadding(new Insets(25));
		
		AddNewEmployeeButton.setOnAction(e->{
			String firstName = firstnameField.getText();
			String lastName = lastnameField.getText();
			String dateofbirth = dateofbirthField.getText();
			String address=addressField.getText();
			String phonenumber = phonenumberField.getText();
			String joindate =joindateField.getText();
			String Type = employeetypeField.getText();
			String salary=employeesalaryField.getText();
			String password=NewEmployeePassword.getText();
			EMP=new Employee(firstName,lastName,address,phonenumber,dateofbirth,joindate,Type,salary,password);
			String i=ES.Add(EMP);
			if(i!=null){
				user=new UserNameIdService();
				String pass=EMP.GetEmployeePassWord();
				int x=user.NewUserIdPass(i,pass);
				if(x==1){
				System.out.println(i);
				ASuccessfulAddScene AS= new ASuccessfulAddScene();
				AS.start(stage);
				}
			}
			else{
				System.out.println("ERROR");
				FailedAddScene failed=new FailedAddScene();
				failed.start(stage);
			}
		});
		CancelAddEmployeeButton.setOnAction(e->{
		AdminControl admin=new AdminControl();
		admin.start(stage);
		});
		
        AddEmployeescene = new Scene(NewEmployeeBox,480,570);
		stage.setScene( AddEmployeescene);
		stage.setTitle("Admin Control Scene");
	}
}