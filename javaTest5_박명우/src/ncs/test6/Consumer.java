package ncs.test6;

public class Consumer implements Runnable {
	private Data data;

	public Consumer(Data buffer) {
		this.data = buffer;
	}

	@Override
	public void run() {
		for (int k = 1; k < 11; k++) {
			int number = data.get();
			System.out.println("get value : " + number);
			try {
				Thread.sleep((int) (Math.random() * 100));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
