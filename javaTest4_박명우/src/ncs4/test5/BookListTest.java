package ncs4.test5;

import java.io.*;

import java.util.*;

public class BookListTest {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		BookListTest test5 = new BookListTest();
		ArrayList<Book> list = new ArrayList<Book>();

		test5.storeList(list);

		test5.saveFile(list);

		 List<Book> booksList = test5.loadFile();

		test5.printList(booksList);
	}

	public void storeList(List<Book> list) {
		list.add(new Book("자바의 정석", "남궁성", 30000, "도우출판", 15));
		list.add(new Book("열혈강의 자바", "구정은", 29000, "프리렉", 20));
		list.add(new Book("객체지향 JAVA8", "금영욱", 30000, "북스홈", 10));

		// Book 객체를 3개 생성하여 리스트에 넣는다.
	}

	public void saveFile(List<Book> list) throws FileNotFoundException, IOException {
		String fileName = "books.dat";
		try {
			ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(fileName));
			objOut.writeObject(list);
			objOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Book> loadFile() {
		// books.dat 파일로부터 객체들을 읽어서 리스트에 담는다.
		
		List<Book> book = null;
		try {
			ObjectInputStream objIn = new ObjectInputStream(new FileInputStream("books.dat"));
			book = (List<Book>)objIn.readObject();
		} catch (Exception e) {
		}
		return book;
	}

	public void printList(List<Book> list) {
		for (Book book : list) {
			System.out.println(book);
			System.out.printf("할인된 가격 :  %.0f 원", (book.getPrice() - (book.getPrice() * book.getDiscountRate() / 100)));
			System.out.println();
		}
	}
}