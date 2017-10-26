import java.util.*;
/*
*
* Author: Noah Rowbotham (200364559)  
* Filename: PersonalCustomer.java 
*
*/

public class PersonalCustomer extends Customer {
	int creditCardNumber;		
		
	PersonalCustomer(String cust_name, String cust_address, double cust_creditRating, int cust_creditCardNumber) {
		name = cust_name;
		address = cust_address;
		creditCardNumber = cust_creditCardNumber;	
		creditRating = cust_creditRating;
		calcDiscountRating();
	}
	
	void calcDiscountRating() {
		discountRating = creditRating/200000;
		System.out.println(discountRating);
	}
}
