package ncs.test6;

public class Provider implements Runnable {
	private Data data;

	public Provider(Data buffer) {
		this.data = buffer;
	}

	@Override
	public void run() {
		for (int k = 1; k < 11; k++) {
			int in = (int) (Math.random() * 100);
			data.put(in);
			System.out.println("set value : " + in);
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}