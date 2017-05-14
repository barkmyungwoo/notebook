package test.generic;

import java.util.*;

import practice2.Book;
import test.list.Person;

public class TestGeneric {

	public static void main(String[] args) {
		
		List li =new ArrayList();
		
		li.add(new String("apple"));
		li.add(new Person("ȫ��", 32, 15));
		li.add(new GregorianCalendar(1985, 9, 23));
		li.add(new Book("002", 3, "����� ����", "�ܾʵ�?"));
		
		for (Object object : li) {
			System.out.println(object);
		}
			
		for (int i = 0; i < li.size(); i++) {
			Object obj = li.get(i);
			
			if(obj instanceof String){
				System.out.println(((String)obj).toUpperCase());
			}
			if(obj instanceof Person){
				System.out.println(((Person)obj).getPoint());
			}
			if(obj instanceof Book){
				System.out.println(((Book)obj).getCategory());
			}
		}
		
		
	}
}
