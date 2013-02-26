package proj.parataxis.test;

import java.util.ArrayList;

import proj.parataxis.DTO.Grocery;

public class GroceryTest {
	public static void main(String[] args){
		PopulateGroceryTest pop = new PopulateGroceryTest();
		ArrayList<Grocery> grocList = pop.populateGroceryList();
		
		for(Grocery grocItm : grocList){
			grocItm.testPrint();
		}
	}
}
