package server;

import java.net.*;
import java.io.*;
import java.util.*;

public class ServerStart {

	private ServerSocket server;
	private BManager bMan = new BManager();

	int gameOn = 0, gameType = 0;
	private String answer = null;
	long start = 0, end = 0;
	String gameMsg;

	int user, winScore = 0, usercount=0;

	String winnerName;
	String[] users;

	Game_Thread gt = new Game_Thread();
	answerCheck ac = new answerCheck();

	public ServerStart() {
	}

	// 실행
	public static void main(String[] args) {
		ServerStart server = new ServerStart();
		server.startServer();
	}

	// 메인
	void startServer() {
		try {
			server = new ServerSocket(7777);
			System.out.println("서버소켓이 생성되었습니다.");
			gt.start();
			ac.start();

			while (true) {
				Socket socket = server.accept();
				new Chat_Thread(socket).start();

				bMan.add(socket);
				bMan.sendClientInfo(socket);
				System.out.println(bMan);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// 클라이언트와 통신하는 스레드 클래스. (게임 정답 받음. 대화 받음.)
	class Chat_Thread extends Thread {
		Socket socket;

		private BufferedReader reader;
		private PrintWriter writer;

		public Chat_Thread(Socket socket) {
			this.socket = socket;
		}

		public void run() {
			try {
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				writer = new PrintWriter(socket.getOutputStream(), true);
				String msg;
				while ((msg = reader.readLine()) != null) {

					if (msg.charAt(0) != '-') {
						if (gameOn == 1) {
							gameMsg = msg;
							ac.check();
						}
					}
					
					if(msg.charAt(0) == '-'){
						String[] tmp = new String[2];
						tmp = msg.replaceAll("-","").split("/");
						tmp[0] = tmp[0].trim();
						tmp[1] = tmp[1].trim();
						users[usercount] = tmp[usercount];
						System.out.println(usercount+" : "+users[usercount]);
						usercount++;
					}

					if (msg != null) {
						bMan.sendToAll(msg);
					}
				}
			} catch (Exception e) {
			} finally {
				try {
					bMan.remove(socket);

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
					bMan.sendClientInfo(socket);
				} catch (Exception e) {
				}
			}
		}
	}

	class Game_Thread extends Thread {
		public Game_Thread() {
		}

		public void run() {
			int gameTerm = 10; // 게임 REROAD 시간
			int gameTime = 60;
			int gameKinds = 3; // 게임 종류
			int cnt = 0; // 정답이 없을때 사용

			do {
				try {
					System.out.println("game thread Check : " + cnt);
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				if (gameOn == 0) {
					for (int i = gameTerm; i >= 0;) {
						System.out.println(i);
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

						if (i < 6)
							bMan.sendToAll("· 게임" + i + "초전");
						else if (i < 17)
							bMan.sendToAll("· 곧 게임이 시작 됩니다.");
						i--;
					}

					int num = (int) (Math.random() * gameKinds);
					System.out.println("게임 타입" + num);

					switch (num) {
					case 0: // 퀴즈 게임
						String[] str = new game.NonsenseQuiz().start();
						bMan.sendToAll("· 넌센스 퀴즈.<br>" + str[0]);
						answer = str[1].trim();
						gameOn = 1;
						gameType = 0;
						gameTime = 15;
						cnt = 0;
						break;
					case 1: // 타자 연습 게임
						String str1 = new game.TypingGame().start();
						bMan.sendToAll("· 타자 연습 게임 !! 아래 글을 입력하세요.<br>" + str1);
						start = System.currentTimeMillis();
						answer = str1.trim();
						gameOn = 1;
						gameType = 1;
						gameTime = 45;
						cnt = 0;
						break;
					case 2: // 베이스볼 게임
						String str2 = new game.BaseBallGame().start();
						answer = str2.trim();
						bMan.sendToAll("· 베이스볼 게임. 중복되지 않는 4자리 숫자를 입력 하세요.");
						gameOn = 1;
						gameType = 2;
						gameTime = 45;
						cnt = 0;
						break;
					case 3: // 화살표 게임
						gameType = 3;
//						bMan.sendToAll("3");
						gameOn = 1;
						gameTime = 20;
						cnt = 0;
						break;
					case 4: // 두더지 게임
						gameType = 4;
						bMan.sendToAll("4");
						gameOn = 1;
						gameTime = 16;
						cnt = 0;
						break;
					}
				} else {
					try {
						Thread.sleep(1000);
						cnt++;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if (cnt == gameTime) {
						if (gameType == 3 || gameType == 4) {
							gameOn = 0;
							try {
								bMan.sendToAll("====================== 승자는" + winnerName + "입니다. ======================");
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						} else {
							gameOn = 0;
							try {
								bMan.sendToAll("· 정답이 없네요. 다음 게임을 준비 중 입니다.");
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						cnt = 0;
					}
				}
			} while (true);
		}

	}

	// 정답 체크
	class answerCheck extends Thread {
		public void run() {
		}

		public void check() {
			System.out.println(gameMsg);
			if (gameMsg != null) {
				System.out.println("test AC ");
				String[] str = new String[2];

				if (gameMsg.charAt(0) == '@') {
					str = gameMsg.replaceAll("@", "").split(":");
					str[0] = str[0].trim();
					str[1] = str[1].trim();
					
					System.out.println(str[0]);
					System.out.println(str[1]);

					if (Integer.parseInt(str[1]) > winScore) {
						winnerName = str[0];
					} else if (Integer.parseInt(str[1]) == winScore) {
						winnerName += (", " + str[0]);
					}
					
					System.out.println(winScore);
					System.out.println(winnerName);
					
				}
				else {
					str = gameMsg.split(":");
					str[0] = str[0].trim();
					str[1] = str[1].trim();

					System.out.println(answer);
					System.out.println(str[0]);
					System.out.println(str[1]);

					if (str[1].equals(answer)) {
						gameOn = 0;
						end = System.currentTimeMillis();
						bMan.sendToAll("====================== " + str[0] + "님 정답입니다!!! ======================");
						if (gameType == 1)
							bMan.sendToAll("경과 시간 : " + (end - start) / 1000 + "초 " + (end - start) % 1000);
						bMan.sendToAll("· 다음 게임을 준비 합니다.");
					} else if (gameType == 2) {
						if (answer.length() == str[1].length())
							bMan.sendToAll(new game.BaseBallGame().countSB(answer, str[1]));
					}
				}
				gameMsg = null;
			}
		}
	}

	// 소켓 정보를 저장
	class BManager extends Vector {
		String name;

		BManager() {
		}

		void add(Socket sock) {
			super.add(sock);
		}

		void remove(Socket sock) {
			super.remove(sock);
		}

		synchronized void sendToAll(String msg) {
			PrintWriter writer = null;
			Socket sock;

			for (int i = 0; i < size(); i++) {
				sock = (Socket) elementAt(i);

				try {
					writer = new PrintWriter(sock.getOutputStream(), true);
				} catch (IOException ie) {
				}

				if (writer != null)
					writer.println(msg);
			}
		}

		synchronized void sendClientInfo(Socket sock) {
			String info = "현재 채팅 인원  : " + size(); // + sock.toString();
			user=size();
			users = new String[user];
			sendToAll(info);
			usercount=0;
			bMan.sendToAll("/"); // 이거 잘 쓰면 잼있을 듯.
		}
	}
}