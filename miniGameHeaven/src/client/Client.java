package client;

import java.awt.*;
import java.awt.event.*;
import java.net.*;

import javax.swing.JFrame;

import java.io.*;

public class Client extends JFrame implements Runnable {
	private String name = "박제언";
	private TextField nameBox = new TextField(name+"님 환영합니다.");

	private TextArea msgView = new TextArea();
	private TextField sendBox = new TextField();
	private BufferedReader reader;
	private PrintWriter writer;
	private Socket socket;

	public static void main(String[] args) {
		Client client = new Client("채팅");
		client.setDefaultCloseOperation(EXIT_ON_CLOSE);
		client.setVisible(true);
		client.connect();
	}

	public Client(String title) {
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
					writer.println(name + " : " + sendBox.getText()); 	// 사용자의 이름과 내용 전달
					sendBox.setText(""); 								// sendBox의 내용을 지운다.
				} catch (Exception ie) {
				}
			}
		});
		pack();
	}

	public void run() {
		while (true) {
			try {
				String str = reader.readLine();

				if (str.toUpperCase().charAt(0) == '·')
					nameBox.setText(str);
				else if(str.toUpperCase().charAt(0) == '/')
					;
//				else if(str.toUpperCase().charAt(0) == '=')
//					;
				else
					msgView.append(str + "\n");
			} catch (IOException ie) {
			}
		}
	}

	private void connect() {
		try {
			msgView.append("서버소켓과의 연결을 시도합니다.\n");
			socket = new Socket("127.0.0.1", 7777);
			msgView.append("채팅 준비가 완료되었습니다.\n");
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new PrintWriter(socket.getOutputStream(), true);

			new Thread(this).start();
			writer.println("/"+name); 
		} catch (Exception e) {
			msgView.append("연결 실패..");
		}
	}

}