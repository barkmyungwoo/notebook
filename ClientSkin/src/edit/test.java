package edit;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class test extends JFrame {
	JScrollPane scrollPane;
	// 멤버 필드에 ImageIcon 클래스 생성자
	ImageIcon icon;

	public test() {
	  // 생성자에 ico 호출 하고 이미지 경로 지정...(상대경로로 안될경우 절대경로 지정)
	  icon = new ImageIcon("cbg2.gif");
	  // 백그라운드 이미지 삽입할 메소드에 이름없는 클래스로 구현
	  JPanel panel = new JPanel() {
	   public void paintComponent(Graphics g) {
	    // Approach 1: Dispaly image at at full size
	    g.drawImage(icon.getImage(), 0, 0, null);
	    // Approach 2: Scale image to size of component
	    // Dimension d = getSize();
	    // g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
	    // Approach 3: Fix the image position in the scroll pane
	    // Point p = scrollPane.getViewport().getViewPosition();
	    // g.drawImage(icon.getImage(), p.x, p.y, null);
	    setOpaque(false);
	    super.paintComponent(g);
	   }
	  };
	  // JButton button = new JButton("Hello");
	  // panel.add(button);
	  scrollPane = new JScrollPane(panel);
	  setContentPane(scrollPane);
	 }

	public static void main(String[] args) {
		test frame = new test();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(890,530);
		frame.setVisible(true);
	}
}
