package cardmaker;

import javax.swing.SwingUtilities;

public class Main {

	// Entry point of the application
	public static void main(String[] args) {
		// Ensure that the GUI is created on the Event Dispatch Thread for thread safety
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Game(); // Create and show the game window
			}
		});
	}

	// Placeholder method for adding music functionality in the future
	public static void music() {
		// Implementation for background music can be added here
	}

}
