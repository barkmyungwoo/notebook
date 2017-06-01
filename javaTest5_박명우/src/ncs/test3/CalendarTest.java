package ncs.test3;

import java.text.SimpleDateFormat;
import java.util.*;

public class CalendarTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int year, month, day;
		Calendar cal;
		SimpleDateFormat sd=new SimpleDateFormat("Y'�� 'M'�� 'd'�� 'EEEE'�Դϴ�.'");

		System.out.println("��¥�� �Է��ϼ���.");
		System.out.print("�� : ");
		year = sc.nextInt();
		System.out.print("�� : ");
		month = sc.nextInt();
		System.out.print("�� : ");
		day = sc.nextInt();

		cal = new GregorianCalendar(year, month-1, day);

		System.out.println("�Էµ� ��¥ ������ �Ʒ��� �����ϴ�.");

		
		System.out.println(sd.format(cal.getTime()));

		if (year % 4 == 0)
			if (year % 100 != 0)
				System.out.println(year + "���� �����Դϴ�.");
			else if (year % 400 == 0)
				System.out.println(year + "���� �����Դϴ�.");
			else
				System.out.println(year + "���� ����Դϴ�.");
		else
			System.out.println(year + "���� ����Դϴ�.");
	}
}
