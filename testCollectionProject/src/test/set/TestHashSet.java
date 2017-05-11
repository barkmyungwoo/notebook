package test.set;

import java.util.*;

public class TestHashSet {
	public static void main(String[] args) {
		HashSet hs = new HashSet();
		hs.add(new String("apple"));
		
		hs.add("banana");
		hs.add(new Integer(123));
		hs.add(456);
		hs.add(3.14);
		hs.add(new Double(54.7));

		System.out.println(hs);
		
		hs.add("apple");
		System.out.println(hs);
		
		
		System.out.println(hs.size());
		
		hs.remove("apple");


		System.out.println(hs);
		
		Iterator iter = hs.iterator();
		
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		

		
	}

}
