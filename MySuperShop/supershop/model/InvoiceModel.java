package supershop.model;
public class InvoiceModel{
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
	
	public InvoiceModel(){}
	public InvoiceModel(String SELLERNAME,String SELLERID,String PRODUCTIMEI,String PRODUCTNAME,String CATEGORY,String PRICE,String QUANTITY,String VAT,String DISCOUNT,String TOTAL,String GIVENMONEY,String RETURNMONEY,String DATE)
	{
		sellDate=DATE;
		SellerId=SELLERID;
		SellerName=SELLERNAME;
		ProductIMEI=PRODUCTIMEI;
		ProductName=PRODUCTNAME;
		ProductCategory=CATEGORY;
		ProductPrice=PRICE;
		ProductQuantity=QUANTITY;
		GivenMoney=GIVENMONEY;
		Vat=VAT;
		ReturnMoney=RETURNMONEY;
		TotalPrice=TOTAL;
		Discount=DISCOUNT;
		
	}

    public String getSellDate() {
        return sellDate;
    }

    public void setSellDate(String sellDate) {
        this.sellDate = sellDate;
    }

    public void setSellerId(String SellerId) {
        this.SellerId = SellerId;
    }

    public void setSellerName(String SellerName) {
        this.SellerName = SellerName;
    }

    public void setProductIMEI(String ProductIMEI) {
        this.ProductIMEI = ProductIMEI;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public void setProductPrice(String ProductPrice) {
        this.ProductPrice = ProductPrice;
    }

    public void setProductCategory(String ProductCategory) {
        this.ProductCategory = ProductCategory;
    }

    public void setProductQuantity(String ProductQuantity) {
        this.ProductQuantity = ProductQuantity;
    }

    public void setGivenMoney(String GivenMoney) {
        this.GivenMoney = GivenMoney;
    }

    public void setVat(String Vat) {
        this.Vat = Vat;
    }

    public void setReturnMoney(String ReturnMoney) {
        this.ReturnMoney = ReturnMoney;
    }

    public void setTotalPrice(String TotalPrice) {
        this.TotalPrice = TotalPrice;
    }

    public void setDiscount(String Discount) {
        this.Discount = Discount;
    }

    public String getSellerId() {
        return SellerId;
    }

    public String getSellerName() {
        return SellerName;
    }

    public String getProductIMEI() {
        return ProductIMEI;
    }

    public String getProductName() {
        return ProductName;
    }

    public String getProductPrice() {
        return ProductPrice;
    }

    public String getProductCategory() {
        return ProductCategory;
    }

    public String getProductQuantity() {
        return ProductQuantity;
    }

    public String getGivenMoney() {
        return GivenMoney;
    }

    public String getVat() {
        return Vat;
    }

    public String getReturnMoney() {
        return ReturnMoney;
    }

    public String getTotalPrice() {
        return TotalPrice;
    }

    public String getDiscount() {
        return Discount;
    }
}