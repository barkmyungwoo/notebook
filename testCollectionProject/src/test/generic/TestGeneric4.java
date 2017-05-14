package test.generic;

import java.util.*;

public class TestGeneric4 {

	public static void main(String[] args) {
		Map<Integer, String> m = new HashMap<Integer, String>();
		putMap(m);
		printMap(m);
		
	}

	private static void printMap(Map<Integer, String> m) {
		Set<Integer> k = m.keySet();
		Iterator<Integer> ki = k.iterator();
		
		while (ki.hasNext()) {
			Integer integer = ki.next();
			String value = m.get(k);
			System.out.println(value);
		}
		
		Set<Map.Entry<Integer, String>> ent = m.entrySet();
		Iterator<Map.Entry<Integer, String>> ei = ent.iterator();
		
		while (ei.hasNext()) {
			Map.Entry<Integer, String> entry = ei.next();
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
	}

	private static void putMap(Map<Integer, String> m) {
		m.put(1, "경기도");
		m.put(2, "강원도");
		m.put(3, "너도나도");
	}

}
