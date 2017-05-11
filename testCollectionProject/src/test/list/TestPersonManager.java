package test.list;

public class TestPersonManager {
	public static void main(String[] args) {
		PersonManager pm = new PersonManager();

		pm.addPerson();
		pm.printPerson();
		System.out.println("-----------------------------------------");
		
		pm.ascendingName();
		pm.printPerson();
		System.out.println("-----------------------------------------");

		pm.descendingName();
		pm.printPerson();
		System.out.println("-----------------------------------------");

		pm.ascendingPoint();
		pm.printPerson();
		System.out.println("-----------------------------------------");

		pm.descendingPoint();
		pm.printPerson();
		System.out.println("-----------------------------------------");

	}
}
