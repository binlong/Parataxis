package scan.parataxis.main;

import init.parataxis.main.PopulateCustomers;
import init.parataxis.main.PopulateGrocery;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import parataxis.dto.Coupon;
import parataxis.dto.Customer;
import parataxis.dto.Grocery;


public class Scan {
	
	private String scanFilename;
	final private String filefolder = "scanfiles/";
	private ArrayList<Grocery> itemBasket = new ArrayList<Grocery>();
	ArrayList<Coupon> couponList = new ArrayList<Coupon>(); 
	private Date date;
	private double amountPaid;
	private long cardNum = 0;
	private double cashback;
	private Customer customer;
	private String paymentType;

	
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
	
	public Date getDate() {
		return date;
	}

	public ArrayList<Grocery> getItemBasket() {
		return itemBasket;
	}

	public double getAmountPaid() {
		return amountPaid;
	}

	public long getCardNum() {
		return cardNum;
	}

	public double getCashback() {
		return cashback;
	}

	public Customer getCustomer() {
		return customer;
	}

	public String getPaymentType() {
		return paymentType;
	}

	/**
	 * Simulate the scanning of items into the system. This function loads the UPC codes from the file
	 * initialized with the Scan object. This method does not do any calculations.
	 * @return ArrayList&lt;Grocery&gt; A List of the Grocery items (including quantity) to be purchased by the customer 
	 * @throws IOException
	 */
	public ArrayList<Grocery> scanItems() throws IOException, ParseException {
		File file = new File(this.scanFilename);
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
	public ArrayList<Grocery> scanFile() throws IOException, ParseException {
		File file = new File(this.scanFilename);
		BufferedReader is = null;
		String text;
		ArrayList<Grocery> itemBasket = new ArrayList<Grocery>();
		PopulateGrocery popGroc = new PopulateGrocery();
		ArrayList<Grocery> groceryItems = popGroc.populateGroceryList();
		String[] upcsplit;
		String upcName;
		int quant = 0;
		double weight;
		String amountTemp = null;
		String[] cardParsing;
		PopulateCustomers popCust = new PopulateCustomers();
		ArrayList<Customer> custList = popCust.populateCustomerList();
		
		is = new BufferedReader(new FileReader(file));
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		while((text = is.readLine()) != null) {
			//this.date = (formatter.parse(is.readLine()));
			this.date = formatter.parse(text);
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
							itemBasket.add(tempGroc);
						} else if(lookup.getType() == 'P') {
							Grocery tempGroc = lookup;
							tempGroc.setWeight(Double.parseDouble(amountTemp));
							itemBasket.add(tempGroc);
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
				} else {
					tempT = new Coupon(type, upc, buyM, getN);
				}			
				
				
				// Add the newly generated Grocery file into the List
		        couponList.add(tempT);
			}
			text = is.readLine();
			if(text.charAt(0) == '$'){
				paymentType = "cash";
				String dollarAmt = text.substring(1, text.length());
				amountPaid = Double.parseDouble(dollarAmt);
			} else if(text.charAt(0) == 'C' || text.charAt(0) == 'D'){
				paymentType = "card";
				cardParsing = text.split(",");
				cardNum = Long.parseLong(cardParsing[1]);
				System.out.println(cardParsing[2].substring(1, cardParsing[2].length()));
				cashback = Double.parseDouble(cardParsing[2].substring(1, cardParsing[2].length()));
				
				if(!(cashback == 0 || cashback == 5.00 || cashback == 10.00 || cashback == 15.00 || cashback == 20.00)){
					System.out.println("INVALID CASH AMOUNT LOL");
					cashback = 0;
				}
				for(Customer i : custList){
					if(i.getCardNum() == cardNum){
						customer = i;
					}
				}
			}	
			text = is.readLine();
			System.out.println(text);
			if(text == null || text.equals("EOS")){
				continue;
			}
		}
		is.close();
		return itemBasket;
	}
	
	
	
	// METHODS USED FOR TESTING
	public String getFile_TEST(){
		return scanFilename;
	}

	public ArrayList<Coupon> getCouponList() {
		return couponList;
	}
}
