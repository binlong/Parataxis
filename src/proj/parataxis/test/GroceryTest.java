package proj.parataxis.test;

import java.io.IOException;
import java.util.ArrayList;

import proj.parataxis.DTO.Grocery;

public class GroceryTest {
	public static void main(String[] args) throws IOException{
		PopulateGroceryTest pop = new PopulateGroceryTest();
		
		//File to be dropped into the root directory of the project (Parataxis)
		ArrayList<Grocery> grocList = pop.populateGroceryList("GroceryData.txt");
		
		for(Grocery grocItm : grocList){
			grocItm.printAll();
		}
	}
}
