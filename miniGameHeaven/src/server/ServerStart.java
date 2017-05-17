package server;

import java.net.*;
import java.io.*;
import java.util.*;

import game.NonsenseQuiz;

public class ServerStart {

	private ServerSocket server;
	private BManager bMan = new BManager(); // �޽��� ����� ���� �޼����� �ٸ� Ŭ���̾�Ʈ���� �Ѹ�.
	Buffer buffer = new Buffer();

	public ServerStart() {
	} // �Ű� ���� ���� ������

	public static void main(String[] args) { // 1. ����.
		ServerStart server = new ServerStart(); // ���� �Ҵ�
		server.startServer(); // ���� ����
	}

	void startServer() {
		try {
			server = new ServerSocket(7777); // ��Ʈ 7777
			Game_Thread gt = new Game_Thread(buffer);

			System.out.println("���������� �����Ǿ����ϴ�.");

			gt.start();

			while (true) {
				Socket socket = server.accept(); // ���� ���� ����

				new Chat_Thread(socket, buffer).start(); // Ŭ���̾�Ʈ�� ����ϴ� �����带
															// �����ϰ� �����Ų��.
				bMan.add(socket); // ������� ����Ʈ�� socket�� �߰��Ѵ�.
				bMan.sendClientInfo(socket); // ����ڴ� ��� Ŭ���̾�Ʈ���� ���� ���� �ο��� ���� �����Ѵ�.
				
				System.out.println(bMan);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// Ŭ���̾�Ʈ�� ����ϴ� ������ Ŭ����
	class Chat_Thread extends Thread {
		Socket socket;
		private BufferedReader reader;
		private PrintWriter writer;
		private Buffer buffer;

		public Chat_Thread(Socket socket, Buffer buffer) {
			this.socket = socket;
			this.buffer = buffer;
		}

		public void run() {
			try {
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				writer = new PrintWriter(socket.getOutputStream(), true);
				String msg;
				while ((msg = reader.readLine()) != null) { // �Է� ��Ʈ�����κ��� �޽�����
															// ��´�.
					buffer.set(msg);
					System.out.println(msg);
					bMan.sendToAll(msg); // ��� Ŭ���̾�Ʈ���� �޽����� �����Ѵ�.
				}
			} catch (Exception e) {
			} finally {
				try {
					bMan.remove(socket); // ������� ����Ʈ���� socket�� �����Ѵ�.

					if (reader != null)
						reader.close();
					if (writer != null)
						writer.close();
					if (socket != null)
						socket.close();
					reader = null;
					writer = null;
					socket = null;
					System.out.println("Ŭ���̾�Ʈ�� �������ϴ�.");
					bMan.sendClientInfo(socket); // ��� Ŭ���̾�Ʈ���� ���� ���� �ο��� ����
													// �����Ѵ�.
				} catch (Exception e) {
				}
			}
		}
	}

	class Game_Thread extends Thread {
		private Buffer buffer;

		public Game_Thread(Buffer buffer) {
			this.buffer = buffer;
		}

		public void run() {
			int gameTerm = 20;

			do {
				for (int i = gameTerm; i > 0; i--) { // 20�� ����.
					System.out.println(i);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					if (i < 6)
						bMan.sendToAll("�� ����" + i + "����");
					else
						bMan.sendToAll("�� �� ������ ���� �˴ϴ�.");

				}
				//--------------------------------------------------------------------------------------
				
				new NonsenseQuiz(buffer).start();
			} while (true);
		}
	}

	public class NonsenseQuiz extends Thread {
		private Buffer buffer;
		private String answer = null;

		public NonsenseQuiz(Buffer buffer) {
			this.buffer = buffer;
		}

		public void checkedAnswer(String str) {
			if (answer.equals(str)) {
				bMan.sendToAll("�����Դϴ�.");
				notify();
			}
		}

		public void start() {
			String fileName = "quiz.dat";
			String[] str = new String[2];
			String[] sstr = new String[2];
			String str2 = null;
			String str3 = null;
			int line;

			try (BufferedReader fi = new BufferedReader(new FileReader(fileName));) {
				line = (int) (Math.random() * 18 + 1); // ���� ���� �����ϱ�

				for (int i = 0; i < line; i++) {
					str = fi.readLine().split("-");
				}

				bMan.sendToAll("��" + str[0]);

				answer = str[1];

				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				// System.out.println("��� �ð� : " + (end - start) / 1000 + "�� " +
				// (end - start) % 1000);
			}
		}
	}

	class BManager extends Vector { // �޽��� ����� Ŭ����, Vector�� ����Ѵ�.
		int win = 0;
		int looser = 0;

		BManager() {
		}

		void add(Socket sock) { // ������ �߰��Ѵ�.
			super.add(sock);
		}

		void remove(Socket sock) { // ������ �����Ѵ�.
			super.remove(sock);
		}

		synchronized void sendToAll(String msg) { // ��� Ŭ���̾�Ʈ���� msg�� �����Ѵ�. ����ȭ
													// �޼ҵ�
			PrintWriter writer = null; // ��� ��Ʈ��
			Socket sock; // ����

			for (int i = 0; i < size(); i++) { // ������ ������ŭ �ݺ� ����
				sock = (Socket) elementAt(i); // i��° ������ ��´�.

				try {
					writer = new PrintWriter(sock.getOutputStream(), true); // i��°
																			// ������
																			// ���
																			// ��Ʈ����
																			// ��´�.
				} catch (IOException ie) {
				}

				if (writer != null) // i��° ������ ��� ��Ʈ������ msg�� ����Ѵ�.
					writer.println(msg);
			}
		}

		synchronized void sendClientInfo(Socket sock) { // ��� Ŭ���̾�Ʈ���� ���� ä�� �ο���
														// ���� �����Ѵ�.
			String info = "���� ä�� �ο�  : " + size(); // + sock.toString();
			System.out.println(info);
			sendToAll(info);
		}
	}
}