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
import supershop.model.ProductList;
import supershop.service.ProductService;
import supershop.service.UserNameIdService;

public class AllProductsTableView extends Application{
	Text ProductListText;
	Button BackButton;
	Separator BottomSeparator,topSeparator;
	VBox root;
	UserNameIdService UID;
	Scene scene;
	Stage stage;
	ProductService PS;
	TableView<ProductList> ProductTable;
	public void start(Stage stage){
		ProductListText = new Text("\t\t\tProducts Information");
        ProductListText.setFont(new Font(20));
		ProductListText.setFill(Color.WHITE);
		ProductListText.setStroke(Color.BLACK);
		ProductListText.setStrokeWidth(1);
		topSeparator=new Separator();
		BottomSeparator=new Separator();
		BackButton =new Button("BACK TO MENU");
		BackButton.setMaxWidth(Double.MAX_VALUE);
		
		ProductTable=new TableView<ProductList>();
		
		TableColumn productnameColumn = new TableColumn("\tProduct Name \t");
		TableColumn productpriceColumn= new TableColumn("\tPrice \t");
		TableColumn productcategoryColumn = new TableColumn("\tCategory  \t");
		TableColumn IMEIColumn = new TableColumn("\tIMEI  \t");
		
		IMEIColumn.setCellValueFactory(new PropertyValueFactory<ProductList, String>("productIMEI"));
		productnameColumn.setCellValueFactory(new PropertyValueFactory<ProductList, String>("productName"));
		productpriceColumn.setCellValueFactory(new PropertyValueFactory<ProductList, String>("productPrice"));
		productcategoryColumn.setCellValueFactory(new PropertyValueFactory<ProductList, String>("productCategory"));
		
		ProductTable.getColumns().addAll(IMEIColumn,productnameColumn,productcategoryColumn,productpriceColumn);
		try{
			PS=new ProductService();
			ProductTable.setItems(FXCollections.observableArrayList(PS.getAllItem()));
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
				root.getChildren().addAll(ProductListText,topSeparator,ProductTable,BottomSeparator,BackButton);
				scene = new Scene(root,480,570);
				stage.setScene(scene);
				stage.setTitle("Product List");
				}
				}