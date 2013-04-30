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


public class ReqTester {

	
	public static void main(String[] args) {
		
	ArrayList<Customer> testCustomers =new ArrayList<Customer>();
		PopulateCustomers p = new PopulateCustomers();
		ArrayList<Basket> list = null;
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
	/** Checkout prints a cash back section if and only if the customer requests cash back. */
	public static void tc00019(){
		
	}
	/** Checkout prints a coupon section if and only if the customer offers coupons to be redeemed. */
	public static void tc00020(){
		
	}
	/** Checkout prints on a single line each legitimate cents-off coupon that a customer offers. */
	public static void tc00021(){
		
	}
	/** Checkout prints on a single line at the end of the coupon section the total of the 
	 * legitimate cents-off coupons that were applied to a customer's basket. */
	public static void tc00022(){
		
	}
	/** Checkout prints a sale subtotal section after the last item in a given customer's basket 
	 * is processed or after the coupon section if there is a coupon section. */
	public static void tc00023(){
		
	}
	/** Checkout prints a sale subtotal section after the last item in a given customer's basket
	 *  is processed or after the coupon section if there is a coupon section. */
	public static void tc00024(){
		
	}
	/** Checkout prints a sale subtotal line immediately after the printing of the 999th main item purchase is completed. */
	public static void tc00025(){
		
	}
	/** Checkout allows at most 9999 grocery store item to be processed on a single receipt. */
	public static void tc00026(){
		
	}
	/** Checkout prints a Total Sale line immediately after the final Sale Subtotal section on a given receipt. */
	public static void tc00027(){
		
	}
	/** Checkout prints a payment section immediately after the Total Sale line on a given receipt. */
	public static void tc00028(){
		
	}
	/** Checkout verifys and print an approved line for a credit or debit card payment that has sufficient funds to cover the purchase. */
	public static void tc00029(){
		
	}
	/** Checkout verifys and prints a disapproved line for a credit or debit card payment that has insufficient funds to cover the purchase. */
	public static void tc00030(){
	    
	}
	/** Checkout prints the cash tendered for a purchase if and only if the customer is paying by cash. */
	public static void tc00031(){
		
	}
	/** Checkout prints a line indicating the change due the customer followed by a blank line if and only if 
	 * the customer is paying by cash and has tendered sufficient funds to cover the total cost of the purchase. */
	public static void tc00032(){
		
	}
	/** Checkout prints a sale canceled line if and only if a customer is paying by cash and has tendered insufficient funds to cover the total cost of the purchase. */
	public static void tc00033(){

	}
	/** Checkout terminates a given receipt for a customer if the payment is insufficient. */
	public static void tc00034(){
		
	}
	/** Checkout prints an items purchased section immediately after the payment section. */
	public static void tc00035(){
		
	}
	/** Checkout begins the print out of the items purchased section by printing a 
	 * border line where a borderline is thirty-three equal sign characters starting in column one. */
	public static void tc00036(){
		
	}
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
