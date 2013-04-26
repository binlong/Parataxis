package scan.parataxis.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import parataxis.dto.Grocery;
import init.parataxis.main.PopulateGrocery;


public class Scan {
	
	private String scanFilename;
	final private String filefolder = "scanfiles/";
	
	//final private String groceryFilename = "GroceryDefault.txt";
	
	/**
	 * This constructor initliazes the filename to "ScanFileDefault.txt"
	 */
	public Scan () {
		scanFilename = filefolder+"ScanFileDefault.txt";
	}
	
	/**
	 * Initialize a Scan object and specify a file of UPC codes to be
	 * "scanned" in by the system.
	 * @param filename The name of the file that holds customer's UPC codes. Note:
	 * 			this file should be a list of UPC codes, with one UPC code on each line, and
	 * 			no other information in the file. The file should be placed in the root 
	 * 			directory of this project. 
	 */
	public Scan(String filename) {
		this.scanFilename = filefolder+filename;
	}
	
	/**
	 * Simulate the scanning of items into the system. This function loads the UPC codes from the file
	 * initialized with the Scan object. This method does not do any calculations.
	 * @return ArrayList&lt;Grocery&gt; A List of the Grocery items (including quantity) to be purchased by the customer 
	 * @throws IOException
	 * @throws ParseException 
	 */
	public ArrayList<Grocery> scanItems() throws IOException, ParseException {
		File file = new File(this.scanFilename);
		BufferedReader is = null;
		String text;
		ArrayList<Grocery> itemBasket = new ArrayList<Grocery>();
		PopulateGrocery popGroc = new PopulateGrocery();
		ArrayList<Grocery> groceryItems = popGroc.populateGroceryList();
		
		is = new BufferedReader(new FileReader(file));	
		while((text = is.readLine()) != null){
			for(Grocery lookup : groceryItems){
				if(text.equals(lookup.getUpc())){
					if(lookup.getQuantity() == 0) {
						// Initialize first occurance of the item
						Grocery tempGroc = lookup;
						tempGroc.incrementQuantity();
						itemBasket.add(tempGroc);
					} else {
						/* Increment the item if already scanned.
						 * This should also result in keeping the correct placement of the item in 
						 * the list (based on when the item was first scanned. */
						lookup.incrementQuantity();
					}
				}
			}
		}
		is.close();
		return itemBasket;
	}
	
	// METHODS USED FOR TESTING
	public String getFile_TEST(){
		return scanFilename;
	}
}
