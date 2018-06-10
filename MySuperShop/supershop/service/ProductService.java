package supershop.service;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import supershop.model.Product;
import supershop.model.ProductList;
import supershop.view.ProductSellView;
public class ProductService{
	ProductSellView Sell;
	ProductList ProductList;
	public static ArrayList<ProductList> productsInfo;
	public String Add(Product Pro){
		String sql="";
        sql+="INSERT INTO PRODUCT(IMEI,PRODUCTNAME,PRODUCTPRICE,CATEGORY)";
        sql+="VALUES('"+Pro.GetIMEI()+"','"+Pro.GetProductName()+"','"+Pro.GetProductPrice()+"','"+Pro.GetProductCategory()+"')";
		try{  
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			//step2 create  the connection object  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Evansihab");  
			//step3 create the statement object  
			Statement stmt=con.createStatement();
            int r = stmt.executeUpdate(sql);
			if(r==1)
			{System.out.println("SUCCESSFULLY ADDED");
		System.out.println(Pro.GetIMEI());
		return Pro.GetIMEI();}
		}
		catch(Exception ex){
			ex.printStackTrace();
			System.out.print("FAILED");
			return null;
		}
		return null;
	}
	public int Delete(String IMEI){
		String sql="";
		sql+="DELETE from PRODUCT where IMEI='"+IMEI+"'";
		try{  
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			//step2 create  the connection object  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Evansihab");  
			//step3 create the statement object  
			Statement stmt=con.createStatement();
            int r = stmt.executeUpdate(sql);
			return r;
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return 0;
	}
	public int UpdatePrice(String IMEI,String NewPrice){
		String sql ="";
		sql+="UPDATE PRODUCT SET PRODUCTPRICE = '"+NewPrice+"' WHERE IMEI='"+IMEI+"' OR PRODUCTNAME LIKE '"+IMEI+"'";
		try{  
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			//step2 create  the connection object  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Evansihab");  
			//step3 create the statement object  
			Statement stmt=con.createStatement();
            int r = stmt.executeUpdate(sql);
			if(r!=0)
			{
            System.out.println("SUCCESSFULLY Updated");
			return r;
			}
			else{System.out.println("Invalid Id");
			return 0;}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return 0;
	}
	public int UpdateCategory(String IMEI,String Category){
		String sql ="";
		sql+="UPDATE PRODUCT SET CATEGORY = '"+Category+"' WHERE IMEI='"+IMEI+"' OR PRODUCTNAME LIKE '"+IMEI+"'";
		try{  
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			//step2 create  the connection object  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Evansihab");  
			//step3 create the statement object  
			Statement stmt=con.createStatement();
            int r = stmt.executeUpdate(sql);
			if(r!=0)
			{
            System.out.println("SUCCESSFULLY Updated");
			return r;
			}
			else{System.out.println("Invalid Id");
			return 0;}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return 0;
	}
	public int UpdateName(String IMEI,String Name){
		String sql ="";
		sql+="UPDATE PRODUCT SET PRODUCTNAME = '"+Name+"' WHERE IMEI='"+IMEI+"' OR PRODUCTNAME LIKE '"+IMEI+"'";
		try{  
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			//step2 create  the connection object  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Evansihab");  
			//step3 create the statement object  
			Statement stmt=con.createStatement();
            int r = stmt.executeUpdate(sql);
			if(r!=0)
			{
            System.out.println("SUCCESSFULLY Updated");
			return r;
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return 0;
	}
public static ArrayList<ProductList> getSearchItem(String IMEI){
	  productsInfo = new ArrayList<ProductList>();
		String sql ="";
		sql+="SELECT IMEI,PRODUCTNAME,PRODUCTPRICE,CATEGORY FROM PRODUCT WHERE IMEI='"+IMEI+"' OR PRODUCTNAME LIKE '"+"%"+IMEI+"%"+"'";
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Evansihab");  
			Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);  
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
					ProductList List=new ProductList();
					List.setProductIMEI(rs.getString("IMEI"));
					List.setProductName(rs.getString("PRODUCTNAME"));
					List.setProductCategory(rs.getString("CATEGORY"));
					List.setProductPrice(rs.getString("PRODUCTPRICE"));
					productsInfo.add(List);
					List=null;
			}
			}
			catch(Exception ex){
				ex.printStackTrace();
				System.out.println("FAILED");
				}
				return productsInfo;
  }
  public static List<ProductList> getAllItem(){
	  productsInfo = new ArrayList<ProductList>();
		String sql ="";
		sql+="SELECT IMEI,PRODUCTNAME,PRODUCTPRICE,CATEGORY FROM PRODUCT";
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Evansihab");  
			Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);  
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
					ProductList List=new ProductList();
					List.setProductIMEI(rs.getString("IMEI"));
					List.setProductName(rs.getString("PRODUCTNAME"));
					List.setProductCategory(rs.getString("CATEGORY"));
					List.setProductPrice(rs.getString("PRODUCTPRICE"));
					productsInfo.add(List);
					List=null;
			}
			}
			catch(Exception ex){
				ex.printStackTrace();
				System.out.println("FAILED");
				}
				return productsInfo;
  }
      public int SearchProduct(String IMEINUM){
        try{
    Class.forName("oracle.jdbc.driver.OracleDriver");  
    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Evansihab");  
    Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);  
    ResultSet rs=stmt.executeQuery("SELECT IMEI,PRODUCTNAME,PRODUCTPRICE,CATEGORY FROM PRODUCT WHERE IMEI='"+IMEINUM+"'");
        while(rs.next()){
            Sell=new ProductSellView();
        Sell.SetProductAll(rs.getString("IMEI"),rs.getString("PRODUCTNAME"),rs.getString("PRODUCTPRICE"),rs.getString("CATEGORY"));
        System.out.println(rs.getString("IMEI"));
        return 1;
        }}
        catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Failed");
        }
   return 0;
    }
}