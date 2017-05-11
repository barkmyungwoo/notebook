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
				Book book = inputBook();
				bm.addBook(book);
				break;

			case 2:
				Book[] bookArray = bm.sortedBookList();
				bm.printBookList(bookArray);
				break;

			case 3:
				System.out.print("삭제할 도서 번호를 입력해 주세요 : ");
				index = sc.nextInt();
				bm.deleteBook(index);
				break;

			case 4:
				String str = "";
				System.out.print("검색할 도서명을 입력해 주세요 : ");
				sc.nextLine();
				str = sc.nextLine();

				index = bm.searchBook(str);

				if(index==-1)
					System.out.println("그런 책 없다.");
				else
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
