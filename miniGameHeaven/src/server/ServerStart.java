package server;

import java.net.*;
import java.io.*;
import java.util.*;

import game.NonsenseQuiz;

public class ServerStart {

	private ServerSocket server;
	private BManager bMan = new BManager(); // 메시지 방송자 받은 메세지를 다른 클라이언트에게 뿌림.
	Buffer buffer = new Buffer();

	public ServerStart() {
	} // 매게 변수 없는 생성자

	public static void main(String[] args) { // 1. 시작.
		ServerStart server = new ServerStart(); // 서버 할당
		server.startServer(); // 서버 시작
	}

	void startServer() {
		try {
			server = new ServerSocket(7777); // 포트 7777
			Game_Thread gt = new Game_Thread(buffer);

			System.out.println("서버소켓이 생성되었습니다.");

			gt.start();

			while (true) {
				Socket socket = server.accept(); // 서버 소켓 접속

				new Chat_Thread(socket, buffer).start(); // 클라이언트와 통신하는 스레드를
															// 생성하고 실행시킨다.
				bMan.add(socket); // 방송자의 리스트에 socket을 추가한다.
				bMan.sendClientInfo(socket); // 방송자는 모든 클라이언트에게 현재 접속 인원의 수를 전송한다.
				
				System.out.println(bMan);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// 클라이언트와 통신하는 스레드 클래스
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
				while ((msg = reader.readLine()) != null) { // 입력 스트림으로부터 메시지를
															// 얻는다.
					buffer.set(msg);
					System.out.println(msg);
					bMan.sendToAll(msg); // 모든 클라이언트에게 메시지를 전송한다.
				}
			} catch (Exception e) {
			} finally {
				try {
					bMan.remove(socket); // 방송자의 리스트에서 socket을 제거한다.

					if (reader != null)
						reader.close();
					if (writer != null)
						writer.close();
					if (socket != null)
						socket.close();
					reader = null;
					writer = null;
					socket = null;
					System.out.println("클라이언트가 나갔습니다.");
					bMan.sendClientInfo(socket); // 모든 클라이언트에게 현재 접속 인원의 수를
													// 전송한다.
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
				for (int i = gameTerm; i > 0; i--) { // 20초 셋팅.
					System.out.println(i);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					if (i < 6)
						bMan.sendToAll("· 게임" + i + "초전");
					else
						bMan.sendToAll("· 곧 게임이 시작 됩니다.");

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
				bMan.sendToAll("정답입니다.");
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
				line = (int) (Math.random() * 18 + 1); // 문제 랜덤 선택하기

				for (int i = 0; i < line; i++) {
					str = fi.readLine().split("-");
				}

				bMan.sendToAll("·" + str[0]);

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
				// System.out.println("경과 시간 : " + (end - start) / 1000 + "초 " +
				// (end - start) % 1000);
			}
		}
	}

	class BManager extends Vector { // 메시지 방송자 클래스, Vector를 상속한다.
		int win = 0;
		int looser = 0;

		BManager() {
		}

		void add(Socket sock) { // 소켓을 추가한다.
			super.add(sock);
		}

		void remove(Socket sock) { // 소켓을 제거한다.
			super.remove(sock);
		}

		synchronized void sendToAll(String msg) { // 모든 클라이언트에게 msg를 전송한다. 동기화
													// 메소드
			PrintWriter writer = null; // 출력 스트림
			Socket sock; // 소켓

			for (int i = 0; i < size(); i++) { // 소켓의 개수만큼 반복 실행
				sock = (Socket) elementAt(i); // i번째 소켓을 얻는다.

				try {
					writer = new PrintWriter(sock.getOutputStream(), true); // i번째
																			// 소켓의
																			// 출력
																			// 스트림을
																			// 얻는다.
				} catch (IOException ie) {
				}

				if (writer != null) // i번째 소켓의 출력 스트림으로 msg를 출력한다.
					writer.println(msg);
			}
		}

		synchronized void sendClientInfo(Socket sock) { // 모든 클라이언트에게 현재 채팅 인원의
														// 수를 전송한다.
			String info = "현재 채팅 인원  : " + size(); // + sock.toString();
			System.out.println(info);
			sendToAll(info);
		}
	}
}