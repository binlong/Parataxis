package finalPackage;

import init.parataxis.main.PopulateCustomers;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import parataxis.dto.Basket;
import parataxis.dto.Coupon;
import parataxis.dto.Customer;
import parataxis.dto.Grocery;
import parataxis.dto.Receipt;
import parataxis.dto.Tax;
import scan.parataxis.main.Scan;

public class ReqTester3 {
	
	private Receipt receiptCard;
	private Receipt receiptCash;
	private Date date;
	private List<Grocery> groceryList = new ArrayList<Grocery>();
	private Customer customer;
	private Tax tax;
	private Double cashBack;
	private List<Coupon> couponList = new ArrayList<Coupon>();
	private double cash;
	
	@Before
	public void setUp() throws Exception {
		tax = new Tax(7.5, new Date(2013, 4, 1), new Date(2013, 4, 20));
		date = new Date(2013, 4, 7);
		Grocery grocery1 = new Grocery();
		grocery1.setBasePrice(2.22);
		grocery1.setCategory('M');
		grocery1.setType('Q');
		grocery1.setName("HM SALISBURY STEAK");
		grocery1.setQuantity(2);
		grocery1.setUpc("1111111111");
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
		
		groceryList.add(grocery1);
		groceryList.add(grocery2);
		groceryList.add(grocery3);
		groceryList.add(grocery4);
		
		Coupon coupon1 = new Coupon('S', "1111111111", 5.00);
		Coupon coupon2 = new Coupon('M', "2222222222", 2.00);
		Coupon coupon3 = new Coupon('X', "4444444444", 4, 1);
		
		couponList.add(coupon1);
		couponList.add(coupon2);
		couponList.add(coupon3);
		
		customer = new Customer('C', 1234567890121111L, 100.00);
		cashBack = 5.0;
		
		
		receiptCard = new Receipt(date, groceryList, customer, tax, cashBack, couponList);
	}
	
	/** Checkout prints a cash back section if and only if the customer requests cash back. */
	/** Checkout prints out the number of items purchased on a line immediately after the initial border line of the items purchased section. */
	@Test
	public void tc00037() {	
		String receipt = receiptCard.toString();
		assertThat("receipt", receipt.contains("Cash Back Requested"), equalTo(true));
	}
	
	/** Checkout ends the print out of the items purchased section by printing a border line where a border line is thirty-three equal sign characters starting in column one. */
	@Test
	public void tc00038(){
		String receipt = receiptCard.toString();
		assertThat("receipt", receipt.contains("|=================================         |\n" +
												 "|    ITEMS PURCHASED:   11                 |\n" +
												 "|=================================         |"), equalTo(true));
	}
	
	/** Checkout prints out an amount saved today section  if and only if the amount a given customer saved is a nonnegative amount of money. */
	@Test
	public void tc00039(){
		String receipt = receiptCard.toString();
		assertThat("receipt", receipt.contains("|=================================         |\n" +
				 								 "|    SAVED TODAY                     7.20  |\n" +
				                                 "|=================================         |"), equalTo(true));
	}
	
	/** Checkout prints the amount saved today line immediately after the training borderline of the items purchased section if and only if an amount saved section is needed for a given customer's purchases. */
	@Test
	public void tc00040(){
		String receipt = receiptCard.toString();
		System.out.println(receipt);
		assertThat("receipt", receipt.contains("|=================================         |\n" +
												 "|    ITEMS PURCHASED:   11                 |\n" +
												 "|=================================         |\n" +
												 "|    SAVED TODAY                     7.20  |\n" +
												 "|=================================         |"), equalTo(true));
	}
	
	/** Checkout ends the print out of the amount saved section  by printing a border line where a border line is thirty-three equal sign characters starting in column one if and only if an amount saved section is needed for a given customer's purchases. */
	@Test
	public void tc00041(){
		String receipt = receiptCard.toString();
		assertThat("receipt", receipt.contains("|=================================         |\n" +
				 							   "|    SAVED TODAY                     7.20  |\n" +
				                               "|=================================         |"), equalTo(true));
	}
	
	/** Checkout terminate the printing of each receipt for a given customer's basket with a date processed section. */
	@Test
	public void tc00042(){
		String receipt = receiptCard.toString();
		assertThat("receipt", receipt.contains("|                                          |\n" +
											   "|    Date:                05/07/3913       |\n" +
											   "|                                          |"), equalTo(true));
	}
	
	/** Checkout begins the date processed section with a blank line. */
	@Test
	public void tc00043(){
		String receipt = receiptCard.toString();
		assertThat("receipt", receipt.contains("|                                          |\n" +
											   "|    Date:                05/07/3913       |\n" +
											   "|                                          |"), equalTo(true));
	}
	
	/** Checkout prints out a date line immediately after the first line of the date processed section where the date line indicates the date that the items in a given customer's basket were purchased. */
	@Test
	public void tc00044(){
		String receipt = receiptCard.toString();
		assertThat("receipt", receipt.contains("|                                          |\n" +
											   "|    Date:                05/07/3913       |\n" +
											   "|                                          |"), equalTo(true));
	}
	
	/** Checkout ends the date processed section with a blank line. */
	@Test
	public void tc00045(){
		String receipt = receiptCard.toString();
		assertThat("receipt", receipt.contains("|                                          |\n" +
											   "|    Date:                05/07/3913       |\n" +
											   "|                                          |"), equalTo(true));
	}
	
	/** Checkout calculates sales tax for grocery store items that are marked as taxable for the date the customer is making any purchases. */
	@Test
	public void tc00046(){
		Assert.assertFalse(true);
	}
	
	/** Checkout identifies grocery store items based on the unique assigned UPC of the item. */
	@Test
	public void tc00047(){
		Assert.assertFalse(true);
	}
	
	/** Checkout  create an exception log for any item in a customer's basket whose UPC is not found. */
	@Test
	public void tc00048(){
		Assert.assertFalse(true);
	}
	
	/** Checkout does not end processing when it encounters any item in a customer's basket whose UPC is not found. */
	@Test
	public void tc00049(){
		Assert.assertFalse(true);
	}
	
	/** Checkout identifies each grocery store item by name based on the item's UPC. */
	@Test
	public void tc00050(){
		Assert.assertFalse(true);
	}
	
	/** Checkout identifies each grocery store item by name on the customer's sale receipt. */
	@Test
	public void tc00051(){
		String receipt = receiptCard.toString();
		assertThat("receipt", receipt.contains("|3   GM HONEY NUT CHEERIOS     KF    3.52  |"), equalTo(true));
	}
	
	/** Checkout identifies a customer's receipt the type for each item being purchased. */
	@Test
	public void tc00052(){
		String receipt = receiptCard.toString();
		assertThat("receipt", receipt.contains("|3   GM HONEY NUT CHEERIOS     KF    3.52  |"), equalTo(true));
	}
	
	/** Checkout identifies a customer's receipt the category for each item being purchased. */
	@Test
	public void tc00053(){
		String receipt = receiptCard.toString();
		assertThat("receipt", receipt.contains("|3   GM HONEY NUT CHEERIOS     KF    3.52  |"), equalTo(true));
	}
	
	/** Checkout applies the base price for a grocery store item based on the item's UPC and the date the customer is  purchasing the item. */
	@Test
	public void tc00054(){
		String receipt = receiptCard.toString();
		assertThat("receipt", receipt.contains("|3   GM HONEY NUT CHEERIOS     KF    3.52  |"), equalTo(true));
	}
	
}
