package proj.parataxis.test;

import java.util.ArrayList;
import java.util.Date;

import org.omg.CORBA.FREE_MEM;

import proj.parataxis.DTO.Grocery;

public class PopulateGroceryTest {
	//TODO: This method of populating the grocery list is horrible and only for testing..
	private Date janfirst = java.sql.Date.valueOf("2013-1-1");
	private Date dec31 = java.sql.Date.valueOf("2013-12-31");
	
	public ArrayList<Grocery> populateGroceryList(){
		ArrayList<Grocery> test = new ArrayList<Grocery>();
		
		
		Grocery temp = new Grocery("A000000000", "HW QUESO ASADERO", 'F', 
				'K', 3.87, janfirst, dec31, 
				100.00, janfirst, dec31, 
				1, 1, janfirst, dec31, 'N');
		test.add(temp);
		
		Grocery temp2 = new Grocery("A000000001", "SHOUT LIQUID 60 OZ REFILL", 'F', 
				'D', 4.67, janfirst, dec31, 
				80.00, janfirst, dec31, 
				1, 0, janfirst, dec31, 'T');
		test.add(temp2);
		
		Grocery temp3 = new Grocery("A000000002", "GARLIC - BULK EACH", 'Q', 
				'P', 0.67, janfirst, dec31, 
				100.00, janfirst, dec31, 
				1, 0, janfirst, dec31, 'N');
		test.add(temp3);
		
		return test;
	}
}
