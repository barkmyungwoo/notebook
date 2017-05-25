package client;

import java.awt.*;
//import java.awt.color.ColorSpace;
import java.awt.event.*;
import java.io.PrintWriter;
import java.util.*;

import javax.swing.*;
//import javax.swing.border.*;

public class ArrowGame extends JFrame {

	private Font font1 = new Font("바탕", Font.BOLD, 60);
	private Font font2 = new Font("바탕", Font.PLAIN, 20);
	private PrintWriter writer;
	private String name;
	
	Random r = new Random();

	JButton jb1, jb2, jb3, jb4, jb5, jb6, jb7, jb8, jb9;
	JPanel jp2, jp4, jp6, jp8;
	JLabel jp1, jp3, jp7, jp9, jp10;

	// 각 버튼에 불이 들어오는 시간. 점점 짧아짐.
	int threadTime = 500;

	int seqDemo = 0; // 프로그램 문제 시연 상태
	int inputAwait = 0; // 사용자 입력 대기 상태
	int exit=0;

	ArrayList<String> alist = new ArrayList<String>(); // 문제 어레이
	ArrayList<String> alist1 = new ArrayList<String>(); // 입력된 답안 어레이

	int stage = 1; // 기본 시작 스테이지 레벨
	int remSeq; // 남은 시퀀스 갯수

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
			// 마우스 클릭 반응
			click();
			// 구동 직후 잠시 대기
			do {
				try {
					Thread.sleep(1000);
					question();
				} catch (InterruptedException e) {
				}
			} while (exit==0);
			dispose();
		}

		// 문제 제출
		public void question() {
			while (inputAwait == 0) {
				// 정답 맞춘 뒤 잠시 대기 후 문제 제출
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				// 문제와 답안 어레이 초기화
				alist.removeAll(alist);
				alist1.removeAll(alist1);

				jp9.setText("현재 도전 단계 : " + stage);
				remSeq = stage + 2;

				for (int i = 1; i <= stage + 2; i++) {
					jp1.setText("");
					jp3.setText("문제 내는 중...");
					jp7.setText("남은 순서 : " + remSeq);
					seqDemo = 1; // 프로그램 문제 출제 시작. 시퀀스 시연.
					int random = r.nextInt(4) + 1; // 4분의 1확률로 방향을 어레이에 추가
					if (random == 1) { // 위
						jp7.setText("남은 순서 : " + (--remSeq)); // 시퀀스 길이
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
					if (random == 2) { // 왼쪽
						jp7.setText("남은 순서 : " + (--remSeq)); // 시퀀스 길이
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
					if (random == 3) { // 오른쪽
						jp7.setText("남은 순서 : " + (--remSeq)); // 시퀀스 길이
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
					if (random == 4) { // 아래
						jp7.setText("남은 순서 : " + (--remSeq)); // 시퀀스 길이
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
				jp3.setText("순서대로 입력 뒤 OK");
				System.out.println("문제 : " + alist);
				seqDemo = 0; // 프로그램 문제 출제 끝. 시퀀스 시연 끝.
				inputAwait = 1; // 사용자 입력 대기
			}
		}

		public void click() {
			// 클릭으로 어레이에 해당 방향 추가해 답안 제출
			jb2.addMouseListener(new MouseAdapter() { // 위
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

			jb4.addMouseListener(new MouseAdapter() { // 왼쪽
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

			jb6.addMouseListener(new MouseAdapter() { // 오른쪽
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

			jb8.addMouseListener(new MouseAdapter() { // 아래
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

			jb5.addMouseListener(new MouseAdapter() { // 확인
				public void mousePressed(MouseEvent e) {
					if (seqDemo == 0) {
						jb5.setBackground(Color.WHITE);
					}
				}

				public void mouseReleased(MouseEvent e) {
					if (seqDemo == 0) {
						// 제출된 답안이 정답인 경우
						if (alist.equals(alist1)) {

							System.out.println("제출된 답안 : " + alist1);
							stage++;
							remSeq = stage + 2;
							jp3.setText("정답!!!");
							jp7.setText("남은 순서 : " + remSeq);
							// 속도 점점 증가
							threadTime = (int) (threadTime * 0.85);
							// 최저 속도 100으로 고정
							if (threadTime <= 100) {
								threadTime = 100;
							}
							System.out.println("속도 : " + threadTime);
							jp1.setText("속도 증가...");
							inputAwait = 0;
						} else {
							// 제출된 답안이 오답인 경우
							writer.println("@"+name+":"+stage);
							jb5.setIcon(new ImageIcon("src/game/img/dead.png"));
							jp1.setText("");
							jp3.setText("");
							jb5.setText("");
							jp7.setText("GAME OVER!!!");
							System.out.println("GAME OVER!");
							System.out.println("최종 도달 단계 : " + (stage - 1));
							jp9.setText("최종 도달 단계 : " + (stage - 1));
							exit=1;
						}
					}
				}
			});
		}
	}

	public void frame() {

		setTitle("화살표 기억 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 600);
		this.setResizable(false);
		this.setLocation(500, 100);

		setLayout(new GridLayout(0, 3));

		jp1 = new JLabel("", SwingConstants.CENTER);
		jp1.setFont(font2);

		jb2 = new JButton(""); // 위
		jb2.setBackground(new Color(115, 25, 35));

		jp3 = new JLabel("", SwingConstants.CENTER);
		jp3.setFont(font2);

		jb4 = new JButton(""); // 왼쪽
		jb4.setBackground(new Color(35, 85, 100));

		jb5 = new JButton("OK"); // 제출버튼
		jb5.setFont(font1);

		jb6 = new JButton(""); // 오른쪽
		jb6.setBackground(new Color(110, 100, 35));

		jp7 = new JLabel("", SwingConstants.CENTER); // 남은 시연 시퀀스 갯수
		jp7.setFont(font2);

		jb8 = new JButton(""); // 아래
		jb8.setBackground(new Color(70, 125, 85));

		jp9 = new JLabel("", SwingConstants.CENTER); // 시퀀스 길이
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
