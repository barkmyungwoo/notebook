package practice2;

import java.util.*;

public class BookManager {
	private ArrayList bookList = new ArrayList();
	
	public BookManager() {}

	public void addBook(Book book) { 							
		 bookList.add(new Book(book.getbNo(), book.getCategory(), book.getTitle(), book.getAuthor()));


//		bookList.add(new Book("0001", 1, "java 공부하기", "박명우"));				// 임시 초기화 파일들.
//		bookList.add(new Book("0002", 2, "oracle 공부하기", "박제언"));
//		bookList.add(new Book("0003", 2, "jdbc 공부하기", "이재훈"));
//		bookList.add(new Book("0004", 3, "javascript 공부하기", "나상민"));
//		bookList.add(new Book("0005", 4, "html 공부하기", "유재영"));
//		bookList.add(new Book("0006", 3, "DB 공부하기", "안재성"));
		 
	}

	public void deleteBook(int index) {
		bookList.remove(index);
	}

	public int searchBook(String bTitle) {
		Object[] ob = bookList.toArray();
		Book[] book = new Book[ob.length];
		
		for (int i = 0; i <book.length ; i++) {
			book[i] = (Book)ob[i];
		}

		for (int i = 0; i < book.length; i++) {
			if (book[i].getTitle().equals(bTitle) == true) {
				return i;
			}
		}

		return -1;
	}

	public void printBook(int index) {
		System.out.println(bookList.get(index));
	}

	public void displayAll() {

		for (Object object : bookList) {
			System.out.println(object);
		}

	}

	public Book[] sortedBookList() {

		bookList.sort(new AscCategory());
//		bookList.sort(new DescCategory());

		Object[] ob = bookList.toArray();
		Book[] book = new Book[ob.length];
		
		for (int i = 0; i <book.length ; i++) {
			book[i] = (Book)ob[i];
		}

		return book;
	}

	public void printBookList(Book[] br) {
		for (Book book : br) {
			System.out.println(book);
		}
	}

}
