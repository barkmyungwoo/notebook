package ncs4.test3;

import java.util.*;

public class MapTest {

	public static void main(String[] args) {
		Map<String, Inventory> map = new HashMap<String, Inventory>();
		Inventory[] inven = new Inventory[3];

		inven[0] = new Inventory("삼성 갤럭시S7", new GregorianCalendar(2016, 3, 15), 30);
		inven[1] = new Inventory("LG G5", new GregorianCalendar(2016, 2, 25), 20);
		inven[2] = new Inventory("애플 아이패드 Pro", new GregorianCalendar(2016, 1, 23), 15);

		for (int i = 0; i < inven.length; i++) {
			map.put(inven[i].getProductName(), inven[i]);
		}

		Iterator kit = map.entrySet().iterator();

		while (kit.hasNext()) {
	        Map.Entry entry = (Map.Entry) kit.next();
	        System.out.println(entry.getValue());
	    }		
		System.out.println();
		System.out.println();
		
		
		System.out.println("출고수량 10 적용시 -------------------------------------------");
		for (int i = 0; i < inven.length; i++) {
			try {
				inven[i].setGetAmount(10);
				System.out.println(inven[i]);
			} catch (AmountNotEnough e) {
				e.printStackTrace();
			}
		}		
		System.out.println();
		System.out.println();
		
		
		System.out.println("출고수량 부족시 -------------------------------------------");
		for (int i = 0; i < inven.length; i++) {
			try {
				inven[i].setGetAmount(20);
				System.out.println(inven[i]);
			} catch (AmountNotEnough e) {
				e.printStackTrace();
			}
		}		
	}
}
