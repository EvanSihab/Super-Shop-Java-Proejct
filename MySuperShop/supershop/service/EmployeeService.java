package supershop.service;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import supershop.view.EmployeeUpdateScene;
import supershop.model.EmployeeList;
import supershop.model.Employee;

public class EmployeeService{
	public static ArrayList<EmployeeList> employees;
	public String Add(Employee EMP){
		String sql="";
        sql+="INSERT INTO EMPLOYEE(EMPLOYEEID,FIRSTNAME,LASTNAME,DATEOFBIRTH,ADDRESS,PHONENUMBER,JOINDATE,EMPLOYEETYPE,SALARY,PASSWORD) ";
        sql+="VALUES('"+EMP.GetId()+"','"+EMP.GetFirstName()+"','"+EMP.GetLastName()+"','"+EMP.GetDateOfBirth()+"','"+EMP.GetAddress()+"','"+EMP.GetEmployeePhone()+"','"+EMP.GetJoinDate()+"','"+EMP.GetEmployeeType()+"','"+EMP.GetEmployeeSalary()+"','"+EMP.GetEmployeePassWord()+"')";
		try{  
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			//step2 create  the connection object  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Evansihab");  
			//step3 create the statement object  
			Statement stmt=con.createStatement();
            int r = stmt.executeUpdate(sql);
			if(r==1)
			{
				System.out.println("SUCCESSFULLY ADDED");
				System.out.println(EMP.GetId());
				return EMP.GetId();
				}
		}
		catch(Exception ex){
			ex.printStackTrace();
			System.out.print("FAILED");
			return null;
		}
		return null;
	}
	public int Delete(String id){
		String sql="";
		sql+="DELETE from EMPLOYEE where EMPLOYEEID='"+id+"'";
		try{  
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			//step2 create  the connection object  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Evansihab");  
			//step3 create the statement object  
			Statement stmt=con.createStatement();
            int r = stmt.executeUpdate(sql);
			if(r==1)
				{System.out.println("SUCCESSFULLY DELETED");
			return r;}
			else{
				System.out.println("Invalid Id");}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return 0;
	}
	public int Update(String id,String firstname,String lastname,String dateofbirth,String address,String phonenumber,String employeetype,String salary){
		String sql ="";
		sql+="UPDATE EMPLOYEE SET FIRSTNAME='"+firstname+"',LASTNAME='"+lastname+"',DATEOFBIRTH='"+dateofbirth+"',ADDRESS ='"+address+"',PHONENUMBER='"+phonenumber+"',EMPLOYEETYPE='"+employeetype+"',SALARY='"+salary+"' WHERE EMPLOYEEID='"+id+"'";
		try{  
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			//step2 create  the connection object  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Evansihab");  
			//step3 create the statement object  
			Statement stmt=con.createStatement();
            int r = stmt.executeUpdate(sql);
			if(r==1)
			{
            System.out.println("SUCCESSFULLY Updated");
			return r;
			}
			else{System.out.println("Invalid Id");}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return 0;
	}
	
	public int ChangePassword(String empid,String NewPass, String OldPass){
		String sql ="";
		sql+="UPDATE EMPLOYEE SET PASSWORD = '"+NewPass+"' WHERE (EMPLOYEEID='"+empid+"' AND PASSWORD='"+OldPass+"')";
		try{  
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			//step2 create  the connection object  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Evansihab");  
			//step3 create the statement object  
			Statement stmt=con.createStatement();
            int r = stmt.executeUpdate(sql);
			if(r==1)
			{
            System.out.println("SUCCESSFULLY Updated");
			}
			else{System.out.println("Invalid Id");}
			return r;
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return 0;
	}
	
	public int Search(String id){
		EmployeeUpdateScene update= new EmployeeUpdateScene();
		try{
	Class.forName("oracle.jdbc.driver.OracleDriver");  
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Evansihab");  
	Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);  
	ResultSet rs=stmt.executeQuery("SELECT EMPLOYEEID,FIRSTNAME,LASTNAME,DATEOFBIRTH,ADDRESS,PHONENUMBER,JOINDATE,EMPLOYEETYPE,SALARY FROM EMPLOYEE WHERE EMPLOYEEID='"+id+"'");
	while(rs.next()){
		update.SetAll(rs.getString("EMPLOYEEID"),rs.getString("FIRSTNAME"),rs.getString("LASTNAME"),rs.getString("DATEOFBIRTH"),rs.getString("ADDRESS"),rs.getString("PHONENUMBER"),rs.getString("JOINDATE"),rs.getString("EMPLOYEETYPE"),rs.getString("SALARY"));
	System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6));
	return 1;
		}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return 0;	
   }

  public static List<EmployeeList> getAll(){
	  employees = new ArrayList<EmployeeList>();
		String sql ="";
		sql+="SELECT EMPLOYEEID,FIRSTNAME,LASTNAME,DATEOFBIRTH,ADDRESS,PHONENUMBER,JOINDATE,EMPLOYEETYPE,SALARY FROM EMPLOYEE";
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Evansihab");  
			Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);  
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
					EmployeeList employeelist=new EmployeeList();
					employeelist.setEmployeeId(rs.getString("EMPLOYEEID"));
					employeelist.setFirstname(rs.getString("FIRSTNAME"));
					employeelist.setLastname(rs.getString("LASTNAME"));
					employeelist.setDateofbirth(rs.getString("DATEOFBIRTH"));
					employeelist.setEmployeeaddress(rs.getString("ADDRESS"));
					employeelist.setEmployeephone(rs.getString("PHONENUMBER"));
					employeelist.setJoindate(rs.getString("JOINDATE"));
					employeelist.setEmployeetype(rs.getString("EMPLOYEETYPE"));
					employeelist.setEmployeesalary(rs.getString("SALARY"));
					employees.add(employeelist);
					employeelist=null;
			}
			}
			catch(Exception ex){
				ex.printStackTrace();
				System.out.println("FAILED");
				}
				return employees;
  }
}