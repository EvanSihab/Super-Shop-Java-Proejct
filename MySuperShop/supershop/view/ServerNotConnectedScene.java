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

public class ServerNotConnectedScene extends Application{
	Text ServerNotConnectedText;
	Button TryAginButton;
	VBox ServerBox;
	Scene NotConnectedScene;
	public void start(Stage stage)
	{
		ServerNotConnectedText = new Text("  Server Not Connected");
        ServerNotConnectedText.setFont(new Font(20));
		ServerNotConnectedText.setFill(Color.RED);
		ServerNotConnectedText.setStroke(Color.BLACK);
		ServerNotConnectedText.setStrokeWidth(.5);
		
		TryAginButton=new Button(" TRY AGAIN  ");
		TryAginButton .setMaxWidth(Double.MAX_VALUE);
		ServerBox=new VBox(5,ServerNotConnectedText,TryAginButton);
		ServerBox.setPadding(new Insets(200,130,200,130));
		NotConnectedScene=new Scene(ServerBox,480,570);
		
		TryAginButton.setOnAction(e->{
			LoginView login=new LoginView();
			login.start(stage);
		});
		
		stage.setTitle("Server Not connected Scene");
        stage.setScene(NotConnectedScene);
	}
}