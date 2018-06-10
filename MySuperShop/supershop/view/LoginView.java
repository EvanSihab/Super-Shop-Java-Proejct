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
import supershop.service.CheckUser;
import supershop.service.UserNameIdService;

public class LoginView extends Application{
	public String getLogID(){return this.LogID;}
	static String LogID;
	Text LoginText;
	Label UserIdLabel,PasswordLabel;
	TextField UserIdField;
	PasswordField passwordField;
	Button LoginButton;
	Separator topSeparator,bottomSeparator;
	VBox root;
	Scene scene;
	Stage stage;
	CheckUser CS=new CheckUser();
	UserNameIdService UID=new UserNameIdService();
	public void start(Stage stage){
		LoginText = new Text(0, 0,"   Welcome To Super-Shop");
        LoginText.setFont(new Font(22));
		LoginText.setFill(Color.AQUA);
		LoginText.setStroke(Color.BLACK);
		LoginText.setStrokeWidth(1);
        UserIdLabel = new Label("User ID");
        UserIdField = new TextField();
        PasswordLabel = new Label("Password");
        passwordField = new PasswordField();
        LoginButton = new Button("Login");
		topSeparator = new Separator();
		topSeparator.setPadding(new Insets(50, 0, 0, 0));
		bottomSeparator = new Separator();
		bottomSeparator.setPadding(new Insets(25, 0, 0, 0));  
		
		LoginButton.setOnAction(e->
		{
			String id = UserIdField.getText();
				String pass = passwordField.getText();
				UID.setUserId(id,pass);
				int Chk=CS.Check(id,pass);
				if(Chk==1){
					String[] S1 = id.split("-");
					char S3 = S1[2].charAt(0);
					if(S3=='1'){
						this.LogID=id;
						System.out.println(LogID);
						AdminControl adminpanal = new AdminControl();
						adminpanal.start(stage);
					}
                }
				else if(Chk==111){
					ServerNotConnectedScene notconnect=new ServerNotConnectedScene();
					notconnect.start(stage);
				}
				else{
					System.out.println("Wrong");
					InvalidLogin invalid=new InvalidLogin();
					invalid.start(stage);
				}
				
		});
		
		root = new VBox(5,LoginText,topSeparator,UserIdLabel,UserIdField,PasswordLabel,passwordField,bottomSeparator,LoginButton);
        root.setPadding(new Insets(100));
		Scene scene=new Scene(root,480,570);
		
		stage.setTitle("Login Scene");
        stage.setScene(scene);
        stage.show();
	}
}