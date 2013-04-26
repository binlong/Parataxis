package proj.parataxis.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import parataxis.dto.Coupon;
import parataxis.dto.Customer;
import parataxis.dto.Grocery;
import parataxis.dto.Receipt;
import parataxis.dto.Tax;


public class ReceiptUnitTest {	
	private Receipt receipt;
	private Customer customer;
	private Tax tax;
	private List<Grocery> groceryList;

	@Before
	public void setUp() throws Exception {
		customer = mock(Customer.class);
		tax = mock(Tax.class);
		
		Grocery grocery1 = new Grocery();
		grocery1.setBasePrice(2.22);
		grocery1.setCategory('M');
		grocery1.setType('Q');
		grocery1.setName("HM SALISBURY STEAK");
		grocery1.setQuantity(2);
		grocery1.setUpc("11111111111");
		Grocery grocery2 = new Grocery();
		grocery2.setBasePrice(1.92);
		grocery2.setCategory('K');
		grocery2.setType('Q');
		grocery2.setName("GG VF STEAMER BROC CAR CA");
		grocery2.setQuantity(3);
		grocery2.setUpc("2222222222");
		Grocery grocery3 = new Grocery();
		grocery3.setBasePrice(3.52);
		grocery3.setCategory('K');
		grocery3.setType('F');
		grocery3.setQuantity(1);
		grocery3.setName("GM HONEY NUT CHEERIOS");
		grocery3.setUpc("3333333333");
		Grocery grocery4 = new Grocery();
		grocery4.setBasePrice(0.20);
		grocery4.setCategory('P');
		grocery4.setType('Q');
		grocery4.setName("MYER LEMONS LARGE");
		grocery4.setQuantity(5);
		grocery4.setUpc("4444444444");
		ArrayList<Grocery> groceryList = new ArrayList<Grocery>();
		groceryList.add(grocery1);
		groceryList.add(grocery2);
		groceryList.add(grocery3);
		groceryList.add(grocery4);
		
		Coupon coupon1 = new Coupon('S', "1111111111", 5.00);
		
		ArrayList<Coupon> couponList = new ArrayList<Coupon>();
		couponList.add(coupon1);
		
		receipt = new Receipt(groceryList, customer, tax, 0.0, couponList);
		when(customer.getCardNum()).thenReturn(1234567890121111L);
		when(customer.getType()).thenReturn('D');
		when(customer.getMoneyAvail()).thenReturn(000.00);
		Receipt cashReceipt = new Receipt(groceryList, 156.88, tax, couponList);
		System.out.println(receipt);
		System.out.println(cashReceipt);
	}

	@Test
	public void makeHeader_makes_header_correctly() {
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
		when(grocery1.getQuantity()).thenReturn(1);
		when(grocery2.getBasePrice()).thenReturn(32.35);
		when(grocery2.getQuantity()).thenReturn(1);
		when(grocery3.getBasePrice()).thenReturn(15.20);
		when(grocery3.getQuantity()).thenReturn(1);
		receipt = new Receipt(groceryList, customer, tax, 0.0, new ArrayList<Coupon>());
		
		double subTotal = receipt.calculateSalesSubtotal();
		assertThat("subtotal",subTotal, equalTo(51.75));
	
	}
	
	@Test
	public void printGroceries_printsCorrectly() throws Exception {
		String groceryReceipt = receipt.printGroceries();
		assertThat("grocery", groceryReceipt, equalTo("|1   HM SALISBURY STEAK        MQ          |\n"+
													  "|      2 Ea.   @   1/    2.22        4.44  |\n"+
													  "|2   GG VF STEAMER BROC CAR CA KQ          |\n"+
													  "|      3 Ea.   @   1/    1.92        5.76  |\n"+
													  "|3   GM HONEY NUT CHEERIOS     KF    3.52  |\n"+
													  "|4   MYER LEMONS LARGE         PQ          |\n"+
													  "|      5 Ea.   @   1/    0.20        1.00  |\n"));
	}
	
	@Test
	public void printTotal_printsCorrectly() throws Exception {
		String totalString = receipt.printTotal();
		assertThat("total", totalString, equalTo("|******** Sale Subtotal***          14.72  |\n"+
												 "|   Sales Tax                        0.00  |\n"+
                                                 "|   Sales Tax Rate:   0.000%               |\n"+
                                                 "|************ Total Sale            14.72  |\n"));
	}
}
