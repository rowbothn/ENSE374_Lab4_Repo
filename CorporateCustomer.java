/*
*
* Filename: CorporateCustomer.java 
* Author: Noah Rowbotham (200364559)  
*
*/

public class CorporateCustomer extends Customer {
	String contactName; 

	CorporateCustomer(String cust_name, String cust_address, String cust_contactName) {
		name = cust_name;
		address = cust_address;
		contactName = cust_contactName;		
	}
}