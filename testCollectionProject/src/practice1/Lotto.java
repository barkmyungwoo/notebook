package practice1;

import java.util.*;

public class Lotto {

	public static void main(String[] args) {
		TreeSet ts = new TreeSet();

		do {
			if (ts.size() != 6)
				ts.add((int) (Math.random() * 45 + 1));
			else
				break;
		} while (true);

		Object[] ob = ts.toArray();
		int[] lotto = new int[6];

		for (int j = 0; j < ob.length; j++) {
			lotto[j] = (int) ob[j];

			System.out.println(lotto[j]);
		}
	}
}