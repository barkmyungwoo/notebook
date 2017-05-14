package practice3;

import java.util.Comparator;

import practice2.*;

public class AscBookTitle implements Comparator {

	@Override
	public int compare(Object ob1, Object ob2) {
		int result = 0;
		if (ob1 instanceof Book && ob2 instanceof Book) {
			Book p1 = (Book) ob1;
			Book p2 = (Book) ob2;

			result = (p1.getTitle().compareTo(p2.getTitle()));
		}
		return result;
	}

}
