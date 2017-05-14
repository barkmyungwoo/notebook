package test.map;

import java.util.*;

import practice2.Book;
import test.list.Person;

public class TestHashMap {

	public static void main(String[] args) {
		HashMap hm = new HashMap();
//		Map hm = new HashMap();  ���� ���. 

		hm.put("one", new Person("ȫ�浿", 23, 123.5));
		hm.put("two", new Person("������", 30, 23));
		hm.put("three", new Book("0010", 33, "�ڼ���", "������Ʈ"));
		hm.put("four", new Person("������", 27, 235));
		
		System.out.println(hm.size());				//����
		System.out.println(hm);						//���� ���. 
		
		hm.put("one", new Person("�����", 26, 135));
		
		System.out.println(hm);						//���� ���. 
		
		
		//		value �� �ߺ� ���, key �� �ȴ�. ���� ������ �Ǿ����.
		
		System.out.println(hm.get("one"));
		
		
		hm.replace("two", "��⵵ �ǿս� û�赿 ");

		System.out.println(hm);						//���� ���. 
		
		System.out.println();
		System.out.println();

		
		
//---------------------------------------�����ؼ� ���¹��---------------------------------------------//
		
		
		//Ű -> set & iterator
		
		Set key = hm.keySet();
		Iterator kit = key.iterator();
//		Iterator kit = hm.keySet().iterator();		2���� 1�ٷ� 
		
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
