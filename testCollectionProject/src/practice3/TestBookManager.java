package practice3;

import java.util.ArrayList;
import java.util.Scanner;

import test.list.Person;
import practice2.*;

public class TestBookManager {
	private Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		TestBookManager bm = new TestBookManager();
		bm.menu();
	}

	public void menu() {

		BookManagerMap bm = new BookManagerMap();
		int name, index = 0;
		Book book;
		String str = "";
		Book[] bookArray;

		do {
			System.out.println("*** ���� ���� ���α׷� ***");

			System.out.println("1. �� ���� �߰�");
			System.out.println("2. �������� ������ ���"); 
			System.out.println("3. ���� ����"); 
			System.out.println("4. ���� �˻����");
			System.out.println("5. ��ü ���");
			System.out.println("6. ������");
			System.out.print("�޴� ���� :");
			name = sc.nextInt();

			switch (name) {

			case 1:
				bm.putBook(new Book("0006", 3, "DB", "���缺"));
				bm.putBook(new Book("0003", 2, "jdbc", "������"));
				bm.putBook(new Book("0001", 1, "java", "�ڸ��"));
				bm.putBook(new Book("0002", 2, "oracle", "������"));
				bm.putBook(new Book("0005", 4, "html", "���翵"));
				bm.putBook(new Book("0004", 3, "javascript", "�����"));
				System.out.println();

//				book = inputBook();
//				bm.putBook(book);
				break;

			case 2:
				bookArray = bm.sortedBookMap();
				bm.printBookMap(bookArray);
				System.out.println();
				break;

			case 3:
				System.out.print("������ų å :");
				str = "";
				str = sc.next();
				bm.removeBook(str);
				System.out.println();
				break;

			case 4:
				System.out.print("ã�� ���� å :");
				str = "";
				str = sc.next();
				
				str = bm.searchBook(str);
				
				if(str==null){
					System.out.println("å ����");
					break;
				}
				
				bm.printBook(str);
				System.out.println();
				break;

			case 5:
				bm.displayAll();
				System.out.println();
				break;

			case 6: System.exit(0);
				break;
			default:
			}
		} while (true);

	}

	public Book inputBook() {
		String num = "";
		String title = "";
		int category = 0;
		String author = "";

		System.out.print("���� ��ȣ : ");
		num = sc.next();
		System.out.print("���� �з� : ");
		category = sc.nextInt();
		System.out.print("������ : ");
		title = sc.next();
		System.out.print("�۰� : ");
		author = sc.next();

		Book book = new Book(num, category, title, author);

		return book;
	}

}
