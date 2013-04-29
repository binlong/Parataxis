package proj.parataxis.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import parataxis.dto.Basket;
import parataxis.dto.Grocery;
import parataxis.dto.Receipt;
import parataxis.dto.Tax;
import scan.parataxis.main.Scan;

public class FinalTest {
	public static void main(String[] args) throws FileNotFoundException{

		Scan scan = new Scan("SampleInputLarge.txt");
		Receipt receipt = null;
		ArrayList<Basket> blist = null;
		try {
			blist = scan.scanFile();
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Basket b:blist){


			Tax tax = new Tax(7.7, new Date(), new Date());
			try{
			if(b.getPaymentType().equals("card")){
				receipt  = new Receipt(b.getDate(), b.getItemBasket(), b.getCustomer(), tax, b.getCashback(), b.getCouponList());
			} else if (b.getPaymentType().equals("cash")){
				receipt = new Receipt(b.getDate(), b.getItemBasket(), b.getAmountPaid(), tax, b.getCouponList());
			}
			
			System.out.println();
			/*System.out.print(receipt.makeHeader());
			System.out.print(receipt.printGroceries());
			System.out.print(receipt.printCoupons());
			System.out.print(receipt.printCashBack());
			System.out.print(receipt.printTotal());
			System.out.print(receipt.printPayment());

			System.out.print(receipt.makeFooter());*/
			System.out.println(receipt);
			System.out.println();
			}catch(NullPointerException e){
				System.out.println("\nEmpty Basket\n");
			}
		}
		
	}

}
