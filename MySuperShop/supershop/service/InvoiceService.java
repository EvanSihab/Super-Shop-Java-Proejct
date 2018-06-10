package supershop.service;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import supershop.model.TotalSellList;
public class InvoiceService{
	public static ArrayList<TotalSellList> InvoiceInfo;
	UserNameIdService UID;
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
	public static String needMoney;
	Date date;
	
	public int SetInvoice(String ProductIMEI,String ProductName,String ProductPrice,String ProductCategory,String ProductQuantity,String GivenMoney,String Vat,String Discount)
	{
		date=new Date();
		UID=new UserNameIdService();
		this.ProductIMEI=ProductIMEI;
		this.ProductName=ProductName;
		this.ProductPrice=ProductPrice;
		this.ProductCategory=ProductCategory;
		this.GivenMoney=GivenMoney;
		this.Vat=Vat;
		this.ProductQuantity=ProductQuantity;
		this.sellDate=date.toString();
		System.out.println(this.sellDate);
		this.Discount=Discount;
		this.SellerId=UID.getUserId();
		this.SellerName=UID.getUserName();
		return 1;
	}
	public int Calculation(){
		int quantity=Integer.valueOf(ProductQuantity);
		double discount=Integer.valueOf(Discount);
		double price=Integer.valueOf(ProductPrice);
		double givenmoney=Integer.valueOf(GivenMoney);
		double vat=Double.valueOf(Vat);
		System.out.println(vat);
		int totalprice=(int)(quantity*(price+(price*(vat/100))-(price*(discount/100))));
		this.TotalPrice=String.valueOf(totalprice);
		if(givenmoney>=totalprice)
		{
			double returnmoney=givenmoney-totalprice;
			this.ReturnMoney=String.valueOf(returnmoney);
			return 1;
		}
		else{
			int need=totalprice-(int)(givenmoney);
			this.needMoney=String.valueOf(need);
			return 0;
		}
	}
	
	public String getDiscount() {
        return this.Discount;
    }

    public String getSellDate() {
        return this.sellDate;
    }

    public String getSellerId() {
        return this.SellerId;
    }

    public String getSellerName() {
        return this.SellerName;
    }

    public String getProductIMEI() {
        return this.ProductIMEI;
    }

    public String getProductName() {
        return this.ProductName;
    }

    public String getProductPrice() {
        return this.ProductPrice;
    }

    public String getProductCategory() {
        return this.ProductCategory;
    }

    public String getProductQuantity() {
        return this.ProductQuantity;
    }

    public String getGivenMoney() {
        return this.GivenMoney;
    }

    public String getVat() {
        return this.Vat;
    }

    public String getReturnMoney() {
        return this.ReturnMoney;
    }

    public String getTotalPrice() {
        return this.TotalPrice;
    }

    public String getNeedMoney() {
        return needMoney;
    }
    
	 public static List<TotalSellList> getAllSell(){
	  InvoiceInfo = new ArrayList<TotalSellList>();
		String sql ="";
		sql+="SELECT SELLERNAME,SELLERID,PRODUCTIMEI,PRODUCTNAME,PRODUCTCATEGORY,PRODUCTPRICE,QUANTITY,VAT,DISCOUNT,TOTALPRICE,GIVENMONEY,RETURNMONEY,SELLDATE FROM INVOICE";
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Evansihab");  
			Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);  
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
					TotalSellList List=new TotalSellList();
					List.setSellerId(rs.getString("SELLERID"));
					List.setSellerName(rs.getString("SELLERNAME"));
					List.setProductIMEI(rs.getString("PRODUCTIMEI"));
					List.setProductName(rs.getString("PRODUCTNAME"));
					List.setProductCategory(rs.getString("PRODUCTCATEGORY"));
					List.setProductPrice(rs.getString("PRODUCTPRICE"));
					List.setProductQuantity(rs.getString("QUANTITY"));
					List.setDiscount(rs.getString("DISCOUNT"));
					List.setTotalPrice(rs.getString("TOTALPRICE"));
					List.setGivenMoney(rs.getString("GIVENMONEY"));
					List.setReturnMoney(rs.getString("RETURNMONEY"));
					List.setSellDate(rs.getString("SELLDATE"));
					List.setVat(rs.getString("VAT"));
					InvoiceInfo.add(List);
					List=null;
			}
		}
			catch(Exception ex){
				ex.printStackTrace();
				System.out.println("FAILED");
				}
				return InvoiceInfo;
  }
    
}