package edit;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class test extends JFrame {
	JScrollPane scrollPane;
	// ��� �ʵ忡 ImageIcon Ŭ���� ������
	ImageIcon icon;

	public test() {
	  // �����ڿ� ico ȣ�� �ϰ� �̹��� ��� ����...(����η� �ȵɰ�� ������ ����)
	  icon = new ImageIcon("cbg2.gif");
	  // ��׶��� �̹��� ������ �޼ҵ忡 �̸����� Ŭ������ ����
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
