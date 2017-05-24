package client;

import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.PrintWriter;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MoleGame extends JFrame {
	PrintWriter writer;
	Random r = new Random(); // 두더지 랜덤발생
	private JLabel h1, h2, h3, h4, h5, h6, h7, h8, h9; // 두더지
	private int timeNum = 30; // 시간
	int scoreNum = 0; // 점수
	String name;
	private JTextField time; // 시간필드
	private JTextField score; // 점수필드
	private int speed = 1000; // 게임속도
	private int on1, on2, on3, on4, on5, on6, on7, on8, on9; // 두더지 스위치

	// public String scoreSend(){ //점수를 서버에 보내는 메소드
	// return String.valueOf(scoreNum);
	// }
	public MoleGame() {
		setTitle("두더지 게임"); // 게임타이틀
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 종료시 프로그램종료
		this.init(); // 화면구성 메소드
		this.setSize(218, 282); // 크기
		this.hole(); // 두더지 클릭메소드

		(new TimeThread()).start();
		(new MoleUp()).start();
		this.setVisible(true);
		
	}
	
	public MoleGame(PrintWriter writer, String name) {
		this.writer = writer;
		this.name = name;

		setTitle("두더지 게임"); // 게임타이틀
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 종료시 프로그램종료
		this.init(); // 화면구성 메소드
		this.setSize(218, 282); // 크기
		this.hole(); // 두더지 클릭메소드

		(new TimeThread()).start();
		(new MoleUp()).start();
		this.setVisible(true);
		
	}

	class TimeThread extends Thread { // 시간관리 스레드
		public void run() {
			do {
				try {
					Thread.sleep(1000);
					timeNum -= 1;
					time.setText(String.valueOf(timeNum));

					if (timeNum == 0) { // 시간종료시 쓰레드종료와 동시에 타임오버 창표시
						writer.println("@"+name+":"+scoreNum);
						JOptionPane.showMessageDialog(time, "T i m e O v e r\n" + "점수는 " + scoreNum + "점 입니다.");
						break;
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			} while (true);
			dispose();
		}
	}

	class MoleUp extends Thread { // 두더지발생 스레드
		public void run() {
			do {
				try {
					if (timeNum == 20) {
						speed = 300;
					}
					if (timeNum == 10) {
						speed = 100;
					}
					Thread.sleep(speed);

					if (timeNum == 0) { // 시간종료시 쓰레드종료
						break;
					}

					score.setText(String.valueOf(scoreNum));

					switch (r.nextInt(10)) {
					case 1:
						h1.setIcon(new ImageIcon("src/client/img/up.gif"));
						on1 = 1;
						hit(h1, 1);
						break;
					case 2:
						h2.setIcon(new ImageIcon("src/client/img/up.gif"));
						on2 = 1;
						hit(h2, 2);
						break;
					case 3:
						h3.setIcon(new ImageIcon("src/client/img/up.gif"));
						on3 = 1;
						hit(h3, 3);
						break;
					case 4:
						h4.setIcon(new ImageIcon("src/client/img/up.gif"));
						on4 = 1;
						hit(h4, 4);
						break;
					case 5:
						h5.setIcon(new ImageIcon("src/client/img/up.gif"));
						on5 = 1;
						hit(h5, 5);
						break;
					case 6:
						h6.setIcon(new ImageIcon("src/client/img/up.gif"));
						on6 = 1;
						hit(h6, 6);
						break;
					case 7:
						h7.setIcon(new ImageIcon("src/client/img/up.gif"));
						on7 = 1;
						hit(h7, 7);
						break;
					case 8:
						h8.setIcon(new ImageIcon("src/client/img/up.gif"));
						on8 = 1;
						hit(h8, 8);
						break;
					case 9:
						h9.setIcon(new ImageIcon("src/client/img/up.gif"));
						on9 = 1;
						hit(h9, 9);
						break;
					}

				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			} while (true);
		}
	}

	public void hit(JLabel h, int on) { // 두더지 내려가는 메소드
		try {
			Thread.sleep(700);
			h.setIcon(new ImageIcon("src/client/img/hole.gif"));
			switch (on) {
			case 1:
				on1 = 0;
				break;
			case 2:
				on2 = 0;
				break;
			case 3:
				on3 = 0;
				break;
			case 4:
				on4 = 0;
				break;
			case 5:
				on5 = 0;
				break;
			case 6:
				on6 = 0;
				break;
			case 7:
				on7 = 0;
				break;
			case 8:
				on8 = 0;
				break;
			case 9:
				on9 = 0;
				break;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// 생성자
	public void hole() {
		h1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (on1 == 1) {
					scoreNum += 100;
					h1.setIcon(new ImageIcon("src/client/img/hit.gif"));
				}
				on1 = 0;
			}
		});
		h2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (on2 == 1) {
					scoreNum += 100;
					h2.setIcon(new ImageIcon("src/client/img/hit.gif"));
				}
				on2 = 0;
			}
		});
		h3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (on3 == 1) {
					scoreNum += 100;
					h3.setIcon(new ImageIcon("src/client/img/hit.gif"));
				}
				on3 = 0;
			}
		});
		h4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (on4 == 1) {
					scoreNum += 100;
					h4.setIcon(new ImageIcon("src/client/img/hit.gif"));
				}
				on4 = 0;
			}
		});
		h5.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (on5 == 1) {
					scoreNum += 100;
					h5.setIcon(new ImageIcon("src/client/img/hit.gif"));
				}
				on5 = 0;
			}
		});
		h6.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (on6 == 1) {
					scoreNum += 100;
					h6.setIcon(new ImageIcon("src/client/img/hit.gif"));
				}
				on6 = 0;
			}
		});
		h7.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (on7 == 1) {
					scoreNum += 100;
					h7.setIcon(new ImageIcon("src/client/img/hit.gif"));
				}
				on7 = 0;
			}
		});
		h8.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (on8 == 1) {
					scoreNum += 100;
					h8.setIcon(new ImageIcon("src/client/img/hit.gif"));
				}
				on8 = 0;
			}
		});
		h9.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (on9 == 1) {
					scoreNum += 100;
					h9.setIcon(new ImageIcon("src/client/img/hit.gif"));
				}
				on9 = 0;
			}
		});

	}

	public void init() { // 두더지 화면구성
		setLayout(new GridLayout(4, 3));

		h1 = new JLabel();
		h1.setIcon(new ImageIcon("src/client/img/hole.gif"));
		h2 = new JLabel();
		h2.setIcon(new ImageIcon("src/client/img/hole.gif"));
		h3 = new JLabel();
		h3.setIcon(new ImageIcon("src/client/img/hole.gif"));
		h4 = new JLabel();
		h4.setIcon(new ImageIcon("src/client/img/hole.gif"));
		h5 = new JLabel();
		h5.setIcon(new ImageIcon("src/client/img/hole.gif"));
		h6 = new JLabel();
		h6.setIcon(new ImageIcon("src/client/img/hole.gif"));
		h7 = new JLabel();
		h7.setIcon(new ImageIcon("src/client/img/hole.gif"));
		h8 = new JLabel();
		h8.setIcon(new ImageIcon("src/client/img/hole.gif"));
		h9 = new JLabel();
		h9.setIcon(new ImageIcon("src/client/img/hole.gif"));

		time = new JTextField();
		score = new JTextField();

		this.add(h1);
		this.add(h2);
		this.add(h3);
		this.add(h4);
		this.add(h5);
		this.add(h6);
		this.add(h7);
		this.add(h8);
		this.add(h9);
		this.add(new JLabel("시간, 점수 : "));
		this.add(time);
		this.add(score);

	}

}
