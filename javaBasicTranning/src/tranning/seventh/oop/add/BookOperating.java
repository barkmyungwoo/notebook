package tranning.seventh.oop.add;

public class BookOperating {
	Book 책 = new Book();												// 같은 패키지 안에 있어서 따로 임포트 안해도 됨. 
	Book 자서전 = new Book("명우의 삶", "박명우",20000, 1985, 9-1, 23);			// 오버로딩
	Book[] 대백과_사전 = new Book[10];										// 배열이용
	
	
	public void 책_가격변경(int a){
		책.set가격(a);
		System.out.println("가격이 변경이됐네?!!");
	}
	
	public void 출력하기(){
		System.out.println(책.toString());
		System.out.println(자서전.toString());
		for(int i=0; i<대백과_사전.length;i++){
			대백과_사전[i] = new Book();
			System.out.println(대백과_사전[i].toString());
		}
	}
}
