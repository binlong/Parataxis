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


public class ReqTester1 {
	static ArrayList<Basket> list = null;
	
	public static void main(String[] args) {
		
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

		// TESTS
		tc00006(receipt);
		tc00007(receipt);
		tc00008(receipt);
		tc00009(receipt);
		tc00010(receipt);
	}
	/** Checkout processes grocery store items from customer's basket for a given date. */
	public static void tc00001(){
		
	}
	/** Checkout prints out a receipt for each customer making purchases. */
	public static void tc00002(){
		
	}
	/** Checkout prints out each receipt in Lucinda Console font size 10. */
	public static void tc00003(){
		
	}
	/** Checkout prints out each receipt with a text width that is fixed at forty-two (42) characters. */
	public static void tc00004(){
		
	}
	/** Checkout prints out each receipt with a left margin width flush to the left. */
	public static void tc00005(){
		
	}/**
	 *  GP1-00006 Checkout shall print out each receipt with a top margin of three blank lines.
	 */
	public static void tc00006(Receipt receipt){
		System.out.println("Top margin of 3 blank lines");
		System.out.println(receipt.makeHeader()+"\n");
	}
	/**
	 * GP1-00007 Checkout shall print out each receipt with bottom margin of one blank line.
	 */
	public static void tc00007(Receipt receipt){
		System.out.println("Bottom margin of 1 blank line");
		System.out.println(receipt.makeFooter()+"\n");
	}
	/**
	 * GP1-00008 Checkout shall print centered on the fourth line from the top  of each receipt "Hoggley-Woggley-Inc.
	 */
	public static void tc00008(Receipt receipt){
		System.out.println("4th line: Hoggley-Woggley-Inc. centered");
		System.out.println(receipt.makeHeader()+"\n");
	}
	/**
	 * GP1-00009 Checkout shall print centered on the fifth line from the top of each receipt the store identifier.
	 */
	public static void tc00009(Receipt receipt){
		System.out.println("5th line: store identifier");
		System.out.println(receipt.makeHeader()+"\n");
	}
	/**
	 * GP1-000010	Checkout shall print a blank line after the fifth line on each receipt.
	 */
	public static void tc00010(Receipt receipt){
		System.out.println("Blank line after the fifth line");
		System.out.println(receipt.makeHeader()+"\n");
	}
	/** Checkout prints a sequential number of up to three digits left justified 
	 * starting in column 1 for each main item purchase line on a receipt. */
	public static void tc00011(){
		
	}
	/** Checkout prints the  name of each item purchased left-justified
	 *  starting in column five of the main item purchase line. */
	public static void tc00012(){
		
	}
	/** Checkout prints the item type code of each item purchased in column thirty-two of the main item purchase line. */
	public static void tc00013(){
		
	}
	/** Checkout prints the item category code of each item purchased in column thirty-one of the main item purchase line. */
	public static void tc00014(){
		
	}
	/** Checkout accumulates multiples of the same item being purchased
	 *  when such multiple items scanned contiguously from a given customer's basket */
	public static void tc00015(){
		
	}
	/** Checkout calculates and print sales tax for any taxable item in a given customer's basket. */
	public static void tc00016(){
		
	}
	/** Checkout calculates and print the price for any item that is purchased by weight. */
	public static void tc00017(){
		
	}
	/** Checkout calculates and print the price for any item that is purchased by quantity. */
	public static void tc00018(){
		
	}
	
}
