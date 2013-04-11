package init.parataxis.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import parataxis.dto.Coupon;

public class PopulateCoupon {
	
	// folder and file names for the input files
	private String filename;
	final private String filefolder = "couponfiles/";
	
	public PopulateCoupon() {
		this.filename = filefolder+"CouponDefault.txt";
	}
	public PopulateCoupon(String filename) {
		this.filename = filefolder+filename;
	}
	
	/**
	 * Method used to populate an ArrayList with Grocery objects for use in the program.
	 * @return ArrayList<Grocery>
	 * @param filename The name of the file used to populate the list
	 * @throws IOException
	 */
	public ArrayList<Coupon> populateCouponList() throws IOException{
		File file = new File(this.filename);
		BufferedReader is = null;
		String text;
		ArrayList<Coupon> alCouponTest = new ArrayList<Coupon>();
		
		is = new BufferedReader(new FileReader(file));	
		
		while((text = is.readLine()) != null){
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
			alCouponTest.add(tempT);
		}

		is.close();
		return alCouponTest;
	}
}
