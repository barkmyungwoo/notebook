package tranning.second.operators;

public class Operators {

	public static void main(String[] args) {
		// 연산자 쉽게 쓰기 위하여 int 를 이용하겠슴.

		int number = 10;
		int value = 20;
		int score = 30;
		char word = 'c';

		// 단항 연산자 +, -
		System.out.println(-number);
		System.out.println(+number);
		System.out.println(number);

		System.out.println();
		System.out.println();

		// 단항 연산자 ++,--
		System.out.println(++value);
		System.out.println(--value);
		System.out.println(value++);
		System.out.println(value--);
		System.out.println(value); // ++ 또는 -- 가 붙은 위치에 따라 값이 변하는 순간이 달라짐!!!

		System.out.println();
		System.out.println();

		// 이항 연산자 +, -, *, / %
		System.out.println(score + score); // 알다 시피 숫자와 숫자의 합은 값을 출력.
		System.out.println(score - score); // 빼기
		System.out.println(score * score); // 곱하기
		System.out.println(score / score); // 나누니
		System.out.println(score % value); // 나누기의 나머지 값
		System.out.println(word + word); // char + char -> 198 출력.
											// 소문자 c 의 유니코드는 99
		System.out.println();
		System.out.println();

		// 비교 연산자 >, <, <=, >=, ==, != //크거나, 작거나, 크고 같거나, 작고 같거나, 같거나, 같지 않거나
		// 논리 연산자 && || //&&- 교집합, || - 합집합

		//일단 제어문 for문이 비교 연산자의 꽃이라 사용 확인 해보기.

		for (int i = 10; i <= 20; i++) {			//숫자 10~20까지 넣음. 이해 안되면 외워!
			if (12 < i && i < 18) {					//12보다 크고 18보다 작은
				System.out.print(i+", ");
			}
		}
		System.out.println();


		for (int i = 10; i < 20; i++) {
			if (12 <= i && i <= 18) {				//12랑 크거나 같고 18보다 작거나 같은
				System.out.print(i+", ");
			}
		}
		System.out.println();


		for (int i = 10; i < 20; i++) {
			if (12 < i || i < 18) {					//12보다 크던지 18보다 작던지
				System.out.print(i+", ");
			}
		}
		System.out.println();


		for (int i = 10; i < 20; i++) {
			if (12 > i || i > 18) {					//12보다 작거나 18보다 크거나
				System.out.print(i+", ");
			}
		}

		System.out.println();
		System.out.println();

		// 다항 연산자. (조건식)? 참 식: 거짓 식; 외워. 방법이 없어.
		System.out.println((number > score) ? "맞다" : "틀리다");

		String st = (score > value) ? "맞다" : "틀리다"; 		// 반환된는 값을 입력해 주는 변수나 함수
															// 필요!!!!!
		System.out.println(st);

		System.out.println();
		System.out.println();
		
		//대입연산자.
		number+=number;									//number = number+number
		System.out.println(number);						//10+10  = 20

		number*=score;									//number = number*score
		System.out.println(number);						//20*30  = 600

		number/=score;									//number = number/score
		System.out.println(number);						//600/30 = 20
		
		number-=number;									//number = number+number
		System.out.println(number);						//20 -20 = 0

		System.out.println();
		
		//잘 좀 해 봐라~
	}
}