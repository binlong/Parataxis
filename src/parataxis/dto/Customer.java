package parataxis.dto;

public class Customer {
	private char type;
	private long cardNum;
	private double moneyAvail;
	
	public Customer(char type, long cardNum, double moneyAvail) {
		this.type = type;
		this.cardNum = cardNum;
		this.moneyAvail = moneyAvail;
	}
	
	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public long getCardNum() {
		return cardNum;
	}

	public void setCardNum(long cardNum) {
		this.cardNum = cardNum;
	}

	public double getMoneyAvail() {
		return moneyAvail;
	}

	public void setMoneyAvail(double moneyAvail) {
		this.moneyAvail = moneyAvail;
	}

	//TODO: create a way of displaying this information if needed
	public void testPrint(){
		System.out.println("Type: "+type+", num: "+cardNum+", balance: "+moneyAvail);
	}

	@Override
	public String toString() {
		return "Customer type=" + type + ", cardNum=" + cardNum
				+ ", moneyAvail=" + moneyAvail;
	}
}
