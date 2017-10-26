import java.util.*;
import java.io.*;
/*
*
* Filename: OrderApplication.java 
* Author: Noah Rowbotham (200364559)  
*
*/

public class OrderApplication {
	ArrayList<Product> catalogue = new ArrayList<Product>();
	
	public static void main(String[] args) {
		OrderApplication orderUI = new OrderApplication();
		System.out.println("Importing Catalogue...");
		boolean check_for_input = orderUI.importCatalogue();
		if(check_for_input == false)
			System.out.println("\nCatalogue Import Failed!");

		System.out.println("Creating Personal Customer...");
		PersonalCustomer personal_cust = new PersonalCustomer("Mr. Personal", "House", 3500, 123456789);

		System.out.println("Creating Corporate Customer...");
		CorporateCustomer corp_cust = new CorporateCustomer("Mr.Business", "Office", "My Buisness Contact");

		System.out.println("Generating Customer Order...");
		Order cust_order = new Order();
		cust_order.addOrderLine(orderUI.catalogue.get(0), 1);
		cust_order.addOrderLine(orderUI.catalogue.get(1), 1);
		cust_order.addOrderLine(orderUI.catalogue.get(2), 1);

		System.out.println("\nProcessing a Personal Customer Order");
		orderUI.createOrder(cust_order, personal_cust);

		System.out.println("Generating Customer Order...");
		cust_order = new Order();
		cust_order.addOrderLine(orderUI.catalogue.get(0), 1);
		cust_order.addOrderLine(orderUI.catalogue.get(1), 1);
		cust_order.addOrderLine(orderUI.catalogue.get(2), 1);

		System.out.println("\nProcessing a Corporate Customer Order");
		orderUI.createOrder(cust_order, corp_cust);
	}
	
	void createOrder(Order purchase, Customer customer) {
		System.out.println("Total Cost: $" + purchase.calculatePrice(customer.getDiscountRating()));
		System.out.println("Date Recieved: " + purchase.getDateRecieved());
		System.out.println("Order ID: " + purchase.getOrderID());
	}
	
	boolean importCatalogue() {
		FileReader file;

		try {
			file = new FileReader("ProductCatalogue.txt");
		}
		catch(IOException e) {
			return false;
		}

		Scanner read_products = new Scanner(file);
		
		while(read_products.hasNextLine()) {
			String name = read_products.next();
			double cost = read_products.nextDouble();
			int id = read_products.nextInt();
			Product item = new Product(name, cost, id);
			catalogue.add(item);
		}
		return true;
	}
}