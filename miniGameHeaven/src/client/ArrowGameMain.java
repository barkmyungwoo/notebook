package client;

import java.util.*;

import javax.swing.UIManager;

public class ArrowGameMain {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			new ArrowGame();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}