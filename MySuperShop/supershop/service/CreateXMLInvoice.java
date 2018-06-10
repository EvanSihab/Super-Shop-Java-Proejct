package supershop.service;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreateXMLInvoice{
	public static String ProductSellerName;
	public static String ProductSellerId;
	public static String productImei;
	public static String productName;
	public static String productCategory;
	public static String productPrice;
	public static String Quantity;
	public static String vat;
	public static String Discount;
	public static String producttotalPrice;
	public static String CustomerGivenMoney;
	public static String CustomerReturnMoney;
	public static String ProductSellDate;
	public static final String xmlFilePath = "F:\\MySuperShop\\supershop\\SellInvoices\\supershopinvoice.xml";
	InvoiceService invoice;
	public CreateXMLInvoice()
	{
		invoice=new InvoiceService();
		ProductSellerName=invoice.getSellerName();
		ProductSellerId=invoice.getSellerId();
		productImei=invoice.getProductIMEI();
		productName=invoice.getProductName();
		productCategory=invoice.getProductCategory();
		productPrice=invoice.getProductPrice();
		Quantity=invoice.getProductQuantity();
		vat=invoice.getVat();
		Discount=invoice.getDiscount();
		producttotalPrice=invoice.getTotalPrice();
		CustomerGivenMoney=invoice.getGivenMoney();
		CustomerReturnMoney=invoice.getReturnMoney();
		ProductSellDate=invoice.getSellDate();	
		try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();
            // root element
            Element root = document.createElement("SuperShopInvoice");
            document.appendChild(root);
            Element invoice = document.createElement("Invoice");
            root.appendChild(invoice);
			
			Element SuperShop = document.createElement("SuperShop");
            SuperShop.appendChild(document.createTextNode("Super Shop"));
            invoice.appendChild(SuperShop);
			
			Element TopSeparator = document.createElement("TopSeparator");
            TopSeparator.appendChild(document.createTextNode("-------------------------------------------------------"));
            invoice.appendChild(TopSeparator);
            
            Element SellerId = document.createElement("SellerId");
            SellerId.appendChild(document.createTextNode("Seller Id\t\t     : "+ProductSellerId));
            invoice.appendChild(SellerId);
			
            Element SellerName = document.createElement("SellerName");
            SellerName.appendChild(document.createTextNode("Seller Name   : "+ProductSellerName));
            invoice.appendChild(SellerName);
            
			Element MidSeparator = document.createElement("MidSeparator");
            MidSeparator.appendChild(document.createTextNode("-------------------------------------------------------"));
            invoice.appendChild(MidSeparator);
			
            Element ProductImei = document.createElement("ProductIMEI");
            ProductImei.appendChild(document.createTextNode("Product IMEI   : "+productImei));
            invoice.appendChild(ProductImei);
			
			Element ProductName = document.createElement("ProductName");
            ProductName.appendChild(document.createTextNode("Product Name  : "+productName));
            invoice.appendChild(ProductName);
			
			Element ProductCategory = document.createElement("Category");
            ProductCategory.appendChild(document.createTextNode("Category \t\t     : "+productCategory));
            invoice.appendChild(ProductCategory);
            
            Element ProductPrice = document.createElement("ProductPrice");
            ProductPrice.appendChild(document.createTextNode("Product Price\t : "+productPrice));
            invoice.appendChild(ProductPrice);
			
			Element ProductQuantity = document.createElement("ProductQuantity");
            ProductQuantity.appendChild(document.createTextNode("Quantity\t\t      : "+Quantity));
            invoice.appendChild(ProductQuantity);
			
			Element VAT = document.createElement("VAT");
            VAT.appendChild(document.createTextNode("VAT\t\t            : "+vat+"%"));
            invoice.appendChild(VAT);
			
			Element discount = document.createElement("Discount");
            discount.appendChild(document.createTextNode("Discount \t\t     : "+Discount+"%"));
            invoice.appendChild(discount);
			
			Element TotalPrice = document.createElement("TotalPrice");
            TotalPrice.appendChild(document.createTextNode("Total Price \t\t  : "+producttotalPrice));
            invoice.appendChild(TotalPrice);
			
			Element givenMoney = document.createElement("GivenMoney");
            givenMoney.appendChild(document.createTextNode("Given Money   : "+CustomerGivenMoney));
            invoice.appendChild(givenMoney);
			
			Element returnMoney= document.createElement("ReturnMoney");
            returnMoney.appendChild(document.createTextNode("Return Money  : "+CustomerReturnMoney));
            invoice.appendChild(returnMoney);
			
			Element SellDate = document.createElement("SellDate");
            SellDate.appendChild(document.createTextNode("Date\t\t\t : "+ProductSellDate));
            invoice.appendChild(SellDate);
			
			Element BottomSeparator = document.createElement("BottomSeparator");
            BottomSeparator.appendChild(document.createTextNode("-------------------------------------------------------"));
            invoice.appendChild(BottomSeparator);
			
			Element ThanksText = document.createElement("ThankYou");
            ThanksText.appendChild(document.createTextNode("\tThank you for shopping with Super-Shop"));
            invoice.appendChild(ThanksText);
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(xmlFilePath));

            transformer.transform(domSource, streamResult);
            System.out.println("Done creating XML File");
        }
		catch (ParserConfigurationException pce) {
            pce.printStackTrace();
			System.out.println("ERROR");
        }
		catch (TransformerException tfe) {
            tfe.printStackTrace();
			System.out.println("ERROR");
        }
    }
}