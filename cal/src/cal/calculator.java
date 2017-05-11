package cal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class calculator {
	
	int text = 0, num1 = 0, num2 = 0, cal = 0;

	private JFrame frame;
	private JTextField textField;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calculator window = new calculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public calculator() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 426, 451);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		textField = new JTextField();
		textField.setBounds(12, 10, 386, 60);
		panel.add(textField);
		textField.setColumns(10);

		
		JButton button_1 = new JButton("1");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (num1 == 0) { // 첫번째 수에 값이 없을 경우
					num1 = 1;
					textField.setText(Integer.toString(num1));

				} else {
					if (cal == 0) {
						num1 *= 10;
						num1 += 1;
						textField.setText(Integer.toString(num1));
					} else {
						num2 *= 10;
						num2 += 1;
						textField.setText(Integer.toString(num2));
					}
				}

			}
		});
		button_1.setFont(new Font("굴림", Font.BOLD, 20));
		button_1.setBounds(12, 250, 90, 70);
		panel.add(button_1);

		JButton button_2 = new JButton("2");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (num1 == 0) { // 첫번째 수에 값이 없을 경우
					num1 = 2;
					textField.setText(Integer.toString(num1));

				} else {
					if (cal == 0) {
						num1 *= 10;
						num1 += 2;
						textField.setText(Integer.toString(num1));
					} else {
						num2 *= 10;
						num2 += 2;
						textField.setText(Integer.toString(num2));
					}
				}

			}
		});
		button_2.setFont(new Font("굴림", Font.BOLD, 20));
		button_2.setBounds(114, 250, 90, 70);
		panel.add(button_2);

		JButton button_3 = new JButton("3");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (num1 == 0) { // 첫번째 수에 값이 없을 경우
					num1 = 3;
					textField.setText(Integer.toString(num1));

				} else {
					if (cal == 0) {
						num1 *= 10;
						num1 += 3;
						textField.setText(Integer.toString(num1));
					} else {
						num2 *= 10;
						num2 += 3;
						textField.setText(Integer.toString(num2));
					}
				}

			}
		});
		button_3.setFont(new Font("굴림", Font.BOLD, 20));
		button_3.setBounds(216, 250, 90, 70);
		panel.add(button_3);

		JButton button_4 = new JButton("4");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (num1 == 0) { // 첫번째 수에 값이 없을 경우
					num1 = 4;
					textField.setText(Integer.toString(num1));

				} else {
					if (cal == 0) {
						num1 *= 10;
						num1 += 4;
						textField.setText(Integer.toString(num1));
					} else {
						num2 *= 10;
						num2 += 4;
						textField.setText(Integer.toString(num2));
					}
				}

			}
		});
		button_4.setFont(new Font("굴림", Font.BOLD, 20));
		button_4.setBounds(12, 165, 90, 70);
		panel.add(button_4);

		JButton button_5 = new JButton("5");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (num1 == 0) { // 첫번째 수에 값이 없을 경우
					num1 = 5;
					textField.setText(Integer.toString(num1));

				} else {
					if (cal == 0) {
						num1 *= 10;
						num1 += 5;
						textField.setText(Integer.toString(num1));
					} else {
						num2 *= 10;
						num2 += 5;
						textField.setText(Integer.toString(num2));
					}
				}

			}
		});
		button_5.setFont(new Font("굴림", Font.BOLD, 20));
		button_5.setBounds(114, 165, 90, 70);
		panel.add(button_5);
		
		JButton button_6 = new JButton("6");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (num1 == 0) { // 첫번째 수에 값이 없을 경우
					num1 = 6;
					textField.setText(Integer.toString(num1));

				} else {
					if (cal == 0) {
						num1 *= 10;
						num1 += 6;
						textField.setText(Integer.toString(num1));
					} else {
						num2 *= 10;
						num2 += 6;
						textField.setText(Integer.toString(num2));
					}
				}

			}
		});
		button_6.setFont(new Font("굴림", Font.BOLD, 20));
		button_6.setBounds(216, 165, 90, 70);
		panel.add(button_6);
		
		JButton button_7 = new JButton("7");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (num1 == 0) { // 첫번째 수에 값이 없을 경우
					num1 = 7;
					textField.setText(Integer.toString(num1));

				} else {
					if (cal == 0) {
						num1 *= 10;
						num1 += 7;
						textField.setText(Integer.toString(num1));
					} else {
						num2 *= 10;
						num2 += 7;
						textField.setText(Integer.toString(num2));
					}
				}

			}
		});
		button_7.setFont(new Font("굴림", Font.BOLD, 20));
		button_7.setBounds(12, 80, 90, 70);
		panel.add(button_7);

		JButton button_8 = new JButton("8");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (num1 == 0) { // 첫번째 수에 값이 없을 경우
					num1 = 8;
					textField.setText(Integer.toString(num1));

				} else {
					if (cal == 0) {
						num1 *= 10;
						num1 += 8;
						textField.setText(Integer.toString(num1));
					} else {
						num2 *= 10;
						num2 += 8;
						textField.setText(Integer.toString(num2));
					}
				}

			}
		});
		button_8.setFont(new Font("굴림", Font.BOLD, 20));
		button_8.setBounds(114, 80, 90, 70);
		panel.add(button_8);

		JButton button_9 = new JButton("9");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (num1 == 0) { // 첫번째 수에 값이 없을 경우
					num1 = 9;
					textField.setText(Integer.toString(num1));

				} else {
					if (cal == 0) {
						num1 *= 10;
						num1 += 9;
						textField.setText(Integer.toString(num1));
					} else {
						num2 *= 10;
						num2 += 9;
						textField.setText(Integer.toString(num2));
					}
				}

			}
		});
		button_9.setFont(new Font("굴림", Font.BOLD, 20));
		button_9.setBounds(216, 80, 90, 70);
		panel.add(button_9);

		JButton button_dot = new JButton(".");
		button_dot.setFont(new Font("굴림", Font.BOLD, 24));
		button_dot.setBounds(216, 335, 90, 70);
		panel.add(button_dot);

		JButton button_0 = new JButton("0");
		button_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (num1 == 0) { // 첫번째 수에 값이 없을 경우
					num1 = 0;
					textField.setText(Integer.toString(num1));

				} else {
					if (cal == 0) {
						num1 *= 10;
						textField.setText(Integer.toString(num1));
					} else {
						num2 *= 10;
						textField.setText(Integer.toString(num2));
					}
				}

			}
		});
		button_0.setFont(new Font("굴림", Font.BOLD, 23));
		button_0.setBounds(12, 335, 192, 70);
		panel.add(button_0);

		JButton button_plus = new JButton("+");
		button_plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (num1 == 0)
					;

				else {
					if (num2 == 0) {
						cal = 1;
						textField.setText(Integer.toString(num2));
					} else {
						num1 += num2;
						textField.setText(Integer.toString(num1));

						num2 = 0;
						cal = 1;
					}
				}
			}
		});
		button_plus.setFont(new Font("굴림", Font.BOLD, 25));
		button_plus.setBounds(318, 80, 80, 60);
		panel.add(button_plus);

		JButton button_minus = new JButton("-");
		button_minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (num1 == 0)
					;
				else {
					if (num2 == 0) {
						cal = 2;
						textField.setText(Integer.toString(num2));
					} else {
						num1 -= num2;
						textField.setText(Integer.toString(num1));

						num2 = 0;
						cal = 2;
					}
				}
			}
		});
		button_minus.setFont(new Font("굴림", Font.BOLD, 25));
		button_minus.setBounds(318, 150, 80, 60);
		panel.add(button_minus);

		JButton button_multi = new JButton("*");
		button_multi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (num1 == 0)
					;

				else {
					if (num2 == 0) {
						cal = 3;
						textField.setText(Integer.toString(num2));
					} else {
						num1 *= num2;
						textField.setText(Integer.toString(num1));

						num2 = 0;
						cal = 3;
					}
				}
			}
		});
		button_multi.setFont(new Font("굴림", Font.BOLD, 25));
		button_multi.setBounds(318, 220, 80, 54);
		panel.add(button_multi);

		JButton button_devide = new JButton("/");
		button_devide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (num1 == 0)
					;

				else {
					if (num2 == 0) {
						cal = 4;
						textField.setText(Integer.toString(num2));
					} else {
						num1 /= num2;
						textField.setText(Integer.toString(num1));

						num2 = 0;
						cal = 4;
					}
				}
			}
		});
		button_devide.setFont(new Font("굴림", Font.BOLD, 25));
		button_devide.setBounds(318, 284, 80, 54);
		panel.add(button_devide);

		JButton button = new JButton("=");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (cal) {
				
				case 1:
					textField.setText(Integer.toString(num1 + num2));
					num1+=num2;
					num2=0;
					break;
				
				case 2:
					textField.setText(Integer.toString(num1 - num2));
					num1-=num2;
					num2=0;
					break;

				case 3:
					textField.setText(Integer.toString(num1 * num2));
					num1*=num2;
					num2=0;
					break;

				case 4:
					textField.setText(Integer.toString(num1 / num2));
					num1/=num2;
					num2=0;
					break;

				}
			}
		});
		button.setFont(new Font("굴림", Font.BOLD, 25));
		button.setBounds(318, 351, 80, 54);
		panel.add(button);
	}
}
