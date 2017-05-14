package test.properties;

import java.io.*;
import java.util.*;

public class TestProperties {
	
	public static void main(String[] args) {

		Properties pr = new Properties(); 
		
		pr.setProperty("a", "java");
		pr.setProperty("b", "oracle");
		pr.setProperty("c", "jdbc");
		pr.setProperty("d", "javascript");
		pr.setProperty("e", "database");
		pr.setProperty("f", "my name is barkmyungwoo");
		
		System.out.println(pr);
		
		try {
			pr.store(new FileOutputStream("driver.dat"), "data file");
			pr.store(new FileWriter("driver.txt"), "hi");
			pr.storeToXML(new FileOutputStream("driver.xml"), "hihihi");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
