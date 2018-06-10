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
import javafx.scene.control.Separator;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ASuccessProductAddScene extends Application{
	Text AProductSuccessful;
	Button ASuccessfulButton,AddMoreProductButton;
	VBox ASuccessfulVBox;
	Scene scene;
	
public void start(Stage stage){
	AProductSuccessful = new Text(" Successfully Added ");
	AProductSuccessful.setFont(new Font(18));
		AProductSuccessful.setFill(Color.GREEN);
		AProductSuccessful.setStroke(Color.BLACK);
		AProductSuccessful.setStrokeWidth(.5);
		
		ASuccessfulButton=new Button("Back To Menu");
		ASuccessfulButton.setMaxWidth(Double.MAX_VALUE);
		AddMoreProductButton=new Button("Add More Products");
		AddMoreProductButton.setMaxWidth(Double.MAX_VALUE);
		ASuccessfulVBox=new VBox(10,AProductSuccessful,AddMoreProductButton,ASuccessfulButton);
		ASuccessfulVBox.setPadding(new Insets(160));
		scene=new Scene(ASuccessfulVBox,480,570);
		
		ASuccessfulButton.setOnAction(e->{
		AdminControl admin=new AdminControl();
		admin.start(stage);
		});
		AddMoreProductButton.setOnAction(e->{
		AddProductScene Form= new AddProductScene();
		Form.start(stage);
		});
		
		stage.setScene(scene);
		stage.setTitle("Successfully Added");
}
}