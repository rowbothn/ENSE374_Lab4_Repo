/*
*
* Filename: OrderApplication.java 
* Author: Noah Rowbotham (200364559)  
*
*/

public class OrderApplication {
	public ArrayList catalogue = new ArrayList();
	
	public static main(string[] args) {
		
	}
	
	boolean createOrder(Order) {
		
	}
	
	boolean importCatalogue() {
		FileReader file;

		try
			file = new FileReader("ProductCatalogue.txt");
		catch(IOException e) {
			System.out.print("File Import Failed");
			return;
		}
		
		Scanner read_products = new Scanner(file);
		
		while(read_products.hasNextLine()) {
			Product item = new Product(read_products.nextln(), read_products.nextDouble(), item_productID.nextInt());
			catalogue.add(item);
		}
	}
}