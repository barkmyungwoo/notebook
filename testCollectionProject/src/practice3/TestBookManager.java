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
				bm.putBook(new Book("0006", 3, "DB", "안재성"));
				bm.putBook(new Book("0003", 2, "jdbc", "이재훈"));
				bm.putBook(new Book("0001", 1, "java", "박명우"));
				bm.putBook(new Book("0002", 2, "oracle", "박제언"));
				bm.putBook(new Book("0005", 4, "html", "유재영"));
				bm.putBook(new Book("0004", 3, "javascript", "나상민"));
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
				System.out.print("삭제시킬 책 :");
				str = "";
				str = sc.next();
				bm.removeBook(str);
				System.out.println();
				break;

			case 4:
				System.out.print("찾고 싶은 책 :");
				str = "";
				str = sc.next();
				
				str = bm.searchBook(str);
				
				if(str==null){
					System.out.println("책 없음");
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

		System.out.print("도서 번호 : ");
		num = sc.next();
		System.out.print("도서 분류 : ");
		category = sc.nextInt();
		System.out.print("도서명 : ");
		title = sc.next();
		System.out.print("작가 : ");
		author = sc.next();

		Book book = new Book(num, category, title, author);

		return book;
	}

}
