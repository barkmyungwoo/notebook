package test.set;

import java.util.TreeSet;

public class TestTreeSet {

	public static void main(String[] args) {
		TreeSet ts = new TreeSet();
		
		ts.add("apple");
		ts.add("banana");
		ts.add("orange");
		
		System.out.println(ts.descendingSet());
		
	}

}
