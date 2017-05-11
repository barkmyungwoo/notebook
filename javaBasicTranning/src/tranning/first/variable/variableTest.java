package tranning.first.variable;

public class variableTest {

	public static void main(String[] args) {

		// 변수 선언
		boolean y;
		byte b;
		short s;
		int i;
		long l;

		float f;
		double d;

		char c;
		String st;

		// 변수 초기화 <- 메소드(함수) 안에서 이거 안하면 출력 안댐.
		
		// System.out.println(a);
		// System.out.println(b);
		// System.out.println(s);
		// System.out.println(c); 					//함 해 봐~ 되는지!?!?
		
		
		//대입 하는 법! 변수 이름(왼쪽) = 들어갈 값(오른쪽)
		y = true; 									// or false;
		b = 1;
		s = 2;
		i = 4;
		l = 8L;										//단어 뒤에 대문자 L

		f = 4f;										//단어 뒤에 소문자 f
		d = 8.000011;
		c = '2';									// 이건 숫자 이가 아님 단어 '2' 임.
		st = "input word";
		
		System.out.println(y);						//System.out.println는 화면에 출력!!!출!력! 해주는 역할.
		System.out.println(b);						//한줄씩 출력 
		System.out.println(s);
		System.out.println(i);
		System.out.println(l);

		System.out.println();						//자체 만으로도 한줄 띄어쓰기 가능.

		System.out.print(y);						//System.out.print는 화면에 출력!!!출!력! 해주는 역할.
		System.out.print(b);						//출력물 옆에 출력
		System.out.print(s);
		System.out.print(i);
		System.out.print(l);

		System.out.println();
		System.out.println();
		
		System.out.printf("%.5f",d);				//소수점 자릿수 처리방법!!!!! 이건 걍 외워. 귀찮아.
		
		System.out.println();
		System.out.println();
		
		//여러가지 사용방법!!!!
		System.out.println(i+i);							//int+int 		4+4 -> 8 이 출력
		System.out.println(b+s);							//byte+short 	1+2 -> 3 이 출력 (형 변환 short?? 이건 나도..;;)
		System.out.println(i+f);							//int+float		4+4.0 ->8 출력 (형 변환 float)
		
		// 따라서 숫자와 숫자의 연산은 값의 결과값이 출력.
				
		//System.out.println(y+i);							//일단 boolean은 더하는거 안대.

		System.out.println(c+i);							//char+int		char이 유니코드값 50으로 변환 후 숫자끼리 더한 값 출력 54.

		c=(char)((int)c+i);									//1. c를 강제 유니코드로 변환	2. 숫자 2를 더함.	3. 합한 값을 유니코드로 이용해서 다시 char형태로 만듬. ->  
		System.out.println(c);								//6 출력.(unicode : 54),  덧셈 전 값 = 2 (unicode : 50)
		
		System.out.println(st+i);							//string+int 는 숫자가 강제 형 변환으로 문자화 되어서 인식 ->	input word4 출력

		System.out.println(s+i+c+b+st);						//다 섞을 경우	1. short + int 				= (int)		6, 
															//  		2. 6 + char(unicode : 54) 	= (int)		60, 
															//			3. 60+byte 					= (int)		61 
															//			4. 61 + string 				= (String)	61input world 

															//			따라서 String 이 짱임. 레퍼런스 즉, 참조 변수임~
		
	}

}