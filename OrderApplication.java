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
	ArrayList<Product> tempOrderLine = new ArrayList<Product>();
	List itemQuantity = new ArrayList();
	
	public static void main(String[] args) {
		OrderApplication orderUI = new OrderApplication();

		System.out.println("Creating Personal Customer...");
		PersonalCustomer personal_cust = new PersonalCustomer("Mr. Personal", "House", 3500, 123456789);

		//Uncomment to use corporate, and vice versa for personal customer
		// System.out.println("Creating Corporate Customer...");
		// CorporateCustomer corp_cust = new CorporateCustomer("Mr.Business", "Office", "My Buisness Contact");

		Order cust_order = new Order();
		Scanner readInput = new Scanner(System.in);
		int userChoice = 0;
		int userQuantity = 0;
		boolean whileOrder = true;
		boolean check_for_input = orderUI.importCatalogue();
			if(check_for_input == false)
				System.out.println("\nCatalogue Import Failed!");

		//Adding Items
		do {
			System.out.print("Choose the item you would like to purchase (Use numbers to select item): ");
			userChoice = readInput.nextInt();

			System.out.print("How many would you like to purchase? ");
			userQuantity = readInput.nextInt();

			orderUI.tempOrderLine.add(orderUI.catalogue.get(userChoice));
			orderUI.itemQuantity.add(userQuantity);

			orderUI.printCurrent();
			
			System.out.print("Would you like to add another item? (Use True/False) ");
			whileOrder = readInput.nextBoolean();

		} while(whileOrder == true);

		//Removing Items
		System.out.print("Would you like to remove any items entirely? (Use True/False) ");
		whileOrder = readInput.nextBoolean();
		while(whileOrder == true) {
			orderUI.printCurrent();
			System.out.print("Which item would you like to remove? (Use numbers to select item): ");
			userChoice = readInput.nextInt();
			orderUI.tempOrderLine.remove(userChoice);
			orderUI.itemQuantity.remove(userChoice);

			orderUI.printCurrent();
			System.out.println("Item removed.");

			System.out.print("Would you like to remove another item? (Use True/False) ");
			whileOrder = readInput.nextBoolean();
		}

		//Modifying Items
		System.out.print("Would you like to change the quantity of any items? (Use True/False) ");
		whileOrder = readInput.nextBoolean();
		 while(whileOrder == true) {
			orderUI.printCurrent();
			System.out.print("Which item would you like to modify? (Use numbers to select item) ");
			userChoice = readInput.nextInt();
			System.out.print("How many would you like instead? ");
			userQuantity = readInput.nextInt();
			orderUI.itemQuantity.set(userChoice, userQuantity);

			orderUI.printCurrent();
			System.out.println("Item Modified.");

			System.out.print("Would you like to modify another item? (Use True/False) ");
			whileOrder = readInput.nextBoolean();
		}

		System.out.println("\nOrder Complete. Your final order is...");
		orderUI.printCurrent();

		for(int i = 0; i < orderUI.tempOrderLine.size(); i++) {
			userQuantity = (int) orderUI.itemQuantity.get(i);
			cust_order.addOrderLine(orderUI.tempOrderLine.get(i), userQuantity);
		}

		System.out.println("\nProcessing customer order...");
		orderUI.createOrder(cust_order, personal_cust);
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
		int counter = 0;
		while(read_products.hasNextLine()) {
			String name = read_products.next();
			double cost = read_products.nextDouble();
			int id = read_products.nextInt();
			Product item = new Product(name, cost, id);
			System.out.print("Item: " + counter);
			System.out.print(" Name: " + item.getName());
			System.out.print(" Price: " + item.getPrice() + "\n");
			catalogue.add(item);
			counter++;
		}
		return true;
	}

	void printCurrent() {
		for(int i = 0; i < tempOrderLine.size(); i++) {
			System.out.print("Item: " + i);
			System.out.print(" Name: " + tempOrderLine.get(i).getName());
			System.out.print(" Quantity: " + itemQuantity.get(i) + "\n");
		}
	}
}