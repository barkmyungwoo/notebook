package test.properties;

import java.io.*;
import java.util.*;

public class TestProperties2 {

	public static void main(String[] args) {
		Properties pr1 = new Properties(); 
		Properties pr2 = new Properties(); 
		Properties pr3 = new Properties(); 

		try {
			pr1.load(new FileInputStream("driver.dat"));
			pr2.load(new FileReader("driver.txt"));
			pr3.loadFromXML(new FileInputStream("driver.xml"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(pr1);
		System.out.println(pr2);
		System.out.println(pr3);
		
		System.out.println(pr1.getProperty("a"));
		System.out.println(pr1.getProperty("e"));
		System.out.println(pr1.getProperty("c"));
		
		pr3.list(System.out);
	}

}
