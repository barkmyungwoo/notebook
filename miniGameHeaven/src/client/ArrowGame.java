package client;

import java.awt.*;
//import java.awt.color.ColorSpace;
import java.awt.event.*;
import java.io.PrintWriter;
import java.util.*;

import javax.swing.*;
//import javax.swing.border.*;

public class ArrowGame extends JFrame {

	private Font font1 = new Font("����", Font.BOLD, 60);
	private Font font2 = new Font("����", Font.PLAIN, 20);
	private PrintWriter writer;
	private String name;
	
	Random r = new Random();

	JButton jb1, jb2, jb3, jb4, jb5, jb6, jb7, jb8, jb9;
	JPanel jp2, jp4, jp6, jp8;
	JLabel jp1, jp3, jp7, jp9, jp10;

	// �� ��ư�� ���� ������ �ð�. ���� ª����.
	int threadTime = 500;

	int seqDemo = 0; // ���α׷� ���� �ÿ� ����
	int inputAwait = 0; // ����� �Է� ��� ����
	int exit=0;

	ArrayList<String> alist = new ArrayList<String>(); // ���� ���
	ArrayList<String> alist1 = new ArrayList<String>(); // �Էµ� ��� ���

	int stage = 1; // �⺻ ���� �������� ����
	int remSeq; // ���� ������ ����

	public ArrowGame() {

		this.frame();
		this.addWindowListener(new JFrameWindowClosingEventHandler());
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		new ArrowGen().start();
	}
	
	public ArrowGame(PrintWriter writer, String name) {
		this.writer = writer;
		this.name = name;
		
		this.frame();
		this.addWindowListener(new JFrameWindowClosingEventHandler());
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		new ArrowGen().start();
	}
	
	class JFrameWindowClosingEventHandler extends WindowAdapter{
		public void windowClosing(WindowEvent e){
			writer.println("@"+name+":"+stage);

			JFrame frame = (JFrame)e.getWindow();
			frame.dispose();
			exit=1;
			System.out.println("closed");
		}
	}

	class ArrowGen {

		public void start() {
			// ���콺 Ŭ�� ����
			click();
			// ���� ���� ��� ���
			do {
				try {
					Thread.sleep(1000);
					question();
				} catch (InterruptedException e) {
				}
			} while (exit==0);
			dispose();
		}

		// ���� ����
		public void question() {
			while (inputAwait == 0) {
				// ���� ���� �� ��� ��� �� ���� ����
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				// ������ ��� ��� �ʱ�ȭ
				alist.removeAll(alist);
				alist1.removeAll(alist1);

				jp9.setText("���� ���� �ܰ� : " + stage);
				remSeq = stage + 2;

				for (int i = 1; i <= stage + 2; i++) {
					jp1.setText("");
					jp3.setText("���� ���� ��...");
					jp7.setText("���� ���� : " + remSeq);
					seqDemo = 1; // ���α׷� ���� ���� ����. ������ �ÿ�.
					int random = r.nextInt(4) + 1; // 4���� 1Ȯ���� ������ ��̿� �߰�
					if (random == 1) { // ��
						jp7.setText("���� ���� : " + (--remSeq)); // ������ ����
						alist.add("UP");
						jb2.setBackground(new Color(230, 50, 70));
						System.out.println(alist);
						try {
							Thread.sleep(threadTime);
							jb2.setBackground(new Color(115, 25, 35));
							Thread.sleep(300);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					if (random == 2) { // ����
						jp7.setText("���� ���� : " + (--remSeq)); // ������ ����
						alist.add("LEFT");
						jb4.setBackground(new Color(70, 170, 200));
						System.out.println(alist);
						try {
							Thread.sleep(threadTime);
							jb4.setBackground(new Color(35, 85, 100));
							Thread.sleep(300);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					if (random == 3) { // ������
						jp7.setText("���� ���� : " + (--remSeq)); // ������ ����
						alist.add("RIGHT");
						jb6.setBackground(new Color(220, 200, 70));
						System.out.println(alist);
						try {
							Thread.sleep(threadTime);
							jb6.setBackground(new Color(110, 100, 35));
							Thread.sleep(300);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					if (random == 4) { // �Ʒ�
						jp7.setText("���� ���� : " + (--remSeq)); // ������ ����
						alist.add("DOWN");
						jb8.setBackground(new Color(140, 250, 170));
						System.out.println(alist);
						try {
							Thread.sleep(threadTime);
							jb8.setBackground(new Color(70, 125, 85));
							Thread.sleep(300);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

				}
				jp3.setText("������� �Է� �� OK");
				System.out.println("���� : " + alist);
				seqDemo = 0; // ���α׷� ���� ���� ��. ������ �ÿ� ��.
				inputAwait = 1; // ����� �Է� ���
			}
		}

		public void click() {
			// Ŭ������ ��̿� �ش� ���� �߰��� ��� ����
			jb2.addMouseListener(new MouseAdapter() { // ��
				public void mousePressed(MouseEvent e) {
					if (seqDemo == 0) {
						alist1.add("UP");
						jb2.setBackground(new Color(230, 50, 70));
					}
				}

				public void mouseReleased(MouseEvent e) {
					jb2.setBackground(new Color(115, 25, 35));
				}
			});

			jb4.addMouseListener(new MouseAdapter() { // ����
				public void mousePressed(MouseEvent e) {
					if (seqDemo == 0) {
						alist1.add("LEFT");
						jb4.setBackground(new Color(70, 170, 200));
					}
				}

				public void mouseReleased(MouseEvent e) {
					jb4.setBackground(new Color(35, 85, 100));
				}
			});

			jb6.addMouseListener(new MouseAdapter() { // ������
				public void mousePressed(MouseEvent e) {
					if (seqDemo == 0) {
						alist1.add("RIGHT");
						jb6.setBackground(new Color(220, 200, 70));
					}
				}

				public void mouseReleased(MouseEvent e) {
					jb6.setBackground(new Color(110, 100, 35));
				}
			});

			jb8.addMouseListener(new MouseAdapter() { // �Ʒ�
				public void mousePressed(MouseEvent e) {
					if (seqDemo == 0) {
						alist1.add("DOWN");
						jb8.setBackground(new Color(140, 250, 170));
					}
				}

				public void mouseReleased(MouseEvent e) {
					jb8.setBackground(new Color(70, 125, 85));
				}
			});

			jb5.addMouseListener(new MouseAdapter() { // Ȯ��
				public void mousePressed(MouseEvent e) {
					if (seqDemo == 0) {
						jb5.setBackground(Color.WHITE);
					}
				}

				public void mouseReleased(MouseEvent e) {
					if (seqDemo == 0) {
						// ����� ����� ������ ���
						if (alist.equals(alist1)) {

							System.out.println("����� ��� : " + alist1);
							stage++;
							remSeq = stage + 2;
							jp3.setText("����!!!");
							jp7.setText("���� ���� : " + remSeq);
							// �ӵ� ���� ����
							threadTime = (int) (threadTime * 0.85);
							// ���� �ӵ� 100���� ����
							if (threadTime <= 100) {
								threadTime = 100;
							}
							System.out.println("�ӵ� : " + threadTime);
							jp1.setText("�ӵ� ����...");
							inputAwait = 0;
						} else {
							// ����� ����� ������ ���
							writer.println("@"+name+":"+stage);
							jb5.setIcon(new ImageIcon("src/game/img/dead.png"));
							jp1.setText("");
							jp3.setText("");
							jb5.setText("");
							jp7.setText("GAME OVER!!!");
							System.out.println("GAME OVER!");
							System.out.println("���� ���� �ܰ� : " + (stage - 1));
							jp9.setText("���� ���� �ܰ� : " + (stage - 1));
							exit=1;
						}
					}
				}
			});
		}
	}

	public void frame() {

		setTitle("ȭ��ǥ ��� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 600);
		this.setResizable(false);
		this.setLocation(500, 100);

		setLayout(new GridLayout(0, 3));

		jp1 = new JLabel("", SwingConstants.CENTER);
		jp1.setFont(font2);

		jb2 = new JButton(""); // ��
		jb2.setBackground(new Color(115, 25, 35));

		jp3 = new JLabel("", SwingConstants.CENTER);
		jp3.setFont(font2);

		jb4 = new JButton(""); // ����
		jb4.setBackground(new Color(35, 85, 100));

		jb5 = new JButton("OK"); // �����ư
		jb5.setFont(font1);

		jb6 = new JButton(""); // ������
		jb6.setBackground(new Color(110, 100, 35));

		jp7 = new JLabel("", SwingConstants.CENTER); // ���� �ÿ� ������ ����
		jp7.setFont(font2);

		jb8 = new JButton(""); // �Ʒ�
		jb8.setBackground(new Color(70, 125, 85));

		jp9 = new JLabel("", SwingConstants.CENTER); // ������ ����
		jp9.setFont(font2);

		this.add(jp1);
		this.add(jb2);
		this.add(jp3);
		this.add(jb4);
		this.add(jb5);
		this.add(jb6);
		this.add(jp7);
		this.add(jb8);
		this.add(jp9);

		this.setVisible(true);

	}
}
