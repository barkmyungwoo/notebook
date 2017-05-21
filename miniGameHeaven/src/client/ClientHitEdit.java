package client;

import java.awt.*;
import java.awt.event.*;
import java.net.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.io.*;

public class ClientHitEdit extends JFrame implements Runnable {
	private String name = "���ġ ����";

	// GUI�� ����
	private JLabel nameBox;
	private JTextField sendBox;
	private JTextArea msgView, userList;
	private JButton send;
	private JPanel north, south, west, center;

	// ��ſ� ����
	private BufferedReader reader;
	private PrintWriter writer;
	private Socket socket;

	private int gameOn = 0;
	private int gameType = 0;

	public ClientHitEdit(String title) {
		// super(title);

		this.setTitle("�̴ϰ��� õ��");
		this.setBounds(new Rectangle(100, 100, 870, 500));
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		nameBox = new JLabel(name + "�� ȯ���ؿ�.");
		north = new JPanel();
		north.add(nameBox);

		this.add(north, BorderLayout.NORTH);
		// -------------------------------------------------------------- ���� ��

		sendBox = new JTextField(50);
		send = new JButton("����");

		south = new JPanel();
		south.add(new JLabel("������ �޼��� : "));
		south.add(sendBox);
		south.add(send);

		this.add(south, BorderLayout.SOUTH);

		// --------------------------------------------------------------- ���� ��

		msgView = new JTextArea(19, 60);

		center = new JPanel();
		center.add(new JLabel("�ְ���� �޼��� ���â"));
		center.add(msgView);

		this.add(center, BorderLayout.CENTER);

		// --------------------------------------------------------------- ���

		userList = new JTextArea(19, 15);

		west = new JPanel();
		west.add(new JLabel("���� ���"));
		west.add(userList);
		west.setPreferredSize(new Dimension(180, 400));
		this.add(west, BorderLayout.WEST);

		// -----------------------------------------------------------------------

		// sendBox �׼� �̺�Ʈ ó��
		sendBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					writer.println(name + " : " + sendBox.getText()); // �������
					if (gameOn == 1) {

					}
					sendBox.setText(""); // sendBox�� ������ �����.

				} catch (Exception ie) {
				}
			}
		});

		send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					writer.println(name + " : " + sendBox.getText()); // �������
					sendBox.setText(""); // sendBox�� ������ �����.
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
					if (str.charAt(0) == '��') {
						nameBox.setText("<html><center><br>" + str.replaceAll("��", "") + "<br><br><center></html>");
					} else if (str.charAt(0) == '/')
						writer.println("-" + name + socket.getInetAddress());
					else if (str.charAt(0) == '��')
						userList.setText(str + "\n");
					else if (str.charAt(0) == '-')
						userList.append(str + "\n");
					else if (str.equals("3")) {
						numberGame();
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
				nameBox.setText("<html><center><br>"+howTo[i]+"<br></center></html>");
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
				nameBox.setText("<html><center><br>"+count + "�ܰ� ����.<br></center></html>");
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}

			for (int j = 0; j < count; j++) {
				nameBox.setText("<html><center><br>"+direct[j]+"<br></center></html>");
				try {
					Thread.sleep(1000);
					nameBox.setText("<html><center><br> <br></center></html>");
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			nameBox.setText("<html><center><br>�Է��ϼ���!"+"<br></center></html>");

			if (ng.answerCheck(sendBox.getText()))
				count++;
			else
				break;
		}
		writer.println("3" + name + count);
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

	public static void main(String[] args) {
		ClientHitEdit client = new ClientHitEdit("�̴ϰ��� õ��");
		client.setDefaultCloseOperation(EXIT_ON_CLOSE);
		client.setVisible(true);
		client.connect();
	}

}