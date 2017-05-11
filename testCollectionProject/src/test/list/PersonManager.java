package test.list;

import java.util.*;

public class PersonManager {
	private Scanner sc = new Scanner(System.in);
	private ArrayList pl = new ArrayList();

	public PersonManager() {
	}

	public void addPerson() {
//		do {
//			System.out.print("이름(exit는 종료) : ");
//			String name = sc.next();
//			if (name.equals("exit") == true)
//				break;
//			System.out.print("나이 : ");
//			int age = sc.nextInt();
//			System.out.print("포인트 : ");
//			double point = sc.nextDouble();
//			pl.add(new Person(name, age, point));
//		} while (true);
		
		pl.add(new Person("박명우", 33, 47.5));
		pl.add(new Person("박제언", 30, 67.5));
		pl.add(new Person("이재훈", 27, 4.5));
		pl.add(new Person("김태희", 35, 40));

		System.out.println("\n" + pl.size() + "명 정보 입력");

	}

	public void printPerson() {
		for (Object object : pl) {
			System.out.println(object);
		}
	}

	public void printPersonList() {
	}

	public void ascendingName() {
		pl.sort(new PersonNameAsc());
	}

	public void descendingName() {
		pl.sort(new PersonNameDesc());
		
	}

	public void ascendingPoint() {
		pl.sort(new PersonPointAsc());
	}

	public void descendingPoint() {
		pl.sort(new PersonPointDesc());
	}

}
