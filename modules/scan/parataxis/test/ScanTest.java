package scan.parataxis.test;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import parataxis.dto.Coupon;
import parataxis.dto.Grocery;
import scan.parataxis.main.Scan;


public class ScanTest {
	
	final static String testFilename = "smallFile.txt";
	
	public static void main(String[] args) throws IOException, ParseException{
		System.out.println("[TEST] Entering ScanTest main method");
		
		Scan scn = new Scan(testFilename);
		System.out.println("[TEST] Scan initialized using file: "+scn.getFile_TEST());
		
		
		ArrayList<Grocery> testlist = scn.scanFile();
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
	}
}
