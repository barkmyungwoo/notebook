package game.typing;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TypingGame {

	public static void main(String[] args) {
		new TypingGame().start();
	}

	public void start() {
		String fileName = "sentence.dat";
		String str = null;
		String str2 = null;
		int line;
		long start=0, end = 0;
		Scanner sc = new Scanner(System.in);

		try (BufferedReader fi = new BufferedReader(new FileReader(fileName));) { 						// 파일 불러오기.
			line = (int) (Math.random() * 55 + 1);														//문장 랜덤 선택하기

			for (int i = 0; i < line; i++) {
				str = fi.readLine();
			}

			System.out.println(str);
			start = System.currentTimeMillis();

			while (true) {
				str2 = sc.nextLine();

				if (str.equals(str2)) {
					System.out.println("정답! 축하.");
					end = System.currentTimeMillis();
					break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("경과 시간 : " +(end - start)/1000+"초 "+(end-start)%1000);
		}
	}
}