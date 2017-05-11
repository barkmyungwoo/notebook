package test.list;

import java.util.*;

public class TestArrayList {
	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		
		al.add("java");
		al.add("oracle");
		al.add("apple");
		al.add("java");
		System.out.println(al);
		
		for (int i = 0; i < al.size(); i++) {
			System.out.println(al.get(i));
		}
		
		al.add(1, "jtbc");

		for (Object object : al) {
			System.out.println(object);
		}
		
		al.remove(2);
		System.out.println(al);
		
		
		al.remove("java");
		System.out.println(al);
	}

}
