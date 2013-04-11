package init.parataxis.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import parataxis.dto.Customer;



public class PopulateCustomers {
	
	// folder and file names for the input files
	private String filename;
	final private String filefolder = "customerfiles/";
	
	public PopulateCustomers() {
		this.filename = filefolder+"CustomerDefault.txt";
	}
	public PopulateCustomers(String filename) {
		this.filename = filefolder+filename;
	}

	public ArrayList<Customer> populateCustomerList() throws IOException{
		File file = new File(this.filename);
		BufferedReader is = null;
		String text;
		ArrayList<Customer> alCustTest = new ArrayList<Customer>();
		
		is = new BufferedReader(new FileReader(file));	
		
		while((text = is.readLine()) != null){
			
			// The input file is delimited by commas
			String[] temp = text.split(",");
			
			// Parse the input file into appropriate types
			char type = temp[0].charAt(0);
			long cardNum = Long.parseLong(temp[1]);
			double moneyAvail = Double.parseDouble(temp[2]);
			
			
			//Create a Grocery object using the parsed input
			Customer tmpC = new Customer(type, cardNum, moneyAvail);
			
			// Add the newly generated Grocery file into the List
			alCustTest.add(tmpC);
		}

		is.close();
		return alCustTest;
	}
}
