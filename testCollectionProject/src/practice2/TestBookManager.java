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
				Book book = inputBook();						// inputBook()에서 반환한 값 선언된 book에 저장	
				bm.addBook(book);								// ArrayList에 저장
				break;

			case 2:
				Book[] bookArray = bm.sortedBookList();			// bookArray를 선언과 동시에 정렬된 Book배열 반환 받차 저장
				bm.printBookList(bookArray);					// bookArray를 전송 출력. 매개변수 있음!!!
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

				index = bm.searchBook(str);						// 검색어를 String 형으로 매개변수로 전송해서 그 위치값을 int로 받아서 저장.

				if(index==-1)									// 책이 없을 때. -1을 반환 받음.
					System.out.println("그런 책 없다.");
				else
					bm.printBook(index);						// 반환값을 매개변수로 이용 전달하여 출력.
				
				break;

			case 5:
				bm.displayAll();								// 매개 변수가 없다!!!! BookManager 안에서 ArrayList를 이용 출력됨.
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
