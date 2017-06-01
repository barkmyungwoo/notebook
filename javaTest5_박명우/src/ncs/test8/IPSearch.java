package ncs.test8;

import java.net.InetAddress;
import java.util.Scanner;

public class IPSearch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a;
		System.out.println("호스트명 또는 도메인명을 입력하세요 : ");
		a = sc.next() + sc.nextLine();
		try {
			InetAddress[] ia = InetAddress.getAllByName(a);
			for (int i = 0; i < ia.length; i++) {
				System.out.println(ia[i].getHostAddress());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
