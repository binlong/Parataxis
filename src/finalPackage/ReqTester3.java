package finalPackage;

import init.parataxis.main.PopulateCustomers;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;

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
	private List<Grocery> groceryList;
	private Customer customer;
	private Tax tax;
	private Double cashBack;
	private List<Coupon> couponList;
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
		cashBack = 0.0;
		
		
		receiptCard = new Receipt(date, groceryList, customer, tax, cashBack, couponList);
	}
	
	/** Checkout prints a cash back section if and only if the customer requests cash back. */
	/** Checkout prints out the number of items purchased on a line immediately after the initial border line of the items purchased section. */
	public static void tc00037(){
		
		
	}
	/** Checkout ends the print out of the items purchased section by printing a border line where a border line is thirty-three equal sign characters starting in column one. */
	public static void tc00038(){
		
	}
	/** Checkout prints out an amount saved today section  if and only if the amount a given customer saved is a nonnegative amount of money. */
	public static void tc00039(){
		
	}
	/** Checkout prints the amount saved today line immediately after the training borderline of the items purchased section if and only if an amount saved section is needed for a given customer's purchases. */
	public static void tc00040(){
		
	}
	/** Checkout ends the print out of the amount saved section  by printing a border line where a border line is thirty-three equal sign characters starting in column one if and only if an amount saved section is needed for a given customer's purchases. */
	public static void tc00041(){
		
	}
	/** Checkout terminate the printing of each receipt for a given customer's basket with a date processed section. */
	public static void tc00042(){
		
	}
	/** Checkout begins the date processed section with a blank line. */
	public static void tc00043(){
		
	}
	/** Checkout prints out a date line immediately after the first line of the date processed section where the date line indicates the date that the items in a given customer's basket were purchased. */
	public static void tc00044(){
		
	}
	/** Checkout ends the date processed section with a blank line. */
	public static void tc00045(){
		
	}
	/** Checkout calculates sales tax for grocery store items that are marked as taxable for the date the customer is making any purchases. */
	public static void tc00046(){
		
	}
	/** Checkout  identifies grocery store items based on the unique assigned UPC of the item. */
	public static void tc00047(){
		
	}
	/** Checkout  create an exception log for any item in a customer's basket whose UPC is not found. */
	public static void tc00048(){
		
	}
	/** Checkout does not end processing when it encounters any item in a customer's basket whose UPC is not found. */
	public static void tc00049(){
		
	}
	/** Checkout identifies each grocery store item by name based on the item's UPC. */
	public static void tc00050(){
		
	}
	/** Checkout identifies each grocery store item by name on the customer's sale receipt. */
	public static void tc00051(){
		
	}
	/** Checkout identifies a customer's receipt the type for each item being purchased. */
	public static void tc00052(){
		
	}
	/** Checkout identifies a customer's receipt the category for each item being purchased. */
	public static void tc00053(){
		
	}
	/** Checkout applies the base price for a grocery store item based on the item's UPC and the date the customer is  purchasing the item. */
	public static void tc00054(){
		
	}
	
}
