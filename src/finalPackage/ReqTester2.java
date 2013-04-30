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

public class ReqTester2 {
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
	
}
