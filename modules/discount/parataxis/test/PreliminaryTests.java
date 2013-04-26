package discount.parataxis.test;

import init.parataxis.main.PopulateCoupon;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import parataxis.dto.Coupon;
import parataxis.dto.Grocery;
import scan.parataxis.main.Scan;

/**
 * This class is just to test some different classes up to this point
 * NOTE: This class is not to be used for the actual testing. DELETE ME
 * @author rweber
 *
 */
public class PreliminaryTests {

	
	public static void main(String[] args) throws IOException, ParseException {
		Scan scn = new Scan();
		ArrayList<Grocery> scanList = scn.scanItems(); 
		
		PopulateCoupon popcpn = new PopulateCoupon();
		ArrayList<Coupon> cpnList = popcpn.populateCouponList();
		
		
		for(Grocery grc : scanList){
			grc.getUpc();
			for(Coupon cpn : cpnList){
				if(grc.getUpc().equals(cpn.getUpc())){
					if(cpn.getType() == 'S')
						System.out.print("Store");
					if(cpn.getType() == 'M')
						System.out.print("Cents-off Manufacturer");
					if(cpn.getType() == 'X')
						System.out.print("Buy "+cpn.getBuyM()+" Get "+cpn.getGetN());
					System.out.println(" coupon found for: "+grc.getUpc());
				}
			}
		}

	}

}
