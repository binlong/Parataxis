package parataxis.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import parataxis.dto.Grocery;



public class PopulateGrocery {
	
	// folder and file names for the input files
	private String filename;
	final private String filefolder = "groceryfiles/";
	
	public PopulateGrocery() {
		this.filename = filefolder+"GroceryDefault.txt";
	}
	
	public PopulateGrocery(String filename) {
		this.filename = filefolder+filename;
	}
	
	/**
	 * Method used to populate an ArrayList with Grocery objects for use in the program.
	 * @return ArrayList<Grocery>
	 * @param filename The name of the file used to populate the list
	 * @throws IOException
	 */
	public ArrayList<Grocery> populateGroceryList() throws IOException{
		File file = new File(this.filename);
		BufferedReader is = null;
		String text;
		ArrayList<Grocery> alGrocTest = new ArrayList<Grocery>();
		
		is = new BufferedReader(new FileReader(file));	
		
		while((text = is.readLine()) != null){
			// The input file is delimited by commas
			String[] temp = text.split(",");
			
			// Parse the input file into appropriate types
			String upc = temp[0];
			String name = temp[1];
			char type = temp[2].charAt(0);
			char category = temp[3].charAt(0);
			double basePrice = Double.parseDouble(temp[4]);
			Date baseStartDate = java.sql.Date.valueOf(temp[5]); //5
			Date baseEndDate = java.sql.Date.valueOf(temp[6]); //6
			double discount = Double.parseDouble(temp[7]);
			Date discountStartDate = java.sql.Date.valueOf(temp[8]); //8
			Date discountEndDate = java.sql.Date.valueOf(temp[9]); //9
			int buyM = Integer.parseInt(temp[10]);
			int buyN = Integer.parseInt(temp[11]);
			Date buyStartDate = java.sql.Date.valueOf(temp[12]); //12
			Date buyEndDate = java.sql.Date.valueOf(temp[13]); //13
			char salesTax = temp[14].charAt(0); //14
			
			//Create a Grocery object using the parsed input
			Grocery tmpG = new Grocery(upc, name, type, category, basePrice, 
					baseStartDate, baseEndDate, discount, discountStartDate, discountEndDate, 
					buyM, buyN, buyStartDate, buyEndDate, salesTax);
			
			// Add the newly generated Grocery file into the List
			alGrocTest.add(tmpG);
		}

		is.close();
		return alGrocTest;
	}
}
