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
import supershop.service.EmployeeService;

public class SearchEmployeeScene extends Application{
	Scene root;
	Label SearchEmployeeIDLabel;
	TextField SearchIdField;
	Button SearchAEmployeeButton,CancelSearchEmployeeButton;
	HBox CancelSearchEmployeeBox;
	Separator SearchBottomSeparate;
	VBox SearchIdSearchBox;
	EmployeeService ES=new EmployeeService();
	public void start(Stage stage){
		SearchEmployeeIDLabel=new Label("Enter Employee ID");
		SearchIdField=new TextField();
		SearchAEmployeeButton=new Button("SEARCH");
		CancelSearchEmployeeButton=new Button("CANCEL");
		SearchAEmployeeButton.setMaxWidth(Double.MAX_VALUE);
		CancelSearchEmployeeButton.setMaxWidth(Double.MAX_VALUE);
		CancelSearchEmployeeBox=new HBox(40);
		CancelSearchEmployeeBox.setPadding(new Insets(10));
		CancelSearchEmployeeBox.setPrefWidth(300);
		CancelSearchEmployeeBox.setSpacing(40);
		CancelSearchEmployeeBox.getChildren().addAll(SearchAEmployeeButton,CancelSearchEmployeeButton);
		SearchBottomSeparate=new Separator();
		
		SearchIdSearchBox = new VBox(5);
		SearchIdSearchBox.getChildren().addAll(SearchEmployeeIDLabel,SearchIdField,SearchBottomSeparate,CancelSearchEmployeeBox);
		SearchIdSearchBox.setPadding(new Insets(150));
        root = new Scene(SearchIdSearchBox,480,570);
		
		SearchAEmployeeButton.setOnAction(e->{
		String SearchID = SearchIdField.getText();
			int i = ES.Search(SearchID);
			if(i==1){
            SearchAEmployeeScene search=new SearchAEmployeeScene();
			search.start(stage);
			}
			else
			{
				AInvalidIDScene invalidID= new AInvalidIDScene();
				invalidID.start(stage);
			}		
		});
		CancelSearchEmployeeButton.setOnAction(e->{
		AdminControl admin=new AdminControl();
		admin.start(stage);
		});
		stage.setScene(root);
		stage.setTitle("Search");
	}
}