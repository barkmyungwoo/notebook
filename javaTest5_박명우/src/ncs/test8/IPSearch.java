package ncs.test8;

import java.net.InetAddress;
import java.util.Scanner;

public class IPSearch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a;
		System.out.println("ȣ��Ʈ�� �Ǵ� �����θ��� �Է��ϼ��� : ");
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
