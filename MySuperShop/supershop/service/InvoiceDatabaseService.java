package supershop.service;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import supershop.model.InvoiceModel;
public class InvoiceDatabaseService{
	public int AddInvoice(InvoiceModel im){
		String sql="";
        sql+="INSERT INTO INVOICE(SELLERNAME,SELLERID,PRODUCTIMEI,PRODUCTNAME,PRODUCTCATEGORY,PRODUCTPRICE,QUANTITY,VAT,DISCOUNT,TOTALPRICE,GIVENMONEY,RETURNMONEY,SELLDATE)";
        sql+="VALUES('"+im.getSellerName()+"','"+im.getSellerId()+"','"+im.getProductIMEI()+"','"+im.getProductName()+"','"+im.getProductCategory()+"','"+im.getProductPrice()+"','"+im.getProductQuantity()+"','"+im.getVat()+"','"+im.getDiscount()+"','"+im.getTotalPrice()+"','"+im.getGivenMoney()+"','"+im.getReturnMoney()+"','"+im.getSellDate()+"')";
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
		return r;}
		}
		catch(Exception ex){
			ex.printStackTrace();
			System.out.print("FAILED");
			return 0;
		}
		return 0;
	}
}