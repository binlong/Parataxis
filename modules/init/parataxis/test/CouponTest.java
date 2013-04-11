package init.parataxis.test;

import init.parataxis.main.PopulateCoupon;

import java.io.IOException;
import java.util.ArrayList;

import parataxis.dto.Coupon;

public class CouponTest {

	final static String testFilename = "CustomerList.txt";
	
	public static void main(String[] args) throws IOException {
		PopulateCoupon pop = new PopulateCoupon();
		
		//File to be dropped into the root directory of the project (Parataxis)
		ArrayList<Coupon> custList = pop.populateCouponList();
		
		for(Coupon cpnItm : custList){
			cpnItm.printAllData();
		}
		
	}

}