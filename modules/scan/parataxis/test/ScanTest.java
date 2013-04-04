package parataxis.test;

import java.io.IOException;
import java.util.ArrayList;

import parataxis.dto.Grocery;
import parataxis.main.Scan;


public class ScanTest {
	
	final static String testFilename = "ScanFile1.txt";
	
	public static void main(String[] args) throws IOException{
		System.out.println("[TEST] Entering ScanTest main method");
		
		Scan scn = new Scan(testFilename);
		System.out.println("[TEST] Scan initialized using file: "+scn.getFile_TEST());
		
		ArrayList<Grocery> testlist = scn.scanItems();
		System.out.println("[TEST] testlist initialized via scanItems() | testlist.size()="+testlist.size());
		
		System.out.println("[TEST] Printing out contents of testlist: ");
		for(Grocery i : testlist){
			System.out.println("UPC: "+i.getUpc()+", quantity: "+i.getQuantity());
		}
		
		System.out.println("[TEST] Exiting ScanTest main method successfully");
	}
}
