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
import supershop.service.ProductService;
import supershop.service.UserNameIdService;

public class ProductSellView extends Application{
	UserNameIdService UID;
	SellProductSuccessfulScene prosell;
	public static String ProductIMEI;
	public static String ProductName;
	public static String ProductPrice;
	public static String ProductCategory;
	
	public String getProductIMEI(){return this.ProductIMEI;}
	public String getProductName(){return this.ProductName;}
	public String getProductPrice(){return this.ProductPrice;}
	public String getProductCategory(){return this.ProductCategory;}
	
	public void SetProductAll(String ProductIMEI,String ProductName,String ProductPrice,String ProductCategory)
	{
		this.ProductIMEI=ProductIMEI;
		this.ProductName=ProductName;
		this.ProductPrice=ProductPrice;
		this.ProductCategory=ProductCategory;
	}
	
	Label SellProductIMEI;
	TextField SellIMEIField;
	Button SellAProductButton,CancelSellProductButton;
	HBox SellCancelBox;
	VBox SellProductBox;
	Separator SellSeparator;
	Scene  root;
	ProductService PS;
	
	public void start(Stage stage){
		UID=new UserNameIdService();
		SellProductIMEI=new Label("Enter Product IMEI");
		SellIMEIField=new TextField();
		SellAProductButton=new Button("CONTINUE");
		CancelSellProductButton=new Button("    BACK    ");
		SellAProductButton.setMaxWidth(Double.MAX_VALUE);
		CancelSellProductButton.setMaxWidth(Double.MAX_VALUE);
		
		SellCancelBox=new HBox(10);
		SellCancelBox.setPadding(new Insets(10));
		SellCancelBox.setPrefWidth(300);
		SellCancelBox.setSpacing(10);
		SellCancelBox.getChildren().addAll(CancelSellProductButton,SellAProductButton);
		
		SellSeparator=new Separator();
		
		SellProductBox = new VBox(5);
		SellProductBox.getChildren().addAll(SellProductIMEI,SellIMEIField,SellSeparator,SellCancelBox);
		SellProductBox.setPadding(new Insets(150));
        root = new Scene(SellProductBox,480,570);
		
		SellAProductButton.setOnAction(e->{
			PS=new ProductService();
			String SearchIMEI=SellIMEIField.getText();
			int i = PS.SearchProduct(SearchIMEI);
			if(i==1){
            prosell= new SellProductSuccessfulScene();
			prosell.start(stage);
			}
			else
			{
				//AdminControl admin=new AdminControl();
				//admin.start(stage);
			}
			
		});
		CancelSellProductButton.setOnAction(e->{
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
		
		stage.setScene(root);
		stage.setTitle("Sell Product");
	}
}