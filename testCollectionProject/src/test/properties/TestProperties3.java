package test.properties;

import java.util.*;
import test.list.*;
import java.io.*;

public class TestProperties3 {

	public static void main(String[] args) {

		Properties pr = new Properties();

		try {
			pr.load(new FileReader("person.txt"));
			pr.list(System.out);

			System.out.println(pr.size());

			Enumeration<String> em = (Enumeration<String>) pr.propertyNames();
			Iterator<Object> it = pr.keySet().iterator();
			Collection<Object> co = pr.values();

			Person[] per = new Person[co.size()];

			for (int i = 0; it.hasNext(); i++) {
				String key = (String) it.next();
				String value = pr.getProperty(key);

//				(Person[])co.toArray();
				
				String[] fields = value.split(",");
				per[i] = new Person(fields[0], Integer.parseInt(fields[1]), Double.parseDouble(fields[2]));
			}
			for (Person person : per) {
				System.out.println(person);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
