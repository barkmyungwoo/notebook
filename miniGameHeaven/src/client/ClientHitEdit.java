package client;

import java.awt.*;
import java.awt.event.*;
import java.net.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import java.io.*;

public class ClientHitEdit extends JFrame implements Runnable {
	SaveScore score = new SaveScore();

	private String name = "멍dd";

	// GUI용 선언
	private JLabel nameBox;
	private JTextField sendBox;
	private JTextArea msgView, userList;
	private JButton send;
	private JPanel north, south, west, center;
	private JScrollPane scroll;
	// 통신용 선언
	private BufferedReader reader;
	private PrintWriter writer;
	private Socket socket;

	private int gameOn = 0;
	private int gameType = 0;

	public ClientHitEdit(String title) {
		super(title);

		this.setTitle("미니게임 천국");
		this.setBounds(new Rectangle(100, 100, 890, 530));
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		nameBox = new JLabel("<html><br>" + name + "님 환영해요.<br><br><br></html>");
		north = new JPanel();
		north.add(nameBox);

		this.add(north, BorderLayout.NORTH);
		// -------------------------------------------------------------- 북쪽 얼굴

		sendBox = new JTextField(50);
		send = new JButton("전송");

		south = new JPanel();
		south.add(new JLabel("전송할 메세지 : "));
		south.add(sendBox);
		south.add(send);

		this.add(south, BorderLayout.SOUTH);

		// --------------------------------------------------------------- 남쪽 얼굴

		msgView = new JTextArea(19, 60);
		msgView.setEditable(false);
		scroll = new JScrollPane(msgView);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		center = new JPanel();
		center.add(new JLabel("- Message -"));
		center.add(scroll);

		this.add(center, BorderLayout.CENTER);

		// --------------------------------------------------------------- 가운데

		userList = new JTextArea(19, 15);

		west = new JPanel();
		west.add(new JLabel("- User -"));
		west.add(userList);
		west.setPreferredSize(new Dimension(180, 400));
		this.add(west, BorderLayout.WEST);

		// -----------------------------------------------------------------------

		// sendBox 액션 이벤트 처리
		sendBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					writer.println(name + " : " + sendBox.getText()); // 사용자의
					if (gameOn == 1) {

					}
					sendBox.setText(""); // sendBox의 내용을 지운다.

				} catch (Exception ie) {
				}
			}
		});

		send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					writer.println(name + " : " + sendBox.getText()); // 사용자의
					sendBox.setText(""); // sendBox의 내용을 지운다.
				} catch (Exception ie) {
				}
			}
		});
		// pack();
	}

	public void run() {
		// writer.println(name + socket.getInetAddress());
		while (true) {
			try {
				String str = reader.readLine();
				if (str != null) {
					if (str.charAt(0) == '·') {
						if (str.contains("<br>"))
							nameBox.setText("<html><center><br>" + str.replaceAll("·", "") + "<br><center></html>");
						else
							nameBox.setText("<html><center><br>" + str.replaceAll("·", "") + "<br><br><center></html>");
					} else if (str.charAt(0) == '/')
						writer.println("-" + name + socket.getInetAddress());
					else if (str.charAt(0) == '현')
						userList.setText(str + "\n");
					else if (str.charAt(0) == '-')
						userList.append(str + "\n");
					else if (str.equals("3")) {
						nameBox.setText("<html><center><br>리멤버 다이렉트<br><br><center></html>");
						new Numbers();
					} else if (str.equals("4")) {
						nameBox.setText("<html><center><br>두더지 게임!!!<br><br><center></html>");
						new MoleGame(writer, name);
					} else if (str.charAt(0) == '3') {
						;
					} else
						msgView.append(str + "\n");
				}
			} catch (IOException ie) {
			}
		}
	}

	public void numberGame() {
		Numbers ng = new Numbers();
		int count = 4;
		String[] howTo = ng.howTo();
		String question;
		for (int i = 0; i < howTo.length; i++) {
			try {
				nameBox.setText("<html><center><br>" + howTo[i] + "<br></center></html>");
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		while (true) {
			question = ng.question(count);
			System.out.println(question);
			String[] direct = question.replaceAll("null", "").split(" ");

			try {
				nameBox.setText("<html><center><br>" + count + "단계 문제.<br></center></html>");
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}

			for (int j = 0; j < count; j++) {
				nameBox.setText("<html><center><br>" + direct[j] + "<br></center></html>");
				try {
					Thread.sleep(1000);
					nameBox.setText("<html><center><br> <br></center></html>");
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			nameBox.setText("<html><center><br>입력하세요!" + "<br></center></html>");

			if (ng.answerCheck(sendBox.getText()))
				count++;
			else
				break;
		}
		writer.println("3" + name + count);
	}

	private void connect() {
		try {
			msgView.append("서버소켓과의 연결을 시도합니다.\n");
			socket = new Socket("127.0.0.1", 7777);
			msgView.append("채팅 준비가 완료되었습니다.\n");
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new PrintWriter(socket.getOutputStream(), true);

			new Thread(this).start();
		} catch (Exception e) {
			msgView.append("연결 실패..");
		}
	}

	public static void main(String[] args) {
		ClientHitEdit client = new ClientHitEdit("미니게임 천국");
		client.setDefaultCloseOperation(EXIT_ON_CLOSE);
		client.setVisible(true);
		client.connect();
	}

}