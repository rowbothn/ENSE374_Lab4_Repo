/*
*
* Filename: OrderLine.java 
* Author: Noah Rowbotham (200364559)  
*
*/

public class OrderLine {
	int quantity;
	Product product = new Product();
	
	OrderLine(Product item, int amount) {
		product = item;
		quantity = amount;
	}
	
	int getQuantity() {
		return quantity;
	}

	double getPrice() {
		return product.getPrice();
	}
}