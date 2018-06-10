package supershop.model;
public class Employee{
	private static int count=0;
	private String id;
	private String firstName;
	private String lastName;
	private String address;
	private String dateOfBirth;
	private String joinDate;
	private String EmployeeType;
	private String EmployeeSalary;
	private String EmployeePhone;
	private String EmployeePassWord;
	
	public Employee(){}
	public Employee(String firstName,String lastName,String address,String EmployeePhone,String dateOfBirth,String joinDate,String EmployeeType,String EmployeeSalary,String EmployeePassWord){
		if(EmployeeType.equals("Admin")||EmployeeType.equals("admin")||EmployeeType.equals("ADMIN")){
			String[] S1 = joinDate.split("-");
			char S3 = S1[2].charAt(2);
			char S4 = S1[2].charAt(3);
			this.id = S3 + "" + S4 + S1[1]+"-" + ++count + "-" + 1;
		}
		else if(EmployeeType.equals("Manager")||EmployeeType.equals("manager")||EmployeeType.equals("MANAGER")){
			String[] S1 = joinDate.split("-");
			char S3 = S1[2].charAt(2);
			char S4 = S1[2].charAt(3);
			this.id = S3 + "" + S4 + S1[1]+"-" + ++count + "-" + 2;
		}
		else if(EmployeeType.equals("Staff")||EmployeeType.equals("staff")||EmployeeType.equals("STAFF")){
			String[] S1 = joinDate.split("-");
			char S3 = S1[2].charAt(2);
			char S4 = S1[2].charAt(3);
			this.id = S3 + "" + S4 + S1[1]+"-" + ++count + "-" + 3;
		}
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.joinDate = joinDate;
		this.EmployeeType = EmployeeType;
		this.EmployeePhone= EmployeePhone;
		this.EmployeeSalary=EmployeeSalary;
		this.EmployeePassWord=EmployeePassWord;
	}
	
	//GETTER METHODS
	public String GetId(){return this.id;}
	public String GetFirstName(){return this.firstName;}
	public String GetLastName() {return this.lastName;}
	public String GetDateOfBirth(){return this.dateOfBirth;}
	public String GetAddress(){return this.address;}
	public String GetEmployeePhone(){return this.EmployeePhone;}
	public String GetJoinDate(){return this.joinDate;}
	public String GetEmployeeType(){return this.EmployeeType;}
	public String GetEmployeeSalary(){return this.EmployeeSalary;}
	public String GetEmployeePassWord(){return this.EmployeePassWord;}
	
	//SETTER METHODS
	public void SetFirstName(String firstName){this.firstName = firstName;}
	public void SetLastName(String lastName){this.lastName = lastName;}
	public void SetDateOfBirth(String dateOfBirth){this.dateOfBirth = dateOfBirth;}
	public void SetAddress(String address){this.address = address;}
	public void SetEmployeePhone(String EmployeePhone){this.EmployeePhone = EmployeePhone;}
	public void SetJoinDate(String joinDate){this.joinDate = joinDate;}
	public void SetEmployeeType(String EmployeeType){this.EmployeeType = EmployeeType;}
	public void SetEmployeeSalary(String EmployeeSalary){this.EmployeeSalary = EmployeeSalary;}
	public void SetEmployeePassWord(String EmployeePassWord){this.EmployeePassWord=EmployeePassWord;}
}
