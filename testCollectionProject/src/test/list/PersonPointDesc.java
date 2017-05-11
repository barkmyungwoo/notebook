package test.list;

import java.util.Comparator;

public class PersonPointDesc implements Comparator {
	public PersonPointDesc() {}

	@Override
	public int compare(Object ob1, Object ob2) {
		int result = 0;
		if (ob1 instanceof Person && ob2 instanceof Person) {
			Person p1 = (Person) ob1;
			Person p2 = (Person) ob2;

			if(p1.getPoint()> p2.getPoint())
			result = 1;		
			else if(p1.getPoint()== p2.getPoint())
			result = 0;		
			if(p1.getPoint()< p2.getPoint())
			result = -1;		
			}
		
		return -result;
	}

}
