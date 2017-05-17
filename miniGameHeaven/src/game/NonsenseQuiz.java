package game;

import java.io.*;
import java.util.Scanner;

public class NonsenseQuiz extends Thread{
public static void main(String[] args) {
	new NonsenseQuiz().start();
}

	public void start() {
		String fileName = "quiz.dat";
		String[] str = new String[2];
		String str2 = null;
		int line;
		Scanner sc = new Scanner(System.in);

		try (BufferedReader fi = new BufferedReader(new FileReader(fileName));) {
			line = (int) (Math.random() * 18 + 1); // ���� ���� �����ϱ�

			for (int i = 0; i < line; i++) {
				str = fi.readLine().split("-");
			}

			System.out.println(str[0]);

			while (true) {
				str2 = sc.nextLine();

				if (str2.equals(str[1])) {
					System.out.println("����! ����.");
					break;
				}
			}

		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		finally {
			// System.out.println("��� �ð� : " + (end - start) / 1000 + "�� " +
			// (end - start) % 1000);
		}
	}

}
