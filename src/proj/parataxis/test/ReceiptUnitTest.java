package proj.parataxis.test;

import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.containsString;

import static org.mockito.Mockito.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import proj.parataxis.DTO.Customer;
import proj.parataxis.DTO.Grocery;
import proj.parataxis.DTO.Receipt;

public class ReceiptUnitTest {	
	private Receipt receipt;
	private Customer customer;
	private List groceryList;
	
	@Before
	public void setUp() throws Exception {
		customer = mock(Customer.class);
		groceryList = mock(List.class);
		receipt = new Receipt(groceryList, customer);
	}

	@Test
	public void toString_printsReceipt_correctly() {
		Grocery grocery = mock(Grocery.class);
		when(groceryList.size()).thenReturn(1);
		when(groceryList.get(0)).thenReturn(grocery);
		when(grocery.getName()).thenReturn("HM SALISBURY STEAK");
		when(grocery.getCategory()).thenReturn('M');
		when(grocery.getType()).thenReturn('Q');
//       final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
       //System.setOut(new PrintStream(outContent));
	   System.out.println(receipt.toString());
//       assertThat("print message", outContent.toString(), containsString(Receipt.storeName));
	}

}
