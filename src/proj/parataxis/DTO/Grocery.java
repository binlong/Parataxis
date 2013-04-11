package proj.parataxis.DTO;

import java.util.Date;

public class Grocery {
	private String upc;
	private String name;
	private char type;
	private char category;
	private double basePrice;
	private Date baseStartDate;
	private Date baseEndDate;
	private double discount;
	private Date discountStartDate;
	private Date discountEndDate;
	private int buyM;
	private int buyN;
	private Date buyStartDate;
	private Date buyEndDate;
	private char salesTax;
	
	public Grocery(){
		
	}

	public Grocery(String upc, String name, char type, char category,
			double basePrice, Date baseStartDate, Date baseEndDate,
			double discount, Date discountStartDate, Date discountEndDate,
			int buyM, int buyN, Date buyStartDate, Date buyEndDate,
			char salesTax) {
		this.upc = upc;
		this.name = name;
		this.type = type;
		this.category = category;
		this.basePrice = basePrice;
		this.baseStartDate = baseStartDate;
		this.baseEndDate = baseEndDate;
		this.discount = discount;
		this.discountStartDate = discountStartDate;
		this.discountEndDate = discountEndDate;
		this.buyM = buyM;
		this.buyN = buyN;
		this.buyStartDate = buyStartDate;
		this.buyEndDate = buyEndDate;
		this.salesTax = salesTax;
	}
	
	public String getName() {
		return name;
	}
	
	public char getCategory() {
		return category;
	}
	
	public char getType() {
		return type;
	}
	
	public double getBasePrice() {
		return basePrice;
	}
	
	
	

	//TODO: create a way to display relevant information (with toString or do it here)
	/**
	 * Method used only for testing purposes at the early phases of this
	 * project. Method should be unaccessible after testing is concluded.
	 */
	public void testPrint(){
		System.out.println("UPC:"+upc+", name: "+name+", price: $"+basePrice);
		System.out.println("Date:"+baseStartDate+" thru "+baseEndDate);	
	}
	
	public void printAll() {
		System.out.println("Grocery [upc=" + upc + ", name=" + name + ", type=" + type
				+ ", category=" + category);
		System.out.println("basePrice=" + basePrice
				+ ", baseStartDate=" + baseStartDate + ", baseEndDate="
				+ baseEndDate);
		System.out.println("discount=" + discount
				+ ", discountStartDate=" + discountStartDate
				+ ", discountEndDate=" + discountEndDate);
		System.out.println("buyM=" + buyM
				+ ", buyN=" + buyN + ", buyStartDate=" + buyStartDate
				+ ", buyEndDate=" + buyEndDate + ", salesTax=" + salesTax + "]"+'\n');
	}
}
