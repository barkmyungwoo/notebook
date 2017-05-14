package test.generic;

import java.util.*;

public class TestGeneric3 {

	
	public void printList(List<String> li) {
		//1��. foreach
		for (String string : li) {
			System.out.println(string);
		}
		
		Iterator<String> iter = li.iterator();
		//2��. iterator
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}

	public List<String> addList(){
		List<String> li = new ArrayList<String>(); 

		li.add("apple");
		li.add("banana");
		li.add("orange");

		return li;		
	}
	
	
	public static void main(String[] args) {
		TestGeneric3 tg = new TestGeneric3();
		tg.printList(tg.addList());

	}

}
