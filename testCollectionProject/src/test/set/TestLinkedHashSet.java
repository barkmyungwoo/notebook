package test.set;

import java.util.*;

public class TestLinkedHashSet {
	public static void main(String[] args) {
		LinkedHashSet ls = new LinkedHashSet();

		ls.add("apple");
		ls.add("banana");
		ls.add("orange");
		ls.add(123);
		ls.add(3.014);

		System.out.println(ls);

		Object[] ob = ls.toArray();

		for (int i = 0; i < ob.length; i++) {
			System.out.println(ob[i]);
		}

		System.out.println("-------------------------------------");

		for (Object object : ob) {
			System.out.println(object);
		}

		System.out.println("-------------------------------------");

		Iterator it = ls.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}
}
