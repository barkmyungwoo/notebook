package client;

import java.awt.*;
import java.awt.event.*;
import java.io.PrintWriter;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;

public class ArrowGame extends JFrame {
	Random r = new Random();
	private PrintWriter writer;
	private String name;
	JButton jb1, jb2, jb3, jb4, jb5, jb6, jb7, jb8, jb9;
	JPanel jp1, jp2, jp3, jp4, jp6, jp8;
	JLabel jp7, jp9, jp10;

	int seqDemo = 0; // ���α׷� ���� �ÿ� ����
	int inputAwait = 0; // ����� �Է� ��� ����

	ArrayList<String> alist = new ArrayList<String>(); // ���� ���
	ArrayList<String> alist1 = new ArrayList<String>(); // �Էµ� ��� ���

	int stage = 1; // �⺻ ���� �������� ����
	int remSeq = stage + 2; // ���� ������ ����
	int exit=0;

	public ArrowGame() {
		this.frame();
		new ArrowGen().start();
	}
	
	public ArrowGame(PrintWriter writer, String name) {
		this.writer = writer;
		this.name = name;

		this.frame();
		new ArrowGen().start();
	}

	class ArrowGen {
		public void start() {
			click();
			do {
				question();
				
				if(exit==1){
					break;
				}
			} while (true);
			
			dispose();
		}

		public void question() {
			while (inputAwait == 0) {
				alist.removeAll(alist);
				alist1.removeAll(alist1);

				for (int i = 1; i <= stage + 2; i++) {
					seqDemo = 1; // ���α׷� ���� ���� ����. ������ �ÿ�.
					int random = r.nextInt(4) + 1; // 4���� 1Ȯ���� ������ ��̿� �߰�
					if (random == 1) { // ��
						alist.add("UP");
						jb2.setBackground(new Color(204, 0, 0));
						try {
							Thread.sleep(500);
							jb2.setBackground(null);
							Thread.sleep(300);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					if (random == 2) { // ����
						alist.add("LEFT");
						jb4.setBackground(new Color(0, 102, 204));
						try {
							Thread.sleep(500);
							jb4.setBackground(null);
							Thread.sleep(300);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					if (random == 3) { // ������
						alist.add("RIGHT");
						jb6.setBackground(new Color(255, 255, 51));
						try {
							Thread.sleep(500);
							jb6.setBackground(null);
							Thread.sleep(300);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					if (random == 4) { // �Ʒ�
						alist.add("DOWN");
						jb8.setBackground(new Color(0, 204, 0));
						try {
							Thread.sleep(500);
							jb8.setBackground(null);
							Thread.sleep(300);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					jp7.setText("���� Ƚ�� : " + (--remSeq));

				}
				System.out.println(alist);
				seqDemo = 0; // ���α׷� ���� ���� ��. ������ �ÿ� ��.
				inputAwait = 1; // ����� �Է� ���
			}			
		}

		public void click() {

			// Ŭ������ ��̿� �ش� ���� �߰��� ��� ����
			jb2.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					alist1.add("UP");
					jb2.setBackground(new Color(204, 0, 0));
					System.out.println(alist1);
				}

				public void mouseReleased(MouseEvent e) {
					jb2.setBackground(null);
				}
			});

			jb4.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					alist1.add("LEFT");
					jb4.setBackground(new Color(0, 102, 204));
					System.out.println(alist1);
				}

				public void mouseReleased(MouseEvent e) {
					jb4.setBackground(null);
				}
			});

			jb6.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					alist1.add("RIGHT");
					jb6.setBackground(new Color(255, 255, 51));
					System.out.println(alist1);
				}

				public void mouseReleased(MouseEvent e) {
					jb6.setBackground(null);
				}
			});

			jb8.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					alist1.add("DOWN");
					jb8.setBackground(new Color(0, 204, 0));
					System.out.println(alist1);
				}

				public void mouseReleased(MouseEvent e) {
					jb8.setBackground(null);
				}
			});

			jb5.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					jb5.setBackground(Color.GRAY);
				}

				public void mouseReleased(MouseEvent e) {
					jb5.setBackground(null);

					if (alist.size() == alist1.size()) {
						for (int i = 0; i < alist.size(); i++) {
							if (alist.get(i) == alist1.get(i))
								continue;
							else {
								writer.println("@" + name + ":" + stage);
								exit=1;
								System.out.println("exit=1");
							}
						}
					} else {
						writer.println("@" + name + ":" + stage);
						exit=1;
						System.out.println("exit=2");
					}

					System.out.println(alist1);
					remSeq = 3 + stage++;
					inputAwait = 0;
					jp7.setText("���� Ƚ�� : " + remSeq);
					jp9.setText("�������� : " + stage);

				}
			});
		}
	}

	public void frame() {

		setTitle("ȭ��ǥ ��� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 500);
		this.setResizable(false);
		this.setLocation(100, 100);

		setLayout(new GridLayout(0, 3));

		jp1 = new JPanel();
		jb2 = new JButton("UP"); // ��

		jp3 = new JPanel();
		jb4 = new JButton("LEFT"); // ����
		jb5 = new JButton("SUBMIT"); // �����ư
		jb6 = new JButton("RIGHT"); // ������

		jp7 = new JLabel("���� Ƚ�� : " + remSeq); // ���� �ÿ� ������ ����
		jb8 = new JButton("DOWN"); // �Ʒ�
		jp9 = new JLabel("�������� : " + stage); // ������ ����

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
