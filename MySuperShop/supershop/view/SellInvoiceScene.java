package supershop.view;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
import javafx.scene.Node;
import javafx.print.PrinterJob;
import supershop.model.InvoiceModel;
import supershop.service.InvoiceDatabaseService;
import supershop.service.InvoiceService;
import supershop.service.ProductService;
import supershop.service.CreateXMLInvoice;

public class SellInvoiceScene extends Application{
	public static String sellDate;
	public static String SellerId;
	public static String SellerName;
	public static String ProductIMEI;
	public static String ProductName;
	public static String ProductPrice;
	public static String ProductCategory;
	public static String ProductQuantity;
	public static String GivenMoney;
	public static String Vat;
	public static String ReturnMoney;
	public static String TotalPrice;
	public static String Discount;
	InvoiceService invoice;
	Text InvoiceText;
	Text SellerIdText,SellerNameText,ThanksText;
	Text ProductIMEIText,DateText,ProductNameText,ProductCategoryText,DiscountText,ProductQuantityText,ProductPriceText,ProductVatText,GivenMoneyText,TotalPriceText,ReturnMoneyText;
	Label ProductIMEILabel,ProductNameLabel,ProductCategoryLabel,ProductPriceLabel;
	Label QuantityLabel,GivenMoneyLabel,VATLabel,ReturnMoneyLabel,TotalPriceLabel;
	Label SellerIdLabel,SellerNameLabel,DateLabel,DiscountLabel;
	Button SellMoreButton,ProductSellFinishButton;
	Separator InvoiceSepartor;
	Separator SellSeparator;
	Separator Topsepartor;
	Separator midsepartor;
	HBox SellerIdBox,SellerNameBox,DiscountBox;
	HBox VatBox,TotalPriceBox,DateBox,ReturnMoneyBox,GivenMoneyBox,QuantityBox;
	HBox ProductIMEIBox,ProductNameBox,ProductCategoryBox,ProductPriceBox;
	HBox SellCancelProductBox;
	VBox SuccessfulSellBox;
	VBox PrintBox;
	Scene InvoiceScene;
	InvoiceModel IM;
	InvoiceDatabaseService IDS;
	ProductService PS;
	CreateXMLInvoice createXML;
	Node printNode;
	
	public void start(Stage stage)
	{
		invoice=new InvoiceService();
		sellDate=invoice.getSellDate();
		SellerId=invoice.getSellerId();
		SellerName=invoice.getSellerName();
		ProductIMEI=invoice.getProductIMEI();
		ProductName=invoice.getProductName();
		ProductPrice=invoice.getProductPrice();
		ProductCategory=invoice.getProductCategory();
		ProductQuantity=invoice.getProductQuantity();
		GivenMoney=invoice.getGivenMoney();
		Vat=invoice.getVat();
		Discount=invoice.getDiscount();
		ReturnMoney=invoice.getReturnMoney();
		TotalPrice=invoice.getTotalPrice();
		createXML=new CreateXMLInvoice();
		
		SellerIdLabel=new Label("Seller ID\t\t :");
		SellerNameLabel=new Label("Seller Name\t :");
		ProductIMEILabel=new Label("IMEI\t\t\t :");
		ProductNameLabel=new Label("Name\t\t :");
		ProductCategoryLabel=new Label("Category\t\t :");
		ProductPriceLabel=new Label("Price\t\t\t :");
		DateLabel=new Label("Date\t\t\t :");
		QuantityLabel=new Label("Quantity\t\t :");
		GivenMoneyLabel=new Label("Given Money    :");
		TotalPriceLabel=new Label("Total Price \t :");
		ReturnMoneyLabel=new Label("Return Money  :");
		VATLabel=new Label("VAT\t\t\t :");
		DiscountLabel=new Label("Discount\t\t : ");
		
		InvoiceSepartor=new Separator();
		SellSeparator=new Separator();
		Topsepartor=new Separator();
		midsepartor=new Separator();
		
		InvoiceText=new Text("Super Shop");
        InvoiceText.setFont(new Font(20));
		InvoiceText.setFill(Color.GREY);
		InvoiceText.setStroke(Color.BLACK);
		InvoiceText.setStrokeWidth(.2);
		
		ThanksText=new Text("\tThank you for shopping with Super-Shop");
        ThanksText.setFont(new Font(12));
		ThanksText.setFill(Color.GREY);
		ThanksText.setStroke(Color.BLACK);
		ThanksText.setStrokeWidth(.1);
		
		DiscountText=new Text(Discount+"%");
        DiscountText.setFont(new Font(12));
		DiscountText.setFill(Color.GREY);
		DiscountText.setStroke(Color.BLACK);
		DiscountText.setStrokeWidth(.2);
		
		SellerNameText=new Text(SellerName);
        SellerNameText.setFont(new Font(12));
		SellerNameText.setFill(Color.GREY);
		SellerNameText.setStroke(Color.BLACK);
		SellerNameText.setStrokeWidth(.2);
		
		SellerIdText=new Text(SellerId);
        SellerIdText.setFont(new Font(12));
		SellerIdText.setFill(Color.GREY);
		SellerIdText.setStroke(Color.BLACK);
		SellerIdText.setStrokeWidth(.2);
		
		ProductIMEIText=new Text(ProductIMEI);
        ProductIMEIText.setFont(new Font(12));
		ProductIMEIText.setFill(Color.GREY);
		ProductIMEIText.setStroke(Color.BLACK);
		ProductIMEIText.setStrokeWidth(.2);
		
		ProductNameText=new Text(ProductName);
        ProductNameText.setFont(new Font(12));
		ProductNameText.setFill(Color.GREY);
		ProductNameText.setStroke(Color.BLACK);
		ProductNameText.setStrokeWidth(.2);
		
		ProductCategoryText=new Text(ProductCategory);
        ProductCategoryText.setFont(new Font(12));
		ProductCategoryText.setFill(Color.GREY);
		ProductCategoryText.setStroke(Color.BLACK);
		ProductCategoryText.setStrokeWidth(.2);
		
		ProductPriceText=new Text(ProductPrice);
        ProductPriceText.setFont(new Font(12));
		ProductPriceText.setFill(Color.GREY);
		ProductPriceText.setStroke(Color.BLACK);
		ProductPriceText.setStrokeWidth(.2);
		
		DateText=new Text(sellDate);
        DateText.setFont(new Font(12));
		DateText.setFill(Color.GREY);
		DateText.setStroke(Color.BLACK);
		DateText.setStrokeWidth(.2);
		
		ProductQuantityText=new Text(ProductQuantity);
        ProductQuantityText.setFont(new Font(12));
		ProductQuantityText.setFill(Color.GREY);
		ProductQuantityText.setStroke(Color.BLACK);
		ProductQuantityText.setStrokeWidth(.2);
		
		TotalPriceText=new Text(TotalPrice);
        TotalPriceText.setFont(new Font(12));
		TotalPriceText.setFill(Color.GREY);
		TotalPriceText.setStroke(Color.BLACK);
		TotalPriceText.setStrokeWidth(.2);
		
		ReturnMoneyText=new Text(ReturnMoney);
        ReturnMoneyText.setFont(new Font(12));
		ReturnMoneyText.setFill(Color.GREY);
		ReturnMoneyText.setStroke(Color.BLACK);
		ReturnMoneyText.setStrokeWidth(.2);
		
		ProductVatText=new Text(Vat+"%");
        ProductVatText.setFont(new Font(12));
		ProductVatText.setFill(Color.GREY);
		ProductVatText.setStroke(Color.BLACK);
		ProductVatText.setStrokeWidth(.2);
		
		GivenMoneyText=new Text(GivenMoney);
        GivenMoneyText.setFont(new Font(12));
		GivenMoneyText.setFill(Color.GREY);
		GivenMoneyText.setStroke(Color.BLACK);
		GivenMoneyText.setStrokeWidth(.2);
		
		SellerIdBox=new HBox(10,SellerIdLabel,SellerIdText);
		SellerNameBox=new HBox(10,SellerNameLabel,SellerNameText);
		ProductIMEIBox=new HBox(10,ProductIMEILabel,ProductIMEIText);
		ProductNameBox=new HBox(10,ProductNameLabel,ProductNameText);
		ProductCategoryBox=new HBox(10,ProductCategoryLabel,ProductCategoryText);
		ProductPriceBox=new HBox(10,ProductPriceLabel,ProductPriceText);
		VatBox=new HBox(10,VATLabel,ProductVatText);
		QuantityBox=new HBox(10,QuantityLabel,ProductQuantityText);
		TotalPriceBox=new HBox(10,TotalPriceLabel,TotalPriceText);
		GivenMoneyBox=new HBox(10,GivenMoneyLabel,GivenMoneyText);
		ReturnMoneyBox=new HBox(10,ReturnMoneyLabel,ReturnMoneyText);
		DateBox=new HBox(5,DateLabel,DateText);
		DiscountBox=new HBox(5,DiscountLabel,DiscountText);
		
		SellMoreButton=new Button("\tSell More\t\t");
		SellMoreButton.setMaxWidth(Double.MAX_VALUE);
		ProductSellFinishButton=new Button("      \t  Sell  Finish     \t ");
		ProductSellFinishButton.setMaxWidth(Double.MAX_VALUE);
	
		SellCancelProductBox=new HBox(30,ProductSellFinishButton,SellMoreButton);
		SuccessfulSellBox=new VBox(6,InvoiceText,Topsepartor,SellerIdBox,SellerNameBox,InvoiceSepartor,ProductIMEIBox,ProductNameBox,ProductCategoryBox,ProductPriceBox,QuantityBox,VatBox,DiscountBox,TotalPriceBox,GivenMoneyBox,ReturnMoneyBox,DateBox,ThanksText,SellSeparator,SellCancelProductBox);
		SuccessfulSellBox.setPadding(new Insets(100));
		InvoiceScene=new Scene(SuccessfulSellBox,480,570);
		SellMoreButton.setOnAction(e->{
			PrintBox=new VBox(6,InvoiceText,Topsepartor,SellerIdBox,SellerNameBox,InvoiceSepartor,ProductIMEIBox,ProductNameBox,ProductCategoryBox,ProductPriceBox,QuantityBox,VatBox,DiscountBox,TotalPriceBox,GivenMoneyBox,ReturnMoneyBox,DateBox,ThanksText,SellSeparator);
			printNode=PrintBox;
			PrinterJob job=PrinterJob.createPrinterJob();
			IDS=new InvoiceDatabaseService();
			PS=new ProductService();
			IM=new InvoiceModel(SellerName,SellerId,ProductIMEI,ProductName,ProductCategory,ProductPrice,ProductQuantity,Vat,Discount,TotalPrice,GivenMoney,ReturnMoney,sellDate);
			if(job != null){
				boolean success = job.printPage(printNode);
				if(success)
				{
				job.endJob();}
			}
					int x=IDS.AddInvoice(IM);
					if(x==1){
						int y=PS.Delete(ProductIMEI);
						if(y==1){
							ProductSellView view=new ProductSellView();
							view.start(stage);}
							}
							else {
								System.out.println("Failed");
								}
								});
		ProductSellFinishButton.setOnAction(e->{
			PrintBox=new VBox(6,InvoiceText,Topsepartor,SellerIdBox,SellerNameBox,InvoiceSepartor,ProductIMEIBox,ProductNameBox,ProductCategoryBox,ProductPriceBox,QuantityBox,VatBox,DiscountBox,TotalPriceBox,GivenMoneyBox,ReturnMoneyBox,DateBox,ThanksText,SellSeparator);
			printNode=PrintBox;
			PrinterJob job=PrinterJob.createPrinterJob();
			IDS=new InvoiceDatabaseService();
			PS=new ProductService();
			IM=new InvoiceModel(SellerName,SellerId,ProductIMEI,ProductName,ProductCategory,ProductPrice,ProductQuantity,Vat,Discount,TotalPrice,GivenMoney,ReturnMoney,sellDate);
			if(job != null){
				boolean success = job.printPage(printNode);
				if(success)
				{job.endJob();
				}
			}
					int x=IDS.AddInvoice(IM);
					if(x==1){
						int y=PS.Delete(ProductIMEI);
						if(y==1){
							String id = SellerId;
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
											}
											}
											});
		
		stage.setScene(InvoiceScene);
		stage.setTitle("Confirm Sell");
		stage.show();
	}   
}