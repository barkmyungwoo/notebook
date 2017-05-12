package board.controller;

import java.io.*;
import java.util.*;

import board.model.vo.*;

public class BoardManager {
	ArrayList<Board> list = new ArrayList<Board>();
	Scanner sc = new Scanner(System.in);
	private int num =0;

	public BoardManager() {
		try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream("board_list.dat"));) {
			while (true) {
				list.add((Board)oi.readObject());
				num++;
			}
		} catch (EOFException e) {
			System.out.println("board_list.dat �б� �Ϸ�.");			
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
	}
	// �޼ҵ� �ۼ�
	// 1. �Խñ� ���� �޼ҵ�
	public void writeBoard() {
		String title, writer, contents = null;
		String str = "";
		Date now = new Date();

		System.out.println("�� �Խñ� ���� �Դϴ�.");
		System.out.println("�� ���� :");
		title = sc.next()+sc.nextLine();
		System.out.println("�ۼ���  :");
		writer = sc.nextLine();
		System.out.println("�� ���� :");

		while (true) {
			str = sc.nextLine();

			if (str.equals("exit")) {
				break;
			}

			contents += str;
		}
		list.add(new Board(num, title, writer, now, contents, 0));
		num++;

		// >> ��������
		// 1> "�� �Խñ� ���� �Դϴ�." ���
		// 2> "������ : " >> �Է¹���(��������)
		// 3> "�ۼ��� : " >> �̸� �Է¹��� (�������)
		// 4> �ۼ���¥�� ���� ��¥�� �Է�ó����
		// 5> "�۳��� : " >> ���� �ٷ� �Է¹���
		// "exit" �Է��ϸ� �Է�����
		// 6> Board ��ü ������ �ʱⰪ���� �����
		// 7> list�� �߰���
	}

	// 2. �Խñ� ��ü ���� �޼ҵ�
	public void displayAllList() {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		// >> ��������
		// 1> list �� ��ϵ� ������ ��� ȭ�鿡 ��½�Ŵ
	}

	// 3. �Խñ� �Ѱ� ���� �޼ҵ�
	public void displayBoard() {
		System.out.print("��ȸ�� �۹�ȣ : ");
		int index = sc.nextInt();
		list.get(index).setReadCount(list.get(index).getReadCount() + 1);
		System.out.println(list.get(index));

		// >> ��������
		// 1> "��ȸ�� �۹�ȣ : " >> �Է¹���
		// 2> �ش� �۹�ȣ�� ���� �Խñ��� ȭ�鿡 ��½�Ŵ
		// 3> �ش� �ۿ� ���� ��ȸ�� 1���� ó����
	}

	// 4. �Խñ� ���� ���� �޼ҵ�
	public void modifyTitle() {
		System.out.print("������ �۹�ȣ : ");
		int index = sc.nextInt();
		System.out.println(list.get(index));
		System.out.print("������ ���� : ");
		sc.nextLine();
		String str = sc.nextLine();
		list.get(index).setBoardTitle(str);

		// >> ��������
		// 1> "������ �۹�ȣ : " >> �Է¹���
		// 2> �ش� �۹�ȣ�� ���� �Խñ��� ȭ�鿡 ��½�Ŵ
		// 3> "������ ���� : " >> �� ���� �Է¹��� >> ���񺯰�
		// 4> ����� ��ü ������ list�� �ش� ��ȣ ��ü�� ������
	}

	// 5. �Խñ� ���� ���� �޼ҵ�
	public void modifyContent() {

		String str = "", str2 = "";
		System.out.print("������ �۹�ȣ : ");
		int index = sc.nextInt();
		System.out.println(list.get(index));
		System.out.print("������ ���� (����� exit) : ");
		while (true) {
			sc.nextLine();
			str2 = sc.nextLine();
			if (str2.equals("exit"))
				break;
			str += str2;
		}

		list.get(index).setBoardContent(str);

		// >> ��������
		// 1> "������ �۹�ȣ : " >> �Է¹���
		// 2> �ش� �۹�ȣ�� ���� �Խñ��� ȭ�鿡 ��½�Ŵ
		// 3> "������ ���� : " >> �� ���� �Է¹��� >> ���뺯��
		// 4> ����� ��ü ������ list�� �ش� ��ȣ ��ü�� ������

		// 6. �Խñ� ���� �޼ҵ�
	}
	public void deleteBoard() {
		System.out.print("������ �۹�ȣ : ");
		int index = sc.nextInt();
		System.out.print("������ �����Ͻðڽ��ϱ�? (y/n) : ");

		if (sc.next().toUpperCase().charAt(0) == 'Y') {
			list.remove(index);
			System.out.println(index + "�� ���� �����Ǿ����ϴ�.");
		}

		// >> ��������
		// 1> "������ �۹�ȣ : " >> �Է¹���
		// 2> �ش� �۹�ȣ�� ���� �Խñ��� ȭ�鿡 ��½�Ŵ
		// 3> "������ �����Ͻðڽ��ϱ�? (y/n) : "
		// >> 'Y'�Է½� list���� �ش� ��ü ������
		// 4> "oo�� ���� �����Ǿ����ϴ�." ���
	}

	// 7. �Խñ� �˻� �޼ҵ�
	public void searchBoard() {
		System.out.print("�˻��� ���� : ");
		sc.nextLine();
		String str = sc.nextLine();

		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getBoardTitle().indexOf(str)!=-1);
				System.out.println(list.get(i).toString());
		}
		
		// >> ��������
		// 1> "�˻��� ���� : " >> �˻��� ���ڸ� �Է¹���
		// 2> �Էµ� ���ڸ� �������� �����ϰ� �ִ� ��ü���� list����
		// ã��
		// 3> ȭ�鿡 �˻��� ��ü���� �����

	}

	// 8. ���Ͽ� �����ϱ� �޼ҵ�
	public void saveListFile() {
		try (ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream("board_list.dat"));) {
			for (int i = 0; i < list.size(); i++) {
				oo.writeObject((Board)list.get(i));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("board_list.dat �� ���������� ����Ǿ����ϴ�.");

		// >> ��������
		// 1> list�� ����� ������ board_list.dat ���Ͽ�
		// ObjectOutputStream Ŭ���� ����Ͽ� ��� ������
		// try with resource �� ����� ��
		// 2> "board_list.dat �� ���������� ����Ǿ����ϴ�." ���
	}

	// 9. ����ó���� �޼ҵ�
	public void sortList(int item, boolean isDesc) {
		switch (item) {
		case 1:
			if (isDesc == true) {
				list.sort(new AscBoardNo());
			} else
				list.sort(new DescBoardNo());
				
				break;
		case 2:
			if (isDesc == true) {
				list.sort(new AscBoardDate());
			} else
				list.sort(new DescBoardDate());

				break;
		case 3:
			if (isDesc == true) {
				list.sort(new AscBoardTitle());
			} else
				list.sort(new DescBoardTitle());

				break;
		default:
			break;
		}

		// >> ��������
		// 1> item �� 1�̸� ��ȣ�� ����
		// item �� 2�̸� ��¥�� ����
		// item �� 3�̸� ����� ���� �۵��ǰ� ���Ŀ� Ŭ���� �����
		// 2> isDesc �� true �̸� ������������ �۵�
		// isDesc �� false �̸� ������������ �۵��ǰ� ��
	}

}
