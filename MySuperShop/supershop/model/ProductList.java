package supershop.model;
public class ProductList{
	private String productIMEI;
	private String productName;
	private String productPrice;
	private String productCategory;

    public String getProductIMEI() {
        return productIMEI;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductIMEI(String productIMEI) {
        this.productIMEI = productIMEI;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }  
}