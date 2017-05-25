package client.game;

import java.util.*;

import javax.swing.UIManager;

public class ArrowGameTestMain {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			new ArrowGame();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}