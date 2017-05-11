package practice2;

import java.util.ArrayList;
import java.util.Scanner;

import test.list.Person;

public class TestBookManager {
	private Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		TestBookManager bm = new TestBookManager();
		bm.menu();
	}

	public void menu() {

		BookManager bm = new BookManager();
		int name, index = 0;
		Book book;

		Book[] bookArray;
		// al.add(new Book("0001", 1, "java �����ϱ�", "�ڸ��"));
		// al.add(new Book("0002", 2, "oracle �����ϱ�", "������"));
		// al.add(new Book("0003", 2, "jdbc �����ϱ�", "������"));
		// al.add(new Book("0004", 3, "javascript �����ϱ�", "�����"));
		// al.add(new Book("0005", 4, "html �����ϱ�", "���翵"));
		// al.add(new Book("0006", 3, "DB �����ϱ�", "���缺"));

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
				book = inputBook();
				bm.addBook(book);
				break;

			case 2:
				bookArray = bm.sortedBookList();
				bm.printBookList(bookArray);
				break;

			case 3:
				bm.deleteBook(index);
				break;

			case 4:
				String str = "";
				str = sc.next();
				index = bm.searchBook(str);
				bm.printBook(index);
				break;

			case 5:
				bm.displayAll();
				break;

			case 6: 
				break;
			default:
			}
		} while (true);

	}

	public Book inputBook() {
		String num = "";
		String title = "";
		int type = 0;
		String author = "";

		System.out.print("���� ��ȣ : ");
		num = sc.next();
		System.out.print("���� �з� : ");
		num = sc.next();
		System.out.print("������ : ");
		num = sc.next();
		System.out.print("�۰� : ");
		num = sc.next();

		Book book = new Book(num, type, title, author);

		return book;
	}

}
