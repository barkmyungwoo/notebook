package practice2;

import java.util.*;

import test.list.PersonNameAsc;

public class BookManager {
	ArrayList bookList = new ArrayList();
	
	
	public void addBook(Book book) {
		bookList.add(new Book(book.getbNo(), book.getCategory(), book.getTitle(), book.getAuthor()));
	}
	
	public void deleteBook(int index){
		bookList.remove(index);
	}
	
	public int searchBook(String bTitle){
		Book[] book = (Book[]) bookList.toArray();
		
		for (int i = 0; i < book.length; i++) {
			if(book[i].getTitle().equals(bTitle)==true){
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
	
	public Book[] sortedBookList(){
		
		bookList.sort(new AscCategory());
		bookList.sort(new DescCategory());
		
		Book[] book = (Book[]) bookList.toArray();

		return book;
	}
	
	public void printBookList(Book[] br) {
		for (Book book : br) {
			System.out.println(book);
		}
	}

}
