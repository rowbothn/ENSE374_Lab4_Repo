import java.util.*;
/*
*
* Filename: Order.java 
* Author: Noah Rowbotham (200364559)  
*
*/

public class Order {
	ArrayList<OrderLine> order = new ArrayList<OrderLine>();
	Date dateRecieved;
	double order_price = 0;
	int orderID;
	
	Date getDateRecieved() {
		return dateRecieved;
	}

	void addOrderLine(Product item, int quantity) {
		OrderLine order_element = new OrderLine(item, quantity);
		order.add(order_element);
	}
	
	double calculatePrice(double discountRating) {
		System.out.println("Calculating price...");
		int quantity = 0;

		for(int i = 0; i < order.size(); i++) {
			quantity = (order.get(i)).getQuantity();
			order_price += quantity * (order.get(i)).getPrice();
		}
		System.out.println(discountRating);
		double discount = order_price * discountRating;
		return (order_price - discount);
	}

	void generateOrderID() {
		Random newID = new Random();
		orderID = newID.nextInt(20000) + 10000;
	}

	int getOrderID() {
		generateOrderID();
		return orderID;
	}
}