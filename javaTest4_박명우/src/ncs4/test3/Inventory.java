package ncs4.test3;

import java.util.*;

public class Inventory {
	private String productName; 								// 상품명
	private Calendar putDate; 									// 입고일
	private Calendar getDate;		 							// 출고일
	private int putAmount; 										// 입고수량
	private int getAmount; 										// 출고수량
	private int inventoryAmount; 								// 재고수량

	public Inventory(){}

	public Inventory(String productName, Calendar putDate, int putAmount) {
		this.productName = productName;
		this.putDate = putDate;		
		this.getDate = null;
		this.putAmount = putAmount;		
		this.inventoryAmount = putAmount;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Calendar getPutDate() {
		return putDate;
	}

	public void setPutDate(Calendar putDate) {
		this.putDate = putDate;
	}

	public Calendar getGetDate() {
		return getDate;
	}

	public void setGetDate(Calendar getDate) {
		this.getDate = getDate;
	}
	
	public int getPutAmount() {
		return putAmount;
	}

	public void setPutAmount(int putAmount) {
		this.putAmount = putAmount;
	}

	public int getGetAmount() {
		return getAmount;
	}

	public void setGetAmount(int getAmount) throws AmountNotEnough {
		if(getInventoryAmount()<getAmount){
			throw new AmountNotEnough("수량이 충분하지 않습니다.");
		}
		
		this.getAmount = getAmount;
		setPutAmount(getPutAmount()-getAmount);
		setGetDate(new GregorianCalendar());
		setInventoryAmount(getInventoryAmount()-getAmount);
	}

	public int getInventoryAmount() {
		return inventoryAmount;
	}

	public void setInventoryAmount(int inventoryAmount) {
		this.inventoryAmount = inventoryAmount;
	}
	
	@Override
	public String toString() {
		try {
			return productName 
					+ putDate.get(putDate.YEAR) + "년 " + putDate.get(putDate.MONTH) + "월 "+ putDate.get(putDate.DATE) + "일 입고, "
					+ putAmount +"개, " 
					+ getDate.get(getDate.YEAR) + "년 " + getDate.get(getDate.MONTH) + "월 "+ getDate.get(getDate.DATE) + "일 출고, "
					+ getAmount + "개, " 
					+ "재고 " + inventoryAmount+"개";
		} catch (Exception e) {
			return productName 
					+ putDate.get(putDate.YEAR) + "년 " + putDate.get(putDate.MONTH) + "월 "+ putDate.get(putDate.DATE) + "일 입고, "
					+ putAmount +"개, " 
					+ null+", "
					+ getAmount + "개, " 
					+ "재고 " + inventoryAmount+"개";
		}
	}
}