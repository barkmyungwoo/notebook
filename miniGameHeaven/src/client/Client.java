package client;

import java.awt.*;
import java.awt.event.*;
import java.net.*;

import javax.swing.JFrame;

import java.io.*;

public class Client extends JFrame implements Runnable {
	private TextField nameBox = new TextField("�ڸ��"); // ����� �̸��� ��Ÿ����.
	private TextArea msgView = new TextArea();
	private TextField sendBox = new TextField();
	private BufferedReader reader;
	private PrintWriter writer;
	private Socket socket;
	private String name = "�ڸ��";

	public static void main(String[] args) {
		Client client = new Client("ä��");
		client.setVisible(true);
		client.connect();
	}

	public Client(String title) {
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
					writer.println(name + " : " + sendBox.getText()); 	// ������� �̸��� ���� ����
					sendBox.setText(""); 								// sendBox�� ������ �����.
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

				if (str.toUpperCase().charAt(0) == '��')
					nameBox.setText(str);
				else
					msgView.append(str + "\n");
			} catch (IOException ie) {
			}
		}
	}

	private void connect() {
		try {
			msgView.append("�������ϰ��� ������ �õ��մϴ�.\n");
			socket = new Socket("127.0.0.1", 7777);
			msgView.append("ä�� �غ� �Ϸ�Ǿ����ϴ�.\n");
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new PrintWriter(socket.getOutputStream(), true);

			new Thread(this).start();
		} catch (Exception e) {
			msgView.append("���� ����..");
		}
	}

}