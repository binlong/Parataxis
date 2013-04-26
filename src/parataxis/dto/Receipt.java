package parataxis.dto;

import java.util.List;

import org.apache.commons.lang3.StringUtils;


public class Receipt {
	
	public final static String storeName = "HOGGLEY-WOGGLEY, INC";
	public final static String storeNumber = "358";
	
	public List<Grocery> groceryList;
	public Customer customer;
	public Tax tax;
	private double salesSubtotal = 0.0;
	private double salesTax = 0.0;
	private double total = 0.0;
	private double cash = 0.0;
	private double cashBack = 0.0;
	
	
	public Receipt() {
		
	}
	
	public Receipt(List<Grocery> groceryList, Customer customer, Tax tax, Double cashBack) {
		this.groceryList = groceryList;
		this.customer = customer;
		this.tax = tax;
		this.cashBack = cashBack;
	}
	
	public Receipt(List<Grocery> groceryList, Double cash, Tax tax) {
		this.groceryList = groceryList;
		this.cash = cash;
		this.tax = tax;
	}
	
	
	public double calculateSalesSubtotal() {
		Double subtotal = 0.0;
		for (Grocery grocery : groceryList) {
			subtotal += grocery.getQuantity() * grocery.getBasePrice();
		}
		return subtotal;
	}
	
	public double calculateSalesTax() {
		Double salesTotal = 0.0;
		double taxrate = tax.getTaxRate();
		for (Grocery grocery : groceryList) {
			if(grocery.getSalesTax() == 'T'){
				salesTotal += grocery.getBasePrice() * ((taxrate/100));
			}
		}
		return salesTotal;
	}
	
	public double calculateTotal() {
		return salesSubtotal + salesTax + cashBack;
	}
	
	public boolean checkFunding() {
		if (customer.getMoneyAvail() > total) {
			return true;
		}
		return false;
	}
	
	public String makeHeader() {
		String centerTest = " 123456789012345678901234567890123456789012\n";
		String header = "+------------------------------------------+\n" +
						"|                                          |\n" +
				        "|                                          |\n" +
						"|           " + storeName + "           |\n" +
				        "|                 Store " + storeNumber + "                |\n" +
						"|                                          |\n";
		
		return centerTest + header;
	}
	
	public String printGroceries() {
		String totalGroceries = "";
		double basePrice;
		for (int i = 0; i < groceryList.size(); i++) {
			Grocery grocery = groceryList.get(i);
			String groceryReceipt = "|" +  (i+1);
			groceryReceipt += StringUtils.repeat(" ", 4 - String.valueOf(i+1).length()); //"   " + grocery.getName();
			groceryReceipt += grocery.getName(); 
			groceryReceipt += StringUtils.repeat(" ", 26 - grocery.getName().length());
			groceryReceipt += grocery.getCategory() + "" + grocery.getType();
			basePrice = grocery.getBasePrice();
			if (grocery.getType() == 'P' || grocery.getType() == 'Q') {
				groceryReceipt += StringUtils.repeat(" ", 10);
				groceryReceipt += "|\n";
				groceryReceipt += "|";
				groceryReceipt += StringUtils.repeat(" ", 6);
				groceryReceipt += grocery.getQuantity();
				if (grocery.getType() == 'Q') {
					groceryReceipt += " Ea.";
				}
				else {
					groceryReceipt += " Lbs";
				}
				groceryReceipt += StringUtils.repeat(" ", 15 - groceryReceipt.substring(45, groceryReceipt.length()).length());
				groceryReceipt += "@";
				groceryReceipt += "   1/";
				
				groceryReceipt += StringUtils.repeat(" ", 8 - String.format("%.2f", grocery.getBasePrice()).length());
				groceryReceipt += String.format("%.2f", grocery.getBasePrice());				
				groceryReceipt += StringUtils.repeat(" ", 12 - String.format("%.2f", grocery.getBasePrice() * grocery.getQuantity()).length());
				groceryReceipt += String.format("%.2f", grocery.getBasePrice() * grocery.getQuantity());
			}
			else {
				groceryReceipt += StringUtils.repeat(" ", 8 - String.format("%.2f", grocery.getBasePrice()).length());
				groceryReceipt += String.format("%.2f", grocery.getBasePrice()); 
			}
			groceryReceipt += "  |\n";
			totalGroceries += groceryReceipt;

		}
		return totalGroceries;
	}
	
	public String printTotal() {
		salesSubtotal = calculateSalesSubtotal();
		salesTax = calculateSalesTax();
		total = calculateTotal();
		//System.out.println(salesTax + " : " + salesSubtotal);
		
		String subtotalString = "|******** Sale Subtotal***";
		subtotalString += StringUtils.repeat(" ", 15 - String.format("%.2f", salesSubtotal).length());
		subtotalString += String.format("%.2f", salesSubtotal);
		subtotalString += "  |\n";
		
		String salesTaxString = "|   Sales Tax";
		salesTaxString += StringUtils.repeat(" ", 28 - String.format("%.2f", salesTax).length());
		salesTaxString += String.format("%.2f", calculateSalesTax());
		salesTaxString += "  |\n";
		
		String salesTaxRateString = "|   Sales Tax Rate:";
		salesTaxRateString += StringUtils.repeat(" ", 8 - String.format("%.3f", tax.getTaxRate()).length());
		salesTaxRateString += String.format("%.3f", tax.getTaxRate());
		salesTaxRateString += "%";
		salesTaxRateString += StringUtils.repeat(" ", 15);
		salesTaxRateString += "|\n";
		
		String totalString = "|************ Total Sale";
		totalString += StringUtils.repeat(" ", 17 - String.format("%.2f", total).length());
		totalString += String.format("%.2f", total);
		totalString += "  |\n";
		
		return subtotalString + salesTaxString + salesTaxRateString + totalString;
	}
	
	public String printPayment() {
		String paymentString = "|";
		if (customer != null) {
			paymentString += "Account Nr.:xxxxxxxxxxxx";
			paymentString += Long.toString(customer.getCardNum()).substring(12, 16);
			paymentString += StringUtils.repeat(" ", 14);
			paymentString += "|\n";
			if (customer.getType() == 'C') {
				paymentString += "|Credit Card Charged";
			}
			else {
				paymentString += "|Debit Card Charged ";
			}
			paymentString += StringUtils.repeat(" ", 21 - String.format("%.2f", total).length());
			paymentString += String.format("%.2f", total);
			paymentString += "  |\n";
			if (checkFunding()) {
				paymentString += "|Approved";
				paymentString += StringUtils.repeat(" ", 34);
				paymentString += "|\n";
			}
			else {
				paymentString += "|Disapproved Card Declined";
				paymentString += StringUtils.repeat(" ", 17);
				paymentString += "|\n";
			}
		}
		else {
			
		}
		return paymentString;
	}
	
	public String makeFooter(){
		String footer = "";
		return footer;
	}
	
	@Override
	public String toString() {
		return makeHeader() + printGroceries() + printTotal() + printPayment() + makeFooter();
	}
}
