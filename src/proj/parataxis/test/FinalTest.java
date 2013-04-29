package proj.parataxis.test;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import parataxis.dto.Grocery;
import parataxis.dto.Receipt;
import parataxis.dto.Tax;
import scan.parataxis.main.Scan;

public class FinalTest {
	public static void main(String[] args){
		Scan scan = new Scan("smallFile.txt");
		Receipt receipt = null;
		ArrayList<Grocery> list = null;
		try {
			list = scan.scanFile();
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Tax tax = new Tax(7.7, new Date(), new Date());
		if(scan.getPaymentType().equals("card")){
			receipt  = new Receipt(scan.getDate(), list, scan.getCustomer(), tax, scan.getCashback(), scan.getCouponList());
		} else if (scan.getPaymentType().equals("cash")){
			receipt = new Receipt(scan.getDate(), list, scan.getAmountPaid(), tax, scan.getCouponList());
		}
		
		System.out.print(receipt.makeHeader());
		System.out.print(receipt.printGroceries());
		System.out.print(receipt.printCoupons());
		System.out.print(receipt.printCashBack());
		System.out.print(receipt.printTotal());
		System.out.print(receipt.printPayment());

		System.out.print(receipt.makeFooter());
	}

}
