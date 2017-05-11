package tranning.sixth.array;

public class Array {
	//1차배열 
	public static void main(String[] args) {

		int[] a = new int[6];										//배열 선언 방법
		int b[] = new int[6];										//같다. 
		int[] c;													// 선언만 해줘도 됨. 초기화 또는 주소할당(new) 는 사용하기 전에 
																	//초기화 해주면 됨. but 안하고 사용하면 null point exeption 이 선언됨. 

		//배열은 더이상 기본 변수가 아닙니다. 
		int d = 0;													//비교용 기본 변수 선언.
//		System.out.println(d.hashCode());							//주소가 없다!!!!! 오류뜸.
		System.out.println(a.hashCode());							//but 주소가 있다!!! 즉. 레퍼런스 변수다!!!!!!! 참조 변수. 

		
																	// 변수 이름에 . 누르고 레퍼런스 변수에 사용가능한 모든 메소드 사용이 가능함 
																	//가령 length(), toString();, 
		
		System.out.println();										
		System.out.println();										
		System.out.println();										
		System.out.println();										

		
		//※ 비교. 레퍼런스 변수용 메소드도 약간의 모양이 다릅니다. 

		String str = "hello";
		String[] str2 = new String[5];
		char[] c1 = new char[]{'s','u','p','e','r'}; 				// 
		
		System.out.println(str.length());							// 가로가 붙음.
		System.out.println(c1.length);								// 가로가 붙지 않음.
		System.out.println(str2.length);							// 가로가 붙지 않음!!!!!! string의 경우만!!! 그것만 가로가 붙음. 
		
					// 이유는 String의 경우 String이 클.래.스. 처럼 취급되어서 length()메소드가 실행되는것.
					// 기본형 배열의 경우는 배열이 메.소.드.로 처럼 취급되어서 length는 메소드안에 포함된 지.역.변.수.처럼 취급됨. 
		
					// ex>	public class String{
					//			public void length(){
					//
					//			}			
					//		}  			

		
					// 			public void array(){
					//				int lenght 
					//			}
		
					//			이런식임. 
		
		System.out.println();										
		System.out.println();										
		System.out.println();										
		System.out.println();										
		
		//2차원 배열 
		
		
		int[][]aa = new int[2][3];										// 2차 배열 설정
																		// 설정하는 방법은 수십가지 이다. 
																		// 이건 직접 친거 보고 하나하나 해 볼 수 밖에 없음. 
		
		int[][] t = { 													// t의 경우 [4][5]의 메모리 할당이 자동으로 된다. 	 
				{1, 2, 3, 4, 5},										
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
		};

		
		int[][] t2 = { 													// t2의 경우 [4][]의 메모리 할당이 자동으로 된다. 	 
				{1, 2, 3},												// 각 열의 경우 각각 다른 사이즈의 메모리가 할당된다. 
                {6, 7, 8, 9, 10},										// 이거까진 교수님 강의물 봐라.
                {11, 12, 13, 14},										// 일단 이걸 활용이나 사용에 대하여 설명하겠음.
                {16, 17},
		};
		
		System.out.println(t2.length);									//길이 구하는 방식 사용하기. t2의 크.기.와.!!! t2[]의 크.기.가. 각각 다!르!다!!!!! 절대!!!!!! 이해하기.
		System.out.println(t2[0].length);								//2차 배열의 경우 위와 같은 모양으로 선언할 때 띄어서 
		System.out.println(t2[1].length);								// 보여주면 보기 편함.
		System.out.println(t2[2].length);
		System.out.println(t2[3].length);

		//2차원 배열 사용과 응용. +for문
		
		System.out.println();										
		System.out.println();										
		System.out.println();										
		System.out.println();										
		
		//출력
		for(int 줄=0; 줄< t2.length; 줄++){								// 이해를 돕기 위해 변수명을 한글로 선언함. 넌 하지마. 
			for(int 칸 = 0 ; 칸 < t2[줄].length ; 칸++ ){					// 조건식 선언 방법 잘 확인하기!!!!! t2[줄]의 크기가 각각 다르기 때문에 이렇게 해서 각각 사이즈 확인을 해서 출력을 해야함. 
				
				System.out.print(t2[줄][칸]+ ", ");						// 옆으로 출력하기 위하여 print 를 사용함. 

			}		
			System.out.println();										// t2[줄][]	이 끝날때 마다 한줄씩 바꿈하기 위해서 밖 for 문에서 println
		}

		System.out.println();										
		System.out.println();										
		System.out.println();										
		System.out.println();										
		
		
		//더하기!!
		int sum=0;														// for 문의 영향을 받지 않기 위해 밖에 선언.
		for(int 줄=0; 줄< t2.length; 줄++){								
			for(int 칸 = 0 ; 칸 < t2[줄].length ; 칸++ ){				 
				
				System.out.print(t2[줄][칸]+ ", ");						// 출력 남겨 놓음.
				sum += t2[줄][칸];										// sum = sum+ t2[줄][칸];
			}		

			System.out.println();										
		}				
		System.out.println("합계 : "+ sum);								// 합은 for문이 끝나고 밖에서 출력!!
		
		
			
		System.out.println();										
		System.out.println();										
		System.out.println();										
		System.out.println();										
			
		
		//응용 1. 학생들의 개인 평균과 과목평균 구하기.	
		//갑자기 어려워 짐!! 하지만 안돼면 종이에 그려서 해석할것!!!! 반드시 해야함.				

		int ara[][] =new int[5][4];										// 4명의 3과목 국 영 수 평균과 과목별 평균을 구함. 일단 int 배열이라 가공을 조금 하겠음.
		int sump=0;														// sump는 개인 합산. 합산 후 밖에서 /3으로 평균을 구함.

		System.out.println("\t\t국어\t영어\t수학\t평균");
		for(int i=0; i< ara.length-1 ; i++) { 							// 몇줄 = 몇 명인지

			System.out.print(i + "번 학생 : ");

			for (int j = 0; j < ara[i].length - 1; j++) { 				// -1을 하는 이유는 마지막 자리에
																		// 평균을 넣어야 하니까.

				ara[i][j] = (int) (Math.random() * 50 + 51); 			// 점수는 51~100 까지 랜덤
																		// 입력.
				sump += ara[i][j]; 										// for 문 안에서 i번 학생 마지막 칸에 개인 점수를 합해줌.

				System.out.print("\t" + ara[i][j]+"점");

				ara[ara.length - 1][j] += ara[i][j]; 					// 마지막 줄 마지막 칸에 값을 더함. 과목마다 과목평균에 값을 구하는데 사용.
			}

			ara[i][ara[i].length - 1] = (sump / 3); 					// 개인 합산이 끝나고 합산된 점수를 바깥 for문에서 평균을 구해서 줄 마지막 칸에 입력. j는 위에서 끝나서 나오면서 소면됨.
			ara[ara.length - 1][ara[i].length - 1] += (sump / 3); 		// 맨 마지막 평균에 값을 더함.

			System.out.print("\t" + ara[i][ara[i].length - 1]+"점"); 		// 마지막 평균 출력. 위치가 왜여기이고  -1을 왜 해주는지 이해하기! 꼭!!!!!

			sump = 0; 													// 여기서 초기화 해야 다음 학생 값이랑 이전 학생 값이 합쳐지지 않음.

			System.out.println();
		}

		System.out.println("-------------------------------------------");
		System.out.print("과목 평균 \t");
		for (int i = 0; i < ara[0].length; i++) {
			System.out.print("\t" + (ara[ara.length - 1][i] / 4)+"점");
		}
		
		// 일단 위 프로그램이 어려울것이란건 안다. 내가 많이 줄이기도 하거니와 복합적으로 할당된 점수를 한번에 다기능으로 입력하기에 굉장히 힘들꺼라는걸 아는데
		// 나보다 회사 프로그램 소스가 더 복잡해~~~~ 일단 안되면 표 만들어서라도 이해하고 사용해봐봐.
		// 그리고 모든 조건문에서 .length를 쓰는 이유는 위와같이 길이가 정해져 있고 짧으면 사용이 간단하지만 학생의 수가 그때 그때 바뀌거나
		// 반마다 정원이 달라서 바꿔줘야 할때 적용하기가 쉬워서 그랬음. 과목이 늘어날 수도 있는거구. 언제 어떻게 변경이 될지 모르니
		// .length 를 사용해서 적용하기 편하게 하려고 사용하는 것임돠. 
		
		System.out.println();										
		System.out.println();										
		System.out.println();										
		System.out.println();										
		
		
		//응용 2. 정렬 for문을 이용해서 정렬하라. 이것도 중요. 자주사용.
		
		int[] nsort = new int[8];											//8개짜리 배열 만듦
		int tmp;															//나중에 정렬할 때 필요한 임시 저장 공간.

		for(int i=0; i<nsort.length; i++){
			nsort[i] = (int)(Math.random()*50+1);							//배열에 값 부여. 1~50
		}
		
		for(int i = 0; i<nsort.length-1;i++){								
			for(int j=i; j<nsort.length;j++){

				if(nsort[i]>nsort[j]){										//붙어 있는 두 배열의 값을 비교. 가령 0번째와 1번, 1번째와 2번 큰수가 앞에 있다면 체인지 곧 내림차순!!!!
					tmp=nsort[i];											//임시 공간에 큰 숫자 넣음
					nsort[i] =nsort[j];										//큰 숫자 공간에 작은 숫자 넣음
					nsort[j]=tmp;											//임시공간에 있는 큰 수를 작은수가 있던 공간에 넣음.
				}

			}
		}
		
		for(int i=0; i<nsort.length;i++)
			System.out.print(nsort[i]+", ");
		
		
		//가장 기본적으로 사용하는 2중 for문. int j = i를 꼭 이해하기!!!! 왜 저렇게 구현하는지 꼭 이해하기!!!!

		
		System.out.println();										
		System.out.println();										
		System.out.println();										
		System.out.println();										
		
		
	}

}
