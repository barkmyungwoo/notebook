package tranning.seventh.oop.add;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Book {
	
	private String å�̸�;									//�ʵ尪 ���� ���� PRIVATE������! ��?! ������ �Ժη� �� �ٲٰ� �Ϸ���.
	private String �۰�;
	private int ����;
	private Calendar theDay ;
	private String contents;
	
	public Book() {}
	
	public Book(String å�̸�, String �۰�, int ����, int y, int m, int d) {
		super();
		this.å�̸� = å�̸�;
		this.�۰� = �۰�;
		this.���� = ����;
		this.theDay = new GregorianCalendar(y,m,d);
	}

	public String getå�̸�() {
		return å�̸�;
	}

	public void setå�̸�(String å�̸�) {
		this.å�̸� = å�̸�;
	}

	public String get�۰�() {
		return �۰�;
	}

	public void set�۰�(String �۰�) {
		this.�۰� = �۰�;
	}

	public int get����() {
		return ����;
	}

	public void set����(int ����) {
		this.���� = ����;
	}

	public Calendar getTheDay() {
		return theDay;
	}

	public void setTheDay(Calendar theDay) {
		this.theDay = theDay;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String toString() {
		return "å�̸�=" + å�̸� + ", �۰�=" + �۰� + ", ����=" + ���� + ", theDay=" + theDay + ", contents=" + contents;
	}
}
