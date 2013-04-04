package parataxis.test;

import java.io.IOException;
import java.util.ArrayList;

import parataxis.dto.Grocery;
import parataxis.main.PopulateGrocery;

public class GroceryTest {
	
	final static String testFilename = "groceryfiles/LargeGrocery.txt";
	
	public static void main(String[] args) throws IOException{
		PopulateGrocery pop = new PopulateGrocery();
		
		//File to be dropped into the root directory of the project (Parataxis)
		ArrayList<Grocery> grocList = pop.populateGroceryList();
		
		for(Grocery grocItm : grocList){
			grocItm.printAll();
		}
	}
}
