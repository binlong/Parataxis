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

public class ReqTester4 {
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
	
	/** Checkout applies a percentage discount for a grocery store item that is marked as discounted for the date the customer is purchasing that item. */
	public static void tc00055(){
		
	}
	/** Checkout applies a buy multi-purchase discount to an item that meets the criteria for such a discount that is in force for the date the purchases are being made.  */
	public static void tc00056(){
		
	}
	/** Checkout has access to a list of credit cards and debit cards that may be used by customers to make payment. */
	public static void tc00057(){
		
	}
	/** Checkout is able to process coupons that a customer proffers for purchases. */
	public static void tc00058(){
		
	}
	/** Checkout applies store cents-off coupons if and only if all conditions for the coupon are met. */
	public static void tc00059(){
		
	}
	/** Checkout applies manufacturer cents-off coupons if and only if all conditions for the coupon are met. */
	public static void tc00060(){
		
	}
	/** Checkout applies manufacturer multi-purchase item coupons if and only if all conditions for the coupon are met. */
	public static void tc00061(){
		
	}
	/** Checkout applies at most one discount or one coupon to a given item being purchased. */
	public static void tc00062(){
		
	}
	/** Checkout adhere's to precedence rules in applying discounts and coupons to an item being purchased. */
	public static void tc00063(){
		
	}
	/** Checkout doubles the value of a manufacturer cents off coupon if and only if all conditions for the coupon to be applied are met and if and only if the purchase
	 *  is being made on a Monday and if and only if the doubling of the value of the coupon does not exceed the cost of the item to which it is being applied. */
	public static void tc00064(){
		
	}
	/** Checkout applies any cents off coupon for an item to which the coupon applies only up to the price of the item being purchased on the day of the purchase. */
	public static void tc00065(){
		
	}
	/** Checkout allows a customer to request cash back if an only if the payment for the customer's purchases 
	 * is being made by credit card or debit card and if and only if the balance on the credit card or debit card 
	 * is sufficient to cover the total sales price and the amount  */
	public static void tc00066(){
		
	}
	/** Checkout prints each item on a customer's receipt as the item is read in and immediately after the processing of the item is completed. */
	public static void tc00067(){
		
	}
	/** Checkout counts each item that is purchased by weight as a single item with respect to determining the total number of items purchased. */
	public static void tc00068(){
		
	}
	/** Checkout counts each item that is purchased by quantity as a single item with respect to determining the total number of items purchased. */
	public static void tc00069(){
		
	}
	/** Checkout counts each fixed price item when multiples of the same item are purchased by a customer as a single item with respect to determining the total number of items purchased. */
	public static void tc00070(){
		
	}
	/** Checkout uses simple rounding to two decimal places in all cases where rounding of monetary values is needed. */
	public static void tc00071(){
		
	}

	
}
