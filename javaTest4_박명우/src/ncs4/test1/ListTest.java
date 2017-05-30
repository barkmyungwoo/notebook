package ncs4.test1;

import java.util.*;

public class ListTest {

	public void display(List<Integer> list) {
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i).toString());
	}

	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<Integer>();
		Random rn = new Random();
		
		for (int i = 0; i < 10; i++) {
			arr.add(rn.nextInt(100));
		}

		new ListTest().display(arr);
		
		arr.sort(new Decending());
		
		new ListTest().display(arr);
	}


}
