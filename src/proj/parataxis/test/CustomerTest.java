package proj.parataxis.test;

import java.io.IOException;
import java.util.ArrayList;

import parataxis.dto.Customer;

public class CustomerTest {
	public static void main(String[] args) throws IOException{
		PopulateCustomers pop = new PopulateCustomers();
		
		//File to be dropped into the root directory of the project (Parataxis)
		ArrayList<Customer> custList = pop.populateGroceryList("CustomerData.txt");
		
		for(Customer custItm : custList){
			custItm.testPrint();
		}
	}
}
