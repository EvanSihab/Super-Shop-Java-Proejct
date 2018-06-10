package supershop.service;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

public class CheckUser{
	public int Check(String id,String Pass){
		String sql ="";
		sql+="select * from Employee where EMPLOYEEID='"+id+"' AND PASSWORD='"+Pass+"'";
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
			System.out.println("Server Not Connected");
			return 111;
		}
		}
}