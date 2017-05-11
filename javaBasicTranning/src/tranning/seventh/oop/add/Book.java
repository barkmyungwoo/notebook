package tranning.seventh.oop.add;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Book {
	
	private String 책이름;									//필드값 변수 선언 PRIVATE형으로! 왜?! 딴놈이 함부로 못 바꾸게 하려고.
	private String 작가;
	private int 가격;
	private Calendar theDay ;
	private String contents;
	
	public Book() {}
	
	public Book(String 책이름, String 작가, int 가격, int y, int m, int d) {
		super();
		this.책이름 = 책이름;
		this.작가 = 작가;
		this.가격 = 가격;
		this.theDay = new GregorianCalendar(y,m,d);
	}

	public String get책이름() {
		return 책이름;
	}

	public void set책이름(String 책이름) {
		this.책이름 = 책이름;
	}

	public String get작가() {
		return 작가;
	}

	public void set작가(String 작가) {
		this.작가 = 작가;
	}

	public int get가격() {
		return 가격;
	}

	public void set가격(int 가격) {
		this.가격 = 가격;
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
		return "책이름=" + 책이름 + ", 작가=" + 작가 + ", 가격=" + 가격 + ", theDay=" + theDay + ", contents=" + contents;
	}
}
