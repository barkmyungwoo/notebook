package ncs.test6;

public class MultiThreadTest {

	public static void main(String[] args) {
		//��Ƽ�������� ������ �Һ��� ���α׷� �׽�Ʈ
			Data data = new Data();
			(new Thread(new Provider(data))).start();
			(new Thread(new Consumer(data))).start();
	}

}
