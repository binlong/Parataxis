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


	public static void tc00001(){
		/* later */
	}
	public static void tc00002(){
		/* later */
	}
	public static void tc00003(){
		/* later */
	}
	public static void tc00004(){
		/* later */
	}
	public static void tc00005(){
		/* later */
	}
	/**
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
	public static void tc00011(){
		/* later */
	}
	public static void tc00012(){
		/* later */
	}
	public static void tc00013(){
		/* later */
	}
	public static void tc00014(){
		/* later */
	}
	public static void tc00015(){
		/* later */
	}
	public static void tc00016(){
		/* later */
	}
	public static void tc00017(){
		/* later */
	}
	public static void tc00018(){
		/* later */
	}
	public static void tc00019(){
		/* later */
	}
	public static void tc00020(){
		/* later */
	}
	public static void tc00021(){
		/* later */
	}
	public static void tc00022(){
		/* later */
	}
	public static void tc00023(){
		/* later */
	}
	public static void tc00024(){
		/* later */
	}
	public static void tc00025(){
		/* later */
	}
	public static void tc00026(){
		/* later */
	}
	public static void tc00027(){
		/* later */
	}
	public static void tc00028(){
		/* later */
	}
	public static void tc00029(){
		/* later */
	}
	public static void tc00030(){
		/* later */
	}
	public static void tc00031(){
		/* later */
	}
	public static void tc00032(){
		/* later */
	}
	public static void tc00033(){
		/* later */
	}
	public static void tc00034(){
		/* later */
	}
	public static void tc00035(){
		/* later */
	}
	public static void tc00036(){
		/* later */
	}
	public static void tc00037(){
		/* later */
	}
	public static void tc00038(){
		/* later */
	}
	public static void tc00039(){
		/* later */
	}
	public static void tc00040(){
		/* later */
	}
	public static void tc00041(){
		/* later */
	}
	public static void tc00042(){
		/* later */
	}
	public static void tc00043(){
		/* later */
	}
	public static void tc00044(){
		/* later */
	}
	public static void tc00045(){
		/* later */
	}
	public static void tc00046(){
		/* later */
	}
	public static void tc00047(){
		/* later */
	}
	public static void tc00048(){
		/* later */
	}
	public static void tc00049(){
		/* later */
	}
	public static void tc00050(){
		/* later */
	}
	public static void tc00051(){
		/* later */
	}
	public static void tc00052(){
		/* later */
	}
	public static void tc00053(){
		/* later */
	}
	public static void tc00054(){
		/* later */
	}
	public static void tc00055(){
		/* later */
	}
	public static void tc00056(){
		/* later */
	}
	public static void tc00057(){
		/* later */
	}
	public static void tc00058(){
		/* later */
	}
	public static void tc00059(){
		/* later */
	}
	public static void tc00060(){
		/* later */
	}
	public static void tc00061(){
		/* later */
	}
	public static void tc00062(){
		/* later */
	}
	public static void tc00063(){
		/* later */
	}
	public static void tc00064(){
		/* later */
	}
	public static void tc00065(){
		/* later */
	}
	public static void tc00066(){
		/* later */
	}
	public static void tc00067(){
		/* later */
	}
	public static void tc00068(){
		/* later */
	}
	public static void tc00069(){
		/* later */
	}
	public static void tc00070(){
		/* later */
	}
	public static void tc00071(){
		/* later */
	}



}
