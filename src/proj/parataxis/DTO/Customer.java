package proj.parataxis.DTO;

public class Customer {
	private char type;
	private long cardNum;
	private double moneyAvail;
	
	public Customer(char type, long cardNum, double moneyAvail) {
		this.type = type;
		this.cardNum = cardNum;
		this.moneyAvail = moneyAvail;
	}
	
	//TODO: create a way of displaying this information if needed
	public void testPrint(){
		System.out.println("Type: "+type+", num: "+cardNum+", balance: "+moneyAvail);
	}
}
