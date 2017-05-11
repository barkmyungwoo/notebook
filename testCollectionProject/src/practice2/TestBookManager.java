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
		// al.add(new Book("0001", 1, "java 공부하기", "박명우"));
		// al.add(new Book("0002", 2, "oracle 공부하기", "박제언"));
		// al.add(new Book("0003", 2, "jdbc 공부하기", "이재훈"));
		// al.add(new Book("0004", 3, "javascript 공부하기", "나상민"));
		// al.add(new Book("0005", 4, "html 공부하기", "유재영"));
		// al.add(new Book("0006", 3, "DB 공부하기", "안재성"));

		do {
			System.out.println("*** 도서 관리 프로그램 ***");

			System.out.println("1. 새 도서 추가");
			System.out.println("2. 도서정보 정렬후 출력"); 
			System.out.println("3. 도서 삭제"); 
			System.out.println("4. 도서 검색출력");
			System.out.println("5. 전체 출력");
			System.out.println("6. 끝내기");
			System.out.print("메뉴 선택 :");
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

		System.out.print("도서 번호 : ");
		num = sc.next();
		System.out.print("도서 분류 : ");
		num = sc.next();
		System.out.print("도서명 : ");
		num = sc.next();
		System.out.print("작가 : ");
		num = sc.next();

		Book book = new Book(num, type, title, author);

		return book;
	}

}
