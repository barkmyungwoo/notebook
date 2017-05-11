package practice2;

import java.util.Comparator;

public class DescCategory implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		int result = 0;
		if (o1 instanceof Book && o2 instanceof Book) {
			Book p1 = (Book) o1;
			Book p2 = (Book) o2;

			result = (p1.getCategory() < p2.getCategory())? 1 : (p1.getCategory() == p2.getCategory()) ? 0 : -1;
		}
		return result;

	}

}
