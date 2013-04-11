package proj.parataxis.test;

import java.io.IOException;
import java.util.ArrayList;

import parataxis.dto.Grocery;

public class GroceryTest {
	public static void main(String[] args) throws IOException{
		PopulateGroceryTest pop = new PopulateGroceryTest();
		
		//File to be dropped into the root directory of the project (Parataxis)
		ArrayList<Grocery> grocList = pop.populateGroceryList("LargeGrocery.txt");
		
		for(Grocery grocItm : grocList){
			grocItm.printAll();
		}
	}
}
