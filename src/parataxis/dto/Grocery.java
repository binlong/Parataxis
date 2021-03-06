package parataxis.dto;

import java.util.Date;

public class Grocery {
	// loaded data
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
	//data for Scan
	private int quantity;
	private double weight;
	private boolean coupon;
	
	public boolean getCoupon() {
		return coupon;
	}

	public void scannedCoupon() {
		this.coupon = true;
	}

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
		this.quantity = 0;
		this.coupon = false;
	}
	
	public void incrementQuantity(){
		this.quantity++;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(char type) {
		this.type = type;
	}

	public void setCategory(char category) {
		this.category = category;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public void setBaseStartDate(Date baseStartDate) {
		this.baseStartDate = baseStartDate;
	}

	public void setBaseEndDate(Date baseEndDate) {
		this.baseEndDate = baseEndDate;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public void setDiscountStartDate(Date discountStartDate) {
		this.discountStartDate = discountStartDate;
	}

	public void setDiscountEndDate(Date discountEndDate) {
		this.discountEndDate = discountEndDate;
	}

	public void setBuyM(int buyM) {
		this.buyM = buyM;
	}

	public void setBuyN(int buyN) {
		this.buyN = buyN;
	}

	public void setBuyStartDate(Date buyStartDate) {
		this.buyStartDate = buyStartDate;
	}

	public void setBuyEndDate(Date buyEndDate) {
		this.buyEndDate = buyEndDate;
	}

	public void setSalesTax(char salesTax) {
		this.salesTax = salesTax;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getUpc() {
		return upc;
	}

	public String getName() {
		return name;
	}

	public char getType() {
		return type;
	}

	public char getCategory() {
		return category;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public Date getBaseStartDate() {
		return baseStartDate;
	}

	public Date getBaseEndDate() {
		return baseEndDate;
	}

	public double getDiscount() {
		return discount;
	}

	public Date getDiscountStartDate() {
		return discountStartDate;
	}

	public Date getDiscountEndDate() {
		return discountEndDate;
	}

	public int getBuyM() {
		return buyM;
	}

	public int getBuyN() {
		return buyN;
	}

	public Date getBuyStartDate() {
		return buyStartDate;
	}

	public Date getBuyEndDate() {
		return buyEndDate;
	}

	public char getSalesTax() {
		return salesTax;
	}
	public int getQuantity(){
		return quantity;
		
	}
	

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
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
