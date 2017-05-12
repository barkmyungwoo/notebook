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

		p.setProperty("3", "3,김기형,80,90,85");// p.setProperty(key, value);
		p.setProperty("55", "55,형형,80,90,85");// p.setProperty(key, value);
		// >> Properties 에 2개의 샘플 데이터를 추가함
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

		// >> "empData.txt" 파일을 읽어, Properties 객체에 저장하는 메소드
		// >> 읽어들인 키와 값은 각각 Employee 객체 필드에 기록함
		// >> Employee[] 을 리턴함

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

		// >> Properties 에 저장된 리스트를 하나씩 반복 출력하는 메소드
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
		
		
		// >> Employee[] 에서 각 객체별로 보너스포인트가 적용된 연봉을 계산하여,
		// "empResult.xml" 파일에 저장함
		// 보너스포인트적용연봉 = 연봉 + (연봉 * 보너스포인트);
		// >> 저장 예
		// 사번=이름, 소속부서, 연봉, 보너스포인트, 보너스포인트가 적용된 연봉
	}

}
