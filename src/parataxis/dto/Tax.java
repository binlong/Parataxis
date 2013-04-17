package parataxis.dto;

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

	public double getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(double taxRate) {
		this.taxRate = taxRate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	//TODO: create a way of displaying this information if needed
	public void testPrint(){
		System.out.println("TaxRate: "+taxRate+", startDate: "+startDate+", endDate: "+endDate);
	}
}
