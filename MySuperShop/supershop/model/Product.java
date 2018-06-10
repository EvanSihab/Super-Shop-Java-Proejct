package supershop.model;
public class Product{
	private String IMEI;
	private String ProductName;
	private String ProductCategory;
	private String ProductPrice;
	
	public Product(String IMEI,String ProductName,String ProductCategory,String ProductPrice)
	{
		this.IMEI=IMEI;
		this.ProductName=ProductName;
		this.ProductCategory=ProductCategory;
		this.ProductPrice=ProductPrice;
	}
	public void SetIMEI(String IMEI){this.IMEI=IMEI;}
	public void SetProductName(String ProductName){this.ProductName=ProductName;}
	public void SetProductCategory(String ProductCategory){this.ProductCategory=ProductCategory;}
	public void SetProductPrice(String ProductPrice){this.ProductPrice=ProductPrice;}
	
	public String GetIMEI(){return IMEI;}
	public String GetProductName(){return ProductName;}
	public String GetProductCategory(){return ProductCategory;}
	public String GetProductPrice(){return ProductPrice;}
}