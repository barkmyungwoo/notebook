package practice3;

import java.util.*; 
import practice2.*;

public class BookManagerMap {
	private HashMap booksMap;
	// Book books = new Book();

	public BookManagerMap() {
		booksMap = new HashMap();
	}

	public BookManagerMap(HashMap booksMap) {
		this.booksMap = booksMap;
	}

	public void putBook(Book book) {
		booksMap.put(book.getbNo(), book);
	}// 맵에 객체 추가, 도서번호를 키로 사용함

	
	
	public void removeBook(String key) {
		booksMap.remove(key);
	} // 맵에서 객체 제거

	
	
	public String searchBook(String bTitle) {

//		1안 		entrySet 사용
		String key = null;
		Set ms = booksMap.entrySet();
		Iterator bi = ms.iterator();
		
		while (bi.hasNext()) {
			Map.Entry entry = (Map.Entry) bi.next();
			Book b = (Book) entry.getValue();

			if (b.getTitle().equals(bTitle) == true)
				key = (String) entry.getKey();
				break;
		}
		return key;

		
//		2안			Book 형 변환 후 사용. 
//		Object[] ob = booksMap.values().toArray();
//		Book[] ba = new Book[ob.length];
//
//		for (int i = 0; i < ba.length; i++) {
//			ba[i] = (Book)ob[i];
//			
//			if(bTitle.equals(ba[i].getTitle())){
//				return ba[i].getbNo();
//			}
//		}

//		return null;

		
//		3안
//		Iterator ks = booksMap.keySet().iterator();
//		
//		while(ks.hasNext()){
//			Object ob = ks.next();
//			if(booksMap.get(ob).equals(bTitle)){
//				return ob.toString();
//			}
//		}		
//		return null;
	}
	// entrySet() 사용
	// 도서명이 일치하는 객체의 도서번호를 리턴
	// 도서명이 객체가 맵에 없으면, null 리턴함

	
	
	
	public void displayAll() {
		Object[] ob = booksMap.values().toArray();

		for (Object object : ob) {
			System.out.println(object);
		}
	} // 맵정보 모두 출력 : keySet() 사용

	
	
	public Book[] sortedBookMap(){
		
//		1안. ArrayList sort 사용
		ArrayList al = new ArrayList(booksMap.values());
		al.sort(new AscBookTitle());
		
		Book[] ba = new Book[al.size()];
		al.toArray(ba);

		return ba;
		
//		2안. Book[] 직접 정렬 방법
		
//		Object[] ob = booksMap.values().toArray();
//		Book[] ba = new Book[ob.length];
//		Book tmp = new Book();
		
//		for (int i = 0; i < ba.length; i++) {
//			ba[i] = (Book)ob[i];
//		}
		
//		for (int i = 0; i < ba.length-1; i++) {
//			for (int j = i; j < ba.length; j++) {
//				if(ba[i].getTitle().compareTo(ba[j].getTitle())>0){
//					tmp = ba[i];
//					ba[i] = ba[j];
//					ba[j] = tmp;
//				}
//			}
//		}
//		return ba;

	}
	// 해당 도서명순으로 오름차순정렬해서 객체배열 리턴함


	
	
	public void printBookMap(Book[] br) {

		for (Book book : br) {
			System.out.println(book);
		}
	}
	// 객체 배열 출력, for each 문 사용

	
	
	
	public void printBook(String key) {
		System.out.println(booksMap.get(key));
	}
}
