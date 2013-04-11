package proj.parataxis.DTO;

import java.util.List;

import org.apache.commons.lang3.StringUtils;


public class Receipt {
	
	public final static String storeName = "HOGGLEY-WOGGLEY, INC";
	public final static String storeNumber = "358";
	
	public List<Grocery> groceryList;
	public Customer customer;
	
	public Receipt() {
		
	}
	
	public Receipt(List<Grocery> groceryList, Customer customer) {
		this.groceryList = groceryList;
		this.customer = customer;
	}
	
	@Override
	public String toString() {
		String receipt = "";
		String centerTest = " 123456789012345678901234567890123456789012\n";
		String header = "+------------------------------------------+\n" +
						"|                                          |\n" +
				        "|                                          |\n" +
						"|           " + storeName + "           |\n" +
				        "|                 Store " + storeNumber + "                |\n";
		for (int i = 0; i < groceryList.size(); i++) {
			Grocery grocery = groceryList.get(i);
			receipt += "|" +  (i+1) + "   " + grocery.getName();
			receipt += StringUtils.repeat(" ", 26 - grocery.getName().length());
			receipt += grocery.getCategory() + "" + grocery.getType();
			if (grocery.getType() == 'P' || grocery.getType() == 'Q') {
				receipt += StringUtils.repeat(" ", 10);
				receipt += "|\n";
				receipt += "|";
				receipt += StringUtils.repeat(" ", 9);
			}
			else {
				
			}
		}
		
		return centerTest + header + receipt;
	}
}
