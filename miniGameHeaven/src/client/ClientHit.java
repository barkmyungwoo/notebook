package client;

import java.awt.*;
import java.awt.event.*;
import java.net.*;

import javax.swing.JFrame;

import java.io.*;

public class ClientHit extends JFrame implements Runnable {
	String name = "mist";
	private TextField nameBox = new TextField(name); // ����� �̸��� ��Ÿ����.
	private TextArea msgView = new TextArea();
	private TextField sendBox = new TextField();
	private BufferedReader reader;
	private PrintWriter writer;
	private Socket socket;

	public ClientHit(String title) {
		super(title);
		msgView.setEditable(false);

		// ��Ʈ�ѵ��� ��ġ�Ѵ�.
		add(nameBox, "North");
		add(msgView, "Center");
		add(sendBox, "South");

		// sendBox �׼� �̺�Ʈ ó��
		sendBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					writer.println(name + " : " + sendBox.getText()); // �������
					sendBox.setText(""); 											// sendBox�� ������ �����.
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
				
				if(str.charAt(0)=='��')
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
			msgView.append("�������ϰ��� ������ �õ��մϴ�.\n");
			socket = new Socket("192.168.20.39", 7777);
			msgView.append("ä�� �غ� �Ϸ�Ǿ����ϴ�.\n");
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new PrintWriter(socket.getOutputStream(), true);

			new Thread(this).start();
		} catch (Exception e) {
			msgView.append("���� ����..");
		}
	}

	public static void main(String[] args) {
		ClientHit client = new ClientHit("�̴ϰ��� õ��");		
		client.setDefaultCloseOperation(EXIT_ON_CLOSE);
		client.setVisible(true);
		client.connect();
	}
}