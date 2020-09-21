package card;

import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {

		Game game = new Game();
		// calling game from main
		game.newGame();

		SwingUtilities.invokeLater(null);
	}

	public static void music() {

	}

}
