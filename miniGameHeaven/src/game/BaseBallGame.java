package game;

public class BaseBallGame {
	public static int MAX_COUNT = 4;
	public static int MAX_INPUT = 20;
	int x = 0, y = 0;

	private int baseNumber[] = new int[MAX_COUNT];

	public String start() {
		do {
			baseNumber[0] = (int) (Math.random() * 10);
		} while (baseNumber[0] == 0);

		for (int i = 1; i < baseNumber.length; i++) {
			baseNumber[i] = (int) (Math.random() * 10);
			for (int j = 0; j < i; j++) {
				while (baseNumber[i] == baseNumber[j] || baseNumber[i] == 0) {
					baseNumber[i] = (int) (Math.random() * 10);
					j = 0;
				}
			}
		}
		return "" + baseNumber[0] + baseNumber[1] + baseNumber[2] + baseNumber[3];
	}

	public String countSB(String answer, String msg) {

		int[] a = new int[4];
		int[] b = new int[4];

		for (int i = 0; i < a.length; i++) {
			a[i] = answer.charAt(i) - 48;
			b[i] = msg.charAt(i) - 48;
		}

		x = 0;
		y = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if (b[i] == a[j])
					if (i == j)
						x += 1;
					else
						y += 1;
			}
		}

		return "¡¤ " + msg + " : " + x + " Strike, " + y + " Ball";
	}

}