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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import supershop.service.UserNameIdService;

public class ChangeSuccessfullyScene extends Application{
	Text APasswordSuccessful;
	Button ASuccessfulButton;
	VBox ASuccessfulVBox;
	Scene scene;
	UserNameIdService UID=new UserNameIdService();
	
public void start(Stage stage){
	APasswordSuccessful = new Text(" Successfully Changed ");
	APasswordSuccessful.setFont(new Font(18));
		APasswordSuccessful.setFill(Color.GREEN);
		APasswordSuccessful.setStroke(Color.BLACK);
		APasswordSuccessful.setStrokeWidth(.5);
		
		ASuccessfulButton=new Button("Back To Menu");
		ASuccessfulButton.setMaxWidth(Double.MAX_VALUE);
		ASuccessfulVBox=new VBox(10,APasswordSuccessful,ASuccessfulButton);
		ASuccessfulVBox.setPadding(new Insets(160));
		scene=new Scene(ASuccessfulVBox,480,570);
		
		ASuccessfulButton.setOnAction(e->{
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
				AdminControl adminpanal = new AdminControl();
						adminpanal.start(stage);
					}
					else if(S3=='3'){
				System.out.println(id);
				AdminControl adminpanal = new AdminControl();
						adminpanal.start(stage);
					}
				else{
					System.out.println("Wrong");
					InvalidLogin invalid=new InvalidLogin();
					invalid.start(stage);
				}
		});
		stage.setScene(scene);
		stage.setTitle("Successfully Change");
}
}