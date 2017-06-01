package ncs.test6;

public class MultiThreadTest {

	public static void main(String[] args) {
		//멀티스레드의 생산자 소비자 프로그램 테스트
			Data data = new Data();
			(new Thread(new Provider(data))).start();
			(new Thread(new Consumer(data))).start();
	}

}
