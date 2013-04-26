package discount.parataxis.test;

import java.io.IOException;
import java.text.ParseException;

import discount.parataxis.main.Discount;

public class DiscountTest {
	public static void main(String[] args) throws IOException, ParseException{
		Discount discount = new Discount();
		
		discount.applyCoupon();
	}
}
