package tranning.third.condition;

public class Condition {
//---------------------------------------조건문 if, if-else, switch-case------------------------------------
	public static void main(String[] args) {
		//if 문
		int a =7;

		if(a<10){											//조건
			System.out.println("number is "+a);				//참 이면 실행 
		}

		
		
		//if - else 문
		
		if(a<10){											//조건
			System.out.println(true);						//참이면 실행
		}
		else{												//거짓이면 실행
			System.out.println(false);
		}
		
			// 축약문
		if(a<10)											
			System.out.println(true);						
		else												
			System.out.println(false);						//실행문이 1개일 경우 
															//(; 이 1번 만 사용) {중가로}는 필요 없다.
			//응용 1.
		if(a<10)
			;						
		else												
			System.out.println(false);						//거짓일때만 조건문이 있을경우. 

			//응용 2. 
		System.out.println((a<10)? true :false);			//if - else 응용 1.과 같은 기능 syso 안에 사용가능.

		System.out.println();
		System.out.println();
		

	
		
		//if-else if 문										객관식임.

		int no=3;
		
		if(no==1){											//참일때 실행
			System.out.println("1 이다");
		}
		else if(no==2){										//위 if 가 아닐 때 
			System.out.println("2 이다");
		}
		else if(no==3){										//위 else if가 아닐 때
			System.out.println("3 이다");	
		}
		else{												//위에 모든 조건이 다 아닐 때.
			System.out.println("더 큰 숫자");
		}
		

			//축약문
		if(no==1)											
			System.out.println("1 이다");
		else if(no==2)										
			System.out.println("2 이다");
		else if(no==3)										
			System.out.println("3 이다");	
		else												
			System.out.println("더 큰 숫자");					//{중가로 다 뺌.}

		

		
		//응용 사용     ---------------------------------------------------------------

		if(0<no&&no<10){									// 식 : 0<no<10
			System.out.println(no);				
		}
		

		
		
		//응용사용 1. ---------------------------------------------------------------

		if(0<no){											// 식 : 0<no
			if(no<10){										// 식 : no<10
				System.out.println(no);								
			}
		}

		
		
		
		//응용사용 2. ---------------------------------------------------------------

		if(0<no){											// 식 : 0<no
			if(no<10){										// 식 : 0<no<10
				System.out.println(no);								
			}
			else{											//식 : 0<no, 10<=no
				
			}
		}
		else{												//식 : 0>no

		}

		System.out.println();
		System.out.println();
		System.out.println();

		//switch-case 문										// if-else if 문과 같다!
															// {중가로} 해 줄 필요가 없다.
															// break 문 나올때 까지 실행.
		
		char word = 'a';

		switch(word){
		case 'a': 	System.out.println("a choose!");		//조건이 맞으면 실행
			break;											//switch 문 밖으로 빠져 나감. 없다면 밑에 case문 실행.

		case 'b':	System.out.println("a choose!");
			break;
		
		case 'c':	System.out.println("a choose!");
			break;
		
		case 'd':	System.out.println("a choose!");
			break;	
		
		default:
		}
		
//-----------------------------------------------------------------------------------------------------------------------------		
		//switch-case 문 + if-else if 문
		
		String str = "닭";
		int mari = 2;
		switch(str){
		
		case "닭" :	
			System.out.println("닭"); 
			if(mari==1){
				System.out.println("한마리");
			}
			else if(mari ==2){
				System.out.println("두마리");				
			}
			else if(mari == 3){
				System.out.println("세마리");				
			}
			else{
				System.out.println("여러 마리");				
			} 
			break;


		case "개" :	
			System.out.println("개"); 
			if(mari==1){
				System.out.println("한마리");
			}
			else if(mari ==2){
				System.out.println("두마리");				
			}
			else if(mari == 3){
				System.out.println("세마리");				
			}
			else{
				System.out.println("여러 마리");				
			} 
			break;

		
		case "소" : System.out.println("소");
			if(mari==1){
				System.out.println("한마리");
			}
			else if(mari ==2){
				System.out.println("두마리");				
			}
			else if(mari == 3){
				System.out.println("세마리");				
			}
			else{
				System.out.println("여러 마리");				
			} 
			break;

		
		case "말" : System.out.println("말");
			if(mari==1){
				System.out.println("한마리");
			}
			else if(mari ==2){
				System.out.println("두마리");				
			}
			else if(mari == 3){
				System.out.println("세마리");				
			}
			else{
				System.out.println("여러 마리");				
			} 
			break;

		
		case "양" : System.out.println("양");
			if(mari==1){
				System.out.println("한마리");
			}
			else if(mari ==2){
				System.out.println("두마리");				
			}
			else if(mari == 3){
				System.out.println("세마리");				
			}
			else{
				System.out.println("여러 마리");				
			} 
			break;			
		}

//----------------------------------------------------------------------------------------------------------------------------
//실습 1.: 위 switch-case문  + if-else 문의 형태를 거꾸로 if-else문 + switch-case문으로 바꾸시오
//실습 2.: if-else문 + if-else문으로 바꾸시오
//실습 3.: 위 switch-case문  + switch-case문으로 바꾸시오
		
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		
	}	
}		
