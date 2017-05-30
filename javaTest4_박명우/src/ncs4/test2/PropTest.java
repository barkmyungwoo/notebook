package ncs4.test2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;

public class PropTest {

	public static void main(String[] args) {
		Properties prop = new Properties();
		Fruit[] fr;
		prop.setProperty("1", "apple,1200,3");
		prop.setProperty("2", "banana,2500,2");
		prop.setProperty("3", "grape,4500,5");
		prop.setProperty("4", "orange,800,10");
		prop.setProperty("5", "melon,5000,2");

		new PropTest().fileSave(prop);

		fr = new PropTest().fileOpen(prop);

		for (int i = 0; i < fr.length; i++) {
			System.out.println("fr[" + i + "] " + fr[i]);
		}
	}

	public void fileSave(Properties p) {
		try {
			p.storeToXML(new FileOutputStream("data.xml"), "what the.... hell...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Fruit[] fileOpen(Properties p) {
		Fruit[] fr = null;

		try {
			p.loadFromXML(new FileInputStream("data.xml"));

			Iterator<Object> it = p.keySet().iterator();
			Collection<Object> co = p.values();
			fr = new Fruit[co.size()];

			for (int i = 0; it.hasNext(); i++) {
				String key = (String) it.next();
				String value = p.getProperty(key);
				String[] fields = value.split(",");
				fr[i] = new Fruit(fields[0], Integer.parseInt(fields[1]), Integer.parseInt(fields[2]));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return fr;
	}

}
