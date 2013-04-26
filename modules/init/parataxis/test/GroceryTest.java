package init.parataxis.test;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import parataxis.dto.Grocery;
import init.parataxis.main.PopulateGrocery;

public class GroceryTest {
	
	final static String testFilename = "groceryfiles/LargeGrocery.txt";
	
	public static void main(String[] args) throws IOException, ParseException{
		PopulateGrocery pop = new PopulateGrocery("GroceryFile2.txt");
		
		//File to be dropped into the root directory of the project (Parataxis)
		ArrayList<Grocery> grocList = pop.populateGroceryList();
		
		for(Grocery grocItm : grocList){
			grocItm.printAll();
		}
	}
}
