package supershop.view;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.control.Separator;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import supershop.service.ProductService;
import supershop.service.UserNameIdService;

public class DeleteProductScene extends Application{
	Label DeleteProductLabel;
	TextField DeleteIMEIField;
	Button DeleteAProductButton,CancelDeleteProductButton;
	HBox DeleteCancelBox;
	VBox DeleteIMEISearchBox;
	Separator DeleteBottomSeparate;
	Scene  root;
	ProductService PS=new ProductService();
	UserNameIdService UID;
	
	public void start(Stage stage){
		UID=new UserNameIdService();
		DeleteProductLabel=new Label("Enter Product IMEI");
		DeleteIMEIField=new TextField();
		DeleteAProductButton=new Button("DELETE");
		CancelDeleteProductButton=new Button("CANCEL");
		DeleteAProductButton.setMaxWidth(Double.MAX_VALUE);
		CancelDeleteProductButton.setMaxWidth(Double.MAX_VALUE);
		
		DeleteCancelBox=new HBox(40);
		DeleteCancelBox.setPadding(new Insets(10));
		DeleteCancelBox.setPrefWidth(300);
		DeleteCancelBox.setSpacing(40);
		DeleteCancelBox.getChildren().addAll(DeleteAProductButton,CancelDeleteProductButton);
		
		DeleteBottomSeparate=new Separator();
		
		DeleteIMEISearchBox = new VBox(5);
		DeleteIMEISearchBox.getChildren().addAll(DeleteProductLabel,DeleteIMEIField,DeleteBottomSeparate,DeleteCancelBox);
		DeleteIMEISearchBox.setPadding(new Insets(150));
        root = new Scene(DeleteIMEISearchBox,480,570);
		
		DeleteAProductButton.setOnAction(e->{
			String DeleteIMEI = DeleteIMEIField.getText();
			int i = PS.Delete(DeleteIMEI);
			if(i==1){
            DeleteProductSuccessfulScene product= new DeleteProductSuccessfulScene();
			product.start(stage);
			}
			else
			{
				AInvalidIMEI imei=new AInvalidIMEI();
				imei.start(stage);
			}
			
		});
		CancelDeleteProductButton.setOnAction(e->{
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
				};
		});
		
		stage.setScene(root);
		stage.setTitle("Delete Product");
	}
}