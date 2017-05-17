package game.main;

import game.typing.NonsenseQuiz;
import game.typing.TypingGame;
		
public class TestMain {
		
	public static void main(String[] args) {
		TestMain tm = new TestMain();
	}	
		
	public void randomStart() throws InterruptedException {
		NonsenseQuiz nq = new NonsenseQuiz();
		TypingGame tg = new TypingGame();
		
		int r = 0;
		
		while (true) {
			for (int i = 0; i < 55; i++) {
				System.out.println(i);
				Thread.sleep(1000);
			}
			for (int i = 5; i > 0; i--) {
				System.out.println("게임 " + i + "초전");
				Thread.sleep(1000);
			}
			r = (int) (Math.random() * 4 + 1);
			switch (r) {
			case 1:
				nq.start();
				
				break;
			case 2:
				tg.start();
				
				break;
			case 3:
				System.out.println("3번 실행됨.");
				
				break;
			case 4:
				System.out.println("4번 실행됨.");
				
				break;
			default:
			}
		}
	}	
}		
		