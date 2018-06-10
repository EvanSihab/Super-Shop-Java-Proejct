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
import supershop.service.InvoiceService;

public class SellProductSuccessfulScene extends Application{
	public static String ProductIMEI;
	public static String ProductName;
	public static String ProductPrice;
	public static String ProductCategory;
	public static String givenmoney;
	public static String vat;
	public static String quantity;
	public static String discount;
	ProductSellView view;
	UserNameIdService UID;
	InvoiceService IS;
	Text ProductIMEIText,ProductNameText,ProductCategoryText,ProductPriceText;
	Label ProductIMEILabel,ProductNameLabel,ProductCategoryLabel,ProductPriceLabel,discountLabel;
	Label QuantityLabel,GivenMoneyLabel,VATLabel;
	TextField QuantityField,GivenMoneyField,VATField,discountField;
	Button ProductIMEITextButton,AProductSellCancelButton;
	Separator SellSeparator;
	Separator Topsepartor;
	HBox ProductIMEIBox,ProductNameBox,ProductCategoryBox,ProductPriceBox;
	HBox QuantityBox,GivenMoneyBox,SellCancelProductBox,VATBox,discountBox;
	VBox ABackProductSellVBox;
	Scene ConfirmSellScene;
	
	public void start(Stage stage)
	{
		view=new ProductSellView();
		UID=new UserNameIdService();
		ProductIMEI=view.getProductIMEI();
		ProductName=view.getProductName();
		ProductCategory=view.getProductCategory();
		ProductPrice=view.getProductPrice();
		discountLabel=new Label("Discount\t\t:");
		ProductIMEILabel=new Label("IMEI\t\t\t:");
		ProductNameLabel=new Label("Name\t\t:");
		ProductCategoryLabel=new Label("Category\t\t:");
		ProductPriceLabel=new Label("Price\t\t\t:");
		VATLabel=new Label("VAT\t\t\t:");
		QuantityLabel=new Label("Quantity\t\t:");
		GivenMoneyLabel=new Label("Given Money   :");
		QuantityField=new TextField();
		GivenMoneyField=new TextField();
		VATField=new TextField();
		discountField=new TextField();
		
		SellSeparator=new Separator();
		Topsepartor=new Separator();
		ProductIMEIText=new Text(ProductIMEI);
        ProductIMEIText.setFont(new Font(15));
		ProductIMEIText.setFill(Color.WHITE);
		ProductIMEIText.setStroke(Color.BLACK);
		ProductIMEIText.setStrokeWidth(.5);
		
		ProductNameText=new Text(ProductName);
        ProductNameText.setFont(new Font(15));
		ProductNameText.setFill(Color.WHITE);
		ProductNameText.setStroke(Color.BLACK);
		ProductNameText.setStrokeWidth(.5);
		
		ProductCategoryText=new Text(ProductCategory);
        ProductCategoryText.setFont(new Font(15));
		ProductCategoryText.setFill(Color.WHITE);
		ProductCategoryText.setStroke(Color.BLACK);
		ProductCategoryText.setStrokeWidth(.5);
		
		ProductPriceText=new Text(ProductPrice);
        ProductPriceText.setFont(new Font(15));
		ProductPriceText.setFill(Color.WHITE);
		ProductPriceText.setStroke(Color.BLACK);
		ProductPriceText.setStrokeWidth(.5);
		
		VATBox=new HBox(10,VATLabel,VATField);
		ProductIMEIBox=new HBox(10,ProductIMEILabel,ProductIMEIText);
		ProductNameBox=new HBox(10,ProductNameLabel,ProductNameText);
		ProductCategoryBox=new HBox(10,ProductCategoryLabel,ProductCategoryText);
		ProductPriceBox=new HBox(10,ProductPriceLabel,ProductPriceText);
		discountBox=new HBox(10,discountLabel,discountField);
		
		ProductIMEITextButton=new Button("\tContinue\t\t");
		ProductIMEITextButton.setMaxWidth(Double.MAX_VALUE);
		AProductSellCancelButton=new Button("      \t  Cancel     \t ");
		AProductSellCancelButton.setMaxWidth(Double.MAX_VALUE);
		QuantityBox=new HBox(10,QuantityLabel,QuantityField);
		GivenMoneyBox=new HBox(10,GivenMoneyLabel,GivenMoneyField);
		SellCancelProductBox=new HBox(30,AProductSellCancelButton,ProductIMEITextButton);
		ABackProductSellVBox=new VBox(10,ProductIMEIBox,ProductNameBox,ProductCategoryBox,ProductPriceBox,SellSeparator,QuantityBox,VATBox,discountBox,GivenMoneyBox,Topsepartor,SellCancelProductBox);
		ABackProductSellVBox.setPadding(new Insets(100));
		ConfirmSellScene=new Scene(ABackProductSellVBox,480,570);
		
		ProductIMEITextButton.setOnAction(e->{
			IS=new InvoiceService();
			quantity=QuantityField.getText();
			givenmoney=GivenMoneyField.getText();
			vat=VATField.getText();
			discount=discountField.getText();
			if(Integer.valueOf(ProductPrice)<=Integer.valueOf(givenmoney)){
			int i=IS.SetInvoice(ProductIMEI,ProductName,ProductPrice,ProductCategory,quantity,givenmoney,vat,discount);
			if(i==1){
				int j=IS.Calculation();
				if(j==1){
					SellInvoiceScene invoice=new SellInvoiceScene();
					invoice.start(stage);
				}
				else {
					String NeededMoney=IS.getNeedMoney();
					String TotalMoney=IS.getTotalPrice();
					Text ShortMoneyText,NeedMoneyText,PriceText;
					VBox InvalidBox;
					Scene ShortMoneyScenee;
					InvoiceService IS;
					PriceText = new Text("With VAT Total Price : "+TotalMoney);
					PriceText.setFont(new Font(15));
					PriceText.setFill(Color.RED);
					PriceText.setStroke(Color.BLACK);
					PriceText.setStrokeWidth(.5);
					NeedMoneyText = new Text("   Need "+NeededMoney+" More");
					NeedMoneyText.setFont(new Font(15));
					NeedMoneyText.setFill(Color.RED);
					NeedMoneyText.setStroke(Color.BLACK);
					NeedMoneyText.setStrokeWidth(.5);
					ShortMoneyText = new Text("  Short Money ");
					ShortMoneyText.setFont(new Font(25));
					ShortMoneyText.setFill(Color.RED);
					ShortMoneyText.setStroke(Color.BLACK);
					ShortMoneyText.setStrokeWidth(.5);
					
					InvalidBox=new VBox(5,ShortMoneyText,PriceText,NeedMoneyText);
					InvalidBox.setPadding(new Insets(50,100,50,100));
					ShortMoneyScenee=new Scene(InvalidBox,350,200);
					Stage s = new Stage();
					 s.setScene(ShortMoneyScenee);
					 s.show();
				}
			}
			}
			else{
				System.out.println("Short Money");
					Text t;
					Separator top=new Separator();
					Separator bottom=new Separator();
					t = new Text("Given Money Is Short");
					t.setFont(new Font(25));
					t.setFill(Color.RED);
					t.setStroke(Color.BLACK);
					t.setStrokeWidth(.5);
					VBox v1 = new VBox(10);
					VBox root=new VBox();
					v1.setPadding(new Insets(40));
					v1.getChildren().addAll(t);
					root.setPadding(new Insets(20));
					root.getChildren().addAll(top,v1,bottom);
					Scene ShortMoneyScene=new Scene(root,350,200);
				 Stage s = new Stage();
				 s.setScene(ShortMoneyScene);
				 s.show();
					
			}
		});
		AProductSellCancelButton.setOnAction(e->{
			
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
		
		stage.setScene(ConfirmSellScene);
		stage.setTitle("Confirm Sell");
	}
}