package tranning.seventh.oop;

import tranning.seventh.oop.add.BookOperating;							//BookOperating.java를 사용하기 위해 import!!				

public class OOP2 {								

	public static void main(String[] args) {
	BookOperating  bo = new BookOperating();

	bo.출력하기();
	
	System.out.println();
	bo.책_가격변경(30000);
	System.out.println();
	bo.출력하기();

	}

}
