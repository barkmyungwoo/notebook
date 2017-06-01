package ncs.test7;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ScoreFrame {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ScoreFrame window = new ScoreFrame();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public ScoreFrame() {
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 350, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("자 바 :");
		lblNewLabel.setBounds(12, 73, 57, 15);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(48, 70, 75, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("SQL : ");
		lblNewLabel_1.setBounds(210, 73, 57, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(247, 70, 75, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("점수를 입력하세요");
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(12, 10, 345, 33);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("계산하기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int sum =Integer.parseInt(textField.getText())+Integer.parseInt(textField_1.getText());
				textField_2.setText(sum + "");
				textField_3.setText(((double)sum/2)+"");
			}
		});
		btnNewButton.setBounds(130, 115, 90, 33);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("총점 : ");
		lblNewLabel_3.setBounds(12, 180, 57, 15);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(48, 177, 75, 21);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label = new JLabel("평균 : ");
		label.setBounds(210, 180, 57, 15);
		frame.getContentPane().add(label);
		
		textField_3 = new JTextField();
		textField_3.setBounds(247, 177, 75, 21);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
	}
}
