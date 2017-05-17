package server;

public class Buffer {

	private String str=null;
//	private boolean empty = true;

	public synchronized String get() {
//		while (empty) {
//			try {
//				wait();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//		empty = true;
//		notifyAll();
		return str;
	}

	public synchronized void set(String str) {
//		System.out.println("set 저장됨");
//		while (!empty) {
//			try {
//				System.out.println("걸림");
//				wait();
//			} catch (InterruptedException e) {
//				System.out.println("안걸림");
//				e.printStackTrace();
//			}
//		}
//		empty = false;
		this.str = str;
//		notifyAll();
	}
	
	

//	private int number;
//	private boolean empty = true;
//
//	public synchronized int get() {
//		while (empty) {
//			try {
//				System.out.println("값이 없어요 공급 될 때 까지 기다리세요");
//				wait();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//		empty = true;
//		notifyAll();
//		return number;
//	}
//
//	public synchronized void put(int number) {
//		while (!empty) {
//			try {
//				wait();
//				System.out.println("값 들어있으니 소비가 될 때까지 기다려주세요");
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//		empty = false;
//		this.number = number;
//		notifyAll();
//	}
}
