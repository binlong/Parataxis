package scan.parataxis.main;

import init.parataxis.main.PopulateCustomers;
import init.parataxis.main.PopulateGrocery;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import parataxis.dto.Basket;
import parataxis.dto.Coupon;
import parataxis.dto.Customer;
import parataxis.dto.Grocery;


public class Scan {

	private String scanFilename;
	final private String filefolder = "scanfiles/";


	private long cardNum = 0;
	private double cashback;

	private File file;
	BufferedReader is;

	//for scanlist tester
	ArrayList<Grocery> itemBasket = new ArrayList <Grocery>();

	private ArrayList<Basket> basketList = new ArrayList<Basket>();

	//final private String groceryFilename = "GroceryDefault.txt";

	/**
	 * This constructor initliazes the filename to "ScanFileDefault.txt"
	 */
	public Scan () {
		scanFilename = filefolder+"ScanFileDefault.txt";
		file = new File(this.scanFilename);
	}

	/**
	 * Initialize a Scan object and specify a file of UPC codes to be
	 * "scanned" in by the system.
	 * @param filename The name of the file that holds customer's UPC codes. Note:
	 * 			this file should be a list of UPC codes, with one UPC code on each line, and
	 * 			no other information in the file. The file should be placed in the root 
	 * 			directory of this project. 
	 * @throws FileNotFoundException 
	 */
	public Scan(String filename) throws FileNotFoundException {
	
		this.scanFilename = filefolder+filename;
		file = new File(this.scanFilename);
	}



	/**
	 * Simulate the scanning of items into the system. This function loads the UPC codes from the file
	 * initialized with the Scan object. This method does not do any calculations.
	 * @return ArrayList&lt;Grocery&gt; A List of the Grocery items (including quantity) to be purchased by the customer 
	 * @throws IOException
	 */
	public ArrayList<Grocery> scanItems() throws IOException, ParseException {

		BufferedReader is = null;
		String text;

		PopulateGrocery popGroc = new PopulateGrocery();
		ArrayList<Grocery> groceryItems = popGroc.populateGroceryList(); // List of groceries in inventory


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
	public ArrayList<Basket> scanFile() throws IOException, ParseException {


		String text;
		ArrayList<Grocery> itemBasket = new ArrayList<Grocery>();
		PopulateGrocery popGroc = new PopulateGrocery();
		ArrayList<Grocery> groceryItems = popGroc.populateGroceryList();
		String[] upcsplit;
		String upcName;
		Date date;
		int quant = 0;
		double weight;
		String amountTemp = null;
		String[] cardParsing;
		PopulateCustomers popCust = new PopulateCustomers();
		ArrayList<Customer> custList = popCust.populateCustomerList();

		is = new BufferedReader(new FileReader(file));	
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		while((text = is.readLine()) != null){
			Basket b = new Basket();
			//this.date = (formatter.parse(is.readLine()));
			//System.out.println("Scanner here: " + text);
			b.setDate(formatter.parse(text));
			//System.out.println(date);
			while(!(text = is.readLine()).equals("#")){
				if(text.indexOf(',') == -1) {
					upcName = text;
					quant = 1;
				} else {
					upcsplit = text.split(",");
					upcName = upcsplit[0];
					amountTemp = upcsplit[1];

				}
				for(Grocery lookup : groceryItems){
					if(upcName.equals(lookup.getUpc())){
						if(lookup.getType() == 'F' || lookup.getType() == 'Q') {
							Grocery tempGroc = lookup;
							if(quant == 1)
								tempGroc.setQuantity(quant);
							else
								tempGroc.setQuantity(Integer.parseInt(amountTemp));
							b.addItem(tempGroc);
						} else if(lookup.getType() == 'P') {
							Grocery tempGroc = lookup;
							tempGroc.setWeight(Double.parseDouble(amountTemp));
							b.addItem(tempGroc);
						}
					}
				}
			}
			while(!(text = is.readLine()).equals("***")){
				// The input file is delimited by commas
				String[] temp = text.split(",");

				// Parse the input file into appropriate types
				char type = temp[0].charAt(0);
				String upc = temp[1];
				double discount = 0;
				int buyM = 0;
				int getN = 0;
				if(type == 'S' || type == 'M') {
					discount = Double.parseDouble(temp[2]);
				} else {
					buyM = Integer.parseInt(temp[2]); 
					getN = Integer.parseInt(temp[3]);
				}			

				//Create a Grocery object using the parsed input
				Coupon tempT = null;
				if(type == 'S' || type == 'M') {
					tempT = new Coupon(type, upc, discount);
					b.addCoupon(tempT);
				} else {
					tempT = new Coupon(type, upc, buyM, getN);
					b.addCoupon(tempT);
				}			


				// Add the newly generated Grocery file into the List
				b.addCoupon(tempT);
			}
			text = is.readLine();
			if(text.charAt(0) == '$'){
				b.setPaymentType("cash");
				String dollarAmt = text.substring(1, text.length());
				b.setAmountPaid(Double.parseDouble(dollarAmt));

			} else if(text.charAt(0) == 'C' || text.charAt(0) == 'D'){
				b.setPaymentType("card");
				cardParsing = text.split(",");
				cardNum = Long.parseLong(cardParsing[1]);
				//System.out.println(cardParsing[2].substring(1, cardParsing[2].length()));
				cashback = Double.parseDouble(cardParsing[2].substring(1, cardParsing[2].length()));

				if(!(cashback == 0 || cashback == 5.00 || cashback == 10.00 || cashback == 15.00 || cashback == 20.00)){
					System.out.println("INVALID CASH AMOUNT LOL");
					cashback = 0;
				}
				for(Customer i : custList){
					if(i.getCardNum() == cardNum){
						b.setCustomer(i);
					}
				}
			}	
			text = is.readLine();
			//System.out.println(text);
			/*if(text == null || text.equals("EOS")){
				continue;
			}*/
			basketList.add(b);
		}
		is.close();
		return basketList;
	}




	// METHODS USED FOR TESTING
	public String getFile_TEST(){
		return scanFilename;
	}

	
}
