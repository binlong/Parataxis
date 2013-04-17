package discount.parataxis.test;

import java.io.IOException;

import discount.parataxis.main.Discount;

public class DiscountTest {
	public static void main(String[] args) throws IOException{
		Discount discount = new Discount();
		
		discount.applyCoupon();
	}
}
