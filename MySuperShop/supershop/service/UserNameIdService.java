package supershop.service;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class UserNameIdService{
	public static String UserName;
	public static String UserId;
	public static String newUserId;
	public static String newUserPass;
	
	public String getnewUserId(){return this.newUserId;}
	public String getnewUserPass(){return this.newUserPass;}
	public String getUserName(){return this.UserName;}
	public String getUserId(){return this.UserId;}
	
	public void setUserId(String Id,String Password){
		try{
	Class.forName("oracle.jdbc.driver.OracleDriver");  
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Evansihab");  
	Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);  
	ResultSet rs=stmt.executeQuery("SELECT EMPLOYEEID,FIRSTNAME,LASTNAME FROM EMPLOYEE WHERE EMPLOYEEID='"+Id+"' AND PASSWORD='"+Password+"'");
	if(rs!=null){
	while(rs.next()){
		this.UserName=rs.getString(2)+" "+rs.getString(3);
		this.UserId=rs.getString(1);
	System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
		}
	}else
	{
		System.out.println("Failed");
	}
		}
		catch(Exception ex){
			ex.printStackTrace();	
		}
	}
	public int NewUserIdPass(String newUserId,String newUserPass)
	{
		this.newUserId=newUserId;
		this.newUserPass=newUserPass;
		return 1;
	}
}
