package ncs4.test3;

import java.util.*;

public class Inventory {
	private String productName; 								// ��ǰ��
	private Calendar putDate; 									// �԰���
	private Calendar getDate;		 							// �����
	private int putAmount; 										// �԰����
	private int getAmount; 										// ������
	private int inventoryAmount; 								// ������

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
			throw new AmountNotEnough("������ ������� �ʽ��ϴ�.");
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
					+ putDate.get(putDate.YEAR) + "�� " + putDate.get(putDate.MONTH) + "�� "+ putDate.get(putDate.DATE) + "�� �԰�, "
					+ putAmount +"��, " 
					+ getDate.get(getDate.YEAR) + "�� " + getDate.get(getDate.MONTH) + "�� "+ getDate.get(getDate.DATE) + "�� ���, "
					+ getAmount + "��, " 
					+ "��� " + inventoryAmount+"��";
		} catch (Exception e) {
			return productName 
					+ putDate.get(putDate.YEAR) + "�� " + putDate.get(putDate.MONTH) + "�� "+ putDate.get(putDate.DATE) + "�� �԰�, "
					+ putAmount +"��, " 
					+ null+", "
					+ getAmount + "��, " 
					+ "��� " + inventoryAmount+"��";
		}
	}
}