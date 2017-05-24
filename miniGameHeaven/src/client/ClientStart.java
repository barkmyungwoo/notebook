package client;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ClientStart {

	private JFrame nicframe;
	private JTextField textField;

	String name;

	public static void main(String[] args) {
		new ClientStart();
	}

	public ClientStart() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		System.out.println(screenSize);
		int x = screenSize.width / 2 - 150;
		int y = screenSize.height / 2 - 75;

		nicframe = new JFrame("미니게임천국");
		nicframe.setBounds(x, y, 300, 150);
		nicframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		nicframe.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("대화명을 입력해 주세요");
		lblNewLabel.setBounds(80, 10, 140, 15);
		nicframe.getContentPane().add(lblNewLabel);

		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().charAt(0) >= 32 && textField.getText().charAt(0) <= 64) {
					JOptionPane.showMessageDialog(textField,"숫자나 특수 기호의 경우 첫글자로 사용 할 수 없어요.");
					textField.setText("");
				} 
				else if (textField.getText().charAt(0) >= 91 && textField.getText().charAt(0) <= 96) {
					JOptionPane.showMessageDialog(textField,"숫자나 특수 기호의 경우 첫글자로 사용 할 수 없어요.");
					textField.setText("");
				} 
				else if (textField.getText().charAt(0) >= 123 && textField.getText().charAt(0) <= 126) {
					JOptionPane.showMessageDialog(textField,"숫자나 특수 기호의 경우 첫글자로 사용 할 수 없어요.");
					textField.setText("");
				} 
				else {
					name = textField.getText();
					mainFrame client = new mainFrame("미니게임천국", name);
					client.setVisible(true);
					client.connect();
					nicframe.dispose();
				}
			}
		});

		textField.setBounds(80, 40, 140, 21);
		nicframe.getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("확 인");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				name = textField.getText();
				mainFrame client = new mainFrame("미니게임천국", name);
				client.setName(name);
				client.setVisible(true);
				client.connect();
				nicframe.dispose();
			}
		});
		btnNewButton.setBounds(100, 70, 100, 20);
		nicframe.getContentPane().add(btnNewButton);

		nicframe.setVisible(true);
	}
}