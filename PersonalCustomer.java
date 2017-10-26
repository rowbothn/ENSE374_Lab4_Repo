/*
*
* Filename: PersonalCustomer.java 
* Author: Noah Rowbotham (200364559)  
*
*/

public class PersonalCustomer extends Customer {
	int creditCardNumber;

	PersonalCustomer(String cust_name, String cust_address, double cust_creditRating, double cust_discountRating, int cust_creditCardNumber) {
		name = cust_name;
		address = cust_address;
		creditRating = cust_creditRating;
		discountRating = cust_discountRating;	
		creditCardNumber = cust_creditCardNumber;	
	}
}