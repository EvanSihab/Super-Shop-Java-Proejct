package supershop.view;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
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

public class DeleteProductSuccessfulScene{
	Text AProductSuccessful;
	Button AProductSuccessfulButton,DeleteMoreProductButton;
	VBox ABackProductVBox;
	Scene ABackProductScene;
	UserNameIdService UID;
	public void start(Stage stage)
	{
		UID=new UserNameIdService();
		AProductSuccessful = new Text(" Successfully Deleted ");
        AProductSuccessful.setFont(new Font(18));
		AProductSuccessful.setFill(Color.GREEN);
		AProductSuccessful.setStroke(Color.BLACK);
		AProductSuccessful.setStrokeWidth(.5);
		
		AProductSuccessfulButton=new Button("Back To Menu");
		AProductSuccessfulButton.setMaxWidth(Double.MAX_VALUE);
		DeleteMoreProductButton=new Button("Delete More Employee");
		DeleteMoreProductButton.setMaxWidth(Double.MAX_VALUE);
		ABackProductVBox=new VBox(5,AProductSuccessful,DeleteMoreProductButton,AProductSuccessfulButton);
		ABackProductVBox.setPadding(new Insets(160));
		ABackProductScene=new Scene(ABackProductVBox,480,570);
		
		AProductSuccessfulButton.setOnAction(e->{
			String id = UID.getUserId();
			String[] S1 = id.split("-");
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
		DeleteMoreProductButton.setOnAction(e->{
			DeleteProductScene deleteproduct=new DeleteProductScene();
			deleteproduct.start(stage);
		});
		
		stage.setScene(ABackProductScene);
		stage.setTitle("Deleted");
	}
}