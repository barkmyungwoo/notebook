package practice2;

import java.util.*;

public class TestBookManager {
	private Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		TestBookManager bm = new TestBookManager();
		bm.menu();
	}

	public void menu() {

		BookManager bm = new BookManager();
		int name, index = 0;
		
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
				Book book = inputBook();						// inputBook()���� ��ȯ�� �� ����� book�� ����	
				bm.addBook(book);								// ArrayList�� ����
				break;

			case 2:
				Book[] bookArray = bm.sortedBookList();			// bookArray�� ����� ���ÿ� ���ĵ� Book�迭 ��ȯ ���� ����
				bm.printBookList(bookArray);					// bookArray�� ���� ���. �Ű����� ����!!!
				break;

			case 3:
				System.out.print("������ ���� ��ȣ�� �Է��� �ּ��� : ");
				index = sc.nextInt();
				bm.deleteBook(index);							
				break;

			case 4:
				String str = "";
				System.out.print("�˻��� �������� �Է��� �ּ��� : ");
				sc.nextLine();
				str = sc.nextLine();

				index = bm.searchBook(str);						// �˻�� String ������ �Ű������� �����ؼ� �� ��ġ���� int�� �޾Ƽ� ����.

				if(index==-1)									// å�� ���� ��. -1�� ��ȯ ����.
					System.out.println("�׷� å ����.");
				else
					bm.printBook(index);						// ��ȯ���� �Ű������� �̿� �����Ͽ� ���.
				
				break;

			case 5:
				bm.displayAll();								// �Ű� ������ ����!!!! BookManager �ȿ��� ArrayList�� �̿� ��µ�.
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
