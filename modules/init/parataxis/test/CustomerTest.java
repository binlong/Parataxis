package init.parataxis.test;

import java.io.IOException;
import java.util.ArrayList;

import parataxis.dto.Customer;
import init.parataxis.main.PopulateCustomers;




public class CustomerTest {
	
	final static String testFilename = "CustomerList.txt";
	
	public static void main(String[] args) throws IOException{
		PopulateCustomers pop = new PopulateCustomers(testFilename);
		
		//File to be dropped into the root directory of the project (Parataxis)
		ArrayList<Customer> custList = pop.populateCustomerList();
		
		for(Customer custItm : custList){
			custItm.testPrint();
		}
	}
}
