package test.list;

import java.util.Comparator;

public class PersonNameDesc implements Comparator {
	public PersonNameDesc() {}

	@Override
	public int compare(Object ob1, Object ob2) {
		int result = 0;
		if (ob1 instanceof Person && ob2 instanceof Person) {
			Person p1 = (Person) ob1;
			Person p2 = (Person) ob2;

			result = -(p1.getName().compareTo(p2.getName()));
		}
		return result;
	}

}
