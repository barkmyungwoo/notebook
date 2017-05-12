package test.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.*;

import test.entity.Employee;
import test.entity.Employee;

public class TestProperties {

	public static void main(String[] args) {
		TestProperties test = new TestProperties();
		Properties prop = new Properties();
		Employee[] ear;

		ear = test.readFile(prop);
		test.printConsole(prop);
		test.addEmpData(prop);
		test.printConsole(prop);
		test.saveEmpXML(ear);
	}

	public void addEmpData(Properties p) {

		p.setProperty("3", "3,�����,80,90,85");// p.setProperty(key, value);
		p.setProperty("55", "55,����,80,90,85");// p.setProperty(key, value);
		// >> Properties �� 2���� ���� �����͸� �߰���
	}

	public Employee[] readFile(Properties p) {
		Employee[] per = null;

		try {
			p.load(new FileReader("Employee.txt"));

			Enumeration<String> em = (Enumeration<String>) p.propertyNames();
			Iterator<Object> it = p.keySet().iterator();
			Collection<Object> co = p.values();
			per = new Employee[co.size()];

			for (int i = 0; it.hasNext(); i++) {
				String key = (String) it.next();
				String value = p.getProperty(key);

				String[] fields = value.split(",");
				per[i] = new Employee(Integer.parseInt(fields[0]), fields[1], fields[2], Integer.parseInt(fields[3]),
						Double.parseDouble(fields[4]));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// for (Employee Employee : per) {
		// System.out.println(Employee);
		// }

		return per;

		// >> "empData.txt" ������ �о�, Properties ��ü�� �����ϴ� �޼ҵ�
		// >> �о���� Ű�� ���� ���� Employee ��ü �ʵ忡 �����
		// >> Employee[] �� ������

	}

	public void printConsole(Properties p) {

		Enumeration<String> em = (Enumeration<String>) p.propertyNames();
		Iterator<Object> it = p.keySet().iterator();
		Collection<Object> co = p.values();
		Employee[] per = new Employee[co.size()];

		for (int i = 0; it.hasNext(); i++) {
			String key = (String) it.next();
			String value = p.getProperty(key);

			String[] fields = value.split(",");
			per[i] = new Employee(Integer.parseInt(fields[0]), fields[1], fields[2], Integer.parseInt(fields[3]),
					Double.parseDouble(fields[4]));
		}
		for (Employee Employee : per) {
			System.out.println(Employee);
		}

		// >> Properties �� ����� ����Ʈ�� �ϳ��� �ݺ� ����ϴ� �޼ҵ�
	}

	public void saveEmpXML(Employee[] er) {
		Properties pr = new Properties(); 
		String str ="";
		for (int i = 0; i < er.length; i++) {
			
			str = er[i].geteId()+"";
			pr.setProperty(str, er[i].geteName()+
					er[i].getDept()+
					er[i].getSalary()+
					er[i].getBonusPoint()+
					(er[i].getSalary()+(int)(er[i].getSalary()*er[i].getBonusPoint()/100)));
		}
		

		try {
			pr.storeToXML(new FileOutputStream("empResult.xml"), "hihihi");	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		// >> Employee[] ���� �� ��ü���� ���ʽ�����Ʈ�� ����� ������ ����Ͽ�,
		// "empResult.xml" ���Ͽ� ������
		// ���ʽ�����Ʈ���뿬�� = ���� + (���� * ���ʽ�����Ʈ);
		// >> ���� ��
		// ���=�̸�, �ҼӺμ�, ����, ���ʽ�����Ʈ, ���ʽ�����Ʈ�� ����� ����
	}

}
