package proj.parataxis.test;

import init.parataxis.main.PopulateCustomers;
import init.parataxis.main.PopulateTax;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import parataxis.dto.Coupon;
import parataxis.dto.Customer;
import parataxis.dto.Grocery;
import parataxis.dto.Receipt;
import parataxis.dto.Tax;
import scan.parataxis.main.Scan;
import discount.parataxis.main.Discount;

public class ReceiptTest {
	
	public static void main(String[] args) throws IOException, ParseException{
		Scan scan = new Scan(); 
		List<Grocery> scanList = scan.scanItems(); 
		PopulateCustomers cust = new PopulateCustomers();
		List<Customer> customerList = cust.populateCustomerList();
		PopulateTax tax = new PopulateTax();
		List<Tax> taxList = tax.populateTaxList();
		
		Discount discount = new Discount();
		
		Receipt receipt = new Receipt(scanList, customerList.get(1), taxList.get(1), 0.0, new ArrayList<Coupon>());
		
		// See what the receipt looks like when put together.
		System.out.print(receipt.makeHeader());
		System.out.print(receipt.printGroceries());
		if(discount.getTotal() != 0)
			discount.applyCoupon();
		System.out.print(receipt.printTotal());
	}

}
