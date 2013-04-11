package parataxis.dto;

public class Coupon {
	private char type; // S, M, X
	private String upc;
	private double discount;
	private int buyM;
	private int getN;
	
	public Coupon(char type, String upc, double discount){
		this.type = type;
		this.upc = upc;
		this.discount = discount;
	}
	
	public Coupon(char type, String upc, int buyM, int getN){
		this.type = type;
		this.upc = upc;
		this.buyM = buyM;
		this.getN = getN;
	}
	
	
	public char getType() {
		return type;
	}

	public String getUpc() {
		return upc;
	}

	public double getDiscount() {
		return discount;
	}

	public int getBuyM() {
		return buyM;
	}

	public int getGetN() {
		return getN;
	}

	/**
	 * Print out data depending on type
	 */
	public void printAllData(){
		if(type == 'S' || type == 'M') {
			System.out.println("type: "+type+ '\t'+" upc: "+upc+'\t'+" discount: "+discount);
		} else {
			System.out.println("type: "+type+ '\t'+" upc: "+upc+'\t'+" buyM: "+buyM+'\t'+" buyM: "+getN);
		}
	}
}
