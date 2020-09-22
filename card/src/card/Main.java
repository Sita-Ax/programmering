package card;

import java.io.IOException;
import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) throws IOException {
		

		Game game = new Game();
		// calling game from main
		game.newGame();
		
//		cardController controller = null;

		SwingUtilities.invokeLater(null);
	}

	public static void music() {

	}

}
