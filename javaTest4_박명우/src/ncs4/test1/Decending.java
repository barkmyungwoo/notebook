package ncs4.test1;

import java.util.Comparator;

public class Decending implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		return ((int)o2>(int)o1)?1:((int)o2==(int)o1)?0:-1;
	}
}
