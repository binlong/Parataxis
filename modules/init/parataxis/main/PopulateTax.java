package init.parataxis.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import parataxis.dto.Tax;



public class PopulateTax {
	
	// folder and file names for the input files
	private String filename;
	final private String filefolder = "taxfiles/";
	
	public PopulateTax() {
		this.filename = filefolder+"TaxDefault.txt";
	}
	public PopulateTax(String filename) {
		this.filename = filefolder+filename;
	}
	
	/**
	 * Method used to populate an ArrayList with Grocery objects for use in the program.
	 * @return ArrayList<Grocery>
	 * @param filename The name of the file used to populate the list
	 * @throws IOException
	 * @throws ParseException 
	 */
	public ArrayList<Tax> populateTaxList() throws IOException, ParseException{
		File file = new File(this.filename);
		BufferedReader is = null;
		String text;
		ArrayList<Tax> alTaxTest = new ArrayList<Tax>();
		
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		
		is = new BufferedReader(new FileReader(file));	
		
		while((text = is.readLine()) != null){
			// The input file is delimited by commas
			String[] temp = text.split(",");
			
			// Parse the input file into appropriate types
			
			double taxRate = Double.parseDouble(temp[0].substring(0, 5));
			Date startDate = formatter.parse(temp[1]);
			Date endDate = formatter.parse(temp[2]);
			
			
			//Create a Grocery object using the parsed input
			Tax tempT = new Tax(taxRate, startDate, endDate);
			
			// Add the newly generated Grocery file into the List
			alTaxTest.add(tempT);
		}

		is.close();
		return alTaxTest;
	}
}
