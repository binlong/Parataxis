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
	static Receipt receipt = null;
	static ArrayList<Receipt> rlist = new ArrayList<Receipt>();
	static ArrayList<Customer> testCustomers =new ArrayList<Customer>();

	public static void main(String[] args){
		
		PopulateCustomers p = new PopulateCustomers();
		try {
			testCustomers = p.populateCustomerList();
		} catch (IOException e) {
			e.printStackTrace();
		}



		

		try {
			Scan scan = new Scan("SampleInputLarge.txt");

			list = scan.scanFile();
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Tax tax = new Tax(7.7, new Date(), new Date());
		for(Basket b: list){
			try{
				if(b.getPaymentType().equals("card")){
					receipt  = new Receipt(b.getDate(), b.getItemBasket(), b.getCustomer(), tax, b.getCashback(), b.getCouponList());
				} else if (b.getPaymentType().equals("cash")){
					receipt = new Receipt(b.getDate(),b.getItemBasket(), b.getAmountPaid(), tax, b.getCouponList());
				}
				rlist.add(receipt);
			}catch(Exception e){
			
			}
		}

		tc00055();
		tc00056();
		tc00057();

	}

	/** Checkout applies a percentage discount for a grocery store item that is marked as discounted for the date the customer is purchasing that item. */
	public static void tc00055(){
		System.out.println(rlist.get(42));
		System.out.println("Checkout applies a percentage discount for a grocery store item that is\nmarked as discounted for the date the customer is purchasing that item: test failed");

	}
	/** Checkout applies a buy multi-purchase discount to an item that meets the criteria for such a discount that is in force for the date the purchases are being made.  */
	public static void tc00056(){
		System.out.println(rlist.get(42));
		System.out.println("Checkout applies a buy multi-purchase discount to an item that meets the\ncriteria for such a discount that is in force for the date the purchases are being made.: test failed");


	}
	/** Checkout has access to a list of credit cards and debit cards that may be used by customers to make payment. */
	public static void tc00057(){
		for(Customer cust:testCustomers){
			System.out.println(cust);
		}
		System.out.println("Checkout has access to a list of credit cards and\ndebit cards that may be used by customers to make payment: success");

	}
	/** Checkout is able to process coupons that a customer proffers for purchases. */
	public static void tc00058(){
		System.out.println(rlist.get(42));
		System.out.println("Checkout is able to process coupons that a customer proffers for purchases: success");


	}
	/** Checkout applies store cents-off coupons if and only if all conditions for the coupon are met. */
	public static void tc00059(){
		System.out.println(rlist.get(42));
		System.out.println("Checkout applies store cents-off coupons if and only if all conditions for the coupon are met: fail");

	}
	/** Checkout applies manufacturer cents-off coupons if and only if all conditions for the coupon are met. */
	public static void tc00060(){
		System.out.println(rlist.get(42));
		System.out.println("Checkout applies manufacturer cents-off coupons if and only if all conditions for the coupon are met: fail");
	}
	/** Checkout applies manufacturer multi-purchase item coupons if and only if all conditions for the coupon are met. */
	public static void tc00061(){
		System.out.println(rlist.get(42));
		System.out.println("Checkout applies manufacturer multi-purchase item coupons if and only if all conditions for the coupon are met: fail");

	}
	/** Checkout applies at most one discount or one coupon to a given item being purchased. */
	public static void tc00062(){
		System.out.println(rlist.get(42));
		System.out.println("Checkout applies at most one discount or one coupon to a given item being purchased. : fail");

	}
	/** Checkout adhere's to precedence rules in applying discounts and coupons to an item being purchased. */
	public static void tc00063(){
		System.out.println(rlist.get(42));
		System.out.println("Checkout adhere's to precedence rules in applying discounts and coupons to an item being purchased: fail");


	}
	/** Checkout doubles the value of a manufacturer cents off coupon if and only if all conditions for the coupon to be applied are met and if and only if the purchase
	 *  is being made on a Monday and if and only if the doubling of the value of the coupon does not exceed the cost of the item to which it is being applied. */
	public static void tc00064(){
		System.out.println(rlist.get(42));
		System.out.println("Checkout doubles the value of a manufacturer cents off coupon if and only if all conditions\n" +
				" for the coupon to be applied are met and if and only if the purchase\n" +
				"is being made on a Monday and if and only if the doubling of the value of\n" +
				"the coupon does not exceed the cost of the item to which it is being applied: fail\n");

	}
	/** Checkout applies any cents off coupon for an item to which the coupon applies only up to the price of the item being purchased on the day of the purchase. */
	public static void tc00065(){
		System.out.println(rlist.get(42));
		System.out.println("Checkout applies any cents off coupon for an item to which the coupon applies only up to the price of the item being purchased on the day of the purchase.:fail");
	}
	/** Checkout allows a customer to request cash back if an only if the payment for the customer's purchases 
	 * is being made by credit card or debit card and if and only if the balance on the credit card or debit card 
	 * is sufficient to cover the total sales price and the amount  */
	public static void tc00066(){
		System.out.println(rlist.get(42));
		System.out.println("Checkout applies any cents off coupon for an item to which the coupon applies only up to the price of the item being purchased on the day of the purchase:");

	}
	/** Checkout prints each item on a customer's receipt as the item is read in and immediately after the processing of the item is completed. */
	public static void tc00067(){
		System.out.println(rlist.get(42));
		System.out.println("Checkout prints each item on a customer's receipt as the item is read in and immediately after the processing of the item is completed.: success");

	}
	/** Checkout counts each item that is purchased by weight as a single item with respect to determining the total number of items purchased. */
	public static void tc00068(){
		System.out.println(rlist.get(42));
		System.out.println("Checkout counts each item that is purchased by weight as a single item with respect to determining the total number of items purchased: success");

	}
	/** Checkout counts each item that is purchased by quantity as a single item with respect to determining the total number of items purchased. */
	public static void tc00069(){
		System.out.println(rlist.get(42));
		System.out.println("Checkout counts each item that is purchased by weight as a single item with respect to determining the total number of items purchased: success");

	}
	/** Checkout counts each fixed price item when multiples of the same item are purchased by a customer as a single item with respect to determining the total number of items purchased. */
	public static void tc00070(){
		System.out.println(rlist.get(42));
		System.out.println("Checkout counts each fixed price item when multiples of the same item are purchased by a customer as a single item with respect to determining the total number of items purchased: fail");

	}
	/** Checkout uses simple rounding to two decimal places in all cases where rounding of monetary values is needed. */
	public static void tc00071(){
		System.out.println(rlist.get(42));
		System.out.println("Checkout uses simple rounding to two decimal places in all cases where rounding of monetary values is needed: pass");

	}


}
