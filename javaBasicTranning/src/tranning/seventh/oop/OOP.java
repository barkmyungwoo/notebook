package tranning.seventh.oop;

public class OOP {															// Oriented Operating Programming	
																			// 객체지향프로그래밍 이야 외워. 반대는 절차지향. 영어는 니가 찾아.

	public static void main(String[] args) {
		new OOP().oopProgram();												//메인이 static 라서 다른 메소드 들을 heap 영역에서 운영하려면 new 선언 해 줘야 한다.
	}
	
	public void oopProgram(){

		//절차지향.
		int a =5, b = 7;
		int c=0;
		c= a+b;																//절차지향은 직접 계산해서 값을 넣음.
		
		System.out.println("5더하기 7은 "+ c);
		
		
		
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		
		
		
		//객체지향
		c = 더하기(a, b);														// 더하기 하는 기능을 따로 메소드로 넘겨서 계산한 값을 받음. 
		출력하기(c);															// 알아보기 편하라고 메소드 이름을 한글로 했음.. 
		
	}

	
	public int 더하기(int a, int b){											// ( )안에 받아올 인자값의 형태를 명시해 줘야함.!!! 그 형태만 받을 수 있음.
		return a+b;															// 반환할 형태의 인자값 형태에 따라 메소드 선언에 형식이 달라집. 지금은 int 반환이기 때문에 public int 형임.
	}
	
	public void 출력하기(int c){
		System.out.println("5더하기 7은 "+ c);						
	}
	
	// ※ 알아두기!!! 

	// class는 하나의 파일 개념!!! inner class는 나중에 다시 알아보기!

	
	// 함수 또는 메소드라고 불리우는 기능!! 머... 
	// public, private, default, 는 이 함수의 접근에 관련해서 권한이고.
	// 그 다음에 int, void String는 반환(return )할때 그 값의 형태에 따라 결정되는 값.
	// 되도록 카멜기법(대소문자 구분)에 맞춰 작성하고 그 기능에 맞게만 설계!!!! 
	// 한가지 메소드에서 여러가지 기능은 안됨!!! 한가지 기능씩! 
	
	
	// 인자값!!  [public viod 메소드(인자값!!)] 저 안 ( ) 안에 들어가는 값이 인자값입니다!!!
	// 선언할 때는 당연 인자값이 어떤형태로 받아야 할지 정해야 하기 때문에 변수 형태를 int 다~ String 이다 알려줘서 선언 해야하고!
	//사용 할 때는 선언이 필요없이 같은 형태의 변수명만 입력해서 사용 하면 됩니다.!!!!!
	
	
	//return 반환!!!
	//반환 형태에 따라 메소드의 이름 형태가 달라짐. 
	//void 의 경우 return 을 사용 안해도 됨. ok?? 그러나 반환이 있다면 반드시 같은 형태에 반환문을 써 줘야 함. 
	
	
	//OOP2 에서 계속...
	
	
}
