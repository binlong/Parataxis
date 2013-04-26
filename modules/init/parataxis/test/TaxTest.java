package init.parataxis.test;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import parataxis.dto.Tax;
import init.parataxis.main.PopulateTax;


public class TaxTest {
	
	final static String testFilename = "taxfiles/TaxData.txt";
	
	public static void main(String[] args) throws IOException, ParseException{
		PopulateTax pop = new PopulateTax();
		
		//File to be dropped into the root directory of the project (Parataxis)
		ArrayList<Tax> grocList = pop.populateTaxList();
		
		for(Tax grocItm : grocList){
			grocItm.testPrint();
		}
	}
}
