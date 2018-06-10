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
import javafx.scene.text.Text;
import javafx.scene.control.Separator;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import supershop.model.Product;
import supershop.service.ProductService;
import supershop.service.UserNameIdService;

public class AddProductScene extends Application{
	Label ProductIMEILabel,ProductNameLabel,ProductPriceLabel,ProductCategoryLabel;
	Button AddNewProductButton,CancelAddProductButton;
	TextField ProductIMEIField,ProductNameField,ProductPriceField,ProductCategoryField;
	HBox productAddCancelBox;
	VBox NewProductBox;
	Separator ProductFormBottomSeparate;
	Scene AddProductscene;
	UserNameIdService UID;
	Product PRO;
	ProductService PS=new ProductService();
	public void start(Stage stage){
		UID=new UserNameIdService();
		AddNewProductButton = new Button("\t\tADD    \t \t");
		CancelAddProductButton = new Button("\t\tCANCEL\t\t\t");
		
		ProductIMEILabel=new Label("IMEI NUMBER");
		ProductNameLabel=new Label("Product Name");
		ProductPriceLabel=new Label("Price");
		ProductCategoryLabel=new Label("Category");
		
		ProductIMEIField= new TextField();
		ProductNameField=new TextField();
		ProductPriceField=new TextField();
		ProductCategoryField=new TextField();
	
		productAddCancelBox=new HBox(80);
		productAddCancelBox.setPadding(new Insets(15));
		productAddCancelBox.setPrefWidth(300);
		productAddCancelBox.setSpacing(78);
		productAddCancelBox.getChildren().addAll(AddNewProductButton,CancelAddProductButton);
		
		ProductFormBottomSeparate=new Separator();
		
		NewProductBox = new VBox(5);
		NewProductBox.getChildren().addAll(ProductIMEILabel,ProductIMEIField,ProductNameLabel,ProductNameField,ProductCategoryLabel,ProductCategoryField,ProductPriceLabel,ProductPriceField,productAddCancelBox);
		NewProductBox.setPadding(new Insets(25));
		
        AddProductscene = new Scene(NewProductBox,480,570);
		AddNewProductButton.setOnAction(e->{
			String Imei = ProductIMEIField.getText();
			String Productname = ProductNameField.getText();
			String Productcategory = ProductCategoryField.getText();
			String Productprice=ProductPriceField.getText();
			if((Imei.equals(null))||(Productname.equals(null))||(Productcategory.equals(null))||(Productprice.equals(null)))
			{
				FailedAddScene failed=new FailedAddScene();
				failed.start(stage);
			}
			else 
			{
				PRO=new Product(Imei,Productname,Productcategory,Productprice);
				String j=PS.Add(PRO);
				if(j!=null){
				System.out.println(j);
				ASuccessProductAddScene product=new ASuccessProductAddScene();
				product.start(stage);
			}
			else{
				System.out.println("ERROR");
				FailedAddScene failed=new FailedAddScene();
				failed.start(stage);
			}
			}
		});
		CancelAddProductButton.setOnAction(e->{
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
		
		stage.setScene(AddProductscene);
		stage.setTitle("Add Product Scene");
	}
}