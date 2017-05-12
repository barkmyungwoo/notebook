package board.view;

import java.util.*;

import board.controller.BoardManager;

public class BoardMenu {
	Scanner sc = new Scanner(System.in);
	BoardManager bm = new BoardManager();

	public static void main(String[] args) {
		new BoardMenu().mainMenu();
		System.out.println("���α׷� �����մϴ�. �����մϴ�.");
	}

	public void mainMenu() {
		int no;

		do {
			System.out.println("1. �Խñ� ����");
			System.out.println("2. �Խñ� ��ü ����");
			System.out.println("3. �Խñ� �Ѱ� ����");
			System.out.println("4. �Խñ� ���� ����");
			System.out.println("5. �Խñ� ���� ����");
			System.out.println("6. �Խñ� ����");
			System.out.println("7. �Խñ� �˻�");
			System.out.println("8. ���Ͽ� �����ϱ�");
			System.out.println("9. �����ϱ�");
			System.out.println("0. ������");
			System.out.print("��ȣ �Է� : ");
			no = sc.nextInt();

			switch (no) {
			case 1: bm.writeBoard();
				break;
			case 2: bm.displayAllList();
				break;
			case 3: bm.displayBoard();
				break;
			case 4: bm.modifyTitle();
				break;
			case 5: bm.modifyContent();
				break;
			case 6: bm.deleteBoard();
				break;
			case 7: bm.searchBoard();
				break;
			case 8: bm.saveListFile();
				break;
			case 9: sortSubMenu();
				break;
			case 0: System.exit(0);
				break;
			default:
			}

		} while (true);
	}
	
	public void sortSubMenu(){
		int no;

		do {
			System.out.println("1. �۹�ȣ�� ������������");
			System.out.println("2. �۹�ȣ�� ������������");
			System.out.println("3. �ۼ���¥�� ������������");
			System.out.println("4. �ۼ���¥�� ������������");
			System.out.println("5. ������� ������������");
			System.out.println("6. ������� ������������");
			System.out.println("7. ���� �޴��� �̵�");
			System.out.print("��ȣ �Է� : ");
			no = sc.nextInt();

			switch (no) {
			case 1: bm.sortList(1, false);
				break;
			case 2: bm.sortList(1, true);
				break;
			case 3: bm.sortList(2, false);
				break;
			case 4: bm.sortList(2, true);
				break;
			case 5: bm.sortList(3, false);
				break;
			case 6: bm.sortList(3, true);
				break;
			case 7: 
				return ;
			default:
			}

		} while (true);

	}
}
