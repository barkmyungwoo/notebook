package test.map;

import java.util.*;

import practice2.Book;
import test.list.Person;

public class TestHashMap {

	public static void main(String[] args) {
		HashMap hm = new HashMap();
//		Map hm = new HashMap();  같은 방식. 

		hm.put("one", new Person("홍길동", 23, 123.5));
		hm.put("two", new Person("박제언", 30, 23));
		hm.put("three", new Book("0010", 33, "자서전", "영구아트"));
		hm.put("four", new Person("이재훈", 27, 235));
		
		System.out.println(hm.size());				//갯수
		System.out.println(hm);						//내용 출력. 
		
		hm.put("one", new Person("나상민", 26, 135));
		
		System.out.println(hm);						//내용 출력. 
		
		
		//		value 는 중복 허용, key 는 안댐. 따라서 수정이 되었어요.
		
		System.out.println(hm.get("one"));
		
		
		hm.replace("two", "경기도 의왕시 청계동 ");

		System.out.println(hm);						//내용 출력. 
		
		System.out.println();
		System.out.println();

		
		
//---------------------------------------추출해서 쓰는방법---------------------------------------------//
		
		
		//키 -> set & iterator
		
		Set key = hm.keySet();
		Iterator kit = key.iterator();
//		Iterator kit = hm.keySet().iterator();		2줄을 1줄로 
		
		while (kit.hasNext()) {
			Object kob = kit.next();
			System.out.println(hm.get(kob));
		}
		
		
		System.out.println();
		System.out.println();



		//value -> collection , & Iterator or toArray
		
		
		//Iterator
		Collection val = hm.values();
		Iterator vit = val.iterator();
//		Iterator vit = hm.values().iterator();
		
		while(vit.hasNext()){
			System.out.println(vit.next());
		}
		
		System.out.println();
		System.out.println();

		//toArray
		Collection val2 = hm.values();
		Object[] aob = val2.toArray();
		
		for (Object object : aob) {
			System.out.println(object);
		}
	}

}
