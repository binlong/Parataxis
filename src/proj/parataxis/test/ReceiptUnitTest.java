package proj.parataxis.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.containsString;

import static org.mockito.Mockito.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import proj.parataxis.DTO.Customer;
import proj.parataxis.DTO.Grocery;
import proj.parataxis.DTO.Receipt;


public class ReceiptUnitTest {	
	private Receipt receipt;
	private Customer customer;
	private List<Grocery> groceryList;

	@Before
	public void setUp() throws Exception {
		customer = mock(Customer.class);
		groceryList = mock(List.class);
		receipt = new Receipt(groceryList, customer);
	}

	@Test
	public void makeHeader_makes_header_correctly() {
		Grocery grocery = mock(Grocery.class);
		when(groceryList.size()).thenReturn(1);
		when(groceryList.get(0)).thenReturn(grocery);
		when(grocery.getName()).thenReturn("HM SALISBURY STEAK");
		when(grocery.getCategory()).thenReturn('M');
		when(grocery.getType()).thenReturn('Q');
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		String header = receipt.makeHeader();
		assertThat("store name", header, containsString(Receipt.storeName));
		assertThat("store number",header, containsString(Receipt.storeNumber));
		assertThat("header", header, containsString( "123456789012345678901234567890123456789012\n"+
				"+------------------------------------------+\n" +
				"|                                          |\n" +
				"|                                          |\n" +
				"|           HOGGLEY-WOGGLEY, INC           |\n" +
				"|                 Store 358                |\n"));
	}
	
	@Test
	public void calculateSalesSubtotal_adds_up() {
		Grocery grocery1 = mock(Grocery.class);
		Grocery grocery2 = mock(Grocery.class);
		Grocery grocery3 = mock(Grocery.class);
		groceryList = new ArrayList<Grocery>();
		groceryList.add(grocery1);
		groceryList.add(grocery2);
		groceryList.add(grocery3);
		when(grocery1.getBasePrice()).thenReturn(4.20);
		when(grocery2.getBasePrice()).thenReturn(32.35);
		when(grocery3.getBasePrice()).thenReturn(15.20);
		receipt = new Receipt(groceryList, customer);
		
		double subTotal = receipt.calculateSalesSubtotal();
		assertThat("subtotal",subTotal, equalTo(51.75));
	
	}
}
