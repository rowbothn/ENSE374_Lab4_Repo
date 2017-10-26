/*
*
* Filename: Order.java 
* Author: Noah Rowbotham (200364559)  
*
*/

public class Order {
	Date dateRecieved;
	int quantity;
	double order_price = 0;
	int orderID;
	
	Date getDateRecieved() {
		return dateRecieved;
	}
	
	double calculatePrice() {
		for(int i = 0; i < 10; i++) {
			OrderLine item = new OrderLine(catalogue[i]);
			double item_price += item.getPrice();
			quantity = item.getQuantity()
			order_price += quantity * item_price;
		}
	}
}