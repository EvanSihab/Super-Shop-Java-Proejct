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
import supershop.service.UserNameIdService;
import supershop.model.Employee;

public class ChangePasswordScene extends Application{
	Scene  ChangePassscene;
	Text ChangePasswordText;
	Label EmployeeNewPasswordLabel;
	Label EmployeePasswordLabel;
	PasswordField EmployeeCurrentPasswordField;
	PasswordField EmployeeNewPasswordField;
	Button NewPasswordButton;
	Button CancelChangePasswordButton;
	HBox CurrentPasswordBox;
	HBox NewPasswordBox;
	HBox CancelNewPasswordBox;
	Separator FormBottomSeparate;
	Separator TopSeparator;
    VBox NewPasswordVBox;
	Employee EMP;
	EmployeeService ES=new EmployeeService();
	UserNameIdService UID=new UserNameIdService();
	
	public void start(Stage stage){
		NewPasswordButton = new Button("CHANGE PASSWORD");
		CancelChangePasswordButton = new Button("\t CANCEL\t\t");
		
		EmployeeNewPasswordLabel=new Label("  New Password  ");
		EmployeePasswordLabel=new Label("Current Password");
		
		EmployeeCurrentPasswordField=new PasswordField();
		EmployeeNewPasswordField=new PasswordField();
		
		ChangePasswordText = new Text(0, 0,"\t\tChange Password");
        ChangePasswordText.setFont(new Font(18));
		ChangePasswordText.setFill(Color.WHITE);
		ChangePasswordText.setStroke(Color.BLACK);
		ChangePasswordText.setStrokeWidth(.67);
		
		CurrentPasswordBox=new HBox(10);
		CurrentPasswordBox.setPadding(new Insets(5));
		CurrentPasswordBox.setPrefWidth(300);
		CurrentPasswordBox.setSpacing(10);
		CurrentPasswordBox.getChildren().addAll(EmployeePasswordLabel,EmployeeCurrentPasswordField);
		
		NewPasswordBox=new HBox(10);
		NewPasswordBox.setPadding(new Insets(5));
		NewPasswordBox.setPrefWidth(300);
		NewPasswordBox.setSpacing(10);
		NewPasswordBox.getChildren().addAll(EmployeeNewPasswordLabel,EmployeeNewPasswordField);
		
		
		CancelNewPasswordBox=new HBox(10);
		CancelNewPasswordBox.setPadding(new Insets(7));
		CancelNewPasswordBox.setPrefWidth(300);
		CancelNewPasswordBox.setSpacing(10);
		CancelNewPasswordBox.getChildren().addAll(CancelChangePasswordButton,NewPasswordButton);
		
		FormBottomSeparate=new Separator();
		TopSeparator=new Separator();
		
		NewPasswordVBox = new VBox(5);
		NewPasswordVBox.getChildren().addAll(ChangePasswordText,TopSeparator,CurrentPasswordBox,NewPasswordBox,FormBottomSeparate,CancelNewPasswordBox);
		NewPasswordVBox.setPadding(new Insets(150,100,100,100));
		
		NewPasswordButton.setOnAction(e->{
			String id = UID.getUserId();
			String CurrentPass=EmployeeCurrentPasswordField.getText();
			String NewPassword=EmployeeNewPasswordField.getText();
			int i=ES.ChangePassword(id,NewPassword,CurrentPass);
			if(i==1){
				System.out.println(i);
            ChangeSuccessfullyScene change= new ChangeSuccessfullyScene();
			change.start(stage);
			}
			else{
				System.out.println("ERROR");
				FailedAddScene failed=new FailedAddScene();
				failed.start(stage);
			}
		});
		CancelChangePasswordButton.setOnAction(e->{
		String id = UID.getUserId();
;			String[] S1 = id.split("-");
			char S3 = S1[2].charAt(0);
			if(S3=='1')
			{
				System.out.println(id);
				AdminControl adminpanal = new AdminControl();
						adminpanal.start(stage);
					}
					else if(S3=='2'){
				System.out.println(id);
				//AdminControl adminpanal = new AdminControl();
						//adminpanal.start(stage);
					}
					else if(S3=='3'){
				System.out.println(id);
				//AdminControl adminpanal = new AdminControl();
						//adminpanal.start(stage);
					}
				else{
					System.out.println("Wrong");
					InvalidLogin invalid=new InvalidLogin();
					invalid.start(stage);
				}
		});
		
        ChangePassscene = new Scene(NewPasswordVBox,480,570);
		stage.setScene(ChangePassscene);
		stage.setTitle("PASSWORD Change Scene");
	}
}