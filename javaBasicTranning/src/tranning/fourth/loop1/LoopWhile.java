package tranning.fourth.loop1;

import java.util.Scanner;

public class LoopWhile {

	public static void main(String[] args) {
		//while do-while 함께 설명함. 
		
		
//		while(true){													//무한 반복. 무조건 반복 메모리가 가득 찰때까지 계속반복.
//			System.out.println("키지마 키지마 키지마 키지마");
//		}

		
				
//		do{																//무한 반복. 무조건 반복 메모리가 가득 찰때까지 계속반복.
//			System.out.println("키지마 키지마 키지마 키지마");
//		}while(true);
		
		
		//선언, 조건, 제어 또는 증가 감소,
		int a=0;
		while(a <10){													// ()안에 조건문을 입력하면 따로 제어문 필요 없음. 증가감소는 필요!!! 
			System.out.println("요!!!");									// 참이면 실행 거짓이면 뛰쳐나감.
			a++;
		}

		System.out.println("끝!");
		
		
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

		
		a=0;
		do{																// 걍 { } 안에 값은 고데로 내비두고 앞에 do 붙이고 끝에 while(); 붙이면 끝!!! 
			System.out.println("예!!!");									
			a++;
		}while(a <10);
		System.out.println("끝!");
		
		
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

		

		//조건이 true 일때 break 문 사용 종료. 
		a=0;															// a 가 고생한다.
		while(true){
			if(a>10)
				break;
			
			System.out.println("와~");									//이게 몇번 반복 되는걸까?!?! 확인!!! 왜 그런지 이해하기.
			a++;
		}
		
		
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

		
		
		a=0;															// a 가 고생한다.
		do{
			if(a>10)
				break;
			
			System.out.println("췍!");									//이게 몇번 반복 되는걸까?!?! 확인!!! 왜 그런지 이해하기.
			a++;
		}while(true);
		
		
		
		//축약기능.
		
		while(new Scanner(System.in).nextInt()!=0)						//한줄만 할 땐 { } 이거 빼도 됨. 입력 받아서 비교 해버려서 1줄로도 무한 반복 가능. 0 누르면 종료.
			;
		
		System.out.println("end!");		
		//과제. for 문중에 삼각형 출력하는거 이걸로 다시 만들기 for문사용 안됨. while 문만 사용하여 만들기!!
		//tip!! 이건 나도 오늘 알았어. 만약 니가 원하는 만큼 반복문을 돌려야 할 상황이 오면 
		//일단 반복해야 할 영역을 마우스로 드래그 한 후에 		shift + alt + z 키를 누르고 선택 하면 됨!!!!!!! 해봐.
	}

}
