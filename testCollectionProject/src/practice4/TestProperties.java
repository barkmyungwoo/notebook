package practice4;

import java.io.*;
import java.util.*;

public class TestProperties {
	

	public static void main(String[] args) {
		TestProperties tp = new TestProperties();
		Student[] st = tp.readFile();
		tp.printConsole(st);
		tp.saveXMLFile(st);
	}


	public Student[] readFile() {
		Properties prop = new Properties();
		
		try {
			prop.load(new FileReader("score.txt"));

			Enumeration<String> keys = (Enumeration<String>) prop.propertyNames();
			Iterator<Object> keyIter = prop.keySet().iterator();
			Collection<Object> values = prop.values();
			
			Student[] st = new Student[prop.size()];
			for (int i=0; keyIter.hasNext(); i++){			
				String key = (String) keyIter.next();
				String value = prop.getProperty(key);
				String[] fields = value.split(",");
				st[i] = new Student(Integer.parseInt(fields[0]), fields[1], Integer.parseInt(fields[2]), Integer.parseInt(fields[3]), Integer.parseInt(fields[4]));
			}
			return st;

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			return null;
		} 
	}


	public void printConsole(Student[] sr) {
		int kTot=0, eTot=0, mTot=0;

		for (int i=0; i<sr.length; i++){
			System.out.println(sr[i]);
			kTot += sr[i].getKor();
			eTot += sr[i].getEng();
			mTot += sr[i].getMat();
		}

		System.out.println("국어점수 합계 : " + kTot + "\t평균 점수 : " + kTot/sr.length);
		System.out.println("영어점수 합계 : " + eTot + "\t평균 점수 : " + eTot/sr.length);
		System.out.println("수학점수 합계 : " + mTot + "\t평균 점수 : " + mTot/sr.length);
	}


	public void saveXMLFile(Student[] sr) {
		Properties prop = new Properties();
		for (Student st : sr) {
			prop.setProperty(Integer.toString(st.getSno()), st.getSno() + "," + st.getSname()  + "," + st.getKor()  + "," +  st.getEng()  + "," +  st.getMat() + "," + st.getTot()  + "," +  st.getAvg());
		}
		
		try {
			prop.storeToXML(new FileOutputStream("student.xml"), "score.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}