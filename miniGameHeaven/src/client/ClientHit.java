package client;

import java.awt.*;
import java.awt.event.*;
import java.net.*;

import javax.swing.JFrame;

import java.io.*;

public class ClientHit extends JFrame implements Runnable {
	String name = "mist";
	private TextField nameBox = new TextField(name); // 사용자 이름을 나타낸다.
	private TextArea msgView = new TextArea();
	private TextField sendBox = new TextField();
	private BufferedReader reader;
	private PrintWriter writer;
	private Socket socket;

	public ClientHit(String title) {
		super(title);
		msgView.setEditable(false);

		// 컨트롤들을 배치한다.
		add(nameBox, "North");
		add(msgView, "Center");
		add(sendBox, "South");

		// sendBox 액션 이벤트 처리
		sendBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					writer.println(name + " : " + sendBox.getText()); // 사용자의
					sendBox.setText(""); 											// sendBox의 내용을 지운다.
				}
				
				catch (Exception ie) {
				}
			}
		});
		pack();
	}

	public void run() {

		while (true) {
			try {
				String str = reader.readLine();
				
				if(str.charAt(0)=='·')
					nameBox.setText(str);
				else
					msgView.append(str + "\n");
				str = null;
			} catch (IOException ie) {
				
			}
		}
	}

	private void connect() {
		try {
			msgView.append("서버소켓과의 연결을 시도합니다.\n");
			socket = new Socket("192.168.20.39", 7777);
			msgView.append("채팅 준비가 완료되었습니다.\n");
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new PrintWriter(socket.getOutputStream(), true);

			new Thread(this).start();
		} catch (Exception e) {
			msgView.append("연결 실패..");
		}
	}

	public static void main(String[] args) {
		ClientHit client = new ClientHit("미니게임 천국");		
		client.setDefaultCloseOperation(EXIT_ON_CLOSE);
		client.setVisible(true);
		client.connect();
	}
}