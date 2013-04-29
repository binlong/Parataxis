package scan.parataxis.test;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import parataxis.dto.Basket;
import parataxis.dto.Coupon;
import parataxis.dto.Grocery;
import parataxis.dto.Receipt;
import parataxis.dto.Tax;
import scan.parataxis.main.Scan;


public class ScanTest {
	
	final static String testFilename = "smallFile.txt";
	
	public static void main(String[] args) throws IOException, ParseException{
		//NOTE: in order to properly test if scan works, we need to print out\
		// the data scanned via the receipt class, since scan populates the data
		// while receipt prints out this data.
		
		System.out.println("[TEST] Entering ScanTest main method");
		
		Scan scn = new Scan(testFilename);
		System.out.println("[TEST] Scan initialized using file: "+scn.getFile_TEST());
		
		Scan scan = new Scan("SampleInputLarge.txt");
		Receipt receipt = null;
		ArrayList<Basket> blist = null;
		try {
			blist = scan.scanFile();
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Basket b:blist){


			Tax tax = new Tax(7.7, new Date(), new Date());
			try{
			if(b.getPaymentType().equals("card")){
				receipt  = new Receipt(b.getDate(), b.getItemBasket(), b.getCustomer(), tax, b.getCashback(), b.getCouponList());
			} else if (b.getPaymentType().equals("cash")){
				receipt = new Receipt(b.getDate(), b.getItemBasket(), b.getAmountPaid(), tax, b.getCouponList());
			}
			
			System.out.println();
			System.out.println(receipt);
			System.out.println();
			}catch(NullPointerException e){
				System.out.println("\nEmpty Basket\n");
			}
		}
		
		/*
		ArrayList<Grocery> testlist = scn.getGroceryList();
		System.out.println("[TEST] testlist initialized via scanItems() | testlist.size()="+testlist.size());
		
		System.out.println("[TEST] Printing out contents of testlist: ");
		for(Grocery i : testlist){
			System.out.println("UPC: "+i.getUpc()+", quantity: "+i.getQuantity());
		}
		
		System.out.println("[TEST] Get Date Method");
		System.out.println(scn.getDate() + " should equal Tue Jan 15 00:00:00 CST 2013"); 
		
		System.out.println("[TEST] Coupon Scanning Stuff");
		ArrayList<Coupon> testcpn = scn.getCouponList();
		for(Coupon i : testcpn){
			System.out.println("UPC: "+i.getUpc()+", discount:"+i.getDiscount());
		}
		
		System.out.println("[TEST] Exiting ScanTest main method successfully");
		*/
	}
}
