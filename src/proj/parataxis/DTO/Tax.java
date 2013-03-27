package proj.parataxis.DTO;

import java.util.Date;

public class Tax {
	private double taxRate;
	private Date startDate;
	private Date endDate;
	
	// rounding errors n shit
	
	
	public Tax(double taxRate, Date startDate, Date endDate) {
		this.taxRate = taxRate;
		this.startDate = startDate;
		this.endDate = endDate;
	}



	//TODO: create a way of displaying this information if needed
	public void testPrint(){
		System.out.println("TaxRate: "+taxRate+", startDate: "+startDate+", endDate: "+endDate);
	}
}
