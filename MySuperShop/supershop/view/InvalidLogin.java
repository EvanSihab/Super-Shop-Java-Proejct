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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class InvalidLogin extends Application{
	Text InvalidText;
	Button TryAginButton;
	VBox InvalidBox;
	Scene InvalidLogin;
	public void start(Stage stage)
	{
		InvalidText = new Text(" Invalid Login ");
        InvalidText.setFont(new Font(25));
		InvalidText.setFill(Color.RED);
		InvalidText.setStroke(Color.BLACK);
		InvalidText.setStrokeWidth(.5);
		
		TryAginButton=new Button(" TRY AGAIN ");
		TryAginButton .setMaxWidth(Double.MAX_VALUE);
		InvalidBox=new VBox(5,InvalidText,TryAginButton);
		InvalidBox.setPadding(new Insets(160));
		InvalidLogin=new Scene(InvalidBox,480,570);
		
		TryAginButton.setOnAction(e->{
			LoginView login=new LoginView();
			login.start(stage);
		});
		
		stage.setTitle("Invalid Login Scene");
        stage.setScene(InvalidLogin);
	}
}