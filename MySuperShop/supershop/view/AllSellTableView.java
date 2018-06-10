package supershop.view;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.collections.FXCollections;
import javafx.scene.control.cell.PropertyValueFactory;
import supershop.model.TotalSellList;
import supershop.service.UserNameIdService;
import supershop.service.InvoiceService;

public class AllSellTableView extends Application{
	Text SellInfoText;
	Button BackButton;
	Separator BottomSeparator,toISeparator;
	VBox root;
	UserNameIdService UID;
	Scene scene;
	Stage stage;
	InvoiceService IS;
	TableView<TotalSellList> InvoiceTable;
	public void start(Stage stage){
		SellInfoText = new Text("\t\t\tAll Sells Information");
        SellInfoText.setFont(new Font(20));
		SellInfoText.setFill(Color.WHITE);
		SellInfoText.setStroke(Color.BLACK);
		SellInfoText.setStrokeWidth(1);
		toISeparator=new Separator();
		BottomSeparator=new Separator();
		BackButton =new Button("BACK TO MENU");
		BackButton.setMaxWidth(Double.MAX_VALUE);
		
		InvoiceTable=new TableView<TotalSellList>();
		
		TableColumn sellerIdColumn = new TableColumn("Seller Id");
		TableColumn sellerNameColumn= new TableColumn("Seller Name");
		TableColumn productImeiColumn = new TableColumn("Product IMEI");
		TableColumn productNameColumn = new TableColumn("Product Name");
		TableColumn productCategoryColumn = new TableColumn("Category");
		TableColumn productPriceColumn= new TableColumn("Price");
		TableColumn productQuantityColumn = new TableColumn("Quantity");
		TableColumn VatColumn = new TableColumn("VAT");
		TableColumn DiscountColumn = new TableColumn("Discount");
		TableColumn TotalPriceColumn= new TableColumn("Total Price");
		TableColumn GivenMoneyColumn = new TableColumn("Given Money");
		TableColumn ReturnMoneyColumn = new TableColumn("Return Money");
		TableColumn SellDateColumn = new TableColumn("Sell Date");
		
		sellerIdColumn.setCellValueFactory(new PropertyValueFactory<TotalSellList, String>("SellerId"));
		sellerNameColumn.setCellValueFactory(new PropertyValueFactory<TotalSellList, String>("SellerName"));
		productImeiColumn.setCellValueFactory(new PropertyValueFactory<TotalSellList, String>("ProductIMEI"));
		productNameColumn.setCellValueFactory(new PropertyValueFactory<TotalSellList, String>("ProductName"));
		productCategoryColumn.setCellValueFactory(new PropertyValueFactory<TotalSellList, String>("ProductCategory"));
		productPriceColumn.setCellValueFactory(new PropertyValueFactory<TotalSellList, String>("ProductPrice"));
		VatColumn.setCellValueFactory(new PropertyValueFactory<TotalSellList, String>("Vat"));
		DiscountColumn.setCellValueFactory(new PropertyValueFactory<TotalSellList, String>("Discount"));
		TotalPriceColumn.setCellValueFactory(new PropertyValueFactory<TotalSellList, String>("TotalPrice"));
		GivenMoneyColumn.setCellValueFactory(new PropertyValueFactory<TotalSellList, String>("GivenMoney"));
		ReturnMoneyColumn.setCellValueFactory(new PropertyValueFactory<TotalSellList, String>("ReturnMoney"));
		productQuantityColumn.setCellValueFactory(new PropertyValueFactory<TotalSellList, String>("ProductQuantity"));
		SellDateColumn.setCellValueFactory(new PropertyValueFactory<TotalSellList, String>("sellDate"));
		
		InvoiceTable.getColumns().addAll(sellerIdColumn,sellerNameColumn,productImeiColumn,productNameColumn,productCategoryColumn,productPriceColumn,productQuantityColumn,VatColumn,DiscountColumn,TotalPriceColumn,GivenMoneyColumn,ReturnMoneyColumn,SellDateColumn);
		try{
			IS=new InvoiceService();
			InvoiceTable.setItems(FXCollections.observableArrayList(IS.getAllSell()));
			}
			catch(Exception ex){
				System.out.println(ex);
				}
				BackButton.setOnAction(e->{
					UID=new UserNameIdService();
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
				//System.out.println(id);
				//AdminControl adminpanal = new AdminControl();
					//	adminpanal.start(stage);
					}
					else if(S3=='3'){
				//System.out.println(id);
				//AdminControl adminpanal = new AdminControl();
						//adminpanal.start(stage);
					}
				else{
					System.out.println("Wrong");
					InvalidLogin invalid=new InvalidLogin();
					invalid.start(stage);
				}
				});
				root = new VBox(10);
				root.setPadding(new Insets(50,10,50,10));
				root.getChildren().addAll(SellInfoText,toISeparator,InvoiceTable,BottomSeparator,BackButton);
				scene = new Scene(root,480,570);
				stage.setScene(scene);
				stage.setTitle("Sell List");
				}
				}