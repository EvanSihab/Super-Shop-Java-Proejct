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
import supershop.service.UserNameIdService;
import supershop.service.ProductService;

public class UpdateProductInfoScene extends Application{
	Text UpdateProductText,PriceUpdateText,CategoryUpdateText,NameUpdateText;
	TextField PriceUpdateField,CategoryUpdateField,NameUpdateField;
	TextField ImeiNameField,ImeiCategoryField,ImeiPriceField;
	Button PriceUpdateButton,CategoryUpdateButton,NameUpdateButton;
	Label PriceLabel,CategoryLabel,NameLabel;
	Label IMEINameLabel,IMEICategoryLabel,IMEIPriceLabel;
	HBox PriceBox,CategoryBox,NameBox;
	HBox ImeiPriceBox,ImeiCategoryBox,ImeiNameBox;
	VBox PriceVBOX,NameVBOX,CategoryVBOX;
	VBox ProductUpdateVBox;
	Button CancelButton;
	Separator Top,Mid,Bottom,Cancel,twocancel;
	UserNameIdService UID;
	ProductService PS;
	
	public void start(Stage stage){
		UID=new UserNameIdService();
		PS=new ProductService();
		UpdateProductText = new Text(0, 0,"\t\tUpdate Product Info");
        UpdateProductText.setFont(new Font(20));
		UpdateProductText.setFill(Color.AQUA);
		UpdateProductText.setStroke(Color.BLACK);
		UpdateProductText.setStrokeWidth(1);
		
		PriceUpdateText = new Text(0, 0,"For Update Product PRICE :");
		PriceUpdateText.setFont(new Font(16));
		PriceUpdateText.setFill(Color.BLACK);
		PriceUpdateText.setStroke(Color.WHITE);
		PriceUpdateText.setStrokeWidth(.65);
		
		CategoryUpdateText = new Text(0, 0,"For Update Product CATEGORY : ");
		CategoryUpdateText.setFont(new Font(16));
		CategoryUpdateText.setFill(Color.BLACK);
		CategoryUpdateText.setStroke(Color.WHITE);
		CategoryUpdateText.setStrokeWidth(.65);
		
		NameUpdateText = new Text(0, 0,"For Update Product NAME : ");
		NameUpdateText.setFont(new Font(16));
		NameUpdateText.setFill(Color.BLACK);
		NameUpdateText.setStroke(Color.WHITE);
		NameUpdateText.setStrokeWidth(.65);
		
		PriceLabel=new Label(" Product New Price\t\t\t : ");
		CategoryLabel=new Label(" Product New Category\t\t : ");
		NameLabel=new Label(" Product New Name\t\t : ");
		
		IMEIPriceLabel=new Label(" Enter Product Name Or IMEI  : ");
		IMEICategoryLabel=new Label(" Enter Product Name Or IMEI  : ");
		IMEINameLabel=new Label(" Enter Product Name Or IMEI  : ");

		PriceUpdateField=new TextField();
		CategoryUpdateField=new TextField();
		NameUpdateField=new TextField();
		
		ImeiPriceField=new TextField();
		ImeiCategoryField=new TextField();
		ImeiNameField=new TextField();
		
		CancelButton=new Button("\t\t Cancel Update\t\t");
		CancelButton.setMaxWidth(Double.MAX_VALUE);
		PriceUpdateButton=new Button("Update Price");
		CategoryUpdateButton=new Button("Update Category");
		NameUpdateButton=new Button("Update Name");
		PriceUpdateButton.setMaxWidth(Double.MAX_VALUE);
		CategoryUpdateButton.setMaxWidth(Double.MAX_VALUE);
		NameUpdateButton.setMaxWidth(Double.MAX_VALUE);
		
		ImeiPriceBox=new HBox(10);
		ImeiPriceBox.setPadding(new Insets(10));
		ImeiPriceBox.setPrefWidth(60);
		ImeiPriceBox.setSpacing(8);
		ImeiPriceBox.getChildren().addAll(IMEIPriceLabel,ImeiPriceField);
		
		PriceBox=new HBox(10);
		PriceBox.setPadding(new Insets(10));
		PriceBox.setPrefWidth(60);
		PriceBox.setSpacing(8);
		PriceBox.getChildren().addAll(PriceLabel,PriceUpdateField);
		PriceVBOX=new VBox(1,PriceUpdateText,ImeiPriceBox,PriceBox,PriceUpdateButton);
		
		ImeiCategoryBox=new HBox(10);
		ImeiCategoryBox.setPadding(new Insets(10));
		ImeiCategoryBox.setPrefWidth(60);
		ImeiCategoryBox.setSpacing(8);
		ImeiCategoryBox.getChildren().addAll(IMEICategoryLabel,ImeiCategoryField);
		
		CategoryBox=new HBox(10);
		CategoryBox.setPadding(new Insets(10));
		CategoryBox.setPrefWidth(60);
		CategoryBox.setSpacing(8);
		CategoryBox.getChildren().addAll(CategoryLabel,CategoryUpdateField);
		CategoryVBOX=new VBox(1,CategoryUpdateText,ImeiCategoryBox,CategoryBox,CategoryUpdateButton);
		
		ImeiNameBox=new HBox(10);
		ImeiNameBox.setPadding(new Insets(10));
		ImeiNameBox.setPrefWidth(60);
		ImeiNameBox.setSpacing(8);
		ImeiNameBox.getChildren().addAll(IMEINameLabel,ImeiNameField);
		
		NameBox=new HBox(10);
		NameBox.setPadding(new Insets(10));
		NameBox.setPrefWidth(60);
		NameBox.setSpacing(8);
		NameBox.getChildren().addAll(NameLabel,NameUpdateField);
		NameVBOX=new VBox(1,NameUpdateText,ImeiNameBox,NameBox,NameUpdateButton);
		
		Top=new Separator();
		Mid=new Separator();
		Bottom=new Separator();
		Cancel=new Separator();
		twocancel=new Separator();
		
		CancelButton.setOnAction(e->{
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
		PriceUpdateButton.setOnAction(e->{
			String imei=ImeiPriceField.getText();
			String newprice=PriceUpdateField.getText();
			int i=PS.UpdatePrice(imei,newprice);
			if(i!=0){
				SuccessfullyUpdatedScene success=new SuccessfullyUpdatedScene();
				success.start(stage);
			}
			else {
				AInvalidProductUpdateScene invalidproduct=new AInvalidProductUpdateScene();
				invalidproduct.start(stage);
			}
			
		});
		CategoryUpdateButton.setOnAction(e->{
			String imei=ImeiCategoryField.getText();
			String newcategory=CategoryUpdateField.getText();
			int i=PS.UpdatePrice(imei,newcategory);
			if(i!=0){
				SuccessfullyUpdatedScene success=new SuccessfullyUpdatedScene();
				success.start(stage);
			}
			else {
				AInvalidProductUpdateScene invalidproduct=new AInvalidProductUpdateScene();
				invalidproduct.start(stage);
			}
			
		});
		NameUpdateButton.setOnAction(e->{
			String imei=ImeiNameField.getText();
			String newname=NameUpdateField.getText();
			int i=PS.UpdatePrice(imei,newname);
			if(i!=0){
				SuccessfullyUpdatedScene success=new SuccessfullyUpdatedScene();
				success.start(stage);
			}
			else {
				AInvalidProductUpdateScene invalidproduct=new AInvalidProductUpdateScene();
				invalidproduct.start(stage);
			}
			
		});
		
		ProductUpdateVBox=new VBox(5);
		ProductUpdateVBox.getChildren().addAll(UpdateProductText,Top,PriceVBOX,Mid,CategoryVBOX,Bottom,NameVBOX,Cancel,twocancel,CancelButton);
		ProductUpdateVBox.setPadding(new Insets(10,50,10,50));
		Scene scene = new Scene(ProductUpdateVBox,480,570);
		stage.setScene(scene);
		stage.setTitle("Product Update Scene");
		
	}
	
}