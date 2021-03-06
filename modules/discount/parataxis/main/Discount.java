package discount.parataxis.main;

import init.parataxis.main.PopulateCoupon;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;

import parataxis.dto.Coupon;
import parataxis.dto.Grocery;
import scan.parataxis.main.Scan;

public class Discount {
	private String couponFilename;
	private double discnt;
	private double total = 0;
	NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
	
	final private String filefolder = "couponfiles/";
	
	private ArrayList<Coupon> cpnList;
	
	public double getDiscnt() {
		return discnt;
	}
	public void setDiscnt(double discnt) {
		this.discnt = discnt;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Discount () {
		couponFilename = filefolder+"ScanFileDefault.txt";
	}
	public Discount(String filename){
		couponFilename = filefolder+couponFilename;
	}
	
	public void applyCoupon() throws IOException, ParseException{
		Scan scn = new Scan();
		ArrayList<Grocery> scanList = scn.scanItems(); 
		
		PopulateCoupon popcpn = new PopulateCoupon();
		ArrayList<Coupon> cpnList = popcpn.populateCouponList();
		
		System.out.println("|=================================         |");
		for(Grocery grc : scanList){
			grc.getUpc();
			for(Coupon cpn : cpnList){
				if(grc.getUpc().equals(cpn.getUpc()) && !grc.getCoupon()){
					grc.scannedCoupon();
					if(cpn.getType() == 'S'){
						//System.out.print("Store");
						discnt = cpn.getDiscount(); 
//						System.out.print("|  Mfg Store Coupon                 "+format..format(discnt));
						System.out.print("|  Mfg Store Coupon                 "+String.format("%.2f",discnt));
						if(currencyFormatter.format(discnt).length() == 5)
							System.out.println("  |");
						else if (currencyFormatter.format(discnt).length() == 6)
							System.out.println(" |");
						else
							System.out.println("|");
						total += discnt;
					}
					else if(cpn.getType() == 'M'){
						//System.out.print("Cents-off Manufacturer");
						discnt = cpn.getDiscount(); 
						System.out.print("|  Mfg Cents Off Coupon             "+String.format("%.2f",discnt));
						if(currencyFormatter.format(discnt).length() == 5)
							System.out.println("   |");
						else if (currencyFormatter.format(discnt).length() == 6)
							System.out.println("  |");
						else
							System.out.println(" |");
						total += discnt;
					}
					else if(cpn.getType() == 'X'){
						discnt = cpn.getDiscount(); 
						if(grc.getQuantity() >= (cpn.getBuyM()+cpn.getGetN())){							
							discnt = cpn.getGetN()*grc.getBasePrice();
							System.out.print("|  HWI Cents Off Coupon             "+String.format("%.2f",discnt));
						
						if(currencyFormatter.format(discnt).length() == 5)
							System.out.println("   |");
						else if (currencyFormatter.format(discnt).length() == 6)
							System.out.println("  |");
						else
							System.out.println(" |");
						
						}
						total += discnt;
					}
				}
			}
		}
		System.out.print("|                      Total        "+String.format("%.2f",discnt));
		if(currencyFormatter.format(total).length() == 5)
			System.out.println("    |");
		else if (currencyFormatter.format(total).length() == 6)
			System.out.println("   |");
		else
			System.out.println("  |");
		System.out.println("|=================================         |");
	}
}
