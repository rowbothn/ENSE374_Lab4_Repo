/*
*
* Filename: Product.java 
* Author: Noah Rowbotham (200364559)  
*
*/

public class Product {
	String name;
	double price;
	int productID;
	
	Product(String item_name, double item_price, int item_productID) {
		name = item_name;
		price = item_price;
		productID = item_productID;
	}
	
	void setName(String item_name) {
		name = item_name;
	}
	
	void setPrice(double item_price) {
		price = item_price;
	}
	
	void setProductID(int productID) {
		productID = item_productID
	}
	
	String getName() {
		return name;
	}
	
	double getPrice() {
		return price;
	}
	
	int getProductID() {
		return productID;
	}
}