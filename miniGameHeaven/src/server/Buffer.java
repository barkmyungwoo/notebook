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
//		System.out.println("set �����");
//		while (!empty) {
//			try {
//				System.out.println("�ɸ�");
//				wait();
//			} catch (InterruptedException e) {
//				System.out.println("�Ȱɸ�");
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
//				System.out.println("���� ����� ���� �� �� ���� ��ٸ�����");
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
//				System.out.println("�� ��������� �Һ� �� ������ ��ٷ��ּ���");
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//		empty = false;
//		this.number = number;
//		notifyAll();
//	}
}
