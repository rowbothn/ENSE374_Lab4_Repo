import java.util.*
/*
*
* Filename: OrderApplication.java 
* Author: Noah Rowbotham (200364559)  
*
*/

public class OrderApplication {
	public ArrayList<Product> catalogue = new ArrayList<Product>();
	
	public static main(String[] args) {
		System.out.println("Creating Personal Customer...");
		PersonalCustomer personal_cust = new PersonalCustomer("Mr. Personal", "House", 3500, 123456789012);
		System.out.println("Creating Corporate Customer...");
		CorporateCustomer corp_cust = new CorporateCustomer("Mr.Buisness", "Office", "My Buisness Contact");

		System.out.println("Generating Order...");
		OrderApplication orderUI = new OrderApplication();
		Order personal_order = new Order();
		Order cust_order = new Order();

		System.out.println("Importing Catalogue...");
		orderUI.importCatalogue();

		System.out.println("Processing a Personal Customer Order");
		orderUI.createOrder(personal_order);
		System.out.println("Processing a Corporate Customer Order");
		orderUI.createOrder(cust_order);

	}
	
	boolean createOrder(Order purchase) {
		boolean check_for_input = importCatalogue();
		if(check_for_input == false) {
			System.out.println("System failure! Catalogue not available.");
			return false;
		}

		System.out.println("Your total cost is: " + purchase.calculatePrice());
		System.out.println("Order Recieved: " + purchase.getDateRecieved());
		return true;
	}
	
	boolean importCatalogue() {
		FileReader file;

		try
			file = new FileReader("ProductCatalogue.txt");
		catch(IOException e) {
			System.out.print("File Import Failed");
			return false;
		}

		Scanner read_products = new Scanner(file);
		
		while(read_products.hasNextLine()) {
			Product item = new Product(read_products.nextln(), read_products.nextDouble(), item_productID.nextInt());
			catalogue.add(item);
		}
		return true;
	}
	
}