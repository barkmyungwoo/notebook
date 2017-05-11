package tranning.fourth.loop1;

public class LoopFor {

	public static void main(String[] args) {

		//-----------------------------------------for 젠장!!!! -------------------------------------------------	
		
		int i=0;

		
		//반복문	기초 1										//사용가능!! 벗 무한 루프
//		for(   ;   ;   ){									//(정의 int i=0 <- 바로 써야 해서 초기화 해 줘야함 ; 조건문. 참이면 다음 증가감산 과 {중가로} 실행. ; 증가 또는 감산식 하는 곳.)
//			System.out.println("꺄~~~~~~~ 무한루프 1");			//이거 실행하면 안대!! 이대로 돌아감무한 루프!!!!!!!!
//		}													//내부에 조건,증가 감산 해주면 사용 가능. 단 정의는 외부!!! 

		
		for(  ;  ;  ){
			System.out.println("기초문 반복");

			if(i<10) i++;
			else 	break;

		}
		i=0;												//재사용을 위해 초기화 0
		
		
		//반복문 기초 2											//사용가능!! 벗 무한 루프
//		for(   ;i<10;   ){									//조건문 대입시 돌아감. 대신 조건에 따로 처리가 안돼서 나오질 못함
//			
//			System.out.println("꺄~~~~~~~ 무한루프 2");			//실행하면 안대!!!!!!!!!
//		}													//내부에 증가 감산 해주면 사용 가능.
		

		
		
		
		
		
		
		//반복문 기초 3
		for(   ;i<10;i++){									//조건문과 증가 감산 문 입력!!!! 이젠 조건에 따라 for 문에서 탈출 가능 정의는 밖에서 해 줘도 됨.
			System.out.println(" 돈다 돌아~");	
		}


		System.out.println();
		System.out.println();
		System.out.println();
		
		
		//반복문 기초3 응용
		i=0;
		for(   ;i<10;   ){									//조건문과 증가 감산 문 입력!!!! 이젠 조건에 따라 for 문에서 탈출 가능 정의는 밖에서 해 줘도 됨.	
			System.out.println("또 돈다 돌아~");					
			i++;											//가로안에 넣는게 아니라 내부에 넣음.
		}

		
		System.out.println();
		System.out.println();
		System.out.println();

		
//-----------------------------------------------------------------------------------------------------------------------------------		
		
		
		//응용1.
		i = 0;
		for(;;i++){
			if(i<10)										//가로 안에 넣는대신 내부에서 if-else를 이용해서 stop 기능을 줌.
				System.out.println(i+"여기는 응용루프");
			else
				break;										// 프로그램을 종료할 경우 return 으로도 가능함.
		}

		

		System.out.println();
		System.out.println();
		System.out.println();

		
		//응용2.
		i = 0;
		for(;;){

			if(i<10){										
				System.out.println(i+"여기는 응용루프");
				i++;
			}												//내부에 증가연산
			else{
				break;
			}
				//i++										//if 안에서 빼서 여기에 넣어도 됨. 
		}
		

		System.out.println();
		System.out.println();
		System.out.println();

		
//-----------------------------------------------------------------------------------------------------------------------------------		
		
		
		//반복문 기본형
		for(int j=0;j<20;j++){								//반복문 0~19까지 20번 반복해서 실행 됨.			
			System.out.println(j + "	기본문");				
		}													//이 for 문을 빠져나오면서 j는 변수 메모리에서 삭제 됨!!	
		
		
		System.out.println();
		System.out.println();
		System.out.println();

		
		//반복문 리버스!!
		for(int j=20;j>0;j--){								//반복문 20~1까지 20번 반복해서 실행 됨.			
			System.out.println(j + "	역방향");				
		}


		System.out.println();
		System.out.println();
		System.out.println();
		

//-----------------------------------------------------------------------------------------------------------------------------------		
		
		
		//반복문 응용 1.
		for(int j=0;j<10;j+=2){								//2씩 증가 연산. 홀수나 짝수 출력 또는 홀수나 짝수 덧셈에 필요. j=1 부터면 홀수 j=0부터면 짝수!			
			System.out.println(j + "	2씩 증가.");			//
		}
		
		
		System.out.println();
		System.out.println();
		System.out.println();

		
		//같은 내용. 
		for(int j=1;j<10;j=j+2){							//대입 연산자 풀어서 씀.			
			System.out.println(j + "	2씩 증가.");			
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		//같은 내용. 
		for(int j=0;j<10;j++){							// 증가 연산을 2번으로 나눠서 함. +1			
			System.out.println(j + "	2씩 증가.");			//
			j++;											// 증가 연산 +1
		}
		
		//	※ 증가 연산 방법은 여러가지 자기가 여러가지 형태로 응용해서 여러가지 용도로 사용가능. if-else 문 관련 추가 사항은 뒤에 다룸.
		//for(){} 문의 형태를 보면 이것도 일종의 메소드임. ()안에 매게변수 선언해서 {} 안에 내용 실행이니까 .
		//거의 우리가 쓰는 모든 함수 기능 들은 다 [스태틱] 메소드라고 생각 하믄 됨. new 선언 안하고도 다~~~ 쓸 수 있으니까!
		
		
		
		System.out.println();
		System.out.println();
		System.out.println();
		
//-----------------------------------------------------------------------------------------------------------------------------------		

		
		
		
		
		// 이중 for문.						
		for(int a=0; a<5; a++){									//밖	for문	안쪽 for가 5번 실행해야 한번 실행.
			System.out.println("밖 for 실행 " + a);

			for (int b = 0; b < 5; b++) {
				System.out.println("		안 for 실행 " + b);	//안쪽 for문 	바깥 for문 * 안쪽 for문 번 실행 a=5, b=5 a*b = 25번 실행
			}
		}

		
		System.out.println();
		System.out.println("이중 for문 가장 많이 쓰이는 형태");
		System.out.println();
		
		
		// 이중 for문.다른형태!!! 가장 많이 쓰임.						
		for(int a=0; a<5; a++){									

			for (int b = 0; b < 5; b++) {
				System.out.println("		안 for 실행 " + b);	
			}

			System.out.println("밖 for 실행 " + a);				//윗 부분에서 아래로 이동 안에 for 문이 실행 된 후 출력 
		}
		
		
		System.out.println();
		System.out.println();
		System.out.println("중요 응용!!!");
		System.out.println();
		
		
		// 이중 for문 응용.	a행 b열 출력 		중요!!!!!!!			
		for(int a=0; a<5; a++){									

			for (int b = 0; b < 5; b++) {
				System.out.print("안 ");							//print 사용!!!!!!!!!! 한줄 바꿈이 아니라 옆으로 출력됨.
			}

			System.out.println("밖" + a);						//'밖' 이라는 부분이 어디서 출력 되는지 꼭!!! 확인!!! 
		}														// 출력되는 순서가 실행되는 순서임.

		
		System.out.println();
		System.out.println();
		System.out.println("중요 응용2!!!");
		System.out.println();
		
		
		// 이중 for문 응용.	삼각형 출력!!!!			
		for(int a=0; a<5; a++){									
			for (int b = a; b < 5; b++) {						// 정의문에서!!! b = a 적용시 왜 이렇게 출력 되는지 확인!!! 생각 생각 생각!!! 안되면 종이에 그려서 이해하기! 
				System.out.print("안 ");							
			}
			System.out.println("밖" + a);						 
		}														
		

		
		System.out.println();
		System.out.println();
		System.out.println("중요 응용3!!!");
		System.out.println();
		
		
		// 이중 for문 응용.	삼각형 출력!!!!			
		for(int a = 0 ; a < 5 ; a++){									
			for (int b = 0; b < a; b++) {						// 조건문에서 !!! b < a 적용시 왜 이렇게 출력 되는지 확인!!! 생각 생각 생각!!! 안되면 종이에 그려서 이해하기! 
				System.out.print("안 ");							
			}
			System.out.println("밖" + a);						 
		}														
		
		
		
		System.out.println();
		System.out.println();
		System.out.println("중요 응용4!!!");
		System.out.println();
		
		
		// 이중 for문 응용.	삼각형 출력!!!!			
		for(int a=1; a<10; a+=2){								//정의문 a=1, 조건문 a<10 으로 늘렸음!!! 2씩 증가시킴!!!!!!
			for (int b = 0 ; b < a ; b++) {						//이게 왜 이런 형태가 나타나는지 반드시 기억!!!!!!!
				System.out.print("안 ");							
			}
			System.out.println("밖" + a);						 
		}														
		
		// 	과제) 응용 4. 역으로 출력하는 for문 만들기.	
		//	!!!!!!!! 만들라고! 만들어!!!!!!
		//될 수있는 한 모든 숫자를 응용하고 변형해서 여러가지 형태로 출력 해 보기. 
		//머리 속으로  for문을 계속 돌려보는 연습을 해야함. 반드시 이해하기!! 왜 이런 방식으로 구동되는지!!!
		//강사님의 과제들 다시한번 풀어보기.
		
	}

}
