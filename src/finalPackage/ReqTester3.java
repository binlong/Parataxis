package finalPackage;

import init.parataxis.main.PopulateCustomers;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import parataxis.dto.Basket;
import parataxis.dto.Customer;
import parataxis.dto.Grocery;
import parataxis.dto.Receipt;
import parataxis.dto.Tax;
import scan.parataxis.main.Scan;

public class ReqTester3 {
	static ArrayList<Basket> list = null;

	public static void main(String[] args){
		ArrayList<Customer> testCustomers =new ArrayList<Customer>();
		PopulateCustomers p = new PopulateCustomers();
		try {
			testCustomers = p.populateCustomerList();
		} catch (IOException e) {
			e.printStackTrace();
		}



		for(Customer cust:testCustomers){
			System.out.println(cust);
		}
		Receipt receipt = null;
		try {
			Scan scan = new Scan("SampleInputLarge.txt");
			
			list = scan.scanFile();
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Tax tax = new Tax(7.7, new Date(), new Date());
		for(Basket b: list){
			if(b.getPaymentType().equals("card")){
				receipt  = new Receipt(b.getDate(), b.getItemBasket(), b.getCustomer(), tax, b.getCashback(), b.getCouponList());
			} else if (b.getPaymentType().equals("cash")){
				receipt = new Receipt(b.getDate(),b.getItemBasket(), b.getAmountPaid(), tax, b.getCouponList());
			}
		}
		
	}
	
	/** Checkout prints a cash back section if and only if the customer requests cash back. */
	/** Checkout prints out the number of items purchased on a line immediately after the initial border line of the items purchased section. */
	public static void tc00037(){
		
	}
	/** Checkout ends the print out of the items purchased section by printing a border line where a border line is thirty-three equal sign characters starting in column one. */
	public static void tc00038(){
		
	}
	/** Checkout prints out an amount saved today section  if and only if the amount a given customer saved is a nonnegative amount of money. */
	public static void tc00039(){
		
	}
	/** Checkout prints the amount saved today line immediately after the training borderline of the items purchased section if and only if an amount saved section is needed for a given customer's purchases. */
	public static void tc00040(){
		
	}
	/** Checkout ends the print out of the amount saved section  by printing a border line where a border line is thirty-three equal sign characters starting in column one if and only if an amount saved section is needed for a given customer's purchases. */
	public static void tc00041(){
		
	}
	/** Checkout terminate the printing of each receipt for a given customer's basket with a date processed section. */
	public static void tc00042(){
		
	}
	/** Checkout begins the date processed section with a blank line. */
	public static void tc00043(){
		
	}
	/** Checkout prints out a date line immediately after the first line of the date processed section where the date line indicates the date that the items in a given customer's basket were purchased. */
	public static void tc00044(){
		
	}
	/** Checkout ends the date processed section with a blank line. */
	public static void tc00045(){
		
	}
	/** Checkout calculates sales tax for grocery store items that are marked as taxable for the date the customer is making any purchases. */
	public static void tc00046(){
		
	}
	/** Checkout  identifies grocery store items based on the unique assigned UPC of the item. */
	public static void tc00047(){
		
	}
	/** Checkout  create an exception log for any item in a customer's basket whose UPC is not found. */
	public static void tc00048(){
		
	}
	/** Checkout does not end processing when it encounters any item in a customer's basket whose UPC is not found. */
	public static void tc00049(){
		
	}
	/** Checkout identifies each grocery store item by name based on the item's UPC. */
	public static void tc00050(){
		
	}
	/** Checkout identifies each grocery store item by name on the customer's sale receipt. */
	public static void tc00051(){
		
	}
	/** Checkout identifies a customer's receipt the type for each item being purchased. */
	public static void tc00052(){
		
	}
	/** Checkout identifies a customer's receipt the category for each item being purchased. */
	public static void tc00053(){
		
	}
	/** Checkout applies the base price for a grocery store item based on the item's UPC and the date the customer is  purchasing the item. */
	public static void tc00054(){
		
	}
	
}
