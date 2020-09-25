package card1;

import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		// start a new inteface
		UserInterFace game = new UserInterFace();
		SwingUtilities.invokeLater(game);
	}
}
