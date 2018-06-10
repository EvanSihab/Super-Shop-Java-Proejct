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
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.text.Text;
import javafx.scene.control.Separator;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import supershop.service.UserNameIdService;

public class AdminControl extends Application{
	public static String id;
	public String getAdminId(){return this.id;}
	UserNameIdService UID;
	HBox ChangePassBox;
	HBox ProductControlOptionBox;
	HBox AdminControlOptionBox;
	HBox SellOptionBox;
	VBox root;
	Scene scene;
	Stage stage;
	
	Separator topSeparator,midSeparator,sellSeparator,bottomSeparator;
	Text AdminText;
	Text EmployeeOptionText;
	Text ProductOptionText;
	Text SellOptionText;
	Text OtherOptionText;
	Button AddEmployeeButton;
	Button DeleteEmployeeButton;
	Button UpdateEmployeeButton;
	Button SearchEmployeeButton;
	Button GetAllEmployeeButton;
	Button AddProductButton;
	Button DeleteProductButton;
	Button UpdateProductButton;
	Button SearchProductButton;
	Button GetAllProductButton;
	Button SellProductButton;
	Button AllSellButton;
	Button LogoutButton;
	Button ChangePasswordButton;
	
	public void start(Stage stage){
		UID=new UserNameIdService();
		id=UID.getUserId();
		System.out.println(id);
		topSeparator = new Separator();
		topSeparator.setPadding(new Insets(5, 0, 0, 0));
		midSeparator = new Separator();
		midSeparator.setPadding(new Insets(5, 0, 0, 0));
		sellSeparator = new Separator();
		sellSeparator.setPadding(new Insets(5, 0, 0, 0));
		bottomSeparator = new Separator();
		bottomSeparator.setPadding(new Insets(5, 0, 0, 0));  
		
        AdminText = new Text(0, 0,"\t\tAdmin ControlPanel");
        AdminText.setFont(new Font(20));
		AdminText.setFill(Color.AQUA);
		AdminText.setStroke(Color.BLACK);
		AdminText.setStrokeWidth(1);
		
		//Employee Options
		EmployeeOptionText = new Text(0, 0,"Employee Options : ");
		EmployeeOptionText.setFont(new Font(16));
		EmployeeOptionText.setFill(Color.BLACK);
		EmployeeOptionText.setStroke(Color.WHITE);
		EmployeeOptionText.setStrokeWidth(.65);
		
		OtherOptionText = new Text(0, 0,"Other Options : ");
		OtherOptionText.setFont(new Font(16));
		OtherOptionText.setFill(Color.BLACK);
		OtherOptionText.setStroke(Color.WHITE);
		OtherOptionText.setStrokeWidth(.65);
		 
        AddEmployeeButton = new Button("   ADD   ");
		DeleteEmployeeButton = new Button(" DELETE  ");
		UpdateEmployeeButton = new Button(" UPDATE  ");
		SearchEmployeeButton = new Button(" SEARCH ");
		GetAllEmployeeButton = new Button("    ALL    ");
		LogoutButton= new Button("\tLog Out\t\t");
		ChangePasswordButton= new Button("Change Password");
		
		AddEmployeeButton.setMaxWidth(Double.MAX_VALUE);
		DeleteEmployeeButton.setMaxWidth(Double.MAX_VALUE);
		UpdateEmployeeButton.setMaxWidth(Double.MAX_VALUE);
		SearchEmployeeButton.setMaxWidth(Double.MAX_VALUE);
		GetAllEmployeeButton.setMaxWidth(Double.MAX_VALUE);
		LogoutButton.setMaxWidth(Double.MAX_VALUE);
		ChangePasswordButton.setMaxWidth(Double.MAX_VALUE);
		
		ChangePassBox = new HBox(10);
		ChangePassBox.setPadding(new Insets(10));
		ChangePassBox.setPrefWidth(60);
		ChangePassBox.setSpacing(10);
		ChangePassBox.getChildren().addAll(ChangePasswordButton,LogoutButton);
		
		AdminControlOptionBox = new HBox(10);
		AdminControlOptionBox.setPadding(new Insets(10));
		AdminControlOptionBox.setPrefWidth(60);
		AdminControlOptionBox.setSpacing(8);
		AdminControlOptionBox.getChildren().addAll(AddEmployeeButton,DeleteEmployeeButton,UpdateEmployeeButton,SearchEmployeeButton,GetAllEmployeeButton);
       
	   //Product Options
		ProductOptionText = new Text(0, 0,"Product Options : ");
		ProductOptionText.setFont(new Font(16));
		ProductOptionText.setFill(Color.BLACK);
		ProductOptionText.setStroke(Color.WHITE);
		ProductOptionText.setStrokeWidth(.65);
		 
        AddProductButton = new Button("   ADD   ");
		DeleteProductButton = new Button(" DELETE  ");
		UpdateProductButton = new Button(" UPDATE  ");
		SearchProductButton = new Button(" SEARCH ");
		GetAllProductButton = new Button("    ALL    ");
		
		AddProductButton .setMaxWidth(Double.MAX_VALUE);
		DeleteProductButton .setMaxWidth(Double.MAX_VALUE);
		UpdateProductButton .setMaxWidth(Double.MAX_VALUE);
		SearchProductButton .setMaxWidth(Double.MAX_VALUE);
		GetAllProductButton .setMaxWidth(Double.MAX_VALUE);
		
		ProductControlOptionBox = new HBox(10);
		ProductControlOptionBox.setPadding(new Insets(10));
		ProductControlOptionBox.setPrefWidth(60);
		ProductControlOptionBox.setSpacing(8);
		ProductControlOptionBox.getChildren().addAll(AddProductButton,DeleteProductButton,UpdateProductButton,SearchProductButton,GetAllProductButton);
	   
	    
	   //Sell Options
		SellOptionText = new Text(0, 0,"Sell Options : ");
		SellOptionText.setFont(new Font(16));
		SellOptionText.setFill(Color.BLACK);
		SellOptionText.setStroke(Color.WHITE);
		SellOptionText.setStrokeWidth(.65);
		 
        SellProductButton = new Button("   SELL   ");
		AllSellButton = new Button("TOTAL SELL");
		
		SellProductButton .setMaxWidth(Double.MAX_VALUE);
		AllSellButton .setMaxWidth(Double.MAX_VALUE);
		
		SellOptionBox = new HBox(10);
		SellOptionBox.setPadding(new Insets(10));
		SellOptionBox.setPrefWidth(60);
		SellOptionBox.setSpacing(8);
		SellOptionBox.getChildren().addAll(SellProductButton,AllSellButton);
		
		LogoutButton.setOnAction(e->{
			LoginView Log=new LoginView();
			Log.start(stage);});
		AddEmployeeButton.setOnAction(e->{
		EmployeeAddForm form=new EmployeeAddForm();
		form.start(stage);
		});
		DeleteEmployeeButton.setOnAction(e->{
		DeleteEmployeeScene delete=new DeleteEmployeeScene();
		delete.start(stage);
		});
		UpdateEmployeeButton.setOnAction(e->{
			EmployeeUpdateScene update=new EmployeeUpdateScene();
			update.start(stage);
		});
		SearchEmployeeButton.setOnAction(e->{
			SearchEmployeeScene search=new SearchEmployeeScene();
			search.start(stage);
		});
		GetAllEmployeeButton.setOnAction(e->{
			EmployeeTableViewScene view=new EmployeeTableViewScene();
			view.start(stage);
		});
		AddProductButton.setOnAction(e->{
		AddProductScene addproduct=new AddProductScene();
		addproduct.start(stage);
		});
		DeleteProductButton.setOnAction(e->{
			DeleteProductScene deleteproduct=new DeleteProductScene();
			deleteproduct.start(stage);
		});
		UpdateProductButton.setOnAction(e->{
			UpdateProductInfoScene updateinfo=new UpdateProductInfoScene();
			updateinfo.start(stage);
		});
		SearchProductButton.setOnAction(e->{
			SearchProductScene searchproduct=new SearchProductScene();
			searchproduct.start(stage);
		});
		GetAllProductButton.setOnAction(e->{
			AllProductsTableView allproduct=new AllProductsTableView();
			allproduct.start(stage);
		});
		SellProductButton.setOnAction(e->{
			ProductSellView sellproduct=new ProductSellView();
			sellproduct.start(stage);
		});
		AllSellButton.setOnAction(e->{
			AllSellTableView allsell=new AllSellTableView();
			allsell.start(stage);
		});
		ChangePasswordButton.setOnAction(e->{
			ChangePasswordScene password=new ChangePasswordScene();
			password.start(stage);
		});
	   
	root = new VBox(10);
	root.getChildren().addAll(AdminText,topSeparator,EmployeeOptionText,AdminControlOptionBox,midSeparator,ProductOptionText,ProductControlOptionBox,sellSeparator,SellOptionText,SellOptionBox,bottomSeparator,OtherOptionText,ChangePassBox);
	root.setPadding(new Insets(50));
	Scene scene = new Scene(root,480,570);
	stage.setScene(scene);
	stage.setTitle("Admin Control Scene");
	}
}