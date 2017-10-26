/*
*
* Filename: CorporateCustomer.java 
* Author: Noah Rowbotham (200364559)  
*
*/

public class CorporateCustomer extends Customer {
	String contactName; 

	CorporateCustomer(String cust_name, String cust_address, double cust_creditRating, double cust_discountRating, String cust_contactName) {
		name = cust_name;
		address = cust_address;
		creditRating = cust_creditRating;
		discountRating = cust_discountRating;
		contactName = cust_contactName;		
	}
}