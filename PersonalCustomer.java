/*
*
* Filename: PersonalCustomer.java 
* Author: Noah Rowbotham (200364559)  
*
*/

public class PersonalCustomer extends Customer {
	int creditCardNumber;

	PersonalCustomer(String cust_name, String cust_address, double cust_creditRating, int cust_creditCardNumber) {
		name = cust_name;
		address = cust_address;
		creditRating = cust_creditRating;
		creditCardNumber = cust_creditCardNumber;	
	}

	void calcDiscountRating() {
		if(creditRating == 5000)
			discountRating = .1;
		else if(creditRating < )
	}
}