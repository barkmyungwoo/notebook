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
	}// �ʿ� ��ü �߰�, ������ȣ�� Ű�� �����

	
	
	public void removeBook(String key) {
		booksMap.remove(key);
	} // �ʿ��� ��ü ����

	
	
	public String searchBook(String bTitle) {

//		1�� 		entrySet ���
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

		
//		2��			Book �� ��ȯ �� ���. 
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

		
//		3��
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
	// entrySet() ���
	// �������� ��ġ�ϴ� ��ü�� ������ȣ�� ����
	// �������� ��ü�� �ʿ� ������, null ������

	
	
	
	public void displayAll() {
		Object[] ob = booksMap.values().toArray();

		for (Object object : ob) {
			System.out.println(object);
		}
	} // ������ ��� ��� : keySet() ���

	
	
	public Book[] sortedBookMap(){
		
//		1��. ArrayList sort ���
		ArrayList al = new ArrayList(booksMap.values());
		al.sort(new AscBookTitle());
		
		Book[] ba = new Book[al.size()];
		al.toArray(ba);

		return ba;
		
//		2��. Book[] ���� ���� ���
		
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
	// �ش� ����������� �������������ؼ� ��ü�迭 ������


	
	
	public void printBookMap(Book[] br) {

		for (Book book : br) {
			System.out.println(book);
		}
	}
	// ��ü �迭 ���, for each �� ���

	
	
	
	public void printBook(String key) {
		System.out.println(booksMap.get(key));
	}
}
