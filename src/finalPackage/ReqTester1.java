package finalPackage;


import init.parataxis.main.PopulateCustomers;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

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
//		for(Customer cust:testCustomers){
//			System.out.println(cust);
//		}
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
			//System.out.println(b.toString());
			try{
				if(b.getPaymentType().equals("card")){
					receipt  = new Receipt(b.getDate(), b.getItemBasket(), b.getCustomer(), tax, b.getCashback(), b.getCouponList());
				} else if (b.getPaymentType().equals("cash")){
					receipt = new Receipt(b.getDate(),b.getItemBasket(), b.getAmountPaid(), tax, b.getCouponList());
				}
			} catch(NullPointerException e){
				//System.out.println("Empty");
			}
		}

		// TESTS
//		tc00001(list);
//		tc00002(list);
//		tc00003(); // FAILED
//		tc00004();
//		tc00006(receipt);
//		tc00007(receipt);
//		tc00008(receipt);
//		tc00009(receipt);
//		tc00010(receipt);
//		tc00011();
//		tc00012();
//		tc00013();
//		tc00014();
//		tc00015();
//		tc00016();
//		tc00017();
		tc00018();
//		tc0);
	}
	/** Checkout processes grocery store items from customer's basket for a given date. */
	public static void tc00001(ArrayList<Basket> list){
		System.out.println("GP1-00001");
		Basket b;
		Receipt receipt = null;
		Tax tax = new Tax(7.7, new Date(), new Date());
		for(int i = 0; i < 3; i++){
				//System.out.println(list.get(i));
				b = list.get(i);
			try{
				if(b.getPaymentType().equals("card")){
					receipt  = new Receipt(b.getDate(), b.getItemBasket(), b.getCustomer(), tax, b.getCashback(), b.getCouponList());
				} else if (b.getPaymentType().equals("cash")){
					receipt = new Receipt(b.getDate(),b.getItemBasket(), b.getAmountPaid(), tax, b.getCouponList());
				}
			} catch(NullPointerException e){
				System.out.println("Empty");
			}
			System.out.println("[TESTING REQ GP1-00001]");
			System.out.println(receipt.makeHeader());
			System.out.println(receipt.printGroceries());
			System.out.println("[END TESTING REQ GP1-00001]");
		}
	}
	/** Checkout prints out a receipt for each customer making purchases. */
	public static void tc00002(ArrayList<Basket> list){
		System.out.println("GP1-00002");
		Basket b;
		Receipt receipt = null;
		Tax tax = new Tax(7.7, new Date(), new Date());
		for(int i = 0; i < 3; i++){
				//System.out.println(list.get(i));
				b = list.get(i);
			try{
				if(b.getPaymentType().equals("card")){
					receipt  = new Receipt(b.getDate(), b.getItemBasket(), b.getCustomer(), tax, b.getCashback(), b.getCouponList());
				} else if (b.getPaymentType().equals("cash")){
					receipt = new Receipt(b.getDate(),b.getItemBasket(), b.getAmountPaid(), tax, b.getCouponList());
				}
			} catch(NullPointerException e){
				System.out.println("Empty");
			}
			System.out.println("[TESTING REQ GP1-00002]");
			System.out.println(receipt);
			System.out.println("[END TESTING REQ GP1-00002]\n");
		}
	}
	/** Checkout prints out each receipt in Lucinda Console font size 10. */
	public static void tc00003(){
		System.out.println("GP1-00003");
		
		/* TODO: need to figure out how to change font.. */
	}
	/** Checkout prints out each receipt with a text width that is fixed at forty-two (42) characters. */
	public static void tc00004(){
		System.out.println("GP1-00004");
		//not counting the | on each side: so total width is 44 chars
		Basket b;
		Receipt receipt = null;
		Tax tax = new Tax(7.7, new Date(), new Date());
		// easiest way to do this right now is just make a string 44 chars and make sure all columns line up
		// Would be better to have each line as a string and use .length() to compare.....
		String compare = StringUtils.repeat("X", 44);
		for(int i = 0; i < 3; i++){
				//System.out.println(list.get(i));
			b = list.get(i);
			try{
				if(b.getPaymentType().equals("card")){
					receipt  = new Receipt(b.getDate(), b.getItemBasket(), b.getCustomer(), tax, b.getCashback(), b.getCouponList());
				} else if (b.getPaymentType().equals("cash")){
					receipt = new Receipt(b.getDate(),b.getItemBasket(), b.getAmountPaid(), tax, b.getCouponList());
				}
			} catch(NullPointerException e){
				System.out.println("Empty");
			}
			System.out.println(compare);
			System.out.println(receipt);
			System.out.println(compare);
		}
	}
	/** Checkout prints out each receipt with a left margin width flush to the left. */
	public static void tc00005(){
		System.out.println("GP1-00005");
	}/**
	 *  GP1-00006 Checkout shall print out each receipt with a top margin of three blank lines.
	 */
	public static void tc00006(Receipt receipt){
		System.out.println("GP1-00006");
		System.out.println("Top margin of 3 blank lines");
		System.out.println(receipt.makeHeader()+"\n");
	}
	/**
	 * GP1-00007 Checkout shall print out each receipt with bottom margin of one blank line.
	 */
	public static void tc00007(Receipt receipt){
		System.out.println("GP1-00007");
		System.out.println("Bottom margin of 1 blank line");
		System.out.println(receipt.makeFooter()+"\n");
	}
	/**
	 * GP1-00008 Checkout shall print centered on the fourth line from the top  of each receipt "Hoggley-Woggley-Inc.
	 */
	public static void tc00008(Receipt receipt){
		System.out.println("GP1-00008");
		System.out.println("4th line: Hoggley-Woggley-Inc. centered");
		System.out.println(receipt.makeHeader()+"\n");
	}
	/**
	 * GP1-00009 Checkout shall print centered on the fifth line from the top of each receipt the store identifier.
	 */
	public static void tc00009(Receipt receipt){
		System.out.println("GP1-00009");
		System.out.println("5th line: store identifier");
		System.out.println(receipt.makeHeader()+"\n");
	}
	/**
	 * GP1-000010	Checkout shall print a blank line after the fifth line on each receipt.
	 */
	public static void tc00010(Receipt receipt){
		System.out.println("GP1-00010");
		System.out.println("Blank line after the fifth line");
		System.out.println(receipt.makeHeader()+"\n");
	}
	/** Checkout prints a sequential number of up to three digits left justified 
	 * starting in column 1 for each main item purchase line on a receipt. */
	public static void tc00011(){
		System.out.println("GP1-00011 3 digits left justified for each item");
		Basket b;
		Receipt receipt = null;
		Tax tax = new Tax(7.7, new Date(), new Date());
		int loc = 43;
		for(int i = loc; i <= loc; i++){
				//System.out.println(list.get(i));
				b = list.get(i);
			try{
				if(b.getPaymentType().equals("card")){
					receipt  = new Receipt(b.getDate(), b.getItemBasket(), b.getCustomer(), tax, b.getCashback(), b.getCouponList());
				} else if (b.getPaymentType().equals("cash")){
					receipt = new Receipt(b.getDate(),b.getItemBasket(), b.getAmountPaid(), tax, b.getCouponList());
				}
			} catch(NullPointerException e){
				System.out.println("Empty");
			}
			System.out.println("[TESTING REQ GP1-00011]");
			System.out.println(receipt.printGroceries());
			System.out.println("[END TESTING REQ GP1-00011]");
		}
	}
	/** Checkout prints the  name of each item purchased left-justified
	 *  starting in column five of the main item purchase line. */
	public static void tc00012(){
		System.out.println("GP1-00012 print name of each item");
		Basket b;
		Receipt receipt = null;
		Tax tax = new Tax(7.7, new Date(), new Date());
		int loc = 34;
		for(int i = loc; i <= loc+3; i++){
				//System.out.println(list.get(i));
				b = list.get(i);
			try{
				if(b.getPaymentType().equals("card")){
					receipt  = new Receipt(b.getDate(), b.getItemBasket(), b.getCustomer(), tax, b.getCashback(), b.getCouponList());
				} else if (b.getPaymentType().equals("cash")){
					receipt = new Receipt(b.getDate(),b.getItemBasket(), b.getAmountPaid(), tax, b.getCouponList());
				}
			} catch(NullPointerException e){
				System.out.println("Empty");
			}
			System.out.println("[TESTING REQ GP1-00011]");
			System.out.println("|    X    "); // X in column 5
			System.out.print(receipt.printGroceries());
			System.out.println("|    X   <-- x in column 5 "); // X in column 5
			System.out.println("[END TESTING REQ GP1-00011]\n");
		}
	}
	/** Checkout prints the item type code of each item purchased in column thirty-two of the main item purchase line. */
	public static void tc00013(){
		System.out.println("GP1-00013 item type code in column 32");
		String test = "|";
		test += StringUtils.repeat(" ", 31);
		System.out.println(test.length());
		test += "X"; //in column 32
		Basket b;
		Receipt receipt = null;
		Tax tax = new Tax(7.7, new Date(), new Date());
		int loc = 34;
		for(int i = loc; i <= loc+3; i++){
				//System.out.println(list.get(i));
				b = list.get(i);
			try{
				if(b.getPaymentType().equals("card")){
					receipt  = new Receipt(b.getDate(), b.getItemBasket(), b.getCustomer(), tax, b.getCashback(), b.getCouponList());
				} else if (b.getPaymentType().equals("cash")){
					receipt = new Receipt(b.getDate(),b.getItemBasket(), b.getAmountPaid(), tax, b.getCouponList());
				}
			} catch(NullPointerException e){
				System.out.println("Empty");
			}
			System.out.println("[TESTING REQ GP1-00013]");
			System.out.println(test);
			System.out.print(receipt.printGroceries());
			System.out.println("[END TESTING REQ GP1-00013]\n");
		}
	}
	/** Checkout prints the item category code of each item purchased in column thirty-one of the main item purchase line. */
	public static void tc00014(){
		System.out.println("GP1-00014 item category code in column 31");
		String test = "|";
		test += StringUtils.repeat(" ", 30);
		System.out.println(test.length());
		test += "X"; //in column 31
		Basket b;
		Receipt receipt = null;
		Tax tax = new Tax(7.7, new Date(), new Date());
		int loc = 34;
		for(int i = loc; i <= loc+3; i++){
				//System.out.println(list.get(i));
				b = list.get(i);
			try{
				if(b.getPaymentType().equals("card")){
					receipt  = new Receipt(b.getDate(), b.getItemBasket(), b.getCustomer(), tax, b.getCashback(), b.getCouponList());
				} else if (b.getPaymentType().equals("cash")){
					receipt = new Receipt(b.getDate(),b.getItemBasket(), b.getAmountPaid(), tax, b.getCouponList());
				}
			} catch(NullPointerException e){
				System.out.println("Empty");
			}
			System.out.println("[TESTING REQ GP1-00014]");
			System.out.println(test);
			System.out.print(receipt.printGroceries());
			System.out.println("[END TESTING REQ GP1-00014]\n");
		}
	}
	/** Checkout accumulates multiples of the same item being purchased
	 *  when such multiple items scanned contiguously from a given customer's basket */
	public static void tc00015(){
		System.out.println("GP1-00015 scanned continguisly");
		Basket b;
		Receipt receipt = null;
		Tax tax = new Tax(7.7, new Date(), new Date());
		int loc = 43;
		for(int i = loc; i <= loc; i++){
				//System.out.println(list.get(i));
				b = list.get(i);
			try{
				if(b.getPaymentType().equals("card")){
					receipt  = new Receipt(b.getDate(), b.getItemBasket(), b.getCustomer(), tax, b.getCashback(), b.getCouponList());
				} else if (b.getPaymentType().equals("cash")){
					receipt = new Receipt(b.getDate(),b.getItemBasket(), b.getAmountPaid(), tax, b.getCouponList());
				}
			} catch(NullPointerException e){
				System.out.println("Empty");
			}
			System.out.println("[TESTING REQ GP1-00015]");
			System.out.println(receipt.printGroceries());
			System.out.println("[END TESTING REQ GP1-00015]");
		}
	}
	/** Checkout calculates and print sales tax for any taxable item in a given customer's basket. */
	public static void tc00016(){
		System.out.println("GP1-00016 calc and pritn sales tax");
		Basket b;
		Receipt receipt = null;
		Tax tax = new Tax(7.7, new Date(), new Date());
		int loc = 30;
		for(int i = loc; i <= loc+5; i++){
				//System.out.println(list.get(i));
				b = list.get(i);
			try{
				if(b.getPaymentType().equals("card")){
					receipt  = new Receipt(b.getDate(), b.getItemBasket(), b.getCustomer(), tax, b.getCashback(), b.getCouponList());
				} else if (b.getPaymentType().equals("cash")){
					receipt = new Receipt(b.getDate(),b.getItemBasket(), b.getAmountPaid(), tax, b.getCouponList());
				}
			} catch(NullPointerException e){
				System.out.println("Empty");
			}
			System.out.println("[TESTING REQ GP1-00016]");
			System.out.print(receipt.printGroceries());
			System.out.print(receipt.printTotal());
			System.out.println("[END TESTING REQ GP1-00016]\n");
		}
	}
	/** Checkout calculates and print the price for any item that is purchased by weight. */
	public static void tc00017(){
		System.out.println("GP1-00017 purchase by weight");
		Basket b;
		Receipt receipt = null;
		Tax tax = new Tax(7.7, new Date(), new Date());
		int loc = 43;
		for(int i = loc; i <= loc; i++){
				//System.out.println(list.get(i));
				b = list.get(i);
			try{
				if(b.getPaymentType().equals("card")){
					receipt  = new Receipt(b.getDate(), b.getItemBasket(), b.getCustomer(), tax, b.getCashback(), b.getCouponList());
				} else if (b.getPaymentType().equals("cash")){
					receipt = new Receipt(b.getDate(),b.getItemBasket(), b.getAmountPaid(), tax, b.getCouponList());
				}
			} catch(NullPointerException e){
				System.out.println("Empty");
			}
			System.out.println("[TESTING REQ GP1-00017]");
			System.out.println(receipt.printGroceries());
			System.out.println("[END TESTING REQ GP1-00017]");
		}
		System.out.println("TEST FAILED...");
	}
	/** Checkout calculates and print the price for any item that is purchased by quantity. */
	public static void tc00018(){
		System.out.println("GP1-00018 purchased by quantity");
		Basket b;
		Receipt receipt = null;
		Tax tax = new Tax(7.7, new Date(), new Date());
		int loc = 40;
		for(int i = loc; i <= loc+3; i++){
				//System.out.println(list.get(i));
				b = list.get(i);
			try{
				if(b.getPaymentType().equals("card")){
					receipt  = new Receipt(b.getDate(), b.getItemBasket(), b.getCustomer(), tax, b.getCashback(), b.getCouponList());
				} else if (b.getPaymentType().equals("cash")){
					receipt = new Receipt(b.getDate(),b.getItemBasket(), b.getAmountPaid(), tax, b.getCouponList());
				}
			} catch(NullPointerException e){
				System.out.println("Empty");
			}
			System.out.println("[TESTING REQ GP1-00018]");
			System.out.println(receipt.printGroceries());
			System.out.println("[END TESTING REQ GP1-00018]");
			// seems to work for F type groceries...
		}
	}
	
}
