/*
*
* Filename: OrderLine.java 
* Author: Noah Rowbotham (200364559)  
*
*/

public class OrderLine {
	int quantity;
	Product item = new Product();
	double price;
	
	OrderLine(Product product) {
		price = product.getPrice();
		quantity = 2;
	}
	
	Product getProduct() {
		return item;
	}
	
	int getQuantity() {
		return quantity;
	}
	
	double getPrice() {
		return price;
	}
}