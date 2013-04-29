package parataxis.dto;

import java.util.ArrayList;
import java.util.Date;

public class Basket {
	private ArrayList<Grocery> itemBasket = new ArrayList<Grocery>();
	ArrayList<Coupon> couponList = new ArrayList<Coupon>(); 
	private Date date;
	private double amountPaid;
	private long cardNum = 0;
	private double cashback;
	private Customer customer;
	private String paymentType;
	public ArrayList<Grocery> getItemBasket() {
		return itemBasket;
	}
	public void setItemBasket(ArrayList<Grocery> itemBasket) {
		this.itemBasket = itemBasket;
	}
	public void addItem(Grocery g){
		itemBasket.add(g);
	}
	public void addCoupon(Coupon c){
		couponList.add(c);
	}
	public ArrayList<Coupon> getCouponList() {
		return couponList;
	}
	public void setCouponList(ArrayList<Coupon> couponList) {
		this.couponList = couponList;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}
	public long getCardNum() {
		return cardNum;
	}
	public void setCardNum(long cardNum) {
		this.cardNum = cardNum;
	}
	public double getCashback() {
		return cashback;
	}
	public void setCashback(double cashback) {
		this.cashback = cashback;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	@Override
	public String toString() {
		return "Basket [itemBasket=" + itemBasket + ", couponList="
				+ couponList + ", date=" + date + ", amountPaid=" + amountPaid
				+ ", cardNum=" + cardNum + ", cashback=" + cashback
				+ ", customer=" + customer + ", paymentType=" + paymentType
				+ "]";
	}
	

}
