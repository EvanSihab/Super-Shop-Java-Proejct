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
import java.util.ArrayList;
import java.util.List;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.text.Text;
import javafx.scene.control.Separator;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import supershop.service.ProductService;
import supershop.service.UserNameIdService;
import supershop.model.ProductList;

public class SearchProductScene extends Application{
	public static ArrayList<ProductList> productlist;
	Scene root;
	Text ProductSearchText;
	Label ProductImeiLabel;
	TextField SearchIdField;
	Button SearchAProductButton,CancelSearchProductButton;
	HBox CancelSearchProductBox;
	Separator SearchBottomSeparate,topseparator;
	VBox SearchIdSearchBox;
	ProductService PS;
	UserNameIdService UID;
	public void start(Stage stage){
		UID=new UserNameIdService();
		ProductSearchText = new Text("      Search Product");
        ProductSearchText.setFont(new Font(18));
		ProductSearchText.setFill(Color.AQUA);
		ProductSearchText.setStroke(Color.BLACK);
		ProductSearchText.setStrokeWidth(1);
		
		ProductImeiLabel=new Label("Enter Product IMEI Or Name");
		SearchIdField=new TextField();
		SearchAProductButton=new Button("SEARCH");
		CancelSearchProductButton=new Button("CANCEL");
		SearchAProductButton.setMaxWidth(Double.MAX_VALUE);
		CancelSearchProductButton.setMaxWidth(Double.MAX_VALUE);
		CancelSearchProductBox=new HBox(40);
		CancelSearchProductBox.setPadding(new Insets(10));
		CancelSearchProductBox.setPrefWidth(300);
		CancelSearchProductBox.setSpacing(40);
		CancelSearchProductBox.getChildren().addAll(SearchAProductButton,CancelSearchProductButton);
		SearchBottomSeparate=new Separator();
		topseparator=new Separator();
		
		SearchIdSearchBox = new VBox(5);
		SearchIdSearchBox.getChildren().addAll(ProductSearchText,topseparator,ProductImeiLabel,SearchIdField,SearchBottomSeparate,CancelSearchProductBox);
		SearchIdSearchBox.setPadding(new Insets(150));
        root = new Scene(SearchIdSearchBox,480,570);
		
		SearchAProductButton.setOnAction(e->{
		String SearchIMEI = SearchIdField.getText();
		productlist = new ArrayList<ProductList>();
		PS=new ProductService();;
			productlist = PS.getSearchItem(SearchIMEI);
			if(productlist!=null){
            ProductTableView view=new ProductTableView();
			view.start(stage);
			}
			else
			{
				AInvalidIDScene invalidID= new AInvalidIDScene();
				invalidID.start(stage);
			}		
		});
		CancelSearchProductButton.setOnAction(e->{
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
				}
		});
		stage.setScene(root);
		stage.setTitle("Search");
	}
	
	public static List<ProductList> getSearchAll(){
		return productlist;
		}
}