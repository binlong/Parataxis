package proj.parataxis.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import proj.parataxis.DTO.Grocery;

public class PopulateGroceryTest {
	
	/**
	 * Method used to populate an ArrayList with Grocery objects for use in the program.
	 * @return ArrayList<Grocery>
	 * @param filename The name of the file used to populate the list
	 * @throws IOException
	 */
	public ArrayList<Grocery> populateGroceryList(String filename) throws IOException{
		File file = new File(filename);
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
		
//		Grocery temp = new Grocery("A000000000", "HW QUESO ASADERO", 'F', 
//		'K', 3.87, janfirst, dec31, 
//		100.00, janfirst, dec31, 
//		1, 1, janfirst, dec31, 'N');
//test.add(temp);
//
//Grocery temp2 = new Grocery("A000000001", "SHOUT LIQUID 60 OZ REFILL", 'F', 
//		'D', 4.67, janfirst, dec31, 
//		80.00, janfirst, dec31, 
//		1, 0, janfirst, dec31, 'T');
//test.add(temp2);
//
//Grocery temp3 = new Grocery("A000000002", "GARLIC - BULK EACH", 'Q', 
//		'P', 0.67, janfirst, dec31, 
//		100.00, janfirst, dec31, 
//		1, 0, janfirst, dec31, 'N');
//test.add(temp3);
	}
}
