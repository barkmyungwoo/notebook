package client;

import java.util.*;

public class MemoryGame {

	Random r = new Random();
	Scanner sc = new Scanner(System.in);
	int count = 1;

	ArrayList alist = new ArrayList();
	ArrayList alist1 = new ArrayList();

	public String[] howTo() {
		String[] howTo = new String[] { "***** 화살표 기억 게임 *****", "W/S/A/D는 각각 위, 아래, 왼쪽, 오른쪽을 입력합니다.",
				"점점 늘어나는 화살표들의 순서를 잘 기억하세요!" };

		return howTo;

	}

	public String question(int count) {

		count++;

		alist.removeAll(alist);
		alist1.removeAll(alist1);

		// 4분의 1확률로 위, 아래, 왼쪽, 오른쪽 화살표 생성
		for (int i = 1; i < count; i++) {

			int random = r.nextInt(4) + 1;

			if (random == 1) {
				alist.add("up");
			}
			if (random == 2) {
				alist.add("down");
			}
			if (random == 3) {
				alist.add("left");
			}
			if (random == 4) {
				alist.add("right");
			}

		}

		// 4분의 1확률로 위, 아래, 왼쪽, 오른쪽 화살표 생성
		String question = null;
		for (int i = 0; i < count - 1; i++) {
			question += alist.get(i).toString()+" ";
		}

		return question;
	}

	public boolean answerCheck(String input){
		
			for (int i = 0; i < input.length(); i++) {
				if (input.charAt(i) == 'w') {
					alist1.add("up");
				}
				if (input.charAt(i) == 's') {
					alist1.add("down");
				}
				if (input.charAt(i) == 'a') {
					alist1.add("left");
				}
				if (input.charAt(i) == 'd') {
					alist1.add("right");
				}
			}

			if (alist.equals(alist1)) {
				return true;
			}
			
		return false;

	}

	// public int start() {
	// int count = 1;
	//
	// ArrayList alist = new ArrayList();
	// ArrayList alist1 = new ArrayList();
	//
	// do {
	// count++;
	//
	// alist.removeAll(alist);
	// alist1.removeAll(alist1);
	//
	// // 4분의 1확률로 위, 아래, 왼쪽, 오른쪽 화살표 생성
	// for (int i = 1; i < count; i++) {
	//
	// int random = r.nextInt(4) + 1;
	//
	// if (random == 1) {
	// alist.add("up");
	// }
	// if (random == 2) {
	// alist.add("down");
	// }
	// if (random == 3) {
	// alist.add("left");
	// }
	// if (random == 4) {
	// alist.add("right");
	// }
	//
	// }
	//
	// // 4분의 1확률로 위, 아래, 왼쪽, 오른쪽 화살표 생성
	//
	// try {
	// Thread.sleep(1000);
	// System.out.println((count - 1) + "단계 문제 : ");
	// for (int i = 0; i < count - 1; i++) {
	// System.out.printf(alist.get(i).toString() + " ");
	// Thread.sleep(1000);
	// }
	// } catch (InterruptedException e) {
	// e.printStackTrace();
	// }
	//
	// System.out.print("입력하세요");
	// String input = sc.next();
	//
	// for (int i = 0; i < input.length(); i++) {
	// if (input.charAt(i) == 'w') {
	// alist1.add("up");
	// }
	// if (input.charAt(i) == 's') {
	// alist1.add("down");
	// }
	// if (input.charAt(i) == 'a') {
	// alist1.add("left");
	// }
	// if (input.charAt(i) == 'd') {
	// alist1.add("right");
	// }
	// }
	//
	// System.out.println("\n문제 : " + alist);
	// System.out.println("내가 쓴 답 : " + alist1 + "\n");
	//
	// if (alist.equals(alist1)) {
	// try {
	// Thread.sleep(1000);
	// System.out.println("Correct!!!");
	// } catch (InterruptedException e) {
	// e.printStackTrace();
	// }
	// }
	//
	// } while (alist.equals(alist1));
	//
	// try {
	// Thread.sleep(1000);
	// System.out.println("Wrong!!!");
	// } catch (InterruptedException e) {
	// e.printStackTrace();
	// }
	//
	// System.out.println("최종 도달 단계 : " + (count - 1));
	//
	// return count - 1;
	//
	// }

}
