package ncs.test6;

public class Data {

	private int value;
	private boolean isEmpty = true;

	public synchronized int get() {
		while (isEmpty) {
			
			try {
				throw new EmptyException("값이 없어요.");
			} catch (EmptyException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		isEmpty = true;
		notifyAll();
		return value;
	}

	public synchronized void put(int number) {
		while (!isEmpty) {
			try {
				throw new EmptyException("값이 있습니다.");
			} catch (EmptyException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		isEmpty = false;
		this.value = number;
		notifyAll();
	}
}
