package client.game;

import java.awt.EventQueue;
import java.util.Random;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.PrintWriter;

public class poketmonGame extends JFrame {

	private JLabel background, label1, label2, label3, label4; // 플레이어1~4
	private int x1 = 100, x2 = 100, x3 = 100, x4 = 100;
	private JLabel textArea, textArea2;
	private JTextField textField;
	double second = 0;

	private PrintWriter writer;
	private String name;
	private int exit=0;

	private JLabel label, ok, no;
	private JTextField selected;
	private JPanel panel;
	private JList list;
	private String[] cities = { "피카츄", "파이리", "꼬부기", "이상해씨" };
	private int endLine = 500;
	private String a;
	private Random b = new Random();
	private char right = (char) (97 + b.nextInt(25));

	class ComThread extends Thread {
		public void run() {
			do {
				try {
					Thread.sleep(500);
					second += 0.5;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				x2 += (int) (Math.random() * 10);
				label2.setBounds(x2, 50, 100, 100);
				x3 += (int) (Math.random() * 10);
				label3.setBounds(x3, 100, 100, 100);
				x4 += (int) (Math.random() * 10);
				label4.setBounds(x4, 150, 100, 100);
				if (x2 >= endLine || x3 >= endLine || x4 >= endLine) {
					writer.println("@" + name + ":" + (-1));
					JOptionPane.showMessageDialog(panel, "탈락!");
					second = 0;
					break;
				}
				if (x1 >= endLine) {
					writer.println("@" + name + ":" + second);
					JOptionPane.showMessageDialog(panel, "게임 종료.  " + (second * 10) + "초 걸림");
					break;

				}
			} while (exit==0);
			dispose();
		}
	}

	// 포켓몬 레이아웃

	JLabel imgLabel;

	public poketmonGame(PrintWriter writer, String name) {
		this.writer = writer;
		this.name = name;
		this.addWindowListener(new JFrameWindowClosingEventHandler());

		setTitle("포켓몬 레이싱");
		setSize(740, 574);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel panel = new JPanel();

		label = new JLabel("선택한 포켓몬");
		label.setBounds(535, 333, 108, 21);
		selected = new JTextField(10);
		selected.setBounds(620, 331, 82, 24);

		ok = new JLabel();
		ok.setBounds(408, 354, 108, 87);
		panel.add(ok);

		// 텍스트 필드를 편집 불가로 설정한다.
		selected.setEditable(false);
		panel.setLayout(null);
		panel.add(label);
		panel.add(selected);
		getContentPane().add(panel, BorderLayout.CENTER);
		list = new JList(cities);
		list.setBounds(620, 370, 76, 87);
		panel.add(list);

		// 리스트에 경계선을 설정한다.
		list.setBorder(BorderFactory.createLineBorder(Color.black, 1));

		// 리스트의 선택 모드를 단일 선택 모드로 변경
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// 포켓몬 모델
		JPanel panel_1 = new JPanel();

		panel_1.setBounds(37, 15, 561, 258);
		panel_1.setLayout(null);
		background = new JLabel();
		background.setIcon(new ImageIcon("src/client/img/poketmonGame/다운로드.gif"));
		label1 = new JLabel();
		label1.setIcon(new ImageIcon("src/client/img/poketmonGame/피카츄.gif"));
		label2 = new JLabel();
		label2.setIcon(new ImageIcon("src/client/img/poketmonGame/꼬부기.gif"));
		label3 = new JLabel();
		label3.setIcon(new ImageIcon("src/client/img/poketmonGame/파이리.gif"));
		label4 = new JLabel();
		label4.setIcon(new ImageIcon("src/client/img/poketmonGame/이상해씨.gif"));

		panel_1.add(label1);
		panel_1.add(label2);
		panel_1.add(label3);
		panel_1.add(label4);
		panel_1.add(background);

		background.setBounds(0, 0, 561, 258);
		label1.setBounds(x1, 0, 100, 100);
		label2.setBounds(x2, 50, 100, 100);
		label3.setBounds(x3, 100, 100, 100);
		label4.setBounds(x4, 150, 100, 100);

		panel.add(panel_1);

		textArea2 = new JLabel();
		textArea2.setFont(new Font("굴림", Font.BOLD, 33));
		textArea2.setBounds(223, 307, 280, 47);
		textArea2.setText("입력할 값 : " + right);
		panel.add(textArea2);
		textArea = new JLabel();
		textArea.setHorizontalAlignment(SwingConstants.CENTER);
		textArea.setFont(new Font("나눔손글씨 펜", Font.BOLD, 31));
		textArea.setBounds(80, 391, 350, 29);
		panel.add(textArea);
		textField = new JTextField();

		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				a = textField.getText();

				textField.setText("");

				if (a != null) {
					if (right == a.charAt(0)) {

						x1 += 15;
						textArea.setText("한칸 앞으로 이동!");
						label1.setBounds(x1, 0, 100, 100);
						right = (char) (b.nextInt(25) + 97);
						textArea2.setText("입력할 값 : " + right);
						ok.setIcon(new ImageIcon("src/client/img/poketmonGame/ok.gif"));
						return;
					} else {
						textArea.setText("잘못된 값을 입력하였습니다.");
						ok.setIcon(new ImageIcon("src/client/img/poketmonGame/no.gif"));
						return;
					}
				}
			}
		});

		textField.setBounds(80, 456, 519, 21);
		panel.add(textField);
		textField.setColumns(10);

		JLabel label_1 = new JLabel("입력창");
		label_1.setBounds(37, 459, 57, 15);
		panel.add(label_1);
		list.addListSelectionListener(new ListListener());

		setVisible(true);
		new ComThread().start();

		imgLabel = new JLabel(); // 그림 넣을 라벨 생성
		imgLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		imgLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		getContentPane().add(imgLabel, BorderLayout.SOUTH);
	}
	
	class JFrameWindowClosingEventHandler extends WindowAdapter{
		public void windowClosing(WindowEvent e){
			writer.println("@"+name+":"+(-1));
			JFrame frame = (JFrame)e.getWindow();
			exit=1;
			frame.dispose();
			System.out.println("closed");
		}
	}

	// 리스트
	private class ListListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			String selection = (String) list.getSelectedValue();
			selected.setText(selection);
			ImageIcon icon = new ImageIcon("src/client/img/poketmonGame/" + selection + ".gif");// 선택된
																								// 도시의
																								// 이미지
																								// 로딩
			label1.setIcon(icon);// 이미지 넣기
			imgLabel.setIcon(icon);
		}
	}

	// public static void main(String[] args) {
	// poketmon frame = new poketmon();
	// }
}
