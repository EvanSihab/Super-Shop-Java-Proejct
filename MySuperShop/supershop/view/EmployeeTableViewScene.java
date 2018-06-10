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
import javafx.scene.control.Separator;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.collections.FXCollections;
import javafx.scene.control.cell.PropertyValueFactory;
import supershop.service.EmployeeService;
import supershop.model.EmployeeList;

public class EmployeeTableViewScene extends Application{
	Text EmployeeListText;
	Button BackButton;
	Separator BottomSeparator,topSeparator;
	VBox root;
	Scene scene;
	Stage stage;
	EmployeeService service;
	TableView<EmployeeList> employeeTable;
	public void start(Stage stage){
		
		EmployeeListText = new Text("\t\t     All Employees Information");
        EmployeeListText.setFont(new Font(20));
		EmployeeListText.setFill(Color.WHITE);
		EmployeeListText.setStroke(Color.BLACK);
		EmployeeListText.setStrokeWidth(1);
		topSeparator=new Separator();
		BottomSeparator=new Separator();
		BackButton =new Button("BACK TO MENU");
		BackButton.setMaxWidth(Double.MAX_VALUE);
		
		employeeTable=new TableView<EmployeeList>();
		
		TableColumn firstnameColumn = new TableColumn("First Name");
		TableColumn lastnameColumn = new TableColumn("Last Name");
		TableColumn dateofbirthColumn = new TableColumn("Date Of Birth");
		TableColumn addressColumn = new TableColumn("Address");
		TableColumn employeePhoneColumn= new TableColumn("Phone Number");
		TableColumn joindateColumn = new TableColumn("Join Date");
		TableColumn TypeColumn = new TableColumn("Type");
		TableColumn salaryColumn = new TableColumn("Salary");
		TableColumn idColumn = new TableColumn("ID");
		
		idColumn.setCellValueFactory(new PropertyValueFactory<EmployeeList, String>("employeeId"));
		firstnameColumn.setCellValueFactory(new PropertyValueFactory<EmployeeList, String>("firstname"));
		lastnameColumn.setCellValueFactory(new PropertyValueFactory<EmployeeList, String>("lastname"));
		dateofbirthColumn.setCellValueFactory(new PropertyValueFactory<EmployeeList, String>("dateofbirth"));
		addressColumn.setCellValueFactory(new PropertyValueFactory<EmployeeList, String>("employeeaddress"));
		employeePhoneColumn.setCellValueFactory(new PropertyValueFactory<EmployeeList, String>("employeephone"));
		joindateColumn.setCellValueFactory(new PropertyValueFactory<EmployeeList, String>("joindate"));
		TypeColumn.setCellValueFactory(new PropertyValueFactory<EmployeeList, String>("employeetype"));
		salaryColumn.setCellValueFactory(new PropertyValueFactory<EmployeeList, String>("employeesalary"));
		
		employeeTable.getColumns().addAll(idColumn,firstnameColumn,lastnameColumn,dateofbirthColumn,addressColumn,employeePhoneColumn,joindateColumn,TypeColumn,salaryColumn);
		try{
			service = new EmployeeService();
			employeeTable.setItems(FXCollections.observableArrayList(service.getAll()));
			}
			catch(Exception ex){
				System.out.println(ex);
				}
				BackButton.setOnAction(e->{
					AdminControl admin=new AdminControl();
					admin.start(stage);
				});
				root = new VBox(10);
				root.setPadding(new Insets(50,10,50,10));
				root.getChildren().addAll(EmployeeListText,topSeparator,employeeTable,BottomSeparator,BackButton);
				scene = new Scene(root,480,570);
				stage.setScene(scene);
				stage.setTitle("Employee List");
				}
				}