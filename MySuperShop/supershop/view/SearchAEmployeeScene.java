package supershop.view;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.text.Text;
import javafx.scene.control.Separator;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class SearchAEmployeeScene extends Application{
	public static String ID;
	public static String FName;
	public static String LName;
	public static String DOB;
	public static String EAds;
	public static String ContactNumber;
	public static String EType;
	public static String Esalary;
	public static String EJoinDate;
	
	Scene  SearchAEmployeescene;
	Button SearchAEmployeeButton,CancelSearchEmployeeButton;
	Label NameLabel,DateOfBirthLabel,AddressLabel,PhoneNumberLabel,EmployeeTypeLabel,EmployeeSalaryLabel,EmployeeIdLabel,EmployeeJoinDateLabel;
	Text nameText,dateofbirthText,addressText,phonenumberText,employeetypeText,employeesalaryText,EmployeeIdText,EmployeeJoinDateText;
	Text EmployeeInfoText;
	HBox SearchCancelBox;
	HBox EmployeeIdBox,EmployeeNameBox,DateOfBirthBox,EmployeeAddressBox,PhoneNumberBox,JoinDateBox,EmployeeTypeBox,EmployeeSalaryBox;
	Separator FormBottomSeparate;
	Separator TopSeparator;
    VBox SearchEmployeeBox;
	EmployeeUpdateScene update;
	
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
		EJoinDate=update.getJoinDate();
		
		SearchAEmployeeButton = new Button("SEARCH MORE");
		CancelSearchEmployeeButton = new Button("BACK TO MENU");
		
		NameLabel=new Label("Name\t\t\t : ");
		DateOfBirthLabel=new Label("Date Of Birth\t\t : ");
		AddressLabel=new Label("Address\t\t\t : ");
		PhoneNumberLabel=new Label("Phone Number\t : ");
		EmployeeTypeLabel=new Label("Position\t\t\t : ");
		EmployeeSalaryLabel=new Label("Salary\t\t	 : ");
		EmployeeJoinDateLabel=new Label("Join Date\t\t\t : ");
		EmployeeIdLabel=new Label("ID\t\t\t\t : ");
		
		EmployeeInfoText = new Text("\t     EMPLOYEE INFO\t");
        EmployeeInfoText.setFont(new Font(20));
		EmployeeInfoText.setFill(Color.WHITE);
		EmployeeInfoText.setStroke(Color.BLACK);
		EmployeeInfoText.setStrokeWidth(1);
		
		EmployeeIdText=new Text(ID);
		nameText=new Text(FName+" "+LName);
		dateofbirthText=new Text(DOB);
		addressText=new Text(EAds);
		phonenumberText=new Text(ContactNumber);
		employeetypeText=new Text(EType);
		EmployeeJoinDateText=new Text(EJoinDate);
		employeesalaryText=new Text(Esalary);
		
		EmployeeIdBox=new HBox(10,EmployeeIdLabel,EmployeeIdText);
		EmployeeNameBox=new HBox(10,NameLabel,nameText);
		DateOfBirthBox=new HBox(10,DateOfBirthLabel,dateofbirthText);
		EmployeeAddressBox=new HBox(10,AddressLabel,addressText);
		PhoneNumberBox=new HBox(10,PhoneNumberLabel,phonenumberText);
		EmployeeTypeBox=new HBox(10,EmployeeTypeLabel,employeetypeText);
		JoinDateBox=new HBox(10,EmployeeJoinDateLabel,EmployeeJoinDateText);
		EmployeeSalaryBox=new HBox(10,EmployeeSalaryLabel,employeesalaryText);
		
		SearchCancelBox=new HBox(40);
		SearchCancelBox.setPadding(new Insets(15));
		SearchCancelBox.setPrefWidth(300);
		SearchCancelBox.setSpacing(40);
		SearchCancelBox.getChildren().addAll(SearchAEmployeeButton,CancelSearchEmployeeButton);
		
		FormBottomSeparate=new Separator();
		TopSeparator=new Separator();
		
		SearchEmployeeBox = new VBox(5);
		SearchEmployeeBox.getChildren().addAll(EmployeeInfoText,TopSeparator,EmployeeIdBox,EmployeeNameBox,DateOfBirthBox,EmployeeAddressBox,PhoneNumberBox,EmployeeTypeBox,JoinDateBox,EmployeeSalaryBox,FormBottomSeparate,SearchCancelBox);
		SearchEmployeeBox.setPadding(new Insets(100));
		
		SearchAEmployeeButton.setOnAction(e->{
			SearchEmployeeScene search=new SearchEmployeeScene();
			search.start(stage);
		});
		CancelSearchEmployeeButton.setOnAction(e->{
		AdminControl admin=new AdminControl();
		admin.start(stage);
		});
		
        SearchAEmployeescene = new Scene(SearchEmployeeBox,480,570);
		stage.setScene( SearchAEmployeescene);
		stage.setTitle("Employee Info");
	}
}