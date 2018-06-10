package supershop.view;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.text.Text;
import javafx.scene.control.Separator;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import supershop.service.UserNameIdService;

public class SuccessfullyUpdatedScene extends Application{
	Text AProductSuccessfulUpdate;
	Button ASuccessfulButton,UpdateMoreButton;
	VBox ASuccessfulVBox;
	Scene scene;
	UserNameIdService UID;
	
public void start(Stage stage){
	AProductSuccessfulUpdate = new Text("Successfully Updated ");
	AProductSuccessfulUpdate.setFont(new Font(18));
		AProductSuccessfulUpdate.setFill(Color.GREEN);
		AProductSuccessfulUpdate.setStroke(Color.BLACK);
		AProductSuccessfulUpdate.setStrokeWidth(.5);
		
		ASuccessfulButton=new Button("Back To Menu");
		ASuccessfulButton.setMaxWidth(Double.MAX_VALUE);
		UpdateMoreButton=new Button(" Update More ");
		UpdateMoreButton.setMaxWidth(Double.MAX_VALUE);
		ASuccessfulVBox=new VBox(10,AProductSuccessfulUpdate,UpdateMoreButton,ASuccessfulButton);
		ASuccessfulVBox.setPadding(new Insets(160));
		scene=new Scene(ASuccessfulVBox,480,570);
		
		UpdateMoreButton.setOnAction(e->{
			UpdateProductInfoScene update=new UpdateProductInfoScene();
			update.start(stage);
		});
		
		ASuccessfulButton.setOnAction(e->{
			UID=new UserNameIdService();
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
		
		stage.setScene(scene);
		stage.setTitle("Successfully Updated");
}
}