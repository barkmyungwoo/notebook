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

	int seqDemo = 0; // 프로그램 문제 시연 상태
	int inputAwait = 0; // 사용자 입력 대기 상태

	ArrayList<String> alist = new ArrayList<String>(); // 문제 어레이
	ArrayList<String> alist1 = new ArrayList<String>(); // 입력된 답안 어레이

	int stage = 1; // 기본 시작 스테이지 레벨
	int remSeq = stage + 2; // 남은 시퀀스 갯수
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
					seqDemo = 1; // 프로그램 문제 출제 시작. 시퀀스 시연.
					int random = r.nextInt(4) + 1; // 4분의 1확률로 방향을 어레이에 추가
					if (random == 1) { // 위
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
					if (random == 2) { // 왼쪽
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
					if (random == 3) { // 오른쪽
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
					if (random == 4) { // 아래
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
					jp7.setText("남은 횟수 : " + (--remSeq));

				}
				System.out.println(alist);
				seqDemo = 0; // 프로그램 문제 출제 끝. 시퀀스 시연 끝.
				inputAwait = 1; // 사용자 입력 대기
			}			
		}

		public void click() {

			// 클릭으로 어레이에 해당 방향 추가해 답안 제출
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
					jp7.setText("남은 횟수 : " + remSeq);
					jp9.setText("스테이지 : " + stage);

				}
			});
		}
	}

	public void frame() {

		setTitle("화살표 기억 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 500);
		this.setResizable(false);
		this.setLocation(100, 100);

		setLayout(new GridLayout(0, 3));

		jp1 = new JPanel();
		jb2 = new JButton("UP"); // 위

		jp3 = new JPanel();
		jb4 = new JButton("LEFT"); // 왼쪽
		jb5 = new JButton("SUBMIT"); // 제출버튼
		jb6 = new JButton("RIGHT"); // 오른쪽

		jp7 = new JLabel("남은 횟수 : " + remSeq); // 남은 시연 시퀀스 갯수
		jb8 = new JButton("DOWN"); // 아래
		jp9 = new JLabel("스테이지 : " + stage); // 시퀀스 길이

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
