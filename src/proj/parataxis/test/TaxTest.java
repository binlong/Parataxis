package proj.parataxis.test;

import java.io.IOException;
import java.util.ArrayList;

import proj.parataxis.DTO.Tax;

public class TaxTest {
	public static void main(String[] args) throws IOException{
		PopulateTax pop = new PopulateTax();
		
		//File to be dropped into the root directory of the project (Parataxis)
		ArrayList<Tax> grocList = pop.populateTaxList("TaxData.txt");
		
		for(Tax grocItm : grocList){
			grocItm.testPrint();
		}
	}
}