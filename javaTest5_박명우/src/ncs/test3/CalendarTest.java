package ncs.test3;

import java.text.SimpleDateFormat;
import java.util.*;

public class CalendarTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int year, month, day;
		Calendar cal;
		SimpleDateFormat sd=new SimpleDateFormat("Y'년 'M'월 'd'일 'EEEE'입니다.'");

		System.out.println("날짜를 입력하세요.");
		System.out.print("년 : ");
		year = sc.nextInt();
		System.out.print("월 : ");
		month = sc.nextInt();
		System.out.print("일 : ");
		day = sc.nextInt();

		cal = new GregorianCalendar(year, month-1, day);

		System.out.println("입력된 날짜 정보는 아래와 같습니다.");

		
		System.out.println(sd.format(cal.getTime()));

		if (year % 4 == 0)
			if (year % 100 != 0)
				System.out.println(year + "년은 윤년입니다.");
			else if (year % 400 == 0)
				System.out.println(year + "년은 윤년입니다.");
			else
				System.out.println(year + "년은 평년입니다.");
		else
			System.out.println(year + "년은 평년입니다.");
	}
}
