package parataxis.dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class Receipt {

	public final static String storeName = "HOGGLEY-WOGGLEY, INC";
	public final static String storeNumber = "358";

	public List<Grocery> groceryList;
	public List<Coupon> couponList;
	public Customer customer;
	public Tax tax;
	private double salesSubtotal = 0.0;
	private double salesTax = 0.0;
	private double total = 0.0;
	private double cash = 0.0;
	private double cashBack = 0.0;
	private double totalDiscount = 0.0;
	private int totalItems = 0;
	private Date date;

	public Receipt() {

	}

	public Receipt(Date date, List<Grocery> groceryList, Customer customer, Tax tax,
			Double cashBack, List<Coupon> couponList) {
		this.date = date;
		this.groceryList = groceryList;
		this.customer = customer;
		this.tax = tax;
		this.cashBack = cashBack;
		this.couponList = couponList;
	}

	public Receipt(Date date, List<Grocery> groceryList, Double cash, Tax tax, List<Coupon> couponList) {
		this.date = date;
		this.groceryList = groceryList;
		this.cash = cash;
		this.tax = tax;
		this.couponList = couponList;
	}

	public double calculateSalesSubtotal() {
		Double subtotal = 0.0;
		for (Grocery grocery : groceryList) {
			subtotal += grocery.getQuantity() * grocery.getBasePrice();
		}
		return subtotal - totalDiscount + cashBack;
	}

	public double calculateSalesTax() {
		Double salesTotal = 0.0;
		double taxrate = tax.getTaxRate();
		for (Grocery grocery : groceryList) {
			if (grocery.getSalesTax() == 'T') {
				salesTotal += grocery.getBasePrice() * ((taxrate / 100));
			}
		}
		return salesTotal;
	}

	public double calculateTotal() {
		return salesSubtotal + salesTax;
	}

	public boolean checkFunding() {
		if (customer.getMoneyAvail() >= total) {
			return true;
		}
		return false;
	}
	
	public boolean checkCashFunding() {
		if (cash >= total) {
			return true;
		}
		return false;
	}

	public String makeHeader() {
		String centerTest = " 123456789012345678901234567890123456789012\n";
		String header = "+------------------------------------------+\n"
				+ "|                                          |\n"
				+ "|                                          |\n"
				+ "|           " + storeName + "           |\n"
				+ "|                 Store " + storeNumber
				+ "                |\n"
				+ "|                                          |\n";

		return centerTest + header;
	}

	public String printGroceries() {
		String totalGroceries = "";
		double basePrice;
		for (int i = 0; i < groceryList.size(); i++) {
			Grocery grocery = groceryList.get(i);
			String groceryReceipt = "|" + (i + 1);
			groceryReceipt += StringUtils.repeat(" ", 4 - String.valueOf(i + 1).length());
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
				} else {
					groceryReceipt += " Lbs";
				}
				groceryReceipt += StringUtils.repeat(" ", 15 - groceryReceipt.substring(45, groceryReceipt.length()).length());
				groceryReceipt += "@";
				groceryReceipt += "   1/";

				groceryReceipt += StringUtils.repeat(" ", 8 - String.format("%.2f", grocery.getBasePrice()).length());
				groceryReceipt += String.format("%.2f", grocery.getBasePrice());
				groceryReceipt += StringUtils.repeat(" ", 12 - String.format("%.2f", grocery.getBasePrice() * grocery.getQuantity()).length());
				groceryReceipt += String.format("%.2f", grocery.getBasePrice() * grocery.getQuantity());
			} else {
				groceryReceipt += StringUtils.repeat(" ", 8 - String.format("%.2f", grocery.getBasePrice()).length());
				groceryReceipt += String.format("%.2f", grocery.getBasePrice());
			}
			groceryReceipt += "  |\n";
			totalGroceries += groceryReceipt;
			totalItems += grocery.getQuantity();
		}
		return totalGroceries;
	}

	public String printCashBack() {
		String cashBackString = "";
		if (cashBack > 0.0) {
			cashBackString += "|=================================";
			cashBackString += StringUtils.repeat(" ", 9);
			cashBackString += "|\n";
			cashBackString += "|   Cash Back Requested";
			cashBackString += StringUtils.repeat(" ", 18 - String.format("%.2f", cashBack).length());
			cashBackString += String.format("%.2f", cashBack);
			cashBackString += "  |\n";
			cashBackString += "|=================================";
			cashBackString += StringUtils.repeat(" ", 9);
			cashBackString += "|\n";
		}
		return cashBackString;
	}

	public String printCoupons() {
		String couponString = "";
		if (!couponList.isEmpty()) {
			couponString += "|=================================";
			couponString += StringUtils.repeat(" ", 9);
			couponString += "|\n";
			for (Grocery grocery : groceryList) {
				grocery.getUpc();
				for (Coupon coupon : couponList) {
					if (grocery.getUpc().equals(coupon.getUpc()) && !grocery.getCoupon()) {
						
						grocery.scannedCoupon();
						if (coupon.getType() == 'S') {
							coupon.getDiscount();
							couponString += "|  HWI Cents off Coupon";
							couponString += StringUtils.repeat(" ", 18 - String.format("%.2f", coupon.getDiscount()).length());
							couponString += String.format("%.2f", coupon.getDiscount());
							couponString += "  |\n";
							totalDiscount += coupon.getDiscount();
						} 
						else if (coupon.getType() == 'M') {
							coupon.getDiscount();
							couponString += "|  Mfg Cents off Coupon";
							couponString += StringUtils.repeat(" ", 18 - String.format("%.2f", coupon.getDiscount()).length());
							couponString += String.format("%.2f", coupon.getDiscount());
							couponString += "  |\n";
							totalDiscount += coupon.getDiscount();
						} 
						else if (coupon.getType() == 'X') {
							coupon.getDiscount();
							if (grocery.getQuantity() >= (coupon.getBuyM() + coupon.getGetN())) {
								couponString += "|  Mfg Buy " + coupon.getBuyM() + " Get " + coupon.getGetN() + " Free Coupon";
								couponString += StringUtils.repeat(" ", 11 - String.format("%.2f", grocery.getBasePrice()).length());
								couponString += String.format("%.2f", grocery.getBasePrice());
								couponString += "  |\n";
								totalDiscount += coupon.getGetN() * grocery.getBasePrice();
							}
						}
					}
				}
			}
			if (couponString.length() > 45) {
				couponString += "|";
				couponString += StringUtils.repeat(" ", 22);
				couponString += "Total";
				couponString += StringUtils.repeat(" ", 13 - String.format("%.2f", totalDiscount).length());
				couponString += String.format("%.2f", totalDiscount);
				couponString += "  |\n";
				couponString += "|=================================";
				couponString += StringUtils.repeat(" ", 9);
				couponString += "|\n";
			}
			else {
				couponString = "";
			}
		}
		return couponString;
	}

	public String printTotal() {
		salesSubtotal = calculateSalesSubtotal();
		salesTax = calculateSalesTax();
		total = calculateTotal();
		// System.out.println(salesTax + " : " + salesSubtotal);

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
			} else {
				paymentString += "|Debit Card Charged ";
			}
			paymentString += StringUtils.repeat(" ", 21 - String.format("%.2f", total).length());
			paymentString += String.format("%.2f", total);
			paymentString += "  |\n";
			if (checkFunding()) {
				paymentString += "|Approved";
				paymentString += StringUtils.repeat(" ", 34);
				paymentString += "|\n";
			} else {
				paymentString += "|Disapproved Card Declined";
				paymentString += StringUtils.repeat(" ", 17);
				paymentString += "|\n";
			}
		} else {
			paymentString += "Cash Tendered";
			paymentString += StringUtils.repeat(" ", 27 - String.format("%.2f", cash).length());
			paymentString += String.format("%.2f", cash);
			paymentString += "  |\n";
			if (checkCashFunding()) {
				paymentString += "|Change";
				paymentString += StringUtils.repeat(" ", 34 - String.format("%.2f", cash - total).length());
				paymentString += String.format("%.2f", cash - total);
				paymentString += "  |\n";
			}
			else {
				paymentString += "|Sales Canceled Insufficient Funds";
				paymentString += StringUtils.repeat(" ", 9);
				paymentString += "|\n";
			}
			paymentString += "|";
			paymentString += StringUtils.repeat(" ", 42);
			paymentString += "|\n";
		}
		return paymentString;
	}

	public String makeFooter() {
		String footer = "";
		footer += "|=================================";
		footer += StringUtils.repeat(" ", 9);
		footer += "|\n";
		footer += "|    ITEMS PURCHASED:";
		footer += StringUtils.repeat(" ", 5 - String.valueOf(totalItems).length());
		footer += String.valueOf(totalItems);
		footer += StringUtils.repeat(" ", 17);
		footer += "|\n";
		footer += "|=================================";
		footer += StringUtils.repeat(" ", 9);
		footer += "|\n";
		footer += "|    SAVED TODAY";
		footer += StringUtils.repeat(" ", 25 - String.format("%.2f", totalDiscount).length());
		footer += String.format("%.2f", totalDiscount);
		footer += "  |\n";
		footer += "|=================================";
		footer += StringUtils.repeat(" ", 9);
		footer += "|\n";
		footer += "|";
		footer += StringUtils.repeat(" ", 42);
		footer += "|\n";
		footer += "|    Date:";
		footer += StringUtils.repeat(" ", 16);
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		footer += dateFormat.format(date);
		//footer += "/" + date.getYear();
		footer += StringUtils.repeat(" ", 7);
		footer += "|\n";
		footer += "|";
		footer += StringUtils.repeat(" ", 42);
		footer += "|\n";
		footer += "+------------------------------------------+";
		return footer;
	}

	@Override
	public String toString() {
		return makeHeader() + printGroceries() + printCashBack() + printCoupons() + printTotal() + printPayment() + makeFooter();
	}
}
